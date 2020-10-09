package com.shpun.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/18 14:50
 */
@Configuration
public class RibbonConfig {

    @Bean
    // 赋予RestTemplate负载均衡的能力
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}