package game.models.animations;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class CharacterAnimation {

    private int[] animationDuration;

    private Animation upAnimation;
    private Animation rightAnimation;
    private Animation downAnimation;
    private Animation leftAnimation;


    public CharacterAnimation(int[] animationDuration,
                              Image[] upImages, Image[] rightImages, Image[] downImages, Image[] leftImages) {
        this.animationDuration = animationDuration;

        this.upAnimation = new Animation(upImages, this.animationDuration);
        this.rightAnimation = new Animation(rightImages, this.animationDuration);
        this.downAnimation = new Animation(downImages, this.animationDuration);
        this.leftAnimation = new Animation(leftImages, this.animationDuration);
    }

    public Animation getUpAnimation() {
        return this.upAnimation;
    }

    public Animation getRightAnimation() {
        return this.rightAnimation;
    }

    public Animation getDownAnimation() {
        return this.downAnimation;
    }

    public Animation getLeftAnimation() {
        return this.leftAnimation;
    }
}
