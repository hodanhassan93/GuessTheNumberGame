package com.teamseven.model.service;

import java.util.List;

import com.teamseven.dto.entity.Game;
import com.teamseven.dto.entity.Round;


public interface GameService {
	
	List<Game> getAllGames();
	 Game createGame() ;
	 public Game getGame(int id);
	 int updateGameBool(int gameId, String guess);
	 Game getOneGame(int gamedId);
	 public Round updateGame(int gameId, String guess);
		
}