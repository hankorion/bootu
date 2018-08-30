package com.durain.bootu.controller;

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
public class GameControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(GameControllerTest.class);
	private static int testGameId;

	@Autowired
	GameController gameController;

	@Test
	public void testAddGame() {
		Game tGame = new Game();
		tGame.setType("0");
		tGame.setName("SYS_TEST_GAME_1");
		tGame.setTemplate("SYS_TEST_TEMP_1");
		tGame.setSort("10");
		tGame.setGkey("SYS_TEST_GKEY_1");
		tGame.setShowName("SYS_TEST_GAME_SHOW_NAME_1");
		int addResult = gameController.addGame(tGame);
		logger.info("testAddGame [{}] ", addResult);
		if (addResult > 0) {
			testGameId = tGame.getId();
		}
	}

	@Test
	public void testDeleteGame() {
		logger.info("testDeleteGame delete game [{}] with result [{}]", testGameId,
				gameController.deleteGame(testGameId));
	}

	@Test
	public void testFindAllGame() {
		logger.info("testFindAllGame [{}]", gameController.findAllGames(0, 2));
	}

}
