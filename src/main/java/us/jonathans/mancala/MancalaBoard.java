package us.jonathans.mancala;

public interface MancalaBoard {
    Iterable MancalaBoard = null;

    public int getStones(MancalaHole hole);

    public void setStones(MancalaHole hole, int stones);

    public MancalaHole getNextHole(MancalaHole hole);

    public MancalaHole getOppositeHole(MancalaHole hole); //returns the hole directly across from the given hole

}
