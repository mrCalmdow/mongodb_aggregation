package com.flchen.mongodb_aggregation.web.mo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 10:37
 **/
@Data
public class UserAddMO {

    @NotBlank(message = "userId 不能为空")
    private String userId;

    @NotBlank(message = "userName 不能为空")
    private String userName;

    @NotBlank(message = "password 不能为空")
    private String password;

    private Boolean accountState;
}
