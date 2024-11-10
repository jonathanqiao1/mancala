package us.jonathans;

import us.jonathans.drawing.ColorHelper;
import us.jonathans.geom.Align;
import us.jonathans.geom.Obj2;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class JMancalaPanel extends JPanel {
    final Dimension dimension = new Dimension(400, 600);
    final int[] board = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public JMancalaPanel() {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        // Set anti-aliasing
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_DITHERING,
                RenderingHints.VALUE_DITHER_ENABLE);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.dimension.width, this.dimension.height);

        int holeRadius = this.dimension.height / 9;
        int holeMarginY = holeRadius / 6;
        int col1X = this.dimension.width / 3;
        int col2X = this.dimension.width / 3 * 2;


        // Left column
        for (int i = 0; i < 5 ; i++) {
            Obj2 hole = new Obj2(
                    col1X,
                    i * (holeMarginY + holeRadius) + holeRadius / 2 + holeMarginY,
                    holeRadius,
                    holeRadius,
                    Align.CENTER
            );
            hole.fillOval(g, Color.darkGray);

            g.setColor(Color.BLACK);
            drawStones(g, board[i], hole);
        }

        for (int i = 11; i > 6; i--) {
            Obj2 hole = new Obj2(
                    col2X,
                    (i-7) * (holeMarginY + holeRadius) + holeRadius / 2 + holeMarginY,
                    holeRadius,
                    holeRadius,
                    Align.CENTER
            );
            hole.fillOval(g, Color.darkGray);

            g.setColor(Color.BLACK);
            drawStones(g, board[i], hole);
        }
    }

    private void drawStones(Graphics g, int n, Obj2 hole) {
        int stoneRadius = 15;
        for (int i = 0; i <= n; i++) {
            Obj2 stone = randomCircleInsideCircle(hole, stoneRadius);
            Obj2 stoneShadow = stone.copy();
            stoneShadow.grow(3, 3);

            stoneShadow.fillOval(g, Color.BLACK);
            stone.fillOval(g, ColorHelper.getRandomColor());
        }
    }


    private Obj2 randomCircleInsideCircle(Obj2 obj, int radius) {
        Random r = new Random();
        double radians = 2.0d * Math.PI * r.nextDouble(1.0d);
        double deviation = (obj.radius() - radius) * Math.sqrt(r.nextDouble(1.0d));
        return new Obj2(
                (int) (obj.cx() + deviation * Math.cos(radians)),
                (int) (obj.cy() + deviation * Math.sin(radians)),
                radius * 2,
                radius * 2,
                Align.CENTER
        );
    }

    @Override
    public Dimension getPreferredSize() {
        return this.dimension;
    }
}
