package us.jonathans.mancala;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JonathanMancalaBoardTest {
private JonathanMancalaBoard board;
private MancalaHole hole;
    @BeforeEach
    void setUp() {
        board = new JonathanMancalaBoard(4);
    }

    @Test
    void getStones() {
        MancalaHole hole = MancalaHole.A;
        int[] correct = new int[]{
                4,
                4,
                4,
                4,
                4,
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
        for (int i = 0; i < board.board.length; i++) {
            assertEquals(board.getStones(hole), correct[i]);
            hole = board.getNextHole(hole);
        }
    }

    @Test
    void setStones() {
        MancalaHole hole = MancalaHole.A;
        board.setStones(hole, 0);
        assertEquals(board.getStones(hole), 0);
    }

    @Test
    void getNextHole() {
        MancalaHole hole = MancalaHole.A;
        assertEquals(MancalaHole.B, board.getNextHole(hole));
    }

    @Test
    void getOppositeHole() {
        MancalaHole hole = MancalaHole.A;
        assertEquals(MancalaHole.f, board.getOppositeHole(hole));
    }

    @Test
    void testClone() {
        MancalaHole hole = MancalaHole.B;
        MancalaBoard clone = board.clone();
        assertNotEquals(board, clone);
        board.setStones(hole, 20);
        assertNotEquals(20, clone.getStones(hole));
    }
}