package com.teamseven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.teamseven.dto.entity.Game;
import com.teamseven.model.persistence.GameDao;

@SpringBootTest
@ActiveProfiles("test")
class GuessTheNumberRestServiceApplicationTests {
	
	@Autowired
	private GameDao gameDao;

	@Test
	void contextLoads() {
	}

	@Test
	void testUpdateGame(int gameId,boolean status){
		assertEquals(0, gameDao.updateGame(2, false));
	}
	
}


