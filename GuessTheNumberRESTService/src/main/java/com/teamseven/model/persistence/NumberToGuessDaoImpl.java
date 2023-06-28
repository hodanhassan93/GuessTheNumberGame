package com.teamseven.model.persistence;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.teamseven.dto.entity.NumberToGuess;

@Repository
public class NumberToGuessDaoImpl implements NumberToGuessDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

}
