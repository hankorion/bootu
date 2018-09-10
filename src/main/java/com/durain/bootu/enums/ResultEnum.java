package com.durain.bootu.enums;

public enum ResultEnum {
    SUCCESS(200,"success"),
    ERROR_UNKNOWN(500, "error.unkown"),
    ERROR_BAD_REQUEST(400, "error.back.request"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
    	this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
