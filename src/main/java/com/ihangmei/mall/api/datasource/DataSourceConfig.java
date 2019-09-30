package com.ihangmei.mall.api.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

@Component
@Primary
public class DataSourceConfig {
    @Bean("apiDbProperties")
    @ConfigurationProperties(prefix = "api.datasource")
    public AbstractDbProperties apiDbProperties() {
        return new AbstractDbProperties();
    }

    @Autowired
    @Qualifier("apiDbProperties")
    AbstractDbProperties apiDbProperties;

    public DataSource initApiDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        initDataSource(dataSource, apiDbProperties);
        return dataSource;
    }

    @Bean("iMybatisConfiguration")
    @ConfigurationProperties(prefix = "mybatis.configuration")
    @Primary
    public Configuration globalConfiguration() {
        return new org.apache.ibatis.session.Configuration();
    }

    private void initDataSource(DruidDataSource dataSource, AbstractDbProperties abstractDbProperties) {
        dataSource.setUrl(abstractDbProperties.getUrl());
        dataSource.setUsername(abstractDbProperties.getUsername());
        dataSource.setPassword(abstractDbProperties.getPassword());
        dataSource.setDriverClassName(abstractDbProperties.getDriverClassName());
        dataSource.configFromPropety(initCommonProperties());
    }

    /**
     * 注释：初始化公共部分内容
     */
    private Properties initCommonProperties() {

        Properties properties = new Properties();
        properties.put("initialSize", 3);
        properties.put("minIdle", 3);
        properties.put("maxActive", 10);
        properties.put("maxWait", 60000);
        properties.put("timeBetweenEvictionRunsMillis", 60000);
        properties.put("minEvictableIdleTimeMillis", 30000);
        properties.put("validationQuery", "select 1");
        properties.put("testWhileIdle", true);
        properties.put("testOnBorrow", false);
        properties.put("testOnReturn", false);
        properties.put("filters", "stat");
        properties.put("removeAbandoned", true);
        properties.put("removeAbandonedTimeout", 1800);
        properties.put("defaultAutoCommit", true);

        return properties;
    }

}
