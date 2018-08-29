package com.durain.bootu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.durain.bootu.model.Game;
import com.durain.bootu.service.GameService;

@Controller
@RequestMapping(value = "/game")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@ResponseBody
	@RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
	public int addGame(Game game) {
		 return gameService.addGame(game);
	}
	
	@ResponseBody
	@RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
	public Object findAllGames(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
		return gameService.findAllGames(pageNum, pageSize);
	}

}
