package com.ihangmei.mall.api.controller;

import com.ihangmei.mall.api.config.SkuConfig;
import com.ihangmei.mall.api.entity.ReqParamVO;
import com.ihangmei.mall.common.web.Result;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

public class IndexController extends ApiBaseController {

    private SkuConfig skuConfig;
    @RequestMapping(value = "/prod/sku", method = RequestMethod.POST)
    public Result payOrder(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1.请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSign(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();

        String url = skuConfig.getHostUrl();
        repeatSyncProProductJDPrice(url,pageNum,pageSize,total,example);

    }

}
