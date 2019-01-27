package com.flchen.mongodb_aggregation.web.mo;

import lombok.Data;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 15:13
 **/
@Data
public class OrderAddMO {

    private String userId;

    private String goodsId;

    private Integer quantity;
}
