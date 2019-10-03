package com.ihangmei.mall.api.service;

import com.ihangmei.mall.common.web.Result;

public interface IAfterSaleService {
    /**
     * 查询商品支持的售后类型接口
     */
    Result queryServices(String ent_id,String app_key,String params) ;
    /**
     * 查询订单商品是否支持售后接口
     */
    Result queryIsCan(String ent_id,String app_key,String params) ;
    /**
     * 申请售后接口
     */
    Result afterSaleApply(String ent_id,String app_key,String params) ;
    /**
     * 查询售后列表接口
     */
    Result queryList(String ent_id,String app_key,String params) ;
    /**
     * 查询售后详情接口
     */
    Result queryDetail(String ent_id,String app_key,String params) ;
    /**
     * 取消售后单接口
     */
    Result afterSaleCancel(String ent_id,String app_key,String params) ;
    /**
     * 售后物流跟踪接口
     */
    Result track(String ent_id,String app_key,String params) ;
    /**
     * 客户返件售后单填写发运接口
     */
    Result sendSku(String ent_id,String app_key,String params) ;



}
