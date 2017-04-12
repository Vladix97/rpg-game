package game.models.bars;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Bar {

    private int posX;
    private int posY;

    private Image image;
    private String path;
    private int value;

    protected Bar(String imagePath, int value, int posX, int posY) throws SlickException {
        this.posX = posX;
        this.posY = posY;

        this.path = imagePath;
        this.image = new Image(this.path);

        this.setValue(value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void draw() throws SlickException {
        this.image = null;
        if (this.value <= 100) {
            this.image = new Image(this.path.replaceFirst("\\d", "5"));
        } else if (this.value > 100 && this.value <= 200) {
            this.image = new Image(this.path.replaceFirst("\\d", "4"));
        } else if (this.value > 200 && this.value <= 300) {
            this.image = new Image(this.path.replaceFirst("\\d", "3"));
        } else if (this.value > 300 && this.value <= 400) {
            this.image = new Image(this.path.replaceFirst("\\d", "2"));
        } else if (this.value > 400 && this.value < 500) {
            this.image = new Image(this.path.replaceFirst("\\d", "1"));
        } else if (this.value == 500) {
            this.image = new Image(this.path.replaceFirst("\\d", "0"));
        }


        this.image.draw(this.posX, this.posY);
    }
}
