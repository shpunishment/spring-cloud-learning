package com.shpun.service;

import com.shpun.model.Order;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/30 15:52
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void add(Order order);

}
