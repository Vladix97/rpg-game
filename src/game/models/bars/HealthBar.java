package game.models.bars;


import org.newdawn.slick.SlickException;

public class HealthBar extends Bar {

    private static final int IMAGE_X = -150;
    private static final int IMAGE_Y = -50;

    public HealthBar(String imagePath, int value) throws SlickException {
        super(imagePath, value, IMAGE_X, IMAGE_Y);
    }
}
