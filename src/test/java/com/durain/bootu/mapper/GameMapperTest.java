package com.durain.bootu.mapper;

import java.util.List;
import java.util.Optional;

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
public class GameMapperTest {

	private static final Logger logger = LoggerFactory.getLogger(GameMapperTest.class);

	@Autowired
	GameMapper gameMapper;

	private static int testGameID;

	@Test
	public void testA10Insert() {
		Game tGame = new Game();
		tGame.setType("0");
		tGame.setName("SYS_TEST_GAME_1");
		tGame.setTemplate("SYS_TEST_TEMP_1");
		tGame.setSort("10");
		tGame.setGkey("SYS_TEST_GKEY_1");
		tGame.setShowName("SYS_TEST_GAME_SHOW_NAME_1");
		int records = gameMapper.insert(tGame);
		if (records > 0) {
			testGameID = tGame.getId();
		}
		logger.info("testGameID {}" + tGame);
	}

	@Test
	public void testA10ZDeleteByPrimaryKey() {
		logger.info("testD10DeleteByPrimaryKey -> {} ", testGameID);
		if (Optional.ofNullable(testGameID).orElse(0) != 0 && testGameID > 1) {
			gameMapper.deleteByPrimaryKey(testGameID);
		}
	}

	@Test
	public void testA20InsertSelective() {
		Game tGame = new Game();
		tGame.setType("0");
		tGame.setName("SYS_TEST_GAME_2");
		tGame.setTemplate("SYS_TEST_TEMP_2");
		tGame.setSort("20");
		tGame.setGkey("SYS_TEST_GKEY_2");
		tGame.setShowName("SYS_TEST_GAME_SHOW_NAME_2");
		int records = gameMapper.insertSelective(tGame);
		if (records > 0) {
			testGameID = tGame.getId();
		}
		logger.info("testA20InsertSelective {}", tGame);
	}

	@Test
	public void testA20MUpdateByPrimaryKey() {
		Game tGame = new Game();
		tGame.setId(testGameID);
		tGame.setType(null);
		tGame.setName(null);
		tGame.setTemplate(null);
		tGame.setSort(null);
		tGame.setGkey(null);
		tGame.setShowName(null);
		tGame.setDefine(null);
		tGame.setFunR(null);
		int records = gameMapper.updateByPrimaryKey(tGame);
		if (records > 0) {
			testGameID = tGame.getId();
		}
		logger.info("testA20MUpdateByPrimaryKey {}", tGame);
	}

	@Test
	public void testA20MUpdateByPrimaryKeySelective() {
		Game tGame = new Game();
		tGame.setId(testGameID);
		tGame.setType("0");
		tGame.setName("SYS_TEST_GAME_2_UPDATED_Selective");
		tGame.setTemplate("SYS_TEST_TEMP_2_UPDATED_Selective");
		tGame.setSort("20");
		tGame.setGkey("SYS_TEST_GKEY_2_UPDATED_Selective");
		tGame.setShowName("SYS_TEST_GAME_SHOW_NAME_2_UPDATED_Selective");
		tGame.setDefine("DEFINE");
		tGame.setFunR("FUN_R");

		int records = gameMapper.updateByPrimaryKeySelective(tGame);
		if (records > 0) {
			testGameID = tGame.getId();
		}
		logger.info("testA20MUpdateByPrimaryKeySelective {}", tGame.toString());
	}

	@Test
	public void testA20SSelectByPrimaryKey() {
		Game gameOne = gameMapper.selectByPrimaryKey(new Integer(1));
		System.out.println(gameOne.toString());
	}

	@Test
	public void testA20ZDeleteByPrimaryKey() {
		logger.info("testA20ZDeleteByPrimaryKey {} ", testGameID);
		if (Optional.ofNullable(testGameID).orElse(0) != 0 && testGameID > 1) {
			gameMapper.deleteByPrimaryKey(testGameID);
		}
	}

	@Test
	public void testQueryAllGames() {
		List<Game> gamesList = gameMapper.queryAllGames(0, 100);
		for (Game game : gamesList) {
			System.out.println(game);
		}
	}

}
