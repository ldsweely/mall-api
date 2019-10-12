package com.ihangmei.mall.api.controller;

import com.google.common.base.Strings;
import com.ihangmei.mall.api.constants.ApiConstants;
import com.ihangmei.mall.api.entity.EnterPriseEntity;
import com.ihangmei.mall.api.service.impl.EnterPriseServiceImpl;
import com.ihangmei.mall.api.util.RedisUtil;
import com.ihangmei.mall.common.controller.BaseController;
import com.ihangmei.mall.common.util.DecryptMD5;
import com.ihangmei.mall.common.web.Result;
import com.ihangmei.mall.common.constant.GatApiConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 注释：API模块基础controller
 */
@Component
@Slf4j
public class ApiBaseController extends BaseController {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    private EnterPriseServiceImpl enterPriseService;
    /**
     * 功能描述: 将appKey换成ent_Id，app_sec
     * @return: java.lang.String
     * @auther: liudushi
     * @date: 2019/9/24
     */
    String getEntIdAppSecFromRedis(String appKey) {
        if (Strings.isNullOrEmpty(appKey)) {
            return "1"; //KEY为空
        }
        /*1.首先从redis中获取appKey对应的ent_id/appSec*/
        Object object = null;
        StringBuilder builder = new StringBuilder();

        String key = builder.append(ApiConstants.ORDER_PAY_LOCK_PREFIX ).append(":").append(appKey).toString();
        try {
             object = redisUtil.get(key);
        } catch (Exception e) {
            log.error("redis连接异常,异常信息={}",e.getMessage());
            e.printStackTrace();
            return "99";
        }
        /*2.如果redis中无法获取，1.则可能过期 2.redis异常 需要从数据库中读取*/
        if (object != null) {
            return object.toString();
        }
        try {
            EnterPriseEntity enterPriseEntity = enterPriseService.selectByAppKey(appKey);
            if (enterPriseEntity != null) {
                String v = new StringBuilder().append(enterPriseEntity.getEntId()).append(":").append(enterPriseEntity.getAppSecret()).toString();
                redisUtil.set(key, v, 1800);
                return v;
            }
        }
        catch (Exception e)
        {
            log.error("数据库异常,异常信息={}",e.getMessage());
            e.printStackTrace();
            return "99";
        }
//        Integer intEntId = enterPriseService.getEntIdByAppKey(appKey);
//        String strAppSecret = enterPriseService.getAppSecretByAppKey(appKey);
//        if(intEntId!=null && strAppSecret!=null){
//            String v = new StringBuilder().append(intEntId).append(":").append(strAppSecret).toString();
//            redisUtil.set(key,v,1800);
//            return v;
//        }
        return "2";  //无效APP_Key
    }
    /**
     * 验证：请求有效性 1.参数为空校验 2.时间戳检验 3.签名值校验
     */
    protected Result validApiRequest(String appkey, String sign, String params, Long timestamp) {
        /*1.verfity params */
        if (Strings.isNullOrEmpty(appkey))
        {
            return GatApiConstants.HM_SYS_NOT_APPKEY_ERROR.toResult("APPKey为空");
        }
        if(Strings.isNullOrEmpty(sign) ){
            return GatApiConstants.HM_SYS_NOT_JSON_ERROR.toResult("签名为空");
        }
        if(Strings.isNullOrEmpty(params))
        {
            return GatApiConstants.HM_SYS_NOT_JSON_ERROR.toResult("无业务参数");
        }
        if(timestamp == null) {
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("参数为空");
        }
        String entIdAppSec = getEntIdAppSecFromRedis(appkey);
        if(Strings.isNullOrEmpty(entIdAppSec)){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }
        if("1".equals(entIdAppSec)){
            return GatApiConstants.HM_SYS_APPKEY_ERROR.toResult("appSec为空");
        }
        if("99".equals(entIdAppSec)){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }
        if("2".equals(entIdAppSec)){
            return GatApiConstants.HM_SYS_APPKEY_ERROR.toResult("无效APP_Key");
        }
        String ent_id = entIdAppSec.split(":")[0];
        String app_sec = entIdAppSec.split(":")[1];
        /*2.sign签名校验-防止签名被篡改  token+openId+ orderSn + 时间戳   */
        if (!sign.equals(generateSignature(appkey, app_sec, params, timestamp.toString()))) {
            return GatApiConstants.HM_SYS_SIGN_ERROR.toResult("签名无效！sign=" + sign);
        }
        long ct = System.currentTimeMillis()/1000;
        long ct_c = timestamp - ct;
        if(ct_c < -60 * 20 || ct_c > 60 * 20) //20分钟外的误差算非法请求
        {
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("超时请求，检查时间戳");
        }

        return returnSucess(ent_id);
    }

    /**
     * 功能描述: 生成签名 signature = MD5(app_sec+ appkey+ params+  timestamp+app_sec );
     * 签名说明：app_sec+app_key+业务参数+时间戳+app_sec   采用md5方式加密。
     *
     * @param:
     * @return:
     * @auther: liudushi
     * @date: 2019/9/24
     */
    protected String generateSignature(String app_key, String app_sec, String params,String timestamp) {
        StringBuilder builder = new StringBuilder();
        builder.append(app_sec).append("appkey=").append(app_key)
                .append("&params=").append(params)
                .append("&timestamp=").append(timestamp)
                .append(app_sec);
        try {
            return DecryptMD5.MD5(builder.toString());
        } catch (Exception e) {
            log.error("异常消息：调用 DecryptMD5.MD5 方法执行异常！key={}", builder.toString(), e);
            return null;
        }
    }
}
