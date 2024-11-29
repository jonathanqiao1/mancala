package us.jonathans.unit.rule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import us.jonathans.entity.rule.JonathanMancalaBoard;
import us.jonathans.entity.rule.MancalaBoard;
import us.jonathans.entity.rule.MancalaHole;

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
        for (int i = 0; i < board.getBoard().length; i++) {
            assertEquals(board.getStones(hole), correct[i]);
            hole = board.getNextHole(hole);
        }
    }

    @Test
    void setStones() {
        MancalaHole hole = MancalaHole.A;
        board.setStones(hole, 10);
        assertEquals(board.getStones(hole), 10);
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

    @Test
    void testEmptyBoard() {
        assertEquals(board.getStones(null), 0);
        assertEquals(board.getOppositeHole(null), null);
        assertEquals(board.getNextHole(null), null);
    }
}