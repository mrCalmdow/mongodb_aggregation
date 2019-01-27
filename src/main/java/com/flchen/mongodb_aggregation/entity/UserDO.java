package com.flchen.mongodb_aggregation.entity;

import com.flchen.mongodb_aggregation.common.entity.BaseDO;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * user entity
 * author fl.chen
 * Date 2019-01-27
 * Time 09:14
 **/
@Data
@Document(collection = "User")
public class UserDO extends BaseDO {

    private String userId;

    private String userName;

    private String password;

    private Boolean accountState;
}
