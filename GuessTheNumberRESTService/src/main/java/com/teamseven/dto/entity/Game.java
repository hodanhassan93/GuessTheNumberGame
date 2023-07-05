package com.teamseven.dto.entity;

public class Game {

	private int gameId;
	private String gameAnswer;
	private boolean gameStatus;
	
	public Game(int gameId, String gameAnswer, boolean gameStatus) {
		super();
		this.gameId = gameId;
		this.gameAnswer = gameAnswer;
		this.gameStatus = gameStatus;
	}
	
	public Game() {
	}
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getGameAnswer() {
		return gameAnswer;
	}
	public void setGameAnswer(String gameAnswer) {
		this.gameAnswer = gameAnswer;
	}
	public boolean isGameStatus() {
		return gameStatus;
	}
	public void setGameStatus(boolean gameStatus) {
		this.gameStatus = gameStatus;
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameAnswer=" + gameAnswer + ", gameStatus=" + gameStatus + "]";
	}
	

}