package us.jonathans.entity.rule;

public interface MancalaBoard {
    int getStones(MancalaHole hole);

    void setStones(MancalaHole hole, int stones);

    MancalaHole getNextHole(MancalaHole hole); // returns the hole next in the list based on the given hole

    MancalaHole getOppositeHole(MancalaHole hole); // returns the hole directly across from the given hole

    MancalaBoard clone(); // returns a clone of the board

    int[] asArray();
}
