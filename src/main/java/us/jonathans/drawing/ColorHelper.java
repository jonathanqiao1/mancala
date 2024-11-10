package us.jonathans.drawing;

import java.awt.*;
import java.util.Random;

public class ColorHelper {
    public static Color getRandomColor(Random r) {
        Color[] colors = {Color.RED, Color.ORANGE, Color.CYAN, Color.PINK, Color.YELLOW};
        return colors[r.nextInt(colors.length)];
    }
}
