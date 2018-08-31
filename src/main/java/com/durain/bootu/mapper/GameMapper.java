package com.durain.bootu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.durain.bootu.model.Game;

@Mapper
public interface GameMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Game record);

	int insertSelective(Game record);

	Game selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Game record);

	int updateByPrimaryKey(Game record);

	List<Game> queryAllGames(@Param("offset") Integer offset, @Param("limit") Integer limit);

	List<Game> selectAllGames(@Param("language") String language);
}