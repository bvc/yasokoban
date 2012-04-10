package org.yskbn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Game object initializes game states and links them together
 */
public class Yasokoban extends StateBasedGame
{
    public static final int MAINMENUSTATE = 0;
    public static final int GAMEPLAYSTATE = 1;

    public Yasokoban()
    {
        super("Yasokoban");

        this.addState(new MainMenuState(MAINMENUSTATE));
        this.addState(new GameplayState(GAMEPLAYSTATE));

        this.enterState(MAINMENUSTATE);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException
    {

    }
}
