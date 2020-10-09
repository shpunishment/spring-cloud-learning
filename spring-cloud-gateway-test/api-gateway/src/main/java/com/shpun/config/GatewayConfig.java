package com.shpun.config;

import com.shpun.filter.CustomGatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/24 9:30
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // path 和请求的path要一致
//                .route("path_route", r -> r.path("/api/user/*").uri("http://localhost:8101/api/user/*"))
               // hystrix
//                .route("hystrix_route", r -> r.path("/api/user/*").filters(f -> f.hystrix(config -> {
//                    config.setName("fallback");
//                    config.setFallbackUri("forward:/fallback");
//                })).uri("http://localhost:8101/api/user/*"))
                // 限流
//                .route("request_limit_route", r -> r.path("/api/user/*").filters(f -> f.requestRateLimiter(config -> {
//                    config.setKeyResolver(ipKeyResolver());
//                    config.setRateLimiter(redisRateLimiter());
//                })).uri("http://localhost:8101/api/user/*"))
                 // 重试
//                .route("retry_route", r -> r.path("/api/user/*").filters(f -> f.retry(config -> {
//                    config.setRetries(1);
//                    config.setStatuses(HttpStatus.INTERNAL_SERVER_ERROR);
//                })).uri("http://localhost:8101/api/user/*"))
                // 使用自定义过滤器
//                .route("custom_filter_route", r -> r.path("/api/user/*")
//                        .filters(f -> f.filter(new CustomGatewayFilter()))
//                        .uri("http://localhost:8101/api/user/*"))
                .build();
    }

    /**
     * 限流策略生成key规则
     * @return
     */
//    @Bean
//    public KeyResolver ipKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
//    }

    /**
     * Redis 限流
     * @return
     */
//    @Bean
//    public RedisRateLimiter redisRateLimiter() {
//        // 每秒允许处理的请求数量 1，每秒最大处理的请求数量 2
//        return new RedisRateLimiter(1, 2);
//    }

}
