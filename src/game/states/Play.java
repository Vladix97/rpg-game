package game.states;

import game.models.bars.Bar;
import game.models.bars.HealthBar;
import game.models.bars.ManaBar;
import game.models.characters.Player;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
    private int ID;

    /*
    ###IMPORTANT###
    If map is changed OR mapX and mapY are changed
        -change player boundaries
            --walkUP/RIGHT/DOWN/LEFT
        -change camera boundaries
            --shouldMoveMap...
     */

    private Image worldMap;
    private float mapX = -100;
    private float mapY = -100;

    private Bar healthBar;
    private Bar manaBar;

    private Player player;

    public Play(int ID) {
        this.setID(ID);
    }

    @Override
    public int getID() {
        return this.ID;
    }

    private void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.player = new Player();

        this.healthBar = new HealthBar("res/bars/hp/hp0.png", this.player.getHealth());
        this.manaBar = new ManaBar("res/bars/mana/mana0.png", this.player.getMana());

        this.worldMap = new Image("res/map/background/background.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        this.worldMap.draw(mapX, mapY);

        this.player.draw();

        graphics.drawString(String.format("Player X: %.2f; Y: %.2f", this.player.getPlayerX(), this.player.getPlayerY()), 300, 50);
//        graphics.drawString(String.format("MANA: %d", this.player.getMana()), 300, 70);

        this.healthBar.draw();
        this.manaBar.draw();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();

        if (!this.player.isAttacking()) {
            if (input.isKeyPressed(Input.KEY_SPACE) && this.player.canAttack()) {
                this.player.attack();
            } else if (input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_LEFT)) {
                movePlayerUpLeft(i);
            } else if (input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_RIGHT)) {
                movePlayerUpRight(i);
            } else if (input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_LEFT)) {
                movePlayerDownLeft(i);
            } else if (input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_RIGHT)) {
                movePlayerDownRight(i);
            } else if (input.isKeyDown(Input.KEY_UP)) {
                movePlayerUp(i);
            } else if (input.isKeyDown(Input.KEY_RIGHT)) {
                movePlayerRight(i);
            } else if (input.isKeyDown(Input.KEY_DOWN)) {
                movePlayerDown(i);
            } else if (input.isKeyDown(Input.KEY_LEFT)) {
                movePlayerLeft(i);
            } else {
                this.player.stop();
            }
        }

        this.manaBar.setValue(this.player.getMana());
        this.player.regenMana();
    }

    private void movePlayerUpLeft(int i) throws SlickException {
        this.player.movePlayerUp();

        if (this.shouldMoveMapUpDown() && this.shouldMoveMapRightLeft()) {
            this.moveUpMap(i, .1f);
            this.moveLeftMap(i, .1f);
        } else if (shouldMoveMapUpDown()) {
            this.moveUpMap(i, .1f);

            this.walkLeftPlayer(i, .1f);
        } else if (shouldMoveMapRightLeft()) {
            this.moveLeftMap(i, .1f);

            this.walkUpPlayer(i, .1f);
        } else {
            this.walkUpPlayer(i, .1f);
            this.walkLeftPlayer(i, .1f);
        }
    }

    private void movePlayerUpRight(int i) throws SlickException {
        this.player.movePlayerUp();

        if (this.shouldMoveMapUpDown() && this.shouldMoveMapRightLeft()) {
            this.moveUpMap(i, .1f);
            this.moveRightMap(i, .1f);
        } else if (this.shouldMoveMapUpDown()) {
            this.moveUpMap(i, .1f);

            this.walkRightPlayer(i, .1f);
        } else if (this.shouldMoveMapRightLeft()) {
            this.moveRightMap(i, .1f);

            this.walkUpPlayer(i, .1f);
        } else {
            this.walkUpPlayer(i, .1f);
            this.walkRightPlayer(i, .1f);
        }
    }

    private void movePlayerDownLeft(int i) throws SlickException {
        this.player.movePlayerDown();

        if (this.shouldMoveMapUpDown() && this.shouldMoveMapRightLeft()) {
            this.moveDownMap(i, .1f);
            this.moveLeftMap(i, .1f);
        } else if (this.shouldMoveMapUpDown()) {
            this.moveDownMap(i, .1f);

            this.walkLeftPlayer(i, .1f);
        } else if (this.shouldMoveMapRightLeft()) {
            this.moveLeftMap(i, .1f);

            this.walkDownPlayer(i, .1f);
        } else {
            this.walkDownPlayer(i, .1f);
            this.walkLeftPlayer(i, .1f);
        }
    }

    private void movePlayerDownRight(int i) throws SlickException {
        this.player.movePlayerDown();

        if (this.shouldMoveMapUpDown() && this.shouldMoveMapRightLeft()) {
            this.moveDownMap(i, .1f);
            this.moveRightMap(i, .1f);
        } else if (this.shouldMoveMapUpDown()) {
            this.moveDownMap(i, .1f);

            this.walkRightPlayer(i, .1f);
        } else if (this.shouldMoveMapRightLeft()) {
            this.moveRightMap(i, .1f);

            this.walkDownPlayer(i, .1f);
        } else {
            this.walkDownPlayer(i, .1f);
            this.walkRightPlayer(i, .1f);
        }
    }

    private void movePlayerUp(int i) throws SlickException {
        this.player.movePlayerUp();

        if (this.shouldMoveMapUpDown()) {
            this.moveUpMap(i, .14f);
        } else {
            this.walkUpPlayer(i, .14f);
        }
    }

    private void movePlayerRight(int i) throws SlickException {
        this.player.movePlayerRight();

        if (this.shouldMoveMapRightLeft()) {
            this.moveRightMap(i, .14f);
        } else {
            this.walkRightPlayer(i, .14f);
        }
    }

    private void movePlayerDown(int i) throws SlickException {
        this.player.movePlayerDown();

        if (this.shouldMoveMapUpDown()) {
            this.moveDownMap(i, .14f);
        } else {
            walkDownPlayer(i, .14f);
        }
    }

    private void movePlayerLeft(int i) throws SlickException {
        this.player.movePlayerLeft();

        if (this.shouldMoveMapRightLeft()) {
            this.moveLeftMap(i, .14f);
        } else {
            walkLeftPlayer(i, .14f);
        }
    }

    private boolean shouldMoveMapUpDown() {
        return this.player.getPlayerY() > -400 && this.player.getPlayerY() < 70;
    }

    private boolean shouldMoveMapRightLeft() {
        return this.player.getPlayerX() > -70 && this.player.getPlayerX() < 180;
    }

    private void moveDownMap(int i, float flag) {
        this.player.setPlayerY(this.player.getPlayerY() - i * flag);

        this.mapY -= i * flag;
    }

    private void moveRightMap(int i, float flag) {
        this.player.setPlayerX(this.player.getPlayerX() + i * flag);

        this.mapX -= i * flag;
    }

    private void moveLeftMap(int i, float flag) {
        this.player.setPlayerX(this.player.getPlayerX() - i * flag);

        this.mapX += i * flag;
    }

    private void moveUpMap(int i, float flag) {
        this.player.setPlayerY(this.player.getPlayerY() + i * flag);

        this.mapY += i * flag;
    }

    private void walkUpPlayer(int i, float flag) {
        if (this.player.getPlayerY() < 350) {
            this.player.setStartPlayerY(this.player.getStartPlayerY() - i * flag);

            this.player.setPlayerY(this.player.getPlayerY() + i * flag);
        } else {
            this.player.stop();
        }
    }

    private void walkRightPlayer(int i, float flag) {
        if (this.player.getPlayerX() < 675) {
            this.player.setStartPlayerX(this.player.getStartPlayerX() + i * flag);

            this.player.setPlayerX(this.player.getPlayerX() + i * flag);
        } else {
            this.player.stop();
        }
    }

    private void walkDownPlayer(int i, float flag) {
        if (this.player.getPlayerY() > -615) {
            this.player.setStartPlayerY(this.player.getStartPlayerY() + i * flag);

            this.player.setPlayerY(this.player.getPlayerY() - i * flag);
        } else {
            this.player.stop();
        }
    }

    private void walkLeftPlayer(int i, float flag) {
        if (this.player.getPlayerX() > -520) {
            this.player.setStartPlayerX(this.player.getStartPlayerX() - i * flag);

            this.player.setPlayerX(this.player.getPlayerX() - i * flag);
        } else {
            this.player.stop();
        }
    }
}
