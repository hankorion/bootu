package com.durain.bootu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durain.bootu.model.Game;
import com.durain.bootu.service.GameService;

@RestController
public class GameController {

	@Autowired
	private GameService gameService;

	@PostMapping(value = "/game/add", produces = { "application/json;charset=UTF-8" })
	public int addGame(Game game) {
		return gameService.addGame(game);
	}

	@GetMapping(value = "/game/all/{pageNum}/{pageSize}", produces = { "application/json;charset=UTF-8" })
	public Object findAllGames(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
		return gameService.findAllGames(pageNum, pageSize);
	}
}
