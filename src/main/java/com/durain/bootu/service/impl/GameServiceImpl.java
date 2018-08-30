package com.durain.bootu.service.impl;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.durain.bootu.mapper.GameMapper;
import com.durain.bootu.model.Game;
import com.durain.bootu.service.GameService;
import com.github.pagehelper.PageHelper;

@Service(value = "GameService")
public class GameServiceImpl implements GameService {

	private static final Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);

	@Autowired
	private GameMapper gameMapper;

	@Override
	public int addGame(Game game) {
		gameMapper.insertSelective(game);
		logger.debug("Add game {}", game);
		return game.getId();
	}

	@Override
	public int deleteGame(int gameId) {
		logger.debug("deleteGame {}", gameId);
		return gameMapper.deleteByPrimaryKey(gameId);
	}

	@Override
	public List<Game> findAllGames(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Locale locale = LocaleContextHolder.getLocale();
		String language = locale.toString();
		logger.debug("Current locale [{}]", language);
		return gameMapper.selectAllGames(language);
	}

}
