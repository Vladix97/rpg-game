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

        if (input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_LEFT)) {
            this.player.setPlayerUp();
            this.walkUpMap(i, .1f);
            this.walkLeftMap(i, .1f);
        } else if (input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_RIGHT)) {
            this.player.setPlayerUp();
            this.walkUpMap(i, .1f);
            this.walkRightMap(i, .1f);
        } else if (input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_LEFT)) {
            this.player.setPlayerDown();
            this.walkDownMap(i, .1f);
            this.walkLeftMap(i, .1f);
        } else if (input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_RIGHT)) {
            this.player.setPlayerDown();
            this.walkDownMap(i, .1f);
            this.walkRightMap(i, .1f);
        } else if (input.isKeyDown(Input.KEY_UP)) {
            this.player.setPlayerUp();
            this.walkUpMap(i, .14f);
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            this.player.setPlayerRight();
            this.walkRightMap(i, .14f);
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            this.player.setPlayerDown();
            this.walkDownMap(i,.14f);
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            this.player.setPlayerLeft();
            this.walkLeftMap(i,.14f);
        } else {
            this.player.stop();
        }
    }

    private void walkDownMap(int i, float flag) {
        this.mapY -= i * flag;
    }

    private void walkRightMap(int i, float flag) {
        this.mapX -= i * flag;
    }

    private void walkLeftMap(int i, float flag) {
        this.mapX += i * flag;
    }

    private void walkUpMap(int i, float flag) {
        this.mapY += i * flag;
    }


//    private void walkUpPlayer(int i, float flag) {
//        if (this.player.getPlayerY() < -110) {
//            this.player.stop();
//        } else {
//            this.player.setPlayerY(this.player.getPlayerY() - i * flag);
//        }
//    }
//
//    private void walkRightPlayer(int i, float flag) {
//        if (this.player.getPlayerX() > 885) {
//            this.player.stop();
//        } else {
//            this.player.setPlayerX(this.player.getPlayerX() + i * flag);
//        }
//    }
//
//    private void walkDownPlayer(int i, float flag) {
//        if (this.player.getPlayerY() > 389) {
//            this.player.stop();
//        } else {
//            this.player.setPlayerY(this.player.getPlayerY() + i * flag);
//        }
//    }
//
//    private void walkLeftPlayer(int i, float flag) {
//        if (this.player.getPlayerX() < -85) {
//            player.stop();
//        } else {
//            this.player.setPlayerX(this.player.getPlayerX() - i * flag);
//        }
//    }
}
