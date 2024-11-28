package us.jonathans.entities.engine;

import us.jonathans.entity.rule.MancalaBoard;
import us.jonathans.entity.rule.MancalaHole;
import us.jonathans.entity.rule.MancalaRuleSet;
import us.jonathans.entity.rule.MancalaSide;

public class MancalaMinimax implements Engine {
    private final MancalaRuleSet rules;
    private final int maxDepth;

    public MancalaMinimax(MancalaRuleSet rules, int maxDepth) {
        this.rules = rules;
        this.maxDepth = maxDepth;
    }

    // Minimax Algorithm
    public int minimax(MancalaBoard board, int depth, boolean isMaximizingPlayer, MancalaSide player) {
        // Base case: Evaluate if depth is reached or game is over
        if (depth == 0 || rules.isGameOver(board)) {
            return evaluate(board, player);
        }

        // Get the side for the current turn
        MancalaSide currentPlayer = isMaximizingPlayer ? player : player.opposite();

        // Maximizing Player's Turn
        if (isMaximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (MancalaHole move : rules.getLegalMoves(board, currentPlayer)) {
                MancalaBoard clonedBoard = board.clone();
                rules.makeMove(clonedBoard, currentPlayer, move);
                int eval = minimax(clonedBoard, depth - 1, false, player);
                maxEval = Math.max(maxEval, eval);
            }
            return maxEval;
        }

        // Minimizing Player's Turn
        else {
            int minEval = Integer.MAX_VALUE;
            currentPlayer = MancalaSide.PLAYER1;
            for (MancalaHole move : rules.getLegalMoves(board, currentPlayer)) {
                MancalaBoard clonedBoard = board.clone();
                rules.makeMove(clonedBoard, currentPlayer, move);
                int eval = minimax(clonedBoard, depth - 1, true, player);
                minEval = Math.min(minEval, eval);
            }
            return minEval;
        }
    }

    // Finds the best move for the current player
    @Override
    public MancalaHole findBestMove(MancalaBoard board, MancalaSide player) {
        MancalaHole bestMove = null;
        int bestValue = Integer.MIN_VALUE;

        for (MancalaHole move : rules.getLegalMoves(board, player)) {
            MancalaBoard clonedBoard = board.clone();
            rules.makeMove(clonedBoard, player, move);
            int moveValue = minimax(clonedBoard, maxDepth - 1, false, player);
            if (moveValue > bestValue) {
                bestValue = moveValue;
                bestMove = move;
            }
        }
        return bestMove;
    }

    // Evaluation Function
    private int evaluate(MancalaBoard board, MancalaSide player) {
        // Basic evaluation: difference in scores between the two sides
        int playerScore = 0;
        int opponentScore = 0;
        if (player == MancalaSide.PLAYER1) {
            playerScore = board.getStones(MancalaHole.A);
            opponentScore = board.getStones(MancalaHole.a);
        }
        else {
            playerScore = board.getStones(MancalaHole.a);
            opponentScore = board.getStones(MancalaHole.A);
        }
        return playerScore - opponentScore;
    }
}
