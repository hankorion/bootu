package com.durain.bootu.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.durain.bootu.service.LanguageTranslationService;

@RestController
public class LanguageTranslationController {

	@Autowired
	LanguageTranslationService languageTranslationService;

	@Autowired
	private MessageSource messageSource;

	@GetMapping(value = "/language/all/{pageNum}/{pageSize}", produces = { "application/json;charset=UTF-8" })
	public Object findAllLanguageTranslation(@PathVariable("pageNum") int pageNum,
			@PathVariable("pageSize") int pageSize) {
		return languageTranslationService.findAllLanguageTranslations(pageNum, pageSize);
	}

	@GetMapping("/language/welcome")
	public String welcome(Locale locale) {
		return messageSource.getMessage("welcome.message", null, locale);
	}
}
