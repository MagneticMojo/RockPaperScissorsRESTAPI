package com.magneticmojo.rpsapi.api.state;

import com.magneticmojo.rpsapi.api.exceptions.gameexception.GameFullException;
import com.magneticmojo.rpsapi.api.model.entities.Player;
import com.magneticmojo.rpsapi.api.model.entities.PlayerMove;
import com.magneticmojo.rpsapi.api.model.entities.Move;
import com.magneticmojo.rpsapi.api.exceptions.playerexception.PlayerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstMoveMadeAwaitingLastMoveStateTest {

    private Player playerOne;
    private Player playerTwo;
    private PlayerMove firstPlayerMove;
    private FirstMoveMadeAwaitingLastMoveState firstMoveMadeAwaitingLastMoveState;

    @BeforeEach
    void setUp() {
        playerOne = new Player("player1");
        playerTwo = new Player("player2");
        firstPlayerMove = new PlayerMove(playerOne, Move.ROCK);
        firstMoveMadeAwaitingLastMoveState = new FirstMoveMadeAwaitingLastMoveState(playerOne, playerTwo, firstPlayerMove);
    }

    @Test
    void testJoinGameException() {
        Player playerThree = new Player("player3");
        assertThrows(GameFullException.class, () -> firstMoveMadeAwaitingLastMoveState.joinGame(playerThree));
    }

    @Test
    void testMakeMoveWithPlayerNotInGame() {
        Player playerThree = new Player("player3");
        PlayerMove playerThreeMove = new PlayerMove(playerThree, Move.ROCK);
        assertThrows(PlayerException.class, () -> firstMoveMadeAwaitingLastMoveState.makeMove(playerThreeMove));
    }

    @Test
    void testMakeMoveWithPlayerAlreadyMadeMove() {
        PlayerMove duplicatePlayerMove = new PlayerMove(playerOne, Move.PAPER);
        assertThrows(PlayerException.class, () -> firstMoveMadeAwaitingLastMoveState.makeMove(duplicatePlayerMove));
    }

/*    @Test
    void testMakeMoveWithValidMove() {
        PlayerMove validPlayerMove = new PlayerMove(playerTwo, Move.SCISSORS);
        GameState gameResult = firstMoveMadeAwaitingLastMoveState.makeMove(validPlayerMove);

        assertTrue(gameResult instanceof GameEndedState);
        assertEquals("player1 WON BY ROCK BEATING SCISSORS. player2 LOST", ((GameEndedState) gameResult).getResult());
    }

    @Test
    void testMakeMoveWithTie() {
        PlayerMove tiePlayerMove = new PlayerMove(playerTwo, Move.ROCK);
        GameState gameResult = firstMoveMadeAwaitingLastMoveState.makeMove(tiePlayerMove);

        assertTrue(gameResult instanceof GameEndedState);
        assertEquals("TIE", ((GameEndedState) gameResult).getResult());
    }*/
}
