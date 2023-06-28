package com.teamseven.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamseven.model.persistence.GameDao;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameDao numberToGuessDao;

}
