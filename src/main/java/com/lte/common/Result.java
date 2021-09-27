package com.lte.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: laite
 * @Date: 2021/9/18 - 09 - 18 - 14:36
 * @Description: com.lte.common
 * @version: 1.0
 */
@Data
public class Result implements Serializable {
    private Object data;
    private String message;
    private Boolean status;

    public Result(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public Result(Object data, String message, Boolean status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }


}
