package game.models;

import game.models.animations.MyAnimation;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Player {
    // those coordinates place player in the middle of the screen
    private float startPlayerX = 375;
    private float startPlayerY = 175;

    private float playerX;
    private float playerY;
    public Animation player;     // current player animation
    public Animation prevPlayer; // previous player animation

    private MyAnimation moveAnimation;
    private MyAnimation attackAnimation;

    public int mana = 500;

    public boolean isAttacking;
    public boolean shouldLower;

    public Player() throws SlickException {
        this.initMoveAnimations();
        this.initAttackAnimations();

        this.setStartPlayerX(startPlayerX);
        this.setStartPlayerY(startPlayerY);
        this.setPlayerX(0);
        this.setPlayerY(0);

        this.movePlayerDown();
    }

    private void initMoveAnimations() throws SlickException {
        int[] moveAnimationDuration = new int[] { 150, 150, 150, 150 };
        Image[] upMoveImages = new Image[] {
                new Image("res/player/walking/up/1.png"),
                new Image("res/player/walking/up/2.png"),
                new Image("res/player/walking/up/3.png"),
                new Image("res/player/walking/up/4.png"),
        };

        Image[] rightMoveImages = new Image[] {
                new Image("res/player/walking/right/1.png"),
                new Image("res/player/walking/right/2.png"),
                new Image("res/player/walking/right/3.png"),
                new Image("res/player/walking/right/4.png"),
        };

        Image[] downMoveImages = new Image[] {
                new Image("res/player/walking/down/1.png"),
                new Image("res/player/walking/down/2.png"),
                new Image("res/player/walking/down/3.png"),
                new Image("res/player/walking/down/4.png"),
        };

        Image[] leftMoveImages = new Image[] {
                new Image("res/player/walking/left/1.png"),
                new Image("res/player/walking/left/2.png"),
                new Image("res/player/walking/left/3.png"),
                new Image("res/player/walking/left/4.png"),
        };

        this.moveAnimation = new MyAnimation(moveAnimationDuration, upMoveImages, rightMoveImages, downMoveImages, leftMoveImages);
    }

    private void initAttackAnimations() throws SlickException {
        int[] moveAnimationDuration = new int[] { 200 };
        Image[] upAttackImages = new Image[] {
                new Image("res/player/attacking/up/1.png"),
        };

        Image[] rightAttackImages = new Image[] {
                new Image("res/player/attacking/right/1.png"),
        };

        Image[] downAttackImages = new Image[] {
                new Image("res/player/attacking/down/1.png"),
        };

        Image[] leftAttackImages = new Image[] {
                new Image("res/player/attacking/left/1.png"),
        };

        this.attackAnimation = new MyAnimation(moveAnimationDuration, upAttackImages, rightAttackImages, downAttackImages, leftAttackImages);
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

    public void movePlayerUp() throws SlickException {
        this.prevPlayer = this.moveAnimation.getUpAnimation();
        this.player = this.moveAnimation.getUpAnimation();
    }

    public void movePlayerRight() throws SlickException {
        this.prevPlayer = this.moveAnimation.getRightAnimation();
        this.player = this.moveAnimation.getRightAnimation();
    }

    public void movePlayerDown() throws SlickException {
        this.prevPlayer = this.moveAnimation.getDownAnimation();
        this.player = this.moveAnimation.getDownAnimation();
    }

    public void movePlayerLeft() throws SlickException {
        this.prevPlayer = this.moveAnimation.getLeftAnimation();
        this.player = this.moveAnimation.getLeftAnimation();
    }

    public boolean canAttack() {
        return this.mana == 500;
    }

    public void regenMana() {
        if (this.mana < 500) {
            this.mana++;
        }
    }

    public boolean isAttacking() {
        if (this.mana >= 50) {
            this.isAttacking = false;
            this.player = this.prevPlayer;
            return false;
        }

        return true;
    }

    public void attack() {
//        this.isAttacking = true;
        this.mana = 0;

        if (this.player.equals(this.moveAnimation.getUpAnimation())) {
            this.attackUp();
        } else if (this.player.equals(this.moveAnimation.getRightAnimation())) {
            this.attackRight();
        } else if (this.player.equals(this.moveAnimation.getDownAnimation())) {
            this.attackDown();
        } else if (this.player.equals(this.moveAnimation.getLeftAnimation())) {
            this.attackLeft();
        }
    }

    private void attackUp() {
        this.player = this.attackAnimation.getUpAnimation();
    }

    private void attackRight() {
        this.player = this.attackAnimation.getRightAnimation();
    }

    private void attackDown() {
        this.player = this.attackAnimation.getDownAnimation();
    }

    private void attackLeft() {
        this.player = this.attackAnimation.getLeftAnimation();
    }

    public void draw() {
        this.player.draw(startPlayerX, startPlayerY);
    }

    public void stop() {
        this.player.restart();
    }
}
