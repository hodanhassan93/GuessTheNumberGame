package com.teamseven.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.teamseven.dto.entity.Game;
import com.teamseven.model.service.GameService;

@RestController
public class GameResource {
	
	@Autowired
	GameService gameService;


	
	@PostMapping("/begin")
    public ResponseEntity<Game> begin() {
        Game game = gameService.createGame();
        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }

    @GetMapping(path="/games", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<Game>> getAllGames() {
    List<Game> allGames = gameService.getAllGames();
    return new ResponseEntity<>(allGames, HttpStatus.OK);
     
    
    }
    
    @GetMapping("/game/{id}")
    public ResponseEntity<Game> getGame(@PathVariable int id) {
        Game game = gameService.getGame(id);
        if (game == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!game.isGameStatus()) {
            game.setGameAnswer(null);
        }
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    

}