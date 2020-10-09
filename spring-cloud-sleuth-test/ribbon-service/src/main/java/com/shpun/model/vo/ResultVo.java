package com.shpun.model.vo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/18 14:27
 */
public class ResultVo<T> implements Serializable {

    private Integer code = 0;

    private String message = "ok";

    private T data;

    private static final long serialVersionUID = 1L;

    public static ResultVo<?> ok() {
        return new ResultVo<>();
    }

    public static ResultVo<?> ok(Integer code, String message) {
        ResultVo<?> resultVo = new ResultVo<>();
        resultVo.setCode(code);
        resultVo.setMessage(message);
        return resultVo;
    }

    public static <T> ResultVo<T> okData(T data) {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setData(data);
        return resultVo;
    }

    public static <T> ResultVo<T> okData(T data, String message) {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setMessage(message);
        resultVo.setData(data);
        return resultVo;
    }

    public static <T> ResultVo<T> build(Integer code, T data, String message) {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setCode(code);
        resultVo.setMessage(message);
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVo<?> failure(Integer code, String message) {
        ResultVo<?> resultVo = new ResultVo<>();
        resultVo.setCode(code);
        resultVo.setMessage(message);
        return resultVo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
