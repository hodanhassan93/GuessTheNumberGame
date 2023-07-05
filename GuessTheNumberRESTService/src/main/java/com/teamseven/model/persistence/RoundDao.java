package com.teamseven.model.persistence;

import java.util.List;

import com.teamseven.dto.entity.Round;

public interface RoundDao {

	List<Round> getAllRoundsOrderedByTime(int gameId);
	public Round addRound(Round round);
	public int addRoundBool(Round round);

}
