package com.teamseven.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.teamseven.dto.entity.NumberToGuess;

public class GameRowMapper implements RowMapper<NumberToGuess> {

	@Override
	public NumberToGuess mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		NumberToGuess numberToGuess = new NumberToGuess();
		
		numberToGuess.setNum1(resultSet.getInt("NUM1"));
		numberToGuess.setNum2(resultSet.getInt("NUM2"));
		numberToGuess.setNum3(resultSet.getInt("NUM3"));
		numberToGuess.setNum4(resultSet.getInt("NUM4"));
		
		return numberToGuess;
	}

}