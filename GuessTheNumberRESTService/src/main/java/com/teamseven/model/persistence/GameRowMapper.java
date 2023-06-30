package com.teamseven.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.teamseven.model.service.*;
import com.teamseven.dto.entity.Game;
import com.teamseven.model.persistence.*;

public class GameRowMapper implements RowMapper<Game> {

	@Override
    public Game mapRow(ResultSet rs, int i) throws SQLException {
        Game game = new Game();
        game.setGameId(rs.getInt("GAME_ID"));
        game.setGameAnswer(rs.getString("GAMEANSWER"));
        game.setGameStatus(rs.getBoolean("Gamestatus"));
        return game;
    }
	
	}
