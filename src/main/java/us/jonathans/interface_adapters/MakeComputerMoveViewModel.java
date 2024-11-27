package us.jonathans.interface_adapters;

import java.util.HashMap;
import java.util.Map;

public class MakeComputerMoveViewModel {

    private Map<Integer, Integer> holeStates = new HashMap<>();

    /**
     * Updates the stones in a specific hole.
     *
     * @param holeId The unique ID of the hole.
     * @param stones The number of stones in the hole.
     */
    public void setHoleState(int holeId, int stones) {
        holeStates.put(holeId, stones);
    }

    /**
     * Retrieves the current state of all holes.
     *
     * @return A map of hole IDs to their stone counts.
     */
    public Map<Integer, Integer> getHoleStates() {
        return holeStates;
    }

}
