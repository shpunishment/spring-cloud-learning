package com.shpun.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/21 15:12
 */
@Component
public class RouteFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(PreFilter.class);

    @Override
    public String filterType() {
        return ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        logger.info("-----------------RouteFilter");
        return null;
    }
}
