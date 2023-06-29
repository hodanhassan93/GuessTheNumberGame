package com.teamseven.model.service;

import com.teamseven.dto.entity.Game;
import com.teamseven.dto.entity.Round;

public interface RoundService {

	Round addRound(Round round);

	void calculateGuessResult(Game game, Round round);

	String calculateResult(String gameAnswer, String guess);

}
