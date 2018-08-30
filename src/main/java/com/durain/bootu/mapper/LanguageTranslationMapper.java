package com.durain.bootu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.durain.bootu.model.LanguageTranslation;

@Mapper
public interface LanguageTranslationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LanguageTranslation record);

    int insertSelective(LanguageTranslation record);

    LanguageTranslation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LanguageTranslation record);

    int updateByPrimaryKey(LanguageTranslation record);
    
	List<LanguageTranslation> selectAllLanguageTranslation();
}