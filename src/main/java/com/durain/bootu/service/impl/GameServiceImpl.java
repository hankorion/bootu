package com.durain.bootu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durain.bootu.mapper.GameMapper;
import com.durain.bootu.model.Game;
import com.durain.bootu.service.GameService;
import com.github.pagehelper.PageHelper;

@Service(value = "GameService")
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameMapper gameMapper;

	@Override
	public int addGame(Game game) {
		gameMapper.insertSelective(game);
		return game.getId();
	}

	@Override
	public List<Game> findAllGames(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return gameMapper.selectAllGames();
	}

}
