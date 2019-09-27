package com.ihangmei.mall.api.service;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.ihangmei.mall.common.util.http.OkHttpUtil;
import com.ihangmei.mall.common.web.Result;

import java.util.List;
import java.util.Map;

public interface IProductService {
    /**
     * 同步分类接口
     */
    Result queryCateList(String url, String params) throws Exception;

    /**
     * 分页查询全量商品sku接口
     */
    Result queryAllSkuPage(String url,String ent_id, String params);
    /**
     * 根据sku批量查询商品详情
     */
    Result queryBatchQuerySku(String url,String ent_id, String params);
    /**
     * 查询同类商品
     */
    Result querySkuSimilar(String url,String ent_id, String params);

}
