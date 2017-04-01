package game.states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Menu extends BasicGameState {
     private int ID;

    int a = 10000;

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

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString(String.format("A: %d", a), 50, 50);

        if (a == 0) {
            stateBasedGame.enterState(1);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        a -= 5;
    }
}
