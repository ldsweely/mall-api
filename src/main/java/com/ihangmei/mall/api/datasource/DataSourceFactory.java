package com.ihangmei.mall.api.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataSourceFactory {

    public enum DataSourceName{
        Api
    }
    private static final Map<DataSourceName, DataSource> dataSourceMap = new HashMap<DataSourceName, DataSource>();

    @Bean("apiDataSource")
    public DataSource apiDataSource() {
        return getDataSource(DataSourceName.Api);
    }

    @Autowired
    DataSourceConfig dataSourceConfig;

    public DataSource getDataSource(DataSourceName type) {
        synchronized (type) {
            if (dataSourceMap.get(type) == null) {
                dataSourceMap.put(type, createDataSource(type));
            }
            return dataSourceMap.get(type);
        }
    }

    /**
     *
     */
    private DataSource createDataSource(DataSourceName type) {
        switch (type) {
            case Api:
                return dataSourceConfig.initApiDataSource();
            default:
                return null;
        }

    }
}
