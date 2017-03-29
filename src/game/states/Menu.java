package game.states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Menu extends BasicGameState {
    private int ID;
    private Image image;
    private double imageX;
    private double imageY;

    public Menu(int ID) {
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
        this.image = new Image("res/water.png");
        this.imageX = 50;
        this.imageY = 50;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(this.image, (int)this.imageX, (int)this.imageY);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();

        int xpos = input.getMouseX();
        int ypos = input.getMouseY();

        if (input.isKeyDown(Input.KEY_UP)) {
            this.imageY -= 0.1;
        } else if (input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_RIGHT)) {
            this.imageY++;
            this.imageX++;
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            this.imageX++;
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            this.imageX--;
        }
    }
}
