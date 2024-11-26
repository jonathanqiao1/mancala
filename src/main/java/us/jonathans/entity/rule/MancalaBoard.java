package us.jonathans.entity.rule;

public interface MancalaBoard {
    Iterable MancalaBoard = null;

    public int getStones(MancalaHole hole);

    public void setStones(MancalaHole hole, int stones);

    public MancalaHole getNextHole(MancalaHole hole);

}
