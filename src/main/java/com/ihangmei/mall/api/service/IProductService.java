package com.ihangmei.mall.api.service;

import com.ihangmei.mall.common.web.Result;

public interface IProductService {
    /**
     * 同步分类接口
     */
    Result queryCateList(String params) ;

    /**
     * 分页查询全量商品sku接口
     */
    Result queryAllSkuPage(String ent_id, String params);
    /**
     * 根据sku批量查询商品详情
     */
    Result queryBatchQuerySku(String ent_id, String params);
    /**
     * 查询同类商品
     */
    Result querySkuSimilar(String ent_id, String params);

}
