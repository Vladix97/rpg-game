package game.states;

import game.models.Player;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
    private int ID;

    private Image worldMap;

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
        this.worldMap.draw(0, 0);
        this.player.draw();
        graphics.drawString(String.format("Player X: %.2f; Y: %.2f", this.player.getPlayerX(), this.player.getPlayerY()), 50, 50);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();

        if (input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_LEFT)) {
            this.player.setPlayerUp();
            this.player.setPlayerY(this.player.getPlayerY() - i * .1f);
            this.player.setPlayerX(this.player.getPlayerX() - i * .1f);
        } else if (input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_RIGHT)) {
            this.player.setPlayerUp();
            this.player.setPlayerY(this.player.getPlayerY() - i * .1f);
            this.player.setPlayerX(this.player.getPlayerX() + i * .1f);
        } else if (input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_LEFT)) {
            this.player.setPlayerDown();
            this.player.setPlayerY(this.player.getPlayerY() + i * .1f);
            this.player.setPlayerX(this.player.getPlayerX() - i * .1f);
        } else if (input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_RIGHT)) {
            this.player.setPlayerDown();
            this.player.setPlayerY(this.player.getPlayerY() + i * .1f);
            this.player.setPlayerX(this.player.getPlayerX() + i * .1f);
        } else if (input.isKeyDown(Input.KEY_UP)) {
            this.player.setPlayerUp();
            if (this.player.getPlayerY() < -110) {
                this.player.stop();
            } else {
                this.player.setPlayerY(this.player.getPlayerY() - i * .14f);
            }
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            this.player.setPlayerRight();
            if (this.player.getPlayerX() > 885) {
                this.player.stop();
            } else {
                this.player.setPlayerX(this.player.getPlayerX() + i * .14f);
            }
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            this.player.setPlayerDown();
            if (this.player.getPlayerY() > 389) {
                this.player.stop();;
            } else {
                this.player.setPlayerY(this.player.getPlayerY() + i * .14f);
            }
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            this.player.setPlayerLeft();
            if (this.player.getPlayerX() < -85) {
                player.stop();
            } else {
                this.player.setPlayerX(this.player.getPlayerX() - i * .14f);
            }
        } else {
            this.player.stop();
        }
    }
}
