package game.models;


import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
    private static final float START_PLAYER_X = 200;
    private static final float START_PLAYER_Y = 45;

    private float playerX;
    private float playerY;

    private Animation player;

    private Image[] walkUpImages;
    private Image[] walkRightImages;
    private Image[] walkDownImages;
    private Image[] walkLeftImages;

    private Animation movingUp;
    private Animation movingRight;
    private Animation movingDown;
    private Animation movingLeft;

    private int[] animationDuration;

    public Player() throws SlickException {
        this.setAnimationDuration();

        this.setWalkUpImages();
        this.setWalkRightImages();
        this.setWalkDownImages();
        this.setWalkLeftImages();

        this.setMovingUp();
        this.setMovingRight();
        this.setMovingDown();
        this.setMovingLeft();

        this.setPlayerX(START_PLAYER_X);
        this.setPlayerY(START_PLAYER_Y);

        this.setPlayerDown();
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

    public void setPlayerUp() throws SlickException {
        this.player = this.getMovingUp();
    }

    public void setPlayerDown() throws SlickException {
         this.player = this.getMovingDown();
    }

    public void setPlayerRight() throws SlickException {
        this.player = this.getMovingRight();
    }

    public void setPlayerLeft() throws SlickException {
        this.player = this.getMovingLeft();
    }

    public int[] getAnimationDuration() {
        return this.animationDuration;
    }

    private void setAnimationDuration() {
        this.animationDuration = new int[] { 125, 125, 125, 125 };
    }

    public Image[] getWalkUpImages() {
        return this.walkUpImages;
    }

    private void setWalkUpImages() throws SlickException {
        this.walkUpImages = new Image[] {
                new Image("res/playerSprites/walking/walkUp/up1.png"),
                new Image("res/playerSprites/walking/walkUp/up2.png"),
                new Image("res/playerSprites/walking/walkUp/up3.png"),
                new Image("res/playerSprites/walking/walkUp/up4.png")
        };
    }

    public Image[] getWalkRightImages() {
        return this.walkRightImages;
    }

    private void setWalkRightImages() throws SlickException {
        this.walkRightImages = new Image[] {
                new Image("res/playerSprites/walking/walkRight/right1.png"),
                new Image("res/playerSprites/walking/walkRight/right2.png"),
                new Image("res/playerSprites/walking/walkRight/right3.png"),
                new Image("res/playerSprites/walking/walkRight/right4.png")
        };
    }

    public Image[] getWalkDownImages() {
        return this.walkDownImages;
    }

    private void setWalkDownImages() throws SlickException {
        this.walkDownImages = new Image[] {
                new Image("res/playerSprites/walking/walkDown/down1.png"),
                new Image("res/playerSprites/walking/walkDown/down2.png"),
                new Image("res/playerSprites/walking/walkDown/down3.png"),
                new Image("res/playerSprites/walking/walkDown/down4.png")
        };
    }

    public Image[] getWalkLeftImages() {
        return this.walkLeftImages;
    }

    private void setWalkLeftImages() throws SlickException {
       this.walkLeftImages = new Image[] {
               new Image("res/playerSprites/walking/walkLeft/left1.png"),
               new Image("res/playerSprites/walking/walkLeft/left2.png"),
               new Image("res/playerSprites/walking/walkLeft/left3.png"),
               new Image("res/playerSprites/walking/walkLeft/left4.png")
       };
    }

    public Animation getMovingUp() {
        return this.movingUp;
    }

    private void setMovingUp() throws SlickException {
        this.movingUp = new Animation(this.getWalkUpImages(), this.getAnimationDuration(), true);
    }

    public Animation getMovingRight() {
        return this.movingRight;
    }

    private void setMovingRight() throws SlickException {
        this.movingRight = new Animation(this.getWalkRightImages(), this.getAnimationDuration(), true);
    }

    public Animation getMovingDown() {
        return this.movingDown;
    }

    private void setMovingDown() throws SlickException {
        this.movingDown = new Animation(this.getWalkDownImages(), this.getAnimationDuration(), true);
    }

    public Animation getMovingLeft() {
        return this.movingLeft;
    }

    private void setMovingLeft() throws SlickException {
        this.movingLeft = new Animation(this.getWalkLeftImages(), this.getAnimationDuration(), true);
    }

    public void draw() {
        this.player.draw(this.getPlayerX(), this.getPlayerY());
    }

    public void stop() {
        this.player.restart();
    }
}
