package com.teamseven.model.service;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

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

	@Override
    public Game createGame() {
        Game game = new Game();
        game.setGameAnswer(generateUniqueFourDigitNumber());
        game.setGameStatus(false);
        return gameDao.addGame(game);
    }

    private String generateUniqueFourDigitNumber() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(numbers);
        return numbers.subList(0, 4).stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
    
    @Override
    public Game getGame(int id) {
        return gameDao.getGameById(id);
    }

    
    
}