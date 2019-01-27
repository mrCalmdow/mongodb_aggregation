package com.flchen.mongodb_aggregation.repository;

import com.flchen.mongodb_aggregation.entity.TO.OrderTO;

import java.util.List;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 15:56
 **/
public interface OrderRepo {
    List<OrderTO> findByUserIdOrderByGoods_priceOrderByGoods_shelfState(String userId);
}
