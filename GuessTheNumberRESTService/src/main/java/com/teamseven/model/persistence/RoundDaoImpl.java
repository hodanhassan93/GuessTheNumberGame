package com.teamseven.model.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.teamseven.dto.entity.Round;

@Repository
public class RoundDaoImpl implements RoundDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    @Override
	public Round addRound(Round round) {
	    String insertRound = "INSERT INTO round (GAME_ID, Guess, Time_of_guess, Result) VALUES (?, ?, ?, ?)";
	    jdbcTemplate.update(insertRound, round.getGameId(), round.getGuess(), round.getTimeOfGuess(), round.getResult());
		return round;
	}
	
	@Override
	public List<Round> getAllRoundsOrderedByTime(int gameId) {
	    String sql = "SELECT r.* " +
	                       "FROM round r " +
	                       "WHERE r.GAME_ID = ? " +
	                       "ORDER BY r.Time_of_guess ASC";
	    return jdbcTemplate.query(sql, new RoundRowMapper(), gameId);
	}

	@Override
	public int addRoundBool(Round round) {
		try {
			return jdbcTemplate.update("INSERT INTO ROUND VALUES(?,?,?,?,?)", round.getRoundId(),round.getGameId(), round.getGuess(),
					round.getTimeOfGuess(), round.getResult());
		} catch (Exception ex) {
			return 0;
		}
	}

}
