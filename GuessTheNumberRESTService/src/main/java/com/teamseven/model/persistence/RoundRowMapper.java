package com.teamseven.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.teamseven.dto.entity.Round;
import com.teamseven.dto.entity.*;

public class RoundRowMapper implements RowMapper<Round> {

	@Override
	public Round mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Round round=new Round();
		
		round.setRoundId(resultSet.getInt("ROUND_ID"));
		round.setGameId(resultSet.getInt("GAME_ID"));
		round.setTimeOfGuess(resultSet.getTimestamp("time_of_guess").toLocalDateTime());
		round.setGuess(resultSet.getString("GUESS"));
		Timestamp timestamp = resultSet.getTimestamp("TIME_OF_GUESS");   
	    LocalDateTime timeOfGuess = timestamp.toLocalDateTime();
	    round.setTimeOfGuess(timeOfGuess);
		round.setResult(resultSet.getString("RESULT"));
		
        Game game = new Game();
        game.setGameId(resultSet.getInt("game_id"));

        round.setGameId(rowNum);
		
		return round;
	}
}




