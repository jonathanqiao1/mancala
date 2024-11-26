package us.jonathans.entity.rule;

public enum MancalaSide {
    PLAYER1{
        @Override
        public MancalaSide opposite() {
            return PlAYER2;
        }
    },

    PlAYER2{
        @Override
        public MancalaSide opposite() {
            return PLAYER1;
        }
    };

    public abstract MancalaSide opposite();
}
