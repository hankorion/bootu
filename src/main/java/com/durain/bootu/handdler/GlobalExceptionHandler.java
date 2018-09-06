package com.durain.bootu.handdler;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.durain.bootu.exception.RestException;
import com.durain.bootu.model.Result;
import com.durain.bootu.service.MessageByLocaleService;
import com.durain.bootu.util.ResultUtil;

@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Autowired
	MessageByLocaleService messageByLocaleService;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public Result<Object> handleArgumentNotValidException(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<String> errorMessages = result.getAllErrors().stream()
				.map(objectError -> messageByLocaleService.getMessage(objectError.getDefaultMessage()))
				.collect(Collectors.toList());
		return ResultUtil.error(400, errorMessages.toString());
	}

	@ExceptionHandler(BindException.class)
	@ResponseBody
	public Result<Object> handleBindException(BindException ex) {
		BindingResult result = ex.getBindingResult();
		List<String> errorMessages = result.getAllErrors().stream()
				.map(objectError -> messageByLocaleService.getMessage(objectError.getDefaultMessage()))
				.collect(Collectors.toList());
		return ResultUtil.error(400, errorMessages.toString());
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result<Object> defaultErrorHandler(Exception e) {
		logger.error("[System Exception] {}", e);
		if (e instanceof RestException) {
			RestException bootuException = (RestException) e;
			return ResultUtil.error(bootuException.getCode(), bootuException.getMessage());
		} else {
			return ResultUtil.error(-1, e.getMessage());
		}
	}

}