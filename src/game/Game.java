package game;

import game.states.Menu;
import game.states.Play;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {
    private static final String GAME_NAME = "rpg-game";

    private static final int MENU_ID = 0;
    private static final int PLAY_ID = 1;

    public Game(String name) {
        super(GAME_NAME);

        this.addState(new Menu(MENU_ID));
        this.addState(new Play(PLAY_ID));
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.getState(MENU_ID).init(gameContainer, this);
        this.getState(PLAY_ID).init(gameContainer, this);

        this.enterState(MENU_ID);
    }

    public static void main(String[] args) {
        AppGameContainer appGameContainer;
           try {
            appGameContainer = new AppGameContainer(new Game(GAME_NAME));
            appGameContainer.setDisplayMode(1024, 576, false);
            appGameContainer.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
