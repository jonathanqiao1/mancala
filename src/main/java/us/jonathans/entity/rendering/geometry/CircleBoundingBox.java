package us.jonathans.entity.rendering.geometry;

public class CircleBoundingBox extends Obj2 {
    public CircleBoundingBox(int x, int y, int width, int height, Align align) {
        super(x, y, width, height, align);
    }

    public boolean contains(int x, int y) {
        int dx = Math.abs(x - this.cx());
        int dy = Math.abs(y - this.cy());
        int distance = (int) Math.sqrt(dx * dx + dy * dy);
        return distance <= this.radius();
    }
}
