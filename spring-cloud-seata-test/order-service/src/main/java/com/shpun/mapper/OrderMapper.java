package com.shpun.mapper;

import com.shpun.model.Order;

public interface OrderMapper {

    void insertSelective(Order record);

    void completeOrder(Integer orderId);

}