package com.ihangmei.mall.api.service.impl;

import com.ihangmei.mall.api.dao.EnterPriseDao;
import com.ihangmei.mall.api.entity.EnterPriseEntity;
import com.ihangmei.mall.api.service.IEnterPriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("enterPriseService")
public class EnterPriseServiceImpl implements IEnterPriseService {

    @Autowired
    private EnterPriseDao enterPriseDao;

    @Override
    public EnterPriseEntity selectByAppKey(String app_key){
        return enterPriseDao.selectByAppKey(app_key);
    }
    @Override
    public Integer getEntIdByAppKey(String app_key){
        return enterPriseDao.getEntIdByAppKey(app_key);
    }
    @Override
    public String getAppSecretByAppKey(String app_key){
        return enterPriseDao.getAppSecretByAppKey(app_key);
    }
}
