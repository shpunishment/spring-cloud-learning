package com.shpun.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/25 10:38
 */
public class CustomGatewayFilter implements GatewayFilter {

    private static final Logger logger = LoggerFactory.getLogger(CustomGatewayFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put("start_time", System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute("start_time");
                    if (startTime != null) {
                        long endTime = (System.currentTimeMillis() - startTime);
                        logger.info("耗时：" + exchange.getRequest().getURI().getRawPath() + ": " + endTime + "ms");
                    }
                })
        );
    }

}
