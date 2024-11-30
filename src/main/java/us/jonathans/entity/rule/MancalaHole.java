package us.jonathans.entity.rule;

public enum MancalaHole {
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    a,
    b,
    c,
    d,
    e,
    f,
    g;

    public static MancalaHole getHole(int id) {
        MancalaHole[] board = new MancalaHole[]{
                MancalaHole.a,
                MancalaHole.b,
                MancalaHole.c,
                MancalaHole.d,
                MancalaHole.e,
                MancalaHole.f,
                MancalaHole.g,
                MancalaHole.F,
                MancalaHole.E,
                MancalaHole.D,
                MancalaHole.C,
                MancalaHole.B,
                MancalaHole.A,
                MancalaHole.G
        };
        return board[id];
    }
}
