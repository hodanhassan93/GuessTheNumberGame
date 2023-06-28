package com.teamseven.dto.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok dependencies
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NumberToGuessList {
	
	List<NumberToGuess> numberToGuess;

}
