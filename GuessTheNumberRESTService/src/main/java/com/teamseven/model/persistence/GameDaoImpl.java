package com.teamseven.model.persistence;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.teamseven.dto.entity.Game;

import com.teamseven.model.persistence.*;

@Repository
public class GameDaoImpl implements GameDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Game> getAllGames() {
		String query = "SELECT GAME_ID, GAMEANSWER, GAMESTATUS from game";
		return  jdbcTemplate.query(query, new GameRowMapper());
	}

}
