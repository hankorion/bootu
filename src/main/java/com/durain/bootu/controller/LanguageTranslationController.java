package com.durain.bootu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durain.bootu.model.Result;
import com.durain.bootu.service.LanguageTranslationService;
import com.durain.bootu.service.MessageByLocaleService;
import com.durain.bootu.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/language", tags = "语言")
@RestController
@RequestMapping("/language")
public class LanguageTranslationController {

	@Autowired
	LanguageTranslationService languageTranslationService;

	@Autowired
	MessageByLocaleService messageByLocaleService;

	@ApiOperation(value = "语言配置", notes = "语言配置列表")
	@GetMapping(value = "/all/{pageNum}/{pageSize}", produces = { "application/json;charset=UTF-8" })
	public Result<Object> findAllLanguageTranslation(@PathVariable("pageNum") int pageNum,
			@PathVariable("pageSize") int pageSize) {
		return ResultUtil.success(languageTranslationService.findAllLanguageTranslations(pageNum, pageSize));
	}

	@ApiOperation(value = "欢迎", notes = "语言测试")
	@GetMapping("/welcome")
	public Result<Object> welcome() {
		return ResultUtil.success(messageByLocaleService.getMessage("welcome.message"));
	}
}
