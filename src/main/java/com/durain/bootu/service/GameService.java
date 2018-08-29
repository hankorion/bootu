package com.durain.bootu.service;

import java.util.List;

import com.durain.bootu.model.Game;

public interface GameService {

	int addGame(Game game);

	List<Game> findAllGames(int pageNum, int pageSize);

}
