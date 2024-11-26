package us.jonathans.entity.rule;

public interface MancalaBoard {
    int getStones(MancalaHole hole);

    void setStones(MancalaHole hole, int stones);

    MancalaHole getNextHole(MancalaHole hole);

    int[] asArray();
}
