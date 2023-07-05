package com.teamseven.dto.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoundList {

//	List<RoundList> roundList;
	private List<Round> rounds;

	public RoundList(List<Round> rounds) {
		super();
		this.rounds = rounds;
	}
	
	public RoundList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Round> getRounds() {
		return rounds;
	}
	
	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}
	
}
