package com.teamseven.model.persistence;
import java.sql.PreparedStatement;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.teamseven.dto.entity.Game;
import com.teamseven.dto.entity.Round;
import com.teamseven.model.persistence.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;

@Repository
public class GameDaoImpl implements GameDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Game> getAllGames() {
		String query = "SELECT GAME_ID, GAMEANSWER, GAMESTATUS from game";
		return  jdbcTemplate.query(query, new GameRowMapper());
	}

	@Override
	public Game addGame(Game game) {
		String sql = "INSERT INTO game (gameanswer, gamestatus) VALUES (?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, game.getGameAnswer());
            ps.setBoolean(2, game.isGameStatus());
            return ps;
        }, keyHolder);

        game.setGameId(keyHolder.getKey().intValue());
        return game;
    
	}

	@Override
	public Game getGameById(int id) {
	    final String sql = "SELECT * FROM game WHERE game_id = ?";
	    return jdbcTemplate.queryForObject(sql, new GameRowMapper(), id);
	}

	@Override
	public Game getGame(Integer id) {
		String sql = "SELECT * FROM game WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new GameRowMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
	}

	@Override
    public void updateGame(Game game) {
        String sql = "UPDATE game SET gameanswer = ?, gamestatus = ? WHERE game_id = ?";

        jdbcTemplate.update(sql, game.getGameAnswer(), game.isGameStatus(), game.getGameId());
    }

	@Override
	public Game getOneGame(int gamedId) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM GAME WHERE GAME_ID=?", new GameRowMapper(),gamedId);
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int updateGame(int gameId,boolean status) {
		try {
			return jdbcTemplate.update("UPDATE GAME SET GAMESTATUS=? WHERE GAME_ID=?", status, gameId);
		} catch (Exception ex) {
			return 0;
		}
	}
	
	
}