package com.durain.bootu.util;

import com.durain.bootu.model.Result;

public class ResultUtil {

	public static Result<Object> success(Object object) {
		Result<Object> result = new Result<Object>();
		result.setCode(200);
		result.setMsg("success");
		result.setData(object);
		return result;
	}

	public static Result<Object> success() {
		return success(null);
	}

	public static Result<Object> error(Integer code, String msg) {
		Result<Object> result = new Result<Object>();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}

}
