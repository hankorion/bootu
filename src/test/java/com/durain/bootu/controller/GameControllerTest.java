package com.durain.bootu.controller;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.durain.bootu.model.Game;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(GameControllerTest.class);
	private static int testGameId;

	@Autowired
	GameController gameController;

	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext wac;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

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
	public void testAddGameErrorNameSize() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.post("/game").param("name", "1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(400)).andReturn().getResponse()
				.getContentAsString();
		logger.info("testAddGameErrorNameSize result:{}", response);

	}

	@Test
	public void testAddGameErrorEmptyPost() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.post("/game"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(400)).andReturn().getResponse()
				.getContentAsString();
		logger.info("testAddGameErrorEmptyPost result:{}", response);

	}

	@Test
	public void testAddGameErrorExceedLengthPost() throws Exception {
		String response = mockMvc
				.perform(MockMvcRequestBuilders.post("/game").param("name", "TEST EXCEED LENGTH").param("type",
						"01234567890123456789012345678901234567890123456789"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(500)).andReturn().getResponse()
				.getContentAsString();
		logger.info("testAddGameErrorEmptyPost result:{}", response);

	}

	@Test
	public void testDeleteGame() {
		logger.info("testDeleteGame delete game [{}] with result [{}]", testGameId,
				gameController.deleteGame(testGameId));
	}

	@Test
	public void testDeleteGameErrorEmptyGameId() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.delete("/game"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(500)).andReturn().getResponse()
				.getContentAsString();
		logger.info("testDeleteGameErrorEmptyGameId result:{}", response);
	}

	@Test
	public void testFindAllGame() {
		logger.info("testFindAllGame [{}]", gameController.findAllGames(0, 2));
	}

}
