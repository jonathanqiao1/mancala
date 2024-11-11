package us.jonathans.sprites;

import us.jonathans.geom.Align;

import java.awt.*;

public class SquareHole extends Hole implements Drawable{
    public SquareHole(int x, int y, int width, int height, Align align, int id) {
        super(x, y, width, height, align, id);
    }

    @Override
    public void draw(Graphics g) {
        this.fillRect(g, color);
    }
}
