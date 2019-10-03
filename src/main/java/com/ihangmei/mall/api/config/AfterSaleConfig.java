package com.ihangmei.mall.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aftersale.server")
public class AfterSaleConfig {
        /**
         * 服务地址
         */
        private String hostUrl;
}
