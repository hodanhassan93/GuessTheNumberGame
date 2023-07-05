package com.teamseven.model.persistence;

import java.util.List;

import com.teamseven.dto.entity.Game;

public interface GameDao {
	
		public Game addGame(Game game);
		List<Game> getAllGames();
	    Game getGame(Integer id);
	    public Game getGameById(int id);
		public void updateGame(Game game);
		Game getOneGame(int gamedId);
		int updateGame(int gameId, boolean b);
}