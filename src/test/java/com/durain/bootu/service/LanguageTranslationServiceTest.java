package com.durain.bootu.service;

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
public class LanguageTranslationServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(LanguageTranslationServiceTest.class);

	@Autowired
	LanguageTranslationService lts;

	@Test
	public void testFindAllLanguageTranslations() {
		logger.info("testFindAllLanguageTranslations [{}]", lts.findAllLanguageTranslations(0, 10));
	}

}
