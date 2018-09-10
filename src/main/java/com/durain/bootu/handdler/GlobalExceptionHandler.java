package com.durain.bootu.handdler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.durain.bootu.enums.ResultEnum;
import com.durain.bootu.model.Result;
import com.durain.bootu.service.MessageByLocaleService;
import com.durain.bootu.util.ResultUtil;

@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Autowired
	MessageByLocaleService messageByLocaleService;

	@ExceptionHandler(BindException.class)
	@ResponseBody
	public Result<Object> handleBindException(BindException ex) {
		BindingResult result = ex.getBindingResult();
		List<String> messages = new ArrayList<>();
		List<String> errorFields = new ArrayList<>();
		for (Object object : result.getAllErrors()) {
			if (object instanceof FieldError) {
				FieldError fieldError = (FieldError) object;
				logger.debug("handleBindException fieldError {}", fieldError);
				String defaultMsg = (fieldError.getDefaultMessage() == null || fieldError.getDefaultMessage().isEmpty())
						? ResultEnum.ERROR_UNKNOWN.getMsg()
						: fieldError.getDefaultMessage();
				messages.add(messageByLocaleService.getMessage(defaultMsg));
				errorFields.add(fieldError.toString());
			} else {
				logger.debug("handleBindException non-fieldError {}", object);
			}
		}
		return ResultUtil.error(ResultEnum.ERROR_BAD_REQUEST.getCode(), messages.toString(), errorFields.toString());
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result<Object> defaultErrorHandler(Exception e) {
		logger.error("[System Exception] {}", e);
		return ResultUtil.error(ResultEnum.ERROR_UNKNOWN.getCode(), e.getMessage(), e.toString());
	}

}