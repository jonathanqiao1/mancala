package us.jonathans.entity.rendering.geometry;

import java.awt.*;

public class Obj2 {
    private Dimension dimension;
    private Vec2 pos;

    public Obj2(int x, int y, int width, int height, Align align) {
        this.dimension = new Dimension(width, height);
        switch (align) {
            case CENTER -> {
                int tlX = x - width / 2;
                int tlY = y - height / 2;
                this.pos = new Vec2(tlX, tlY);
            }
            case TOP_LEFT -> {
                this.pos = new Vec2(x, y);
            }
        }
    }

    public int x() {
        return this.pos.x;
    }

    public int cx() {
        return this.x() + this.width() / 2;
    }

    public int cy() {
        return this.y() + this.height() / 2;
    }

    public int y() {
        return this.pos.y;
    }

    public int width() {
        return (int) this.dimension.getWidth();
    }

    public int height() {
        return (int) this.dimension.getHeight();
    }

    public void fillOval(Graphics g, Color color) {
        g.setColor(color);
        g.fillOval(this.x(), this.y(), this.width(), this.height());
    }

    public void drawOval(Graphics g, Color color) {
        g.setColor(color);
        g.drawOval(this.x(), this.y(), this.width(), this.height());
    }

    public void fillRect(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(this.x(), this.y(), this.width(), this.height());
    }

    public int radius() {
        return this.width() / 2;
    }

    public void grow(int dx, int dy) {
        this.dimension = new Dimension(this.width() + dx, this.height() + dy);
    }

    public Obj2 copy() {
        return new Obj2(this.x(), this.y(), this.width(), this.height(), Align.TOP_LEFT);
    }
}
