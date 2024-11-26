package us.jonathans.entity.rule;

import java.util.HashSet;
import java.util.Set;

public class JonathanMancalaRuleSet implements MancalaRuleSet {
    @Override
    public MoveResult makeMove(MancalaBoard board, MancalaSide player, MancalaHole hole){
        if (!getLegalMoves(board, player).contains(hole)) {
            return new MoveResult(0, false, false);
        }
        int pastCaptured;

        if (player == MancalaSide.PLAYER1) {
            pastCaptured = board.getStones(MancalaHole.G);
        }
        else {
            pastCaptured = board.getStones(MancalaHole.g);
        }

        if (player == MancalaSide.PLAYER1) {
            int stones = board.getStones(hole);
            board.setStones(hole, 0);
            for (int i = stones; i > 0; i--) {
                hole = board.getNextHole(hole);
                if (hole == MancalaHole.g) {
                    i++;
                }
                else {
                    board.setStones(hole, board.getStones(hole) + 1);
                }
            }
        } else if (player == MancalaSide.PlAYER2) {
            int stones = board.getStones(hole);
            board.setStones(hole, 0);
            for (int i = stones; i > 0; i--) {
                hole = board.getNextHole(hole);
                if (hole == MancalaHole.G) {
                    i++;
                }
                else {
                    board.setStones(hole, board.getStones(hole) + 1);
                }
            }
        }
        return endingMove(board, player, hole, pastCaptured);
    }

    private MoveResult endingMove(MancalaBoard board, MancalaSide player, MancalaHole hole, int pastCaptured) {
        return null;
    }

    @Override
    public Set<MancalaHole> getLegalMoves(MancalaBoard board, MancalaSide player) {
        HashSet<MancalaHole> legalMoves = new HashSet<>();
        if (player == MancalaSide.PLAYER1) {
            for (int i = 0; i < 6; i++) {
                if (board.getStones(getHoles(player)[i]) > 0) {
                    legalMoves.add(getHoles(player)[i]);
                }
            }
        } else if (player == MancalaSide.PlAYER2) {
            for (int i = 0; i < 6; i++) {
                if (board.getStones(getHoles(player)[i]) > 0) {
                    legalMoves.add(getHoles(player)[i]);
                }
            }
        }
        return legalMoves;
    }

    private MancalaHole[] getHoles(MancalaSide player) {
        if (player == MancalaSide.PLAYER1) {
            MancalaHole[] holes = {
                    MancalaHole.A,
                    MancalaHole.B,
                    MancalaHole.C,
                    MancalaHole.D,
                    MancalaHole.E,
                    MancalaHole.F,
            };
            return holes;
        } else if (player == MancalaSide.PlAYER2) {
            MancalaHole[] holes = {
                    MancalaHole.a,
                    MancalaHole.b,
                    MancalaHole.c,
                    MancalaHole.d,
                    MancalaHole.e,
                    MancalaHole.f,
            };
            return holes;
        }
        return null;
    }

    @Override
    public MancalaSide checkWin(MancalaBoard board) {
        return null;
    }

    @Override
    public Boolean isGameOver(MancalaBoard board) {
        return null;
    }
}


