package com.teamseven.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamseven.dto.entity.Game;
import com.teamseven.model.persistence.GameDao;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameDao gameDao;

	@Override
	public List<Game> getAllGames() {
		List<Game> games = gameDao.getAllGames();
		for(Game game : games) {
	        if(!game.isGameStatus()) {
	            game.setGameAnswer(null);
	        }
	    }
	    
	    return games;
	}
	
}
