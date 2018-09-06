package com.durain.bootu.service;

import org.springframework.validation.ObjectError;

public interface MessageByLocaleService {
	public String getMessage(String id);
	public String getMessage(ObjectError msgObj);
}
