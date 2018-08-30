package com.durain.bootu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durain.bootu.mapper.LanguageTranslationMapper;
import com.durain.bootu.model.LanguageTranslation;
import com.durain.bootu.service.LanguageTranslationService;
import com.github.pagehelper.PageHelper;

@Service(value = "LanguageTranslationService")
public class LanguageTranslationServiceImpl implements LanguageTranslationService {

	@Autowired
	LanguageTranslationMapper languageTranslationMapper;

	@Override
	public List<LanguageTranslation> findAllLanguageTranslations(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return languageTranslationMapper.selectAllLanguageTranslation();
	}

}
