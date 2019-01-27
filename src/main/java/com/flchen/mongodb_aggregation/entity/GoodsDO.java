package com.flchen.mongodb_aggregation.entity;

import com.flchen.mongodb_aggregation.common.entity.BaseDO;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 09:15
 **/
@Data
@Document(collection = "goods")
public class GoodsDO extends BaseDO {

    private String goodsName;

    private String categoryName;

    private Integer price;

    private Boolean shelfStatus;
}
