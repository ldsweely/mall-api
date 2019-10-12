package com.ihangmei.mall.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.ihangmei.mall.api.config.OrderConfig;
import com.ihangmei.mall.api.constants.ApiConstants;
import com.ihangmei.mall.api.service.IOrderService;
import com.ihangmei.mall.common.constant.GatApiConstants;
import com.ihangmei.mall.common.util.http.OkHttpUtil;
import com.ihangmei.mall.common.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
@Slf4j
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderConfig orderConfig;
    /**
     * 查询商品库存接口
     */
    public Result queryStock(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = orderConfig.getHostUrl() + ApiConstants.ORDER_STOCK;
        String strResult = null;
        try {
            strResult = OkHttpUtil.postJson(url,param);
        }
        catch (Exception e){
            log.error("调用下级接口异常,接口={},异常信息={}",url,e.getMessage());
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        if(Strings.isNullOrEmpty(strResult)) {
            return GatApiConstants.HM_BUSI_ORDER_ERROR.toResult("空数据");
        }

        try {
            JSONObject resultObj = JSONObject.parseObject(strResult);

            Object objData = resultObj.get("data");
            String strMsg = resultObj.getString("msg");
            Integer intError = resultObj.getInteger("error");
            result = Result.builder().error(intError).msg(strMsg).data(objData).build();

        } catch (Exception e) {
            log.error("返回对象异常,对象信息={},异常信息={}",strResult,e.getMessage());
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

        String url = orderConfig.getHostUrl() + ApiConstants.ORDER_FREIGHT;
        String strResult = null;
        try {
            strResult = OkHttpUtil.postJson(url,param);
        }
        catch (Exception e){
            log.error("调用下级接口异常,接口={},异常信息={}",url,e.getMessage());
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        if(Strings.isNullOrEmpty(strResult)) {
            return GatApiConstants.HM_BUSI_ORDER_ERROR.toResult("空数据");
        }

        try {
            JSONObject resultObj = JSONObject.parseObject(strResult);

            Object objData = resultObj.get("data");
            String strMsg = resultObj.getString("msg");
            Integer intError = resultObj.getInteger("error");
            result = Result.builder().error(intError).msg(strMsg).data(objData).build();

        } catch (Exception e) {
            log.error("返回对象异常,对象信息={},异常信息={}",strResult,e.getMessage());
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

        String url = orderConfig.getHostUrl() + ApiConstants.ORDER_SUBMIT;
        String strResult = null;
        try {
            strResult = OkHttpUtil.postJson(url,param);
        }
        catch (Exception e){
            log.error("调用下级接口异常,接口={},异常信息={}",url,e.getMessage());
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        if(Strings.isNullOrEmpty(strResult)) {
            return GatApiConstants.HM_BUSI_ORDER_ERROR.toResult("空数据");
        }

        try {
            JSONObject resultObj = JSONObject.parseObject(strResult);

            Object objData = resultObj.get("data");
            String strMsg = resultObj.getString("msg");
            Integer intError = resultObj.getInteger("error");
            result = Result.builder().error(intError).msg(strMsg).data(objData).build();

        } catch (Exception e) {
            log.error("返回对象异常,对象信息={},异常信息={}",strResult,e.getMessage());
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

        String url = orderConfig.getHostUrl() + ApiConstants.ORDER_PAY;
        String strResult = null;
        try {
            strResult = OkHttpUtil.postJson(url,param);
        }
        catch (Exception e){
            log.error("调用下级接口异常,接口={},异常信息={}",url,e.getMessage());
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        if(Strings.isNullOrEmpty(strResult)) {
            return GatApiConstants.HM_BUSI_ORDER_ERROR.toResult("空数据");
        }

        try {
            JSONObject resultObj = JSONObject.parseObject(strResult);

            Object objData = resultObj.get("data");
            String strMsg = resultObj.getString("msg");
            Integer intError = resultObj.getInteger("error");
            result = Result.builder().error(intError).msg(strMsg).data(objData).build();

        } catch (Exception e) {
            log.error("返回对象异常,对象信息={},异常信息={}",strResult,e.getMessage());
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

        String url = orderConfig.getHostUrl() + ApiConstants.ORDER_DETAIL;
        String strResult = null;
        try {
            strResult = OkHttpUtil.postJson(url,param);
        }
        catch (Exception e){
            log.error("调用下级接口异常,接口={},异常信息={}",url,e.getMessage());
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        if(Strings.isNullOrEmpty(strResult)) {
            return GatApiConstants.HM_BUSI_ORDER_ERROR.toResult("空数据");
        }

        try {
            JSONObject resultObj = JSONObject.parseObject(strResult);

            Object objData = resultObj.get("data");
            String strMsg = resultObj.getString("msg");
            Integer intError = resultObj.getInteger("error");
            result = Result.builder().error(intError).msg(strMsg).data(objData).build();

        } catch (Exception e) {
            log.error("返回对象异常,对象信息={},异常信息={}",strResult,e.getMessage());
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

        String url = orderConfig.getHostUrl() + ApiConstants.ORDER_REFUND;
        String strResult = null;
        try {
            strResult = OkHttpUtil.postJson(url,param);
        }
        catch (Exception e){
            log.error("调用下级接口异常,接口={},异常信息={}",url,e.getMessage());
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        if(Strings.isNullOrEmpty(strResult)) {
            return GatApiConstants.HM_BUSI_ORDER_ERROR.toResult("空数据");
        }

        try {
            JSONObject resultObj = JSONObject.parseObject(strResult);

            Object objData = resultObj.get("data");
            String strMsg = resultObj.getString("msg");
            Integer intError = resultObj.getInteger("error");
            result = Result.builder().error(intError).msg(strMsg).data(objData).build();

        } catch (Exception e) {
            log.error("返回对象异常,对象信息={},异常信息={}",strResult,e.getMessage());
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

        String url = orderConfig.getHostUrl() + ApiConstants.ORDER_TRACK;
        String strResult = null;
        try {
            strResult = OkHttpUtil.postJson(url,param);
        }
        catch (Exception e){
            log.error("调用下级接口异常,接口={},异常信息={}",url,e.getMessage());
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        if(Strings.isNullOrEmpty(strResult)) {
            return GatApiConstants.HM_BUSI_ORDER_ERROR.toResult("空数据");
        }

        try {
            JSONObject resultObj = JSONObject.parseObject(strResult);

            Object objData = resultObj.get("data");
            String strMsg = resultObj.getString("msg");
            Integer intError = resultObj.getInteger("error");
            result = Result.builder().error(intError).msg(strMsg).data(objData).build();

        } catch (Exception e) {
            log.error("返回对象异常,对象信息={},异常信息={}",strResult,e.getMessage());
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        return result;
    }

}
