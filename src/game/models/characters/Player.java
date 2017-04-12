package game.models.characters;

import game.models.animations.CharacterAnimation;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
    private static final int START_HEALTH = 500;
    private static final int START_MANA = 500;

    // Those coordinates place player in the middle of the screen
    private float startPlayerX = 375;
    private float startPlayerY = 175;

    private float playerX;
    private float playerY;
    private Animation player;     // Current player animation
    private Animation prevPlayer; // Previous player animation

    private CharacterAnimation moveAnimation;
    private CharacterAnimation attackAnimation;

    private int health = START_HEALTH;
    private int mana = START_MANA;

    public Player() throws SlickException {
        this.initMoveAnimations();
        this.initAttackAnimations();

        this.setStartPlayerX(startPlayerX);
        this.setStartPlayerY(startPlayerY);
        this.setPlayerX(0);
        this.setPlayerY(0);

        this.setHealth(START_HEALTH);
        this.setMana(START_MANA);

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

        this.moveAnimation = new CharacterAnimation(moveAnimationDuration, upMoveImages, rightMoveImages, downMoveImages, leftMoveImages);
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

        this.attackAnimation = new CharacterAnimation(moveAnimationDuration, upAttackImages, rightAttackImages, downAttackImages, leftAttackImages);
    }


    //-----------------COORDINATES
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

    //-------------------------------------------------------------------------------------------------------------------

    //-----------------MOVING
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

    //-------------------------------------------------------------------------------------------------------------------

    //-----------------HEALTH
    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    //-------------------------------------------------------------------------------------------------------------------

    //-----------------MANA
    public int getMana() {
        return this.mana;
    }

    private void setMana(int mana) {
        this.mana = mana;
    }

    public void regenMana() {
        if (this.mana < 500) {
            this.mana++;
        }
    }

    //-------------------------------------------------------------------------------------------------------------------

     //-----------------ATTACKING
    public boolean isAttacking() {
        if (this.mana >= 50) {
            boolean isAttacking = false;
            this.player = this.prevPlayer;
            return false;
        }

        return true;
    }

    public void attack() {
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

    //-------------------------------------------------------------------------------------------------------------------

    public void draw() {
        this.player.draw(startPlayerX, startPlayerY);
    }

    public void stop() {
        this.player.restart();
    }
}
