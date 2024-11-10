package us.jonathans.drawing;

import java.awt.*;
import java.util.Random;

public class ColorHelper {
    public static Color getRandomColor() {
        Color[] colors = {Color.RED, Color.ORANGE, Color.CYAN, Color.PINK, Color.YELLOW};
        return colors[new Random().nextInt(colors.length)];
    }
}
