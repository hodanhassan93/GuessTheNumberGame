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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/rounds/{gameId}")
    public ResponseEntity<Round> makeGuess(@PathVariable Integer gameId, @RequestBody Guess guess) {
        Round round = roundService.makeGuess(gameId, guess);
        return new ResponseEntity<>(round, HttpStatus.CREATED);
    }


    @GetMapping(path = "/rounds/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<Round>> getAllRoundsOrderedByTime(@PathVariable int gameId) {
        List<Round> allRoundsByGameId = roundService.getRoundsForGame(gameId);
        return new ResponseEntity<>(allRoundsByGameId, HttpStatus.OK);
    }
}