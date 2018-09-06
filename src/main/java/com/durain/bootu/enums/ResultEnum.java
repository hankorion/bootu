package com.durain.bootu.enums;

public enum ResultEnum {
    ERROR_UNKNOWN(500, "error.unkown"),
    SUCCESS(200,"success"),
    ERROR_NOT_FOUND(404,"error.not.found"),
    ;

    private Integer Code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        Code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return Code;
    }

    public String getMsg() {
        return msg;
    }
}
