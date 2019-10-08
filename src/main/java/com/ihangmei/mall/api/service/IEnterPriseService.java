package com.ihangmei.mall.api.service;

import com.ihangmei.mall.api.entity.EnterPriseEntity;

public interface IEnterPriseService {
    public EnterPriseEntity selectByAppKey(String app_key);
    public Integer getEntIdByAppKey(String app_key);
    public String getAppSecretByAppKey(String app_key);
}
