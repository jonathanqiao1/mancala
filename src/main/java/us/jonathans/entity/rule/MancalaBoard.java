package us.jonathans.entity.rule;

public interface MancalaBoard {
    Iterable board = null;

    public int getStones(MancalaHole hole);

    public void setStones(MancalaHole hole, int stones);

    public MancalaHole getNextHole(MancalaHole hole); // returns the hole next in the list based on the given hole

    public MancalaHole getOppositeHole(MancalaHole hole); // returns the hole directly across from the given hole

    public MancalaBoard clone(); // returns a clone of the board

}
