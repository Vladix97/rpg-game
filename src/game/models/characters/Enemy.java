package game.models.characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemy {
    private static final int START_HEALTH = 500;
    private static final int START_MANA = 500;

    // Those coordinates place player in the middle of the screen
    private float startEnemyX = 500;
    private float startEnemyY = -100;

    private float playerX = 257;
    private float playerY = 208;
    private Animation enemey;     // Current player animation

    private Animation leftEnememyAnimation;
    private Animation rightEnemyAnimation;


    public Enemy() throws SlickException {
        this.initMoveAnimations();

        this.setStartPlayerX(startEnemyX);
        this.setStartPlayerY(startEnemyY);
//        this.setPlayerX(0);
//        this.setPlayerY(0);

        this.enemey = this.rightEnemyAnimation;
    }

    private void initMoveAnimations() throws SlickException {
        int[] moveAnimationDuration = new int[] { 150, 150 };
        Image[] leftMoveAnimation = new Image[] {
                new Image("res/enemies/zombie_left.png"),
                new Image("res/enemies/zombie_left.png")
        };

        Image[] rightMoveImages = new Image[] {
                new Image("res/enemies/zombie_right.png"),
                new Image("res/enemies/zombie_right.png"),
        };

        this.leftEnememyAnimation = new Animation(leftMoveAnimation, moveAnimationDuration);
        this.rightEnemyAnimation = new Animation(rightMoveImages, moveAnimationDuration);
    }

    //-----------------COORDINATES
    public float getStartPlayerX() {
        return this.startEnemyX;
    }

    public void setStartPlayerX(float startEnemyX) {
        this.startEnemyX = startEnemyX;
    }

    public float getStartPlayerY() {
        return this.startEnemyY;
    }

    public void setStartPlayerY(float startEnemyY) {
        this.startEnemyY = startEnemyY;
    }

    public float getPlayerX() {
        return this.playerX;
    }

    public void setPlayerX(float playerX) {
        this.playerX = playerX;
    }

    public float getPlayerY() {
        return this.playerY;
    }

    public void setPlayerY(float playerY) {
        this.playerY = playerY;
    }

    //-------------------------------------------------------------------------------------------------------------------

    //-----------------MOVING

    //-------------------------------------------------------------------------------------------------------------------

    //-----------------HEALTH

    //-------------------------------------------------------------------------------------------------------------------

    //-----------------MANA

    //-------------------------------------------------------------------------------------------------------------------

    //-----------------ATTACKING

    //-------------------------------------------------------------------------------------------------------------------

    public void draw() {
        this.enemey.draw(this.startEnemyX, this.startEnemyY);
    }

    public void stop() {
        this.enemey.restart();
    }
}