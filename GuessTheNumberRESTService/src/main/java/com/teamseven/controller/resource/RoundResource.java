package com.teamseven.controller.resource;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamseven.dto.entity.Game;
import com.teamseven.dto.entity.Round;
import com.teamseven.model.service.GameService;
import com.teamseven.model.service.RoundService;

@RestController
public class RoundResource {
	
	@Autowired
	RoundService roundService;
	GameService	 gameService;
	
	
    @GetMapping(path = "/rounds/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<Round>> getAllRoundsOrderedByTime(@PathVariable int gameId) {
        List<Round> allRoundsByGameId = roundService.getAllRoundsOrderedByTime(gameId);
        return new ResponseEntity<>(allRoundsByGameId, HttpStatus.OK);
    }


}
