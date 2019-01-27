package com.flchen.mongodb_aggregation.service;

import com.flchen.mongodb_aggregation.entity.OrderDO;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 15:15
 **/
public interface OrderService {

    OrderDO makeOrder(OrderDO order);
}
