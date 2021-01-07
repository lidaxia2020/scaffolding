package com.scaffolding.demo.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 21:06
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult<T> {

    public static RestResult suc() {
        return new RestResult(ResultCode.SUC);
    }


    public static RestResult suc(Object data) {
        return new RestResult(ResultCode.SUC, data);
    }

    public static RestResult sucMes(String message) {
        return new RestResult(ResultCode.SUC.getCode(), message);
    }

    public static RestResult failMes(String message) {
        return new RestResult(ResultCode.FAILED.getCode(), message);
    }

    private int code;

    private String message;

    private T data;

    public int getCode() {
        return code;
    }

    public RestResult() {
    }

    public RestResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public RestResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public RestResult(ResultCode resultCode, T data) {
        this(resultCode);
        this.data = data;
    }

}