package us.jonathans.use_case.start_game;

public interface StartGameInputBoundary {
    /**
     * Executes the start game use case.
     * @param startGameInputData the input data
     */
    void execute(StartGameInputData startGameInputData);
}
