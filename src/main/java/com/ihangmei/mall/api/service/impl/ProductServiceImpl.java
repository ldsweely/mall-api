package com.ihangmei.mall.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ihangmei.mall.api.service.IProductService;
import com.ihangmei.mall.common.constant.GatApiConstants;
import com.ihangmei.mall.common.util.http.OkHttpUtil;
import com.ihangmei.mall.common.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("productService")
@Slf4j
public class ProductServiceImpl implements IProductService {
    /**
     * 同步分类接口
     */
    public Result queryCateList(String url, String params)  {
        String result =null;
        try {
             result = OkHttpUtil.postJson(url, params);
        }
        catch (Exception e){
            return GatApiConstants.HM_SYS_UNKOWN_ERROR.toResult("系统异常");
        }
        return returnSucess(result);
    }

    /**
     * 分页查询全量商品sku接口
     */
    public Result queryAllSkuPage(String url,String ent_id, String params) throws Exception {

            JSONObject param = new JSONObject();
            param.put("provinceId", provinceId);
            param.put("cityId", cityId);
            param.put("countyId", countyId);
            param.put("productIds", productIds);
            String result = OkHttpUtil.postJson(url, param);

    }
    /**
     * 根据sku批量查询商品详情
     */
    public Result queryBatchQuerySku(String url,String ent_id, String params){

    }
    /**
     * 查询同类商品
     */
    public Result querySkuSimilar(String url,String ent_id, String params){

    }
}
