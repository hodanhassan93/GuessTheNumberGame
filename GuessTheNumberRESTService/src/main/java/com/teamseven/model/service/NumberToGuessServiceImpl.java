package com.teamseven.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamseven.dto.entity.NumberToGuess;
import com.teamseven.model.persistence.NumberToGuessDao;

@Service
public class NumberToGuessServiceImpl implements NumberToGuessService {
	
	@Autowired
	private NumberToGuessDao numberToGuessDao;

}
