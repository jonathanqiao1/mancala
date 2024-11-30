package us.jonathans.unit;

import org.junit.jupiter.api.Test;
import us.jonathans.entity.rendering.sprite.StoneColors;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class StoneColorTest {
    @Test
    public void testGetColor() {
        assertNotNull(StoneColors.getRandom(new Random(1)));
    }
}
