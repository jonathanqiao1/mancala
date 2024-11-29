package us.jonathans.entity.rendering.sprite;

import java.awt.*;
import java.util.Random;

public class StoneColors {
    private static final Color[] colors = {
        Color.getHSBColor(0.40F, 0.685F, 42.0F),
        Color.getHSBColor(0.39F, 0.91F, 21.0F),
        Color.getHSBColor(0.177F, 0F, 31F),
        Color.getHSBColor(0.0F, 0.0F, 8F),
        Color.getHSBColor(0.6F, 0.48F, 31F),
        Color.getHSBColor(0.2F, 0.27F, 0.14F),
    };

    public static Color getRandom(Random r) {
        int index = r.nextInt(colors.length);
        return colors[index];
    }
}
