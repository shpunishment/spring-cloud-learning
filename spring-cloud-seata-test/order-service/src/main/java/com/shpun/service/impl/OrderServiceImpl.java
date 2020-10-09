package com.shpun.service.impl;

import com.shpun.mapper.OrderMapper;
import com.shpun.model.Order;
import com.shpun.service.AccountFeignService;
import com.shpun.service.OrderService;
import com.shpun.service.StorageFeignService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/30 15:52
 */
@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AccountFeignService accountFeignService;

    @Autowired
    private StorageFeignService storageFeignService;

    @Override
    @GlobalTransactional(name = "seata-add-order", rollbackFor = Exception.class)
    public void add(Order order) {
        logger.info("seata XID：{}", RootContext.getXID());

        logger.info("下单开始");

        logger.info("创建订单开始");
        orderMapper.insertSelective(order);
        logger.info("创建订单结束");

        logger.info("扣减商品库存开始");
        storageFeignService.decrease(order.getProductId(), order.getCount());
        logger.info("扣减商品库存结束");

        logger.info("扣减用户余额开始");
        accountFeignService.decrease(order.getUserId(), order.getMoney());
        logger.info("扣减用户余额结束");

        logger.info("修改订单状态开始");
        orderMapper.completeOrder(order.getOrderId());
        logger.info("修改订单状态结束");

        logger.info("下单结束");
    }

}
