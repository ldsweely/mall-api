package com.ihangmei.mall.api.service;

import com.ihangmei.mall.common.web.Result;

public interface IOrderService {
    /**
     * 查询商品库存接口
     */
    Result queryStock(String ent_id,String app_key,String params) ;

    /**
     * 查询订单运费接口
     */
    Result queryFreight(String ent_id,String app_key,String params) ;
    /**
     * 统一下单接口
     */
    Result submit(String ent_id,String app_key,String params) ;
    /**
     * 下单支付成功回调接口
     */
    Result pay(String ent_id,String app_key,String params) ;
    /**
     * 查询订单详情接口
     */
    Result queryDetail(String ent_id,String app_key,String params) ;
    /**
     * 查询订单退款接口
     */
    Result queryRefund(String ent_id,String app_key,String params) ;
    /**
     * 查询订单物流接口
     */
    Result queryTrack(String ent_id,String app_key,String params) ;

}
