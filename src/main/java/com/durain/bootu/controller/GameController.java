package com.durain.bootu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	@PostMapping(value = "/game", produces = { "application/json;charset=UTF-8" })
	public int addGame(@Valid Game game) {
		return gameService.addGame(game);
	}

	@DeleteMapping(value = "/game/{gameId}", produces = { "application/json;charset=UTF-8" })
	public int deleteGame(@PathVariable("gameId") int gameId) {
		return gameService.deleteGame(gameId);
	}

	@GetMapping(value = "/game/all/{pageNum}/{pageSize}", produces = { "application/json;charset=UTF-8" })
	public Object findAllGames(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
		return gameService.findAllGames(pageNum, pageSize);
	}

}
