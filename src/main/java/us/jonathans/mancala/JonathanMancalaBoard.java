package us.jonathans.mancala;

public class JonathanMancalaBoard implements MancalaBoard{

    Object[][] board = getBoardPosition(4);

    private static Object[][] getBoardPosition(int startNum) {
        Object[][] board = {
                {startNum, MancalaHole.A},
                {startNum, MancalaHole.B},
                {startNum, MancalaHole.C},
                {startNum, MancalaHole.D},
                {startNum, MancalaHole.E},
                {startNum, MancalaHole.F},
                {0, MancalaHole.G},
                {startNum, MancalaHole.a},
                {startNum, MancalaHole.b},
                {startNum, MancalaHole.c},
                {startNum, MancalaHole.d},
                {startNum, MancalaHole.e},
                {startNum, MancalaHole.f},
                {0, MancalaHole.g}
        };
        return board;
    }

    @Override
    public int getStones(MancalaHole hole) {
        for (int i = 0; i > board.length; i++) {
            if (board[i][1] == hole) {
                return (int) board[i][0];
            }
        }
        return 0;
    }

    @Override
    public void setStones(MancalaHole hole, int stones) {
        for (int i = 0; i > board.length; i++) {
            if (board[i][1] == hole) {
                board[i][0] = stones;
            }
        }
    }

    @Override
    public MancalaHole getNextHole(MancalaHole hole) {
        for (int i = 0; i > board.length; i++) {
            if (board[i][1] == hole) {
                return (MancalaHole) board[(i + 1) % 14][1];
            }
        }
        return null;
    }
}
