package us.jonathans.mancala;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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
    void makeLegalMovePlayer1() {
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
    void makeLegalMovePlayer2() {
        ruleSet.makeMove(board, MancalaSide.PlAYER2, MancalaHole.a);
        int[] correct = new int[]{
                4,
                4,
                4,
                4,
                4,
                4,
                0,
                0,
                5,
                5,
                5,
                5,
                4,
                0
        };
        assertEquals(board.board[0][0], correct[0]);
        for (int i = 0; i < board.board.length; i++) {
            assertEquals(board.board[i][0], correct[i]);
        }
    }

    @Test
    void noLegalMoves() {
        board = new JonathanMancalaBoard(0);
        HashSet<MancalaHole> moves = new HashSet<>();
        assertEquals(moves, ruleSet.getLegalMoves(board, MancalaSide.PLAYER1));
        assertEquals(moves, ruleSet.getLegalMoves(board, MancalaSide.PlAYER2));
    }

    @Test
    void testGetLegalMoves() {
        HashSet<MancalaHole> moves = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            moves.add((MancalaHole) board.board[i][1]);
        }
        moves.toArray();
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
    void testCheckWin() {
    }

    @Test
    void testIsGameOver() {
    }
}