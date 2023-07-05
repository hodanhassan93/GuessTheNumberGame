package com.teamseven.dto.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameList {

	List<GameList> gameList;

	public GameList(List<GameList> gameList) {
		super();
		this.gameList = gameList;
	}

	public GameList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<GameList> getGameList() {
		return gameList;
	}

	public void setGameList(List<GameList> gameList) {
		this.gameList = gameList;
	}
	
	
}
