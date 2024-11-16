package us.jonathans;

import java.util.HashSet;
import java.util.Set;

public class GameBoard {
    int[] board = getBoardPosition(4);

    private static int[] getBoardPosition(int startNum) {
        int[] board = {
                startNum,
                startNum,
                startNum,
                startNum,
                startNum,
                startNum,
                0,
                startNum,
                startNum,
                startNum,
                startNum,
                startNum,
                startNum,
                0
        };
        return board;
    }

    public MoveResult makeMove(int position, int player) {
        // code player class and check for valid pos selection based on players availible plays
        if (!getLegalMoves(player).contains(position)) {
            return new MoveResult(0, false, false);
        }
        int pastCaptured;

        if (player == 1) {
            pastCaptured = board[6];
        }
        else {
            pastCaptured = board[13];
        }

        if (0 <= position && position < 6) { // for loop handles player 1 turn
            int stones = board[position];
            board[position] = 0;
            for (int i = stones; i > 0; i--) { // loops for the amount of rocks availible
                position = (position + 1) % 14; // cycles adding a rock to the next hole in a circle
                if (position == 13) {
                    i++; //rock is not used up, so do not remove a rock this loop
                }
                else {
                    board[position]++; // add a rock to the next hole
                }
            }
        }

        if (7 <= position && position < 13) { // for loop handles player 2 turn
            int stones = board[position];
            board[position] = 0;
            for (int i = stones; i > 0; i--) { // loops for the amount of rocks availible
                position = (position + 1) % 14; // cycles adding a rock to the next hole in a circle
                if (position == 6) {
                    i++; //stone is not used up, so do not remove a rock this loop
                }
                else {
                    board[position]++; // add a rock to the next hole
                }
            }
        }
        return endingMove(position, player, pastCaptured);
    }

    public MoveResult endingMove(int endingPosition, int player, int pastCaptured) {
        int currCaptured;
        int goalPosition;

        if (player == 1) {
            currCaptured = board[6];
            goalPosition = 6;
        }
        else {
            currCaptured = board[13];
            goalPosition = 13;
        }

        if (endingPosition == goalPosition) {
            return new MoveResult(currCaptured - pastCaptured, true, true);
        }
        if (board[endingPosition] == 1 && getLegalMoves(player).contains(endingPosition)) {
            board[endingPosition] = 0;
            board[goalPosition] += (1 + board[12 - endingPosition]);
            board[12 - endingPosition] = 0;
            currCaptured = board[goalPosition];
        }
        return new MoveResult(currCaptured - pastCaptured, false, true);
    }

    public Set<Integer> getLegalMoves(int player) {
        HashSet<Integer> legalMoves = new HashSet<>();
        if (player == 1) {
            for (int i = 0; i < 6; i++) {
                if (board[i] > 0) {
                    legalMoves.add(i);
                }
            }
        } else if (player == 2) {
            for (int i = 7; i < 13; i++) {
                if (board[i] > 0) {
                    legalMoves.add(i);
                }
            }
        }
        return legalMoves;
    }
}
