package com.teamseven.model.service;

import java.util.List;

import com.teamseven.dto.entity.Game;
import com.teamseven.dto.entity.Guess;
import com.teamseven.dto.entity.GuessResult;
import com.teamseven.dto.entity.Round;
import com.teamseven.model.persistence.RoundDao;

public interface RoundService {

	Round addRound(Round round);

	void calculateGuessResult(Game game, Round round);

	List<Round> getAllRoundsOrderedByTime(int gameId);
	
	Round makeGuess(int gameId, Guess guess);
	List<Round> getRoundsForGame(int gameId);

	String calculateResultString(String gameAnswer, Guess guess);

	GuessResult calculateResult(String gameAnswer, String guess);

	Round createRound(int gameId, String guess);

	Game getOneGame(int gamedId);

}
