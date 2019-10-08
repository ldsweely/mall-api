package com.ihangmei.mall.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.ihangmei.mall.api.config.SkuConfig;
import com.ihangmei.mall.api.constants.ApiConstants;
import com.ihangmei.mall.api.service.IProductService;
import com.ihangmei.mall.common.constant.GatApiConstants;
import com.ihangmei.mall.common.util.http.OkHttpUtil;
import com.ihangmei.mall.common.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
@Slf4j
public class ProductServiceImpl implements IProductService {
    @Autowired
    private SkuConfig skuConfig;
    /**
     * 同步分类接口
     */
    public Result queryCateList(String params)  {
        Result result = null;
        JSONObject param = JSONObject.parseObject(params);

        String url = skuConfig.getHostUrl() + ApiConstants.PROD_QUERY_CATE_LIST;
        String strResult = null;
        try {
            strResult = OkHttpUtil.postJson(url,param);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        if(Strings.isNullOrEmpty(strResult)) {
            return GatApiConstants.HM_BUSI_SKU_ERROR.toResult("空数据");
        }

        try {
            JSONObject resultObj = JSONObject.parseObject(strResult);
            if(0 != resultObj.getInteger("error")) {
                return GatApiConstants.HM_BUSI_SKU_ERROR.toResult("下级商品数据异常");
            }

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
     * 分页查询全量商品sku接口
     */
    public Result queryAllSkuPage(String ent_id, String params)  {
        Result result = null;

        JSONObject param = JSONObject.parseObject(params);
        param.put("companyId", ent_id);

        String url = skuConfig.getHostUrl() + ApiConstants.PROD_QUERY_ALL_SKU_PAGE;

        String strResult = null;
        try {
            strResult = OkHttpUtil.postJson(url,param);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        if(Strings.isNullOrEmpty(strResult)) {
            return GatApiConstants.HM_BUSI_SKU_ERROR.toResult("空数据");
        }

        try {
            JSONObject resultObj = JSONObject.parseObject(strResult);
            if(0 != resultObj.getInteger("error")) {
                return GatApiConstants.HM_BUSI_SKU_ERROR.toResult("下级商品数据异常");
            }

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
     * 根据sku批量查询商品详情
     */
    public Result queryBatchQuerySku(String ent_id, String params){
        Result result = null;

        JSONObject param = JSONObject.parseObject(params);
        param.put("companyId", ent_id);

        String url = skuConfig.getHostUrl() + ApiConstants.PROD_QUERY_BATCH_LIST_SKU;

        String strResult = null;
        try {
            strResult = OkHttpUtil.postJson(url,param);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        if(Strings.isNullOrEmpty(strResult)) {
            return GatApiConstants.HM_BUSI_SKU_ERROR.toResult("空数据");
        }

        try {
            JSONObject resultObj = JSONObject.parseObject(strResult);
            if(0 != resultObj.getInteger("error")) {
                return GatApiConstants.HM_BUSI_SKU_ERROR.toResult("下级商品数据异常");
            }

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
     * 查询同类商品
     */
    public Result querySkuSimilar(String ent_id, String params){
        Result result = null;

        JSONObject param = JSONObject.parseObject(params);
        param.put("companyId", ent_id);

        String url = skuConfig.getHostUrl() + ApiConstants.PROD_QUERY_SKU_SIMILAR;

        String strResult = null;
        try {
            strResult = OkHttpUtil.postJson(url,param);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }

        if(Strings.isNullOrEmpty(strResult)) {
            return GatApiConstants.HM_BUSI_SKU_ERROR.toResult("空数据");
        }

        try {
            JSONObject resultObj = JSONObject.parseObject(strResult);
            if(0 != resultObj.getInteger("error")) {
                return GatApiConstants.HM_BUSI_SKU_ERROR.toResult("下级商品数据异常");
            }

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
