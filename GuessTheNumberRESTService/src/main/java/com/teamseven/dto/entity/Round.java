package com.teamseven.dto.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;




@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Round {
	
	private int roundId;
	private int gameId;
	private String guess;
	private Timestamp timeOfGuess;
	private String result;

}


