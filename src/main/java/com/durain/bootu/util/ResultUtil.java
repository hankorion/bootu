package com.durain.bootu.util;

import com.durain.bootu.model.ErrorResult;
import com.durain.bootu.model.Result;

public class ResultUtil {

	private ResultUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static Result<Object> success(Object object) {
		Result<Object> result = new Result<>();
		result.setCode(200);
		result.setMsg("success");
		result.setData(object);
		return result;
	}

	public static Result<Object> success() {
		return success(null);
	}

	public static Result<Object> error(Integer code, String msg, String errorDetails) {
		ErrorResult result = new ErrorResult();
		result.setCode(code);
		result.setMsg(msg);
		result.setErrorDetails(errorDetails);
		return result;
	}

}
