package us.jonathans.entity.rendering.sprite;

import us.jonathans.entity.rendering.geometry.Align;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class SquareHole extends Hole implements Drawable {
    public SquareHole(int x, int y, int width, int height, Align align, int id) {
        super(x, y, width, height, align, id);
    }

    @Override
    public void draw(Graphics g) {
        Shape shapeBg = new RoundRectangle2D.Double(x(), y(), width(), height(), 50, 50);
        g.setColor(Color.gray);
        ((Graphics2D) g).fill(shapeBg);
    }
}
