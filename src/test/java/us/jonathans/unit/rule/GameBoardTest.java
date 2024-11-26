package us.jonathans.unit.rule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import us.jonathans.entity.rule.GameBoard;
import us.jonathans.entity.rule.MoveResult;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {
    private GameBoard board;

    @BeforeEach
    void init() {
        board = new GameBoard();
    }
    @Test
    void makeLegalMove() {
        board.makeMove(0, 1);
        assertArrayEquals (
                new int[]{
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
                },
                board.board
        );
    }

    @Test
    void makeIllegalMove() {
        assertEquals(board.makeMove(6, 1), new MoveResult(0, false, false));
    }

    @Test
    void makeTwoLegalMoves() {
        board.makeMove(0, 1);
        board.makeMove(12, 2);
        assertArrayEquals (
                new int[]{
                        1,
                        6,
                        6,
                        5,
                        5,
                        4,
                        0,
                        4,
                        4,
                        4,
                        4,
                        4,
                        0,
                        1
                },
                board.board
        );
    }

    @Test
    void endingMoveCapture() {
        board.board = new int[]{
                1,
                0,
                6,
                5,
                5,
                4,
                0,
                4,
                4,
                4,
                4,
                100,
                0,
                1
        };
        assertEquals(board.makeMove(0, 1), new MoveResult(101, false, true));
        assertArrayEquals (
                new int[]{
                        0,
                        0,
                        6,
                        5,
                        5,
                        4,
                        101,
                        4,
                        4,
                        4,
                        4,
                        0,
                        0,
                        1
                },
                board.board
        );
    }

    @Test
    void endingMoveCaptureLoopAround() {
        board.board = new int[]{
                0,
                0,
                12,
                5,
                5,
                4,
                0,
                4,
                4,
                4,
                4,
                100,
                0,
                1
        };
        assertEquals(board.makeMove(2, 1), new MoveResult(103, false, true));
        assertArrayEquals (
                new int[]{
                        1,
                        0,
                        0,
                        6,
                        6,
                        5,
                        103,
                        5,
                        5,
                        5,
                        5,
                        0,
                        1,
                        1
                },
                board.board
        );
    }
}