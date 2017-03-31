package game.states;

import game.models.Player;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
    private int ID;

    private Image worldMap;
    private float mapX = -100;
    private float mapY = -100;

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
        this.worldMap = new Image("res/map/background/background.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        this.worldMap.draw(mapX, mapY);
        this.player.draw();

        graphics.drawString(String.format("Player X: %.2f; Y: %.2f", this.player.getPlayerX(), this.player.getPlayerY()), 50, 50);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();

        /*if (input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_LEFT)) {
            this.player.setPlayerUp();

            this.player.setPlayerX(this.player.getPlayerX() - i * .1f);
            this.player.setPlayerY(this.player.getPlayerY() + i * .1f);

            if (this.player.getPlayerX() > -70 && this.player.getPlayerY() < 70) {
                this.moveUpMap(i, .1f);
                this.moveLeftMap(i, .1f);
            } *//*else {
                this.walkUpPlayer(i, .1f);
                this.walkLeftPlayer(i, .1f);
            }*//*
        } else if (input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_RIGHT)) {
            this.player.setPlayerUp();

            this.player.setPlayerX(this.player.getPlayerX() + i * .1f);
            this.player.setPlayerY(this.player.getPlayerY() + i * .1f);

            this.moveUpMap(i, .1f);
            this.moveRightMap(i, .1f);
        } else if (input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_LEFT)) {
            this.player.setPlayerDown();

            this.player.setPlayerX(this.player.getPlayerX() - i * .1f);
            this.player.setPlayerY(this.player.getPlayerY() - i * .1f);

            this.moveDownMap(i, .1f);
            this.moveLeftMap(i, .1f);
        } else if (input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_RIGHT)) {
            this.player.setPlayerDown();

            this.player.setPlayerX(this.player.getPlayerX() + i * .1f);
            this.player.setPlayerY(this.player.getPlayerY() - i * .1f);

            this.moveDownMap(i, .1f);
            this.moveRightMap(i, .1f);
        } else*/ if (input.isKeyDown(Input.KEY_UP)) {
            this.player.setPlayerUp();

            if (shouldMoveMapUpDown()) {
                this.player.setPlayerY(this.player.getPlayerY() + i * .14f);

                this.moveUpMap(i, .14f);
            } else {
                this.walkUpPlayer(i, .14f);
            }
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            this.player.setPlayerRight();

            if (shouldMoveMapRightLeft()) {
                this.player.setPlayerX(this.player.getPlayerX() + i *.14f);

                this.moveRightMap(i, .14f);
            } else {
                this.walkRightPlayer(i, .14f);
            }
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            this.player.setPlayerDown();

            if (shouldMoveMapUpDown()) {
                this.player.setPlayerY(this.player.getPlayerY() - i * .14f);

                this.moveDownMap(i,.14f);
            } else {
                walkDownPlayer(i, .14f);
            }
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            this.player.setPlayerLeft();

            if (shouldMoveMapRightLeft()) {
                this.player.setPlayerX(this.player.getPlayerX() - i * .14f);

                this.moveLeftMap(i,.14f);
            } else {
                walkLeftPlayer(i, .14f);
            }
        } else {
            this.player.stop();
        }
    }

    private boolean shouldMoveMapUpDown() {
        return this.player.getPlayerY() > -400 && this.player.getPlayerY() < 70;
    }

    private boolean shouldMoveMapRightLeft() {
        return this.player.getPlayerX() > -70 && this.player.getPlayerX() < 180;
    }

    //------------------------------------------------------------------------------
    //------------------------------------------------------------------------------
    //------------------------------------------------------------------------------


    private void moveDownMap(int i, float flag) {
        this.mapY -= i * flag;
    }

    private void moveRightMap(int i, float flag) {
        this.mapX -= i * flag;
    }

    private void moveLeftMap(int i, float flag) {
        this.mapX += i * flag;
    }

    private void moveUpMap(int i, float flag) {
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
            this.player.setStartPlayerX(this.player.getStartPlayerX() - i * flag)
            ;
            this.player.setPlayerX(this.player.getPlayerX() - i * flag);
        } else {
            this.player.stop();
        }
    }
}
