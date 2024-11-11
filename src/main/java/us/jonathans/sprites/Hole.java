package us.jonathans.sprites;

import us.jonathans.geom.Align;
import us.jonathans.geom.CircleBoundingBox;

import java.awt.*;

public class Hole extends CircleBoundingBox implements Drawable{
    protected static final Color color = Color.GRAY;
    protected static final Color hoveredColor = Color.DARK_GRAY;
    private boolean hovered = false;
    private int id;

    public Hole(int x, int y, int width, int height, Align align, int id) {
        super(x, y, width, height, align);
        this.id = id;
    }

    @Override
    public void draw(Graphics g) {
        this.fillOval(g, isHovered() ? hoveredColor : color);
    }

    public int getId() {
        return this.id;
    }

    public boolean isHovered() {
        return hovered;
    }

    public void setHovered(boolean hovered) {
        this.hovered = hovered;
    }
}
