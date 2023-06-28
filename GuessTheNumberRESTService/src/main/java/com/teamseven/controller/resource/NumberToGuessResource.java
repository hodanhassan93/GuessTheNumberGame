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

import com.teamseven.dto.entity.NumberToGuess;
import com.teamseven.dto.entity.NumberToGuessList;
import com.teamseven.model.service.NumberToGuessService;

@RestController
public class NumberToGuessResource {
	
	@Autowired
	NumberToGuessService numberToGuessService;

}
