package us.jonathans.use_case.make_player_move;

public class MakePlayerMoveInteractor implements MakePlayerMoveInputBoundary {

    MakePlayerMoveInputData inputData;

    public MakePlayerMoveInteractor(MakePlayerMoveInputData inputData) {
        this.inputData = inputData;
    }

    @Override
    public void execute(MakePlayerMoveInputData inputData) {

    }
}
