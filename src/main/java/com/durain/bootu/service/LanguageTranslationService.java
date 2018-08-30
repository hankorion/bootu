package com.durain.bootu.service;

import java.util.List;

import com.durain.bootu.model.LanguageTranslation;

public interface LanguageTranslationService {
	
	List<LanguageTranslation> findAllLanguageTranslations(int pageNum, int pageSize);

}
