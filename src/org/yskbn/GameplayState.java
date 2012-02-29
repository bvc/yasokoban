package org.yskbn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameplayState extends BasicGameState
{
    private int stateID = -1;

    public GameplayState(int stateID)
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

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException
    {

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int i) throws SlickException
    {

    }
}
