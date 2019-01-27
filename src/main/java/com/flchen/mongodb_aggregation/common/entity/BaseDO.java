package com.flchen.mongodb_aggregation.common.entity;

import lombok.Data;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 09:16
 **/
@Data
public class BaseDO {

    public static final Boolean ENABLE = Boolean.TRUE;
    public static final Boolean DISABLE = Boolean.FALSE;
    private String id;

    private Long createTime;

    private Boolean enable = ENABLE;
}
