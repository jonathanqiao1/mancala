package us.jonathans.interface_adapter.make_computer_move;

public class MakeComputerMoveState {
    private final int[] board;

    public MakeComputerMoveState(int[] board) {
        this.board = board;
    }

    public int[] getBoard() {
        return board;
    }
}
