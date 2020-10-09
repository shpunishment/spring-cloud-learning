package com.shpun.controller;

import com.shpun.model.Order;
import com.shpun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/30 16:22
 */
@RequestMapping("/api/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public void add(@RequestBody Order order) {
        orderService.add(order);
    }

}
