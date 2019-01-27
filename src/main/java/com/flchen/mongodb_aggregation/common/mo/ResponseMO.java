package com.flchen.mongodb_aggregation.common.mo;

import lombok.Data;
import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 * author fl.chen
 * Date 2019-01-27
 * Time 10:01
 **/
@Data
public class ResponseMO<T> {

    public static final Integer CODE_SUCCESS = 0;
    public static final Integer CODE_FAILURE = 1;

    private Integer code = CODE_SUCCESS;

    private String message = "";

    private T data;

    private String debugInfo;

    public ResponseMO() {

    }

    public ResponseMO(T data) {
        this.data = data;
    }

    public ResponseMO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseMO(Integer code, T data) {

        this.code = code;
        this.data = data;
    }

    public ResponseMO(Integer code, T data, String message) {

        this.code = code;
        this.message = message;
        this.data = data;
    }
}
