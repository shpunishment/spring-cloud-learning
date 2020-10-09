package com.shpun.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/25 10:53
 */
@Component
public class CustomGlobalFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(CustomGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put("global_start_time", System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute("global_start_time");
                    if (startTime != null) {
                        long endTime = (System.currentTimeMillis() - startTime);
                        logger.info("耗时：" + exchange.getRequest().getURI().getRawPath() + ": " + endTime + "ms");
                    }
                })
        );
    }
}
