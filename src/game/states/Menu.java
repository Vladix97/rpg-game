package game.states;

import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Menu extends BasicGameState {
    private int ID;

    private int mouseX;
    private int mouseY;
    private Image image;
    private boolean keyPressed;

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
        this.image = new Image("res/map/main_menu/bg.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        this.image.draw();
        graphics.drawString(String.format("X: %d", this.mouseX), 50, 50);
        graphics.drawString(String.format("Y: %d", this.mouseY), 50, 70);
        graphics.drawString("KEY PRESSED: " + this.keyPressed, 50, 90);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();

        int xpos = input.getMouseX();
        int ypos = input.getMouseY();

        boolean mousePressed = input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON);

        if (mousePressed && this.inExitButton(xpos, ypos)) {
            System.exit(0);
        }

        if (mousePressed && this.inStartButton(xpos, ypos)) {
            stateBasedGame.enterState(1);
        }



        this.mouseX = xpos;
        this.mouseY = ypos;
    }

    private boolean inExitButton(int x, int y) {
        return x >= 425 && x <= 570 && y >= 360 && y <= 410;
    }

    private boolean inStartButton(int x, int y) {
        return x >= 390 && x <= 600 && y >= 215 && y <= 270;
    }
}
