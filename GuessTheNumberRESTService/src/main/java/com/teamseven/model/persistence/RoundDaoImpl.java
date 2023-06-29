package com.teamseven.model.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.teamseven.dto.entity.Round;

public class RoundDaoImpl implements RoundDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void addRound(Round round) {
	    String insertRound = "INSERT INTO round (GAME_ID, Guess, Time_of_guess, Result) VALUES (?, ?, ?, ?)";
	    jdbcTemplate.update(insertRound, round.getGameId(), round.getGuess(), round.getTimeOfGuess(), round.getResult());
	}
	

}
