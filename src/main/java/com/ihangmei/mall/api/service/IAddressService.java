package com.ihangmei.mall.api.service;

import com.ihangmei.mall.common.web.Result;

public interface IAddressService {
    /**
     * 查询一级地域（省份）接口
     */
    Result queryProvinceList(String ent_id,String app_key,String params) ;

    /**
     * 根据一级地域编码查询二级地域（地市）接口
     */
    Result queryCityList(String ent_id,String app_key, String params);
    /**
     * 根据二级地域编码查询三级地域（区县）接口
     */
    Result queryCountyList(String ent_id,String app_key, String params);
    /**
     * 根据三级地域编码查询四级地域（乡镇）接口
     */
    Result queryTownList(String ent_id,String app_key, String params);
    /**
     * 校验地址接口
     */
    Result CheckAddress(String ent_id,String app_key, String params);

}
