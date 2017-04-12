package game.models.bars;


import org.newdawn.slick.SlickException;

public class ManaBar extends Bar {

    private static final int IMAGE_X = -150;
    private static final int IMAGE_Y = -20;

    public ManaBar(String imagePath, int value) throws SlickException {
        super(imagePath, value, IMAGE_X, IMAGE_Y);
    }
}
