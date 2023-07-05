package com.teamseven.model.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.teamseven.dto.entity.Game;
import com.teamseven.dto.entity.Guess;
import com.teamseven.dto.entity.GuessResult;
import com.teamseven.dto.entity.Round;
import com.teamseven.model.persistence.GameDao;
import com.teamseven.model.persistence.RoundDao;

public class RoundServiceImplTest {

    private RoundServiceImpl roundService;
    private GameDao gameDao;
    private RoundDao roundDao;

    @Before
    public void setUp() {
        gameDao = mock(GameDao.class);
        roundDao = mock(RoundDao.class);
        roundService = new RoundServiceImpl();
        roundService.setGameDao(gameDao);
        roundService.setRoundDao(roundDao);
    }

    @Test
    public void testAddRound() {
        Round round = new Round();
        when(roundDao.addRound(any(Round.class))).thenReturn(round);

        Round result = roundService.addRound(round);

        verify(roundDao).addRound(round);
        assertEquals(round, result);
    }

    @Test
    public void testCalculateGuessResult() {
        Game game = new Game();
        game.setGameAnswer("1234");

        Round round = new Round();
        round.setGuessObj(new Guess("4321"));

        roundService.calculateGuessResult(game, round);

        assertEquals("e:0,p:4", round.getResult());
        assertEquals(false, game.getGameStatus());
    }

    @Test
    public void testCalculateResultString() {
        Guess guess = new Guess("1234");

        String result = roundService.calculateResultString("4321", guess);

        assertEquals("e:0,p:4", result);
    }

    @Test
    public void testGetAllRoundsOrderedByTime() {
        int gameId = 1;
        List<Round> rounds = new ArrayList<>();
        when(roundDao.getAllRoundsOrderedByTime(gameId)).thenReturn(rounds);

        List<Round> result = roundService.getAllRoundsOrderedByTime(gameId);

        verify(roundDao).getAllRoundsOrderedByTime(gameId);
        assertEquals(rounds, result);
    }

    @Test
    public void testMakeGuess() {
        int gameId = 1;
        Game game = new Game();
        game.setGameAnswer("1234");
        when(gameDao.getGameById(gameId)).thenReturn(game);

        Guess guess = new Guess("4321");
        Round round = new Round();
        round.setGuessObj(guess);
        round.setTimeOfGuess(LocalDateTime.now());
        round.setResult("e:0,p:4");
        round.setGameId(gameId);
        when(roundDao.addRound(any(Round.class))).thenReturn(round);

        Round result = roundService.makeGuess(gameId, guess);

        verify(gameDao).getGameById(gameId);
        verify(roundDao).addRound(round);
        assertEquals(round, result);
        assertEquals(true, game.getGameStatus());
    }

    @Test
    public void testComputeResult() {
        Guess guess = new Guess("1234");

        String result = roundService.computeResult(guess, "4321");

        assertEquals("e:0:p:4", result);
    }

    @Test
    public void testGetRoundsForGame() {
        int gameId = 1;
        List<Round> rounds = new ArrayList<>();
        when(roundDao.getAllRoundsOrderedByTime(gameId)).thenReturn(rounds);

        List<Round> result = roundService.getRoundsForGame(gameId);

        verify(roundDao).getAllRoundsOrderedByTime(gameId);
        assertEquals(rounds, result);
    }

    @Test
    public void testCalculateResult() {
        String guess = "1234";
        String answer = "4321";

        GuessResult result = roundService.calculateResult(guess, answer);

        assertEquals(0, result.getExactMatches());
        assertEquals(4, result.getPartialMatches());
    }

    @Test
    public void testCreateRound() {
        int gameId = 1;
        String guess = "1234";
        Game game = new Game();
        game.setGameAnswer("4321");
        when(gameDao.getOneGame(gameId)).thenReturn(game);

        GuessResult result = new GuessResult(0, 4);
        when(roundService.calculateResult(guess, game.getGameAnswer())).thenReturn(result);

        Round round = new Round();
        round.setGuess(guess);
        round.setTimeOfGuess(LocalDateTime.now());
        round.setResult(result.toString());
        round.setGameId(gameId);
        when(roundDao.addRoundBool(any(Round.class))).thenReturn(1);

        Round createdRound = roundService.createRound(gameId, guess);

        verify(gameDao).getOneGame(gameId);
        verify(roundService).calculateResult(guess, game.getGameAnswer());
        verify(roundDao).addRoundBool(round);
        assertEquals(round, createdRound);
    }

    @Test
    public void testCreateRound_InvalidGuess() {
        int gameId = 1;
        String guess = "12";
        Game game = new Game();
        game.setGameAnswer("4321");
        when(gameDao.getOneGame(gameId)).thenReturn(game);

        Round createdRound = roundService.createRound(gameId, guess);

        verify(gameDao).getOneGame(gameId);
        assertEquals(null, createdRound);
    }

    @Test
    public void testGetOneGame() {
        int gameId = 1;
        Game game = new Game();
        when(gameDao.getOneGame(gameId)).thenReturn(game);

        Game result = roundService.getOneGame(gameId);

        verify(gameDao).getOneGame(gameId);
        assertEquals(game, result);
    }
}
