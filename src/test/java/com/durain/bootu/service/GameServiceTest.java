package com.durain.bootu.service;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.durain.bootu.model.Game;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(GameServiceTest.class);

	private static int testGameId;

	@Autowired
	GameService gameService;

	@Test
	public void testAddGame() {
		Game tGame = new Game();
		tGame.setType("0");
		tGame.setName("SYS_TEST_GAME_1");
		tGame.setTemplate("SYS_TEST_TEMP_1");
		tGame.setSort("10");
		tGame.setGkey("SYS_TEST_GKEY_1");
		tGame.setShowName("SYS_TEST_GAME_SHOW_NAME_1");
		int addResult = gameService.addGame(tGame);
		logger.info("testAddGame [{}] ", addResult);
		if (addResult > 0) {
			testGameId = tGame.getId();
		}
	}

	@Test
	public void testDeleteGame() {
		logger.info("testDeleteGame delete game [{}] with result [{}]", testGameId, gameService.deleteGame(testGameId));
	}

	@Test
	public void testFindAllGame() {
		List<Game> gamesList = (List<Game>) gameService.findAllGames(0, 2);
		for (Game game : gamesList) {
			System.out.println(game);
		}
	}

}
