package com.ihangmei.mall.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.ihangmei.mall.api.config.AddrConfig;
import com.ihangmei.mall.api.constants.ApiConstants;
import com.ihangmei.mall.api.service.IAddressService;
import com.ihangmei.mall.common.constant.GatApiConstants;
import com.ihangmei.mall.common.util.http.OkHttpUtil;
import com.ihangmei.mall.common.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addressService")
@Slf4j
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddrConfig addrConfig;
    /**
     * 查询一级地域（省份）接口
     */
    public Result queryProvinceList(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = addrConfig.getHostUrl() + ApiConstants.ADDR_PROVINCE_LIST;
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
     * 根据一级地域编码查询二级地域（地市）接口
     */
    public Result queryCityList(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = addrConfig.getHostUrl() + ApiConstants.ADDR_CITY_LIST;
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
     * 根据二级地域编码查询三级地域（区县）接口
     */
    public Result queryCountyList(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = addrConfig.getHostUrl() + ApiConstants.ADDR_COUNTY_LIST;
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
     * 根据三级地域编码查询四级地域（乡镇）接口
     */
    public Result queryTownList(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = addrConfig.getHostUrl() + ApiConstants.ADDR_TOWN_LIST;
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
     * 校验地址接口
     */
    public Result CheckAddress(String ent_id,String app_key,String params){
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);
        param.put("appKey",app_key);
        param.put("companyId", ent_id);

        String url = addrConfig.getHostUrl() + ApiConstants.ADDR_CHECK;
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
