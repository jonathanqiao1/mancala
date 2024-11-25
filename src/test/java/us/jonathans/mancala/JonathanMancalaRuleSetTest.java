package us.jonathans.mancala;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JonathanMancalaRuleSetTest {
    private JonathanMancalaRuleSet ruleSet;
    private JonathanMancalaBoard board;
    @BeforeEach
    void setUp() {
        board = new JonathanMancalaBoard(4);
        ruleSet = new JonathanMancalaRuleSet();
    }

    @Test
    void makeLegalMove() {
        ruleSet.makeMove(board, MancalaSide.PLAYER1, MancalaHole.A);
        int[] correct = new int[]{
                0,
                5,
                5,
                5,
                5,
                4,
                0,
                4,
                4,
                4,
                4,
                4,
                4,
                0
        };
        assertEquals(board.board[0][0], correct[0]);
        for (int i = 0; i < board.board.length; i++) {
            assertEquals(board.board[i][0], correct[i]);
        }
    }

    @Test
    void getLegalMoves() {
    }

    @Test
    void checkWin() {
    }

    @Test
    void isGameOver() {
    }

    @Test
    void testMakeMove() {
    }

    @Test
    void testGetLegalMoves() {
    }

    @Test
    void testCheckWin() {
    }

    @Test
    void testIsGameOver() {
    }
}