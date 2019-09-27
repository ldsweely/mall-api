package com.ihangmei.mall.api.dao;

import com.ihangmei.mall.api.entity.EnterPriseEntity;

public interface EnterPriseDao {
    public EnterPriseEntity selectByAppKey(String app_key);

}
