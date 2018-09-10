package com.durain.bootu.service.impl;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

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
		String localeMessage = id;
		try {
			localeMessage = messageSource.getMessage(id, null, locale);
		} catch (Exception e) {
			logger.warn("getMessage(String id) : {} ", e);
		}
		return localeMessage;
	}

}