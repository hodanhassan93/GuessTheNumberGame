package com.teamseven.dto.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Round {
	
	private int roundId;
	private int gameId;
	private String guess;
	private Guess guessObj;
	private LocalDateTime timeOfGuess;
	private String result;
	
	public Round(int roundId, int gameId, String guess, Guess guessObj, LocalDateTime timeOfGuess, String result) {
		super();
		this.roundId = roundId;
		this.gameId = gameId;
		this.guess = guess;
		this.guessObj = guessObj;
		this.timeOfGuess = timeOfGuess;
		this.result = result;
	}

	public Round() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRoundId() {
		return roundId;
	}

	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGuess() {
		return guess;
	}

	public void setGuess(String guess) {
		this.guess = guess;
	}

	public Guess getGuessObj() {
		return guessObj;
	}

	public void setGuessObj(Guess guessObj) {
		this.guessObj = guessObj;
	}

	public LocalDateTime getTimeOfGuess() {
		return timeOfGuess;
	}

	public void setTimeOfGuess(LocalDateTime timeOfGuess) {
		this.timeOfGuess = timeOfGuess;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Round [roundId=" + roundId + ", gameId=" + gameId + ", guess=" + guess + ", guessObj=" + guessObj
				+ ", timeOfGuess=" + timeOfGuess + ", result=" + result + "]";
	}


	
}