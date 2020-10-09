package com.shpun.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
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
    // 添加Sentinel支持
    @SentinelRestTemplate
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}