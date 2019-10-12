package com.ihangmei.mall.api.dao;

import com.ihangmei.mall.api.entity.EnterPriseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterPriseDao {
    public EnterPriseEntity selectByAppKey(String app_key);

    public Integer getEntIdByAppKey(String app_key);

    public String getAppSecretByAppKey(String app_key);

}
