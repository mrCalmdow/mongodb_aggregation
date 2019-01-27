package com.flchen.mongodb_aggregation.common.controller;

import com.flchen.mongodb_aggregation.common.entity.BaseDO;
import com.flchen.mongodb_aggregation.common.mo.ResponseMO;
import com.flchen.mongodb_aggregation.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 10:00
 **/
@Slf4j
@RestController
public abstract class BaseController {

    protected ResponseMO success() {
        return new ResponseMO();
    }

    protected <T> ResponseMO success(T data) {
        return new ResponseMO(data);
    }

    protected ResponseMO error(String message) {

        return new ResponseMO(ResponseMO.CODE_FAILURE, message);
    }

    protected void addCreateInfo(BaseDO baseDO) {
        baseDO.setCreateTime(DateUtil.nowUnixTime());
    }
}
