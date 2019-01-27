package com.flchen.mongodb_aggregation.entity;

import com.flchen.mongodb_aggregation.common.entity.BaseDO;
import lombok.Data;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 09:15
 **/
@Data
@Document(collection = "order")
public class OrderDO extends BaseDO {

    public static final String STATE_WAIT_PAYMENT = "0";
    public static final String STATE_WAIT_SHIPPING = "1";
    public static final String STATE_WAIT_RECEIVE = "2";
    public static final String STATE_HAS_RECEIVED = "3";
    public static final String STATE_AUDIT_REFUND = "4";
    public static final String STATE_SUCCESS_REFUND = "5";

    private String orderNo;

    private String userId;

    private Integer quantity;

    private Integer totalPrice;

    @DBRef
    private GoodsDO goods;

    private String orderState;
}
