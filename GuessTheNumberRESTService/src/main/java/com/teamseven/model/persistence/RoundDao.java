package com.teamseven.model.persistence;

import java.util.List;

import com.teamseven.dto.entity.Round;

public interface RoundDao {

//	public void addRound(Round round);
	List<Round> getAllRoundsOrderedByTime(int gameId);
	public Round addRound(Round round);

}
