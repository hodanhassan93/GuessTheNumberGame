package com.teamseven.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Lombok dependencies
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class NumberToGuess {
	
	private int num1;
	private int num2;
	private int num3;
	private int num4;

}
