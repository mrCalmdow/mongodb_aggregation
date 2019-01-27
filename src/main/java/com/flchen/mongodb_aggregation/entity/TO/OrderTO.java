package com.flchen.mongodb_aggregation.entity.TO;

import lombok.Data;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 15:57
 **/
@Data
public class OrderTO {

    private String goodsId;

    private String orderState;

    private Integer goodsPrice;

    private Boolean goodsShelfState;
}
