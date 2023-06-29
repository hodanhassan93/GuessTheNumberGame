package com.teamseven.model.service;

import java.util.List;

import com.teamseven.dto.entity.Game;
import com.teamseven.dto.entity.Round;
import com.teamseven.model.persistence.RoundDao;

public interface RoundService {

	Round addRound(Round round);

	void calculateGuessResult(Game game, Round round);

	String calculateResult(String gameAnswer, String guess);

	List<Round> getAllRoundsOrderedByTime(int gameId);

}
