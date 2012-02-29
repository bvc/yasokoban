package org.yskbn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState
{
    Image background = null;
    Image startGameOption = null;
    Image exitGameOption = null;

    int stateID = -1;

    public MainMenuState(int stateID)
    {
        this.stateID = stateID;
    }

    @Override
    public int getID()
    {
        return stateID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException
    {
        // TODO - Create a background image

        startGameOption = new Image("res/start_option.png");
        exitGameOption = new Image("res/exit_option.png");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException
    {
        // TODO - Render a background image

        startGameOption.draw(400 - (startGameOption.getWidth() / 2), 250);
        exitGameOption.draw(400 - (exitGameOption.getWidth() / 2), 300);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int i) throws SlickException
    {
        Input input = container.getInput();

        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();

        boolean insideStartOption = false;
        boolean insideExitOption = false;

        int startX = (400 - startGameOption.getWidth() / 2);
        int startY = 250;

        int exitX = (400 - exitGameOption.getWidth() / 2);
        int exitY = 300;

        if ((mouseX >= startX && mouseX <= startX + startGameOption.getWidth()) &&
                mouseY >= startY && mouseY <= startY + startGameOption.getHeight())
        {
            insideStartOption = true;
        }

        if ((mouseX >= exitX && mouseX <= exitX + exitGameOption.getWidth()) &&
                mouseY >= exitY && mouseY <= exitY + exitGameOption.getHeight())
        {
            insideExitOption = true;
        }

        if (insideStartOption && input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
        {
            game.enterState(Yasokoban.GAMEPLAYSTATE);
        }
        
        if (insideExitOption && input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
        {
            container.exit();
        }
    }
}
