package com.durain.bootu.mapper;

import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.durain.bootu.model.LanguageTranslation;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LanguageTranslationMapperTest {

	private static final Logger logger = LoggerFactory.getLogger(LanguageTranslationMapperTest.class);

	@Autowired
	LanguageTranslationMapper ltm;

	private static int testLanguageId;

	@Test
	public void testA10Insert() {
		LanguageTranslation lt = new LanguageTranslation();
		lt.setLanguageCode("en_US");
		lt.setLanguageKey("SYS_TEST_LANGUAGE_TRANSLATION_1");
		lt.setLanguageText("SYS_TEST_LANGUAGE_TRANSLATION_TEXT_1");
		int records = ltm.insert(lt);
		if (records > 0) {
			testLanguageId = lt.getId();
		}
		logger.info("testA10Insert [{}]", lt);
	}

	@Test
	public void testA10ZDeleteByPrimaryKey() {
		logger.info("testA10ZDeleteByPrimaryKey [{}] ", testLanguageId);
		if (Optional.ofNullable(testLanguageId).orElse(0) != 0 && testLanguageId > 1) {
			ltm.deleteByPrimaryKey(testLanguageId);
		}
	}

	@Test
	public void testA20InsertSelective() {
		LanguageTranslation lt = new LanguageTranslation();
		lt.setLanguageCode(null);
		lt.setLanguageCode("en_US");
		lt.setLanguageKey(null);
		lt.setLanguageText(null);
		int records = ltm.insertSelective(lt);
		if (records > 0) {
			testLanguageId = lt.getId();
		}
		logger.info("testA20InsertSelective [{}]", lt);
	}

	@Test
	public void testA20MUpdateByPrimaryKey() {
		LanguageTranslation lt = new LanguageTranslation();
		lt.setId(testLanguageId);
		lt.setLanguageCode("en_US");
		lt.setLanguageKey("SYS_TEST_LANGUAGE_TRANSLATION_1");
		lt.setLanguageText("SYS_TEST_LANGUAGE_TRANSLATION_TEXT_1");
		ltm.updateByPrimaryKey(lt);
		logger.info("testA20MUpdateByPrimaryKey [{}]", lt);
	}

	@Test
	public void testA20MUpdateByPrimaryKeySelective() {
		LanguageTranslation lt = new LanguageTranslation();
		lt.setId(testLanguageId);
		lt.setLanguageCode("");
		lt.setLanguageKey("");
		lt.setLanguageText("");
		ltm.updateByPrimaryKeySelective(lt);
		logger.info("testA20MUpdateByPrimaryKey [{}]", lt);
	}

	@Test
	public void testA20SSelectByPrimaryKey() {
		LanguageTranslation lt = ltm.selectByPrimaryKey(testLanguageId);
		logger.info("testSelectByPrimaryKey [{}]", lt);
	}

	@Test
	public void testA20ZDeleteByPrimaryKey() {
		logger.info("testA20ZDeleteByPrimaryKey [{}] ", testLanguageId);
		if (Optional.ofNullable(testLanguageId).orElse(0) != 0 && testLanguageId > 1) {
			ltm.deleteByPrimaryKey(testLanguageId);
		}
	}

	@Test
	public void testSelectAllLanguageTranslation() {
		List<LanguageTranslation> languageList = ltm.selectAllLanguageTranslation();
		logger.info("testSelectAllLanguageTranslation [{}]", languageList);
	}
}
