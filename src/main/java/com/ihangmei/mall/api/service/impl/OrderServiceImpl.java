package com.ihangmei.mall.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ihangmei.mall.api.config.OrderConfig;
import com.ihangmei.mall.api.constants.ApiConstants;
import com.ihangmei.mall.api.service.IOrderService;
import com.ihangmei.mall.common.constant.GatApiConstants;
import com.ihangmei.mall.common.util.http.OkHttpUtil;
import com.ihangmei.mall.common.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("orderService")
@Slf4j
public class OrderServiceImpl implements IOrderService {
    private OrderConfig orderConfi;
    /**
     * 查询商品库存接口
     */
    public Result queryStock(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = orderConfi.getHostUrl() + ApiConstants.ORDER_STOCK;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }

    /**
     * 查询订单运费接口
     */
    public Result queryFreight(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = orderConfi.getHostUrl() + ApiConstants.ORDER_FREIGHT;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }
    /**
     * 统一下单接口
     */
    public Result submit(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = orderConfi.getHostUrl() + ApiConstants.ORDER_SUBMIT;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }
    /**
     * 下单支付成功回调接口
     */
    public Result pay(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = orderConfi.getHostUrl() + ApiConstants.ORDER_PAY;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }
    /**
     * 查询订单详情接口
     */
    public Result queryDetail(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = orderConfi.getHostUrl() + ApiConstants.ORDER_DETAIL;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }
    /**
     * 查询订单退款接口
     */
    public Result queryRefund(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = orderConfi.getHostUrl() + ApiConstants.ORDER_REFUND;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }
    /**
     * 查询订单物流接口
     */
    public Result queryTrack(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = orderConfi.getHostUrl() + ApiConstants.ORDER_TRACK;
        try {
            result = JSON.parseObject(JSON.toJSONString(OkHttpUtil.postJson(url,params)), Result.class);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }

}
