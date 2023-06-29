package com.teamseven.model.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



import com.teamseven.dto.entity.Round;
public class RoundRowMapper implements RowMapper<Round> {

	@Override
	public Round mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Round round=new Round();
		
		round.setRoundId(resultSet.getInt("ROUND_ID"));
		round.setGameId(resultSet.getInt("GAME_ID"));
		round.setGuess(resultSet.getString("GUESS"));
		round.setTimeOfGuess(resultSet.getTimestamp("TIME_OF_GUESS"));
		round.setResult(resultSet.getString("RESULT"));
		
		return round;
	}
}
