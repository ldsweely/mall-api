package com.ihangmei.mall.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ihangmei.mall.api.config.AfterSaleConfig;
import com.ihangmei.mall.api.constants.ApiConstants;
import com.ihangmei.mall.api.service.IAfterSaleService;
import com.ihangmei.mall.common.constant.GatApiConstants;
import com.ihangmei.mall.common.util.http.OkHttpUtil;
import com.ihangmei.mall.common.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("orderService")
@Slf4j
public class AfterSaleServiceImpl implements IAfterSaleService {
    private AfterSaleConfig afterSaleConfig;
    /**
     * 查询商品支持的售后类型接口
     */
    public Result queryServices(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = afterSaleConfig.getHostUrl() + ApiConstants.AFTER_SALE_SERVICES;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }

    /**
     * 查询订单商品是否支持售后接口
     */
    @Override
    public Result queryIsCan(String ent_id, String app_key, String params) {
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = afterSaleConfig.getHostUrl() + ApiConstants.AFTER_SALE_IS_CAN;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }
    /**
     * 申请售后接口
     */
    @Override
    public Result apply(String ent_id, String app_key, String params) {
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = afterSaleConfig.getHostUrl() + ApiConstants.AFTER_SALE_APPLY;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;    }
    /**
     * 查询售后列表接口
     */
    @Override
    public Result queryList(String ent_id, String app_key, String params) {
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = afterSaleConfig.getHostUrl() + ApiConstants.AFTER_SALE_LIST;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }
    /**
     * 查询售后详情接口
     */
    @Override
    public Result queryDetail(String ent_id,String app_key,String params) {
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = afterSaleConfig.getHostUrl() + ApiConstants.AFTER_SALE_DETAIL;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }
    /**
     * 查询售后详情接口
     */
    @Override
    public Result afterSaleCancel(String ent_id, String app_key, String params) {
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = afterSaleConfig.getHostUrl() + ApiConstants.AFTER_SALE_CANCEL;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }

    /**
     * 售后物流跟踪接口
     */
    @Override
    public Result track(String ent_id, String app_key, String params) {
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = afterSaleConfig.getHostUrl() + ApiConstants.AFTER_SALE_TRACK;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }

    /**
     * 客户返件售后单填写发运接口
     */
    @Override
    public Result sendSku(String ent_id, String app_key, String params) {
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = afterSaleConfig.getHostUrl() + ApiConstants.AFTER_SALE_SEND_SKU;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }


}
