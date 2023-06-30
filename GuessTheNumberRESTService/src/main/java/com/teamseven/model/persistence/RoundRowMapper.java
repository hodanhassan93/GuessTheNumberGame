package com.teamseven.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.teamseven.dto.entity.Round;
import com.teamseven.dto.entity.*;

public class RoundRowMapper implements RowMapper<Round> {

    @Override
    public Round mapRow(ResultSet rs, int rowNum) throws SQLException {
        Round round = new Round();
        round.setRoundId(rs.getInt("id"));
        round.setTimeOfGuess(rs.getTimestamp("time_of_guess").toLocalDateTime());
        round.setResult(rs.getString("result"));

        Game game = new Game();
        game.setGameId(rs.getInt("game_id"));

        round.setGameId(rowNum);

        return round;
    }
}




