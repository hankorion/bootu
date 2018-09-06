package com.durain.bootu.exception;

import com.durain.bootu.enums.ResultEnum;

public class RestException extends RuntimeException {

	private static final long serialVersionUID = -5941374379707278091L;
	private Integer code;

	public RestException(ResultEnum resultEnum){
	        super(resultEnum.getMsg());
	        this.code = resultEnum.getCode();
	    }

	public RestException(String msg) {
		this.code = 204;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
