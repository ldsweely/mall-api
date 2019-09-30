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
    @RequestMapping(value = "/prod/test", method = RequestMethod.POST)
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
        reqParamVO.setSign(sign);
        Result result = null;

        if (testId.equals("1")){
            result = productService.queryCateList(reqParamVO.getParams());
            if(result ==null){
                return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
            }
         }

        return result;

    }
    /**
     * 请求商品分类信息
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/prod/query/cate/list", method = RequestMethod.POST)
    public Result queryCateList(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSign(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        /*2 下行请求*/
        result = productService.queryCateList(reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }

    /**
     * 请求全量商品sku 分页
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/prod/all/sku/page", method = RequestMethod.POST)
    @ResponseBody
    public Result queryAllSkuPage(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
       /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSign(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = productService.queryAllSkuPage(ent_id,reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
    /**
     * 根据sku批量查询商品详情
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/prod/batch/query/sku", method = RequestMethod.POST)
    @ResponseBody
    public Result queryBatchQuerySku(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSign(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = productService.queryBatchQuerySku(ent_id,reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
    /**
     * 根据sku批量查询商品详情
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/prod/sku/similar", method = RequestMethod.POST)
    @ResponseBody
    public Result querySkuSimilar(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSign(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = productService.querySkuSimilar(ent_id,reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
}
