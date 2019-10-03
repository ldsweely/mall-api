package com.ihangmei.mall.api.controller;

import com.ihangmei.mall.api.entity.ReqParamVO;
import com.ihangmei.mall.api.service.impl.AfterSaleServiceImpl;
import com.ihangmei.mall.api.service.impl.OrderServiceImpl;
import com.ihangmei.mall.common.constant.GatApiConstants;
import com.ihangmei.mall.common.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/aftersale")
public class AfterSaleController extends ApiBaseController {
    @Autowired
    private AfterSaleServiceImpl afterSaleService;

    /**
     * 查询商品支持的售后类型接口
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/query/stock", method = RequestMethod.POST)
    public Result queryStock(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSign(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = afterSaleService.queryServices(ent_id,reqParamVO.getAppkey(),reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }

    /**
     * 查询订单商品是否支持售后接口
     *  @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/query/is/can", method = RequestMethod.POST)
    public Result queryIsCan(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
       /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSign(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = afterSaleService.queryIsCan(ent_id,reqParamVO.getAppkey(),reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
    /**
     * 申请售后接口
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public Result afterSaleApply(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSign(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = afterSaleService.afterSaleApply(ent_id,reqParamVO.getAppkey(),reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
    /**
     * 查询售后列表接口
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/query/list", method = RequestMethod.POST)
    public Result queryList(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSign(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = afterSaleService.queryList(ent_id,reqParamVO.getAppkey(),reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
    /**
     * 查询售后详情接口
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/query/detail", method = RequestMethod.POST)
    public Result queryDetail(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSign(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = afterSaleService.queryDetail(ent_id,reqParamVO.getAppkey(),reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
    /**
     * 取消售后单接口
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public Result afterSaleCancel(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSign(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = afterSaleService.afterSaleCancel(ent_id,reqParamVO.getAppkey(),reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
    /**
     * 售后物流跟踪接口
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/query/track", method = RequestMethod.POST)
    public Result queryTrack(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSign(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = afterSaleService.track(ent_id,reqParamVO.getAppkey(),reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
    /**
     * 客户返件售后单填写发运接口
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/send/sku", method = RequestMethod.POST)
    public Result sendSku(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSign(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = afterSaleService.sendSku(ent_id,reqParamVO.getAppkey(),reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
}
