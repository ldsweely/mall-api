package com.ihangmei.mall.api.controller;

import com.ihangmei.mall.api.entity.ReqParamVO;
import com.ihangmei.mall.api.service.impl.AddressServiceImpl;
import com.ihangmei.mall.api.service.impl.ProductServiceImpl;
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
@RequestMapping("/addr")
public class AddressController extends ApiBaseController {
    @Autowired
    private AddressServiceImpl addressService;

    /**
     * 查询一级地域（省份）接口
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/query/prov/list", method = RequestMethod.POST)
    public Result queryProvinceList(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSignature(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = addressService.queryProvinceList(ent_id,reqParamVO.getAppkey(),reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }

    /**
     * 根据一级地域编码查询二级地域（地市）接口
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/query/city/list", method = RequestMethod.POST)
    public Result queryAllSkuPage(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
       /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSignature(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = addressService.queryCityList(ent_id,reqParamVO.getAppkey(),reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
    /**
     * 根据二级地域编码查询三级地域（区县）接口
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/query/county/list", method = RequestMethod.POST)
    public Result queryBatchQuerySku(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSignature(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = addressService.queryCountyList(ent_id,reqParamVO.getAppkey(),reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
    /**
     * 根据三级地域编码查询四级地域（乡镇）接口
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/query/town/list", method = RequestMethod.POST)
    public Result querySkuSimilar(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSignature(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = addressService.queryTownList(ent_id,reqParamVO.getAppkey(),reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
    /**
     * 校验地址接口
     * @param request
     * @param reqParamVO
     * @return
     */
    @RequestMapping(value = "/check/addr", method = RequestMethod.POST)
    public Result checkAddress(HttpServletRequest request, @RequestBody ReqParamVO reqParamVO) {
        /*1 请求有效性校验*/
        Result result = validApiRequest(reqParamVO.getAppkey(), reqParamVO.getSignature(), reqParamVO.getParams(), reqParamVO.getTimestamp());
        if (result.getError() != 0) {
            return result;
        }
        String ent_id = result.getData().toString();
        /*2 下行请求*/
        result = addressService.CheckAddress(ent_id,reqParamVO.getAppkey(),reqParamVO.getParams());
        if(result ==null){
            return GatApiConstants.HM_SYS_NOT_TIME_ERROR.toResult("请求超时，稍后再试");
        }
        return result;
    }
}
