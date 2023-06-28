package com.teamseven.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Game {
	
	/*
	 
	Table Game
	GAME_ID int AUTO_INCREMENT PK 
	GameAnswer  varchar(4) not null,
	GameStatus boolean not null

 */
	
	private int gameId;
	private String gameAnswer;
	private boolean gameStatus;
	
	

}
