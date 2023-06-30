package com.teamseven.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamseven.dto.entity.Game;
import com.teamseven.dto.entity.Guess;
import com.teamseven.dto.entity.Round;
import com.teamseven.model.persistence.RoundDao;

@Service
public class RoundServiceImpl implements RoundService{
	
	@Autowired
	private GameDao gameDao;
	
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
    
	@Override
	public Round makeGuess(int gameId, Guess guess) {
	    Game game = gameDao.getGameById(gameId);
	    String answer = game.getGameAnswer();

	    String result = computeResult(guess, answer);
	    
	    if(result.equals("e:4:p:0")){
	        game.setGameStatus(true);
	        gameDao.updateGame(game);
	    }

	    Round round = new Round();
	    round.setGuess(guess);
	    round.setTimeOfGuess(LocalDateTime.now());
	    round.setResult(result);
	    round.setGameId(gameId);

	    return roundDao.addRound(round);
	}
	
	
	public String computeResult(Guess guessObj, String answer) {
	    String guess = guessObj.getGuessValue();
	    int exactMatches = 0;
	    int partialMatches = 0;

	    for (int i = 0; i < guess.length(); i++) {
	        char guessDigit = guess.charAt(i);

	        if (answer.charAt(i) == guessDigit) {
	            exactMatches++;
	        } else if (answer.contains(Character.toString(guessDigit))) {
	            partialMatches++;
	        }
	    }

	    return String.format("e:%d:p:%d", exactMatches, partialMatches);
	}


	@Override
	public List<Round> getRoundsForGame(int gameId) {
		return roundDao.getAllRoundsOrderedByTime(gameId);
    }

}
