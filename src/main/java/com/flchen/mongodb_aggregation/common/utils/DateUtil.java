package com.flchen.mongodb_aggregation.common.utils;

import org.springframework.stereotype.Service;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 10:39
 **/
@Service
public class DateUtil {

    public static Long nowUnixTime() {
        return System.currentTimeMillis() % 1000;
    }
}
