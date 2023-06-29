package com.teamseven.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.teamseven.dto.entity.Game;
import com.teamseven.dto.entity.Round;
import com.teamseven.model.persistence.RoundDao;

public class RoundServiceImpl implements RoundService{
	
	@Autowired
	private RoundDao roundDao;

    @Override
    public Round addRound(Round round) {
        roundDao.addRound(round);
        return round;
    }

    @Override
    public void calculateGuessResult(Game game, Round round) {
        String gameAnswer = game.getGameAnswer();
        String guess = round.getGuess();

        
        String result = calculateResult(gameAnswer, guess);

        
        round.setResult(result);

        
        if (result.equals("e:4,p:0")) {
            
            game.setGameStatus(true);
        }
    }

    @Override
    public String calculateResult(String gameAnswer, String guess) {
        
        int exactMatches = 0;
        int partialMatches = 0;

        for (int i = 0; i < gameAnswer.length(); i++) {
            if (gameAnswer.charAt(i) == guess.charAt(i)) {
                exactMatches++;
            } else if (gameAnswer.contains(String.valueOf(guess.charAt(i)))) {
                partialMatches++;
            }
        }

        return "e:" + exactMatches + ",p:" + partialMatches;
    }
    
    @Override
    public List<Round> getAllRoundsOrderedByTime(int gameId) {
        return roundDao.getAllRoundsOrderedByTime(gameId);
    }
}
