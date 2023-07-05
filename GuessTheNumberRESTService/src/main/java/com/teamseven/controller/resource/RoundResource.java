package com.teamseven.controller.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamseven.dto.entity.Game;
import com.teamseven.dto.entity.Guess;
import com.teamseven.dto.entity.Round;
import com.teamseven.model.service.GameService;
import com.teamseven.model.service.RoundService;

@RestController
public class RoundResource {

    @Autowired
    private RoundService roundService;
    @Autowired
    private GameService gameService;

//    @PostMapping("/rounds/{gameId}")
//    public ResponseEntity<Round> makeGuess(@PathVariable Integer gameId, @RequestBody Guess guess) {
//        if (guess == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        Round round = roundService.makeGuess(gameId, guess);
//        return new ResponseEntity<>(round, HttpStatus.CREATED);
//    }

    @GetMapping(path = "/rounds/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Round>> getAllRoundsOrderedByTime(@PathVariable int gameId) {
        List<Round> allRoundsByGameId = roundService.getRoundsForGame(gameId);
        return new ResponseEntity<>(allRoundsByGameId, HttpStatus.OK);
    }
    
//	@PostMapping("/begin")
//    public ResponseEntity<Game> begin() {
//        Game game = gameService.createGame();
//        return new ResponseEntity<>(game, HttpStatus.CREATED);
//    }
//
//
//    @PostMapping("/guess")
//	public ResponseEntity<Round> makeGuess(@RequestBody Round round){
//		int gameId = round.getGameId();
//	    String guess = round.getGuess();
//	    gameService.updateGame(gameId, guess);
//	    Round roundNew = roundService.createRound(gameId, guess);
//	    if (roundNew != null) {
//	        if (gameService.getOneGame(gameId).isGameStatus()) {
//	            roundNew.setResult("Correct Guess!");
//	        }
//	        return new ResponseEntity<Round>(roundNew, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<Round>(HttpStatus.NOT_IMPLEMENTED);
//	    }
//	}
	
    @PostMapping(path = "/guess",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Round> makeGuess(@RequestBody Round round){
		int gameId = round.getGameId();
	    String guess = round.getGuess();
	    gameService.updateGame(gameId, guess);
	    Round roundNew = roundService.createRound(gameId, guess);
	    if (roundNew != null) {
	        if (gameService.getOneGame(gameId).isGameStatus()) {
	            roundNew.setResult("Correct Guess!");
	        }
	        return new ResponseEntity<Round>(roundNew, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<Round>(HttpStatus.NOT_IMPLEMENTED);
	    }
	}

}