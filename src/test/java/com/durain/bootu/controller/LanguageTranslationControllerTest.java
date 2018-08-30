package com.durain.bootu.controller;

import java.util.Locale;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LanguageTranslationControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(LanguageTranslationControllerTest.class);

	@Autowired
	LanguageTranslationController ltc;

	@Test
	public void testFindAllLanguageTranslation() {
		logger.info("testFindAllLanguageTranslation [{}]", ltc.findAllLanguageTranslation(0, 10));
	}

	@Test
	public void testWelcome() {
		Locale locale = new Locale("zh", "CN");
		logger.info("testWelcome [{}]", ltc.welcome(locale));
	}

}
