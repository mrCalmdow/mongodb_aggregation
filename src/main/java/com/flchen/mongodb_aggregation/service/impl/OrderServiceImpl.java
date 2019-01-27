package com.flchen.mongodb_aggregation.service.impl;

import com.flchen.mongodb_aggregation.entity.OrderDO;
import com.flchen.mongodb_aggregation.repository.GoodsAutoRepo;
import com.flchen.mongodb_aggregation.repository.OrderAutoRepo;
import com.flchen.mongodb_aggregation.repository.UserAutoRepo;
import com.flchen.mongodb_aggregation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 15:16
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderAutoRepo orderAutoRepo;

    @Autowired
    private GoodsAutoRepo goodsAutoRepo;

    @Autowired
    private UserAutoRepo userAutoRepo;

    @Override
    public OrderDO makeOrder(OrderDO order) {
        Assert.hasText(order.getUserId(), "userId can't be null");


        return null;
    }
}
