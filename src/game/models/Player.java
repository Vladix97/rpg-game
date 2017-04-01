package game.models;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
    private float startPlayerX = 375;
    private float startPlayerY = 175;

    private float playerX;
    private float playerY;

    public Animation player;
    public Animation prevPlayer;

    private Image[] walkUpImages;
    private Image[] walkRightImages;
    private Image[] walkDownImages;
    private Image[] walkLeftImages;

    private Animation movingUp;
    private Animation movingRight;
    private Animation movingDown;
    private Animation movingLeft;

    private Image[] attackDownImages;

    private Animation attackDown;

    private int[] animationDuration;

    public Player() throws SlickException {
        this.setAnimationDuration();

        this.setWalkUpImages();
        this.setWalkRightImages();
        this.setWalkDownImages();
        this.setWalkLeftImages();

        //-------------------------------------
        this.attackDownImages = new Image[] {
                new Image("res/player.sprites/attacking/attack.down/1.png"),
                new Image("res/player.sprites/attacking/attack.down/2.png")
        };

        this.setAttackDownImages();
        //-------------------------------------

        this.setMovingUp();
        this.setMovingRight();
        this.setMovingDown();
        this.setMovingLeft();
        
        this.setPlayerX(0);
        this.setPlayerY(0);

        this.setPlayerDown();
    }



    public float getStartPlayerX() {
        return this.startPlayerX;
    }

    public void setStartPlayerX(float startPlayerX) {
        this.startPlayerX = startPlayerX;
    }

    public float getStartPlayerY() {
        return this.startPlayerY;
    }

    public void setStartPlayerY(float startPlayerY) {
        this.startPlayerY = startPlayerY;
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
        this.prevPlayer = this.getMovingUp();
        this.player = this.getMovingUp();
    }

    public void setPlayerDown() throws SlickException {
        this.prevPlayer = this.getMovingDown();
        this.player = this.getMovingDown();
    }

    public void setPlayerRight() throws SlickException {
        this.prevPlayer = this.getMovingRight();
        this.player = this.getMovingRight();
    }

    public void setPlayerLeft() throws SlickException {
        this.prevPlayer = this.getMovingLeft();
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
                new Image("res/player.sprites/walking/walk.up/up1.png"),
                new Image("res/player.sprites/walking/walk.up/up2.png"),
                new Image("res/player.sprites/walking/walk.up/up3.png"),
                new Image("res/player.sprites/walking/walk.up/up4.png")
        };
    }

    public Image[] getWalkRightImages() {
        return this.walkRightImages;
    }

    private void setWalkRightImages() throws SlickException {
        this.walkRightImages = new Image[] {
                new Image("res/player.sprites/walking/walk.right/right1.png"),
                new Image("res/player.sprites/walking/walk.right/right2.png"),
                new Image("res/player.sprites/walking/walk.right/right3.png"),
                new Image("res/player.sprites/walking/walk.right/right4.png")
        };
    }

    public Image[] getWalkDownImages() {
        return this.walkDownImages;
    }

    private void setWalkDownImages() throws SlickException {
        this.walkDownImages = new Image[] {
                new Image("res/player.sprites/walking/walk.down/down1.png"),
                new Image("res/player.sprites/walking/walk.down/down2.png"),
                new Image("res/player.sprites/walking/walk.down/down3.png"),
                new Image("res/player.sprites/walking/walk.down/down4.png")
        };
    }

    public Image[] getWalkLeftImages() {
        return this.walkLeftImages;
    }

    private void setWalkLeftImages() throws SlickException {
       this.walkLeftImages = new Image[] {
               new Image("res/player.sprites/walking/walk.left/left1.png"),
               new Image("res/player.sprites/walking/walk.left/left2.png"),
               new Image("res/player.sprites/walking/walk.left/left3.png"),
               new Image("res/player.sprites/walking/walk.left/left4.png")
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

    private void setAttackDownImages() {
        this.attackDown = new Animation(this.attackDownImages, new int[] { 10, 1000 }, true);
    }

    public void attackDown() {
        this.player = this.attackDown;
    }

    public void draw() {
        this.player.draw(startPlayerX, startPlayerY);
    }

    public void stop() {
        this.player = this.prevPlayer;
        this.player.restart();
    }
}
