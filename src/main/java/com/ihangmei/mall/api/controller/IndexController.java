package com.ihangmei.mall.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ihangmei.mall.api.config.SkuConfig;
import com.ihangmei.mall.api.entity.ReqParamVO;
import com.ihangmei.mall.api.service.impl.ProductServiceImpl;
import com.ihangmei.mall.common.constant.GatApiConstants;
import com.ihangmei.mall.common.util.http.OkHttpUtil;
import com.ihangmei.mall.common.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class IndexController extends ApiBaseController {
    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    /**
     * 请求商品分类信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Result queryTest(HttpServletRequest request,  @RequestParam("testId") String testId) {
        /* 默认公司appkey 0f885924309540105db61266b21d7cbc
                  appsec deab698325704321603fefdfc6b4cfc3
       */
        String appKey = "0f885924309540105db61266b21d7cbc";
        String appSec = "deab698325704321603fefdfc6b4cfc3";
        long timeStamp = System.currentTimeMillis()/1000;

        String params = new StringBuilder().append("{")
                        .append("\"parentId\":").append("0,")
                        .append("\"catClass\":").append("0")
                        .append("}")
                        .toString();
        String sign = generateSignature(appKey,appSec,params,String.valueOf(timeStamp));
        ReqParamVO reqParamVO =new ReqParamVO();
        reqParamVO.setAppkey(appKey);
        reqParamVO.setParams(params);
        reqParamVO.setTimestamp(timeStamp);
        reqParamVO.setSignature(sign);
        Result result = null;

        if (testId.equals("1")){
            result = productService.queryCateList(reqParamVO.getParams());
            if(result ==null){
                return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
            }
         }

        return result;

    }

    @RequestMapping(value = "/getkey", method = RequestMethod.POST)
    public String queryGetKey(HttpServletRequest request,  @RequestParam("params") String params) {
        /* 默认公司appkey 0f885924309540105db61266b21d7cbc
                  appsec deab698325704321603fefdfc6b4cfc3
       */

        /* 测试环境配置appKey appSec
        String appKey = "0f885924309540105db61266b21d7cbc";
        String appSec = "deab698325704321603fefdfc6b4cfc3";
        */
        String appKey = "e1a61afcf5bf4b995845c7ea504a719c";
        String appSec = "37339352dfb24b854a80734ccf380e35";
        long timeStamp = System.currentTimeMillis()/1000;

        String sign = generateSignature(appKey,appSec,params,String.valueOf(timeStamp));
        ReqParamVO reqParamVO =new ReqParamVO();
        reqParamVO.setAppkey(appKey);
        reqParamVO.setParams(params);
        reqParamVO.setTimestamp(timeStamp);
        reqParamVO.setSignature(sign);

        String strResult = reqParamVO.toString();
        return strResult;

        //{"appkey":"0f885924309540105db61266b21d7cbc","timestamp":"1570522339","signature":"2cdb47e43c8f6c704a0f754c00b04d7c","params":"{{\"pageNum\":1,\"pageSize\":10}}"}


    }

}
