package com.flchen.mongodb_aggregation.web.mo;

import lombok.Data;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 15:05
 **/
@Data
public class GoodsAddMO {
    private String goodsName;

    private String categoryName;

    private Integer price;

    private Boolean shelfStatus;
}
