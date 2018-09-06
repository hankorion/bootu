package com.durain.bootu.service.impl;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import com.durain.bootu.service.MessageByLocaleService;

@Component
public class MessageByLocaleServiceImpl implements MessageByLocaleService {

	private Logger logger = LoggerFactory.getLogger(MessageByLocaleServiceImpl.class);
	@Autowired
	private MessageSource messageSource;

	@Override
	public String getMessage(String id) {
		Locale locale = LocaleContextHolder.getLocale();
		logger.debug("Income id [{}]", id);
		return messageSource.getMessage(id, null, locale);
	}

	@Override
	public String getMessage(ObjectError msgObj) {
		Locale locale = LocaleContextHolder.getLocale();
		logger.debug("Income message [{}]", msgObj);
		return messageSource.getMessage(msgObj, locale);
	}

}