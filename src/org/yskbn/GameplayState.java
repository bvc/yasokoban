package org.yskbn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.yskbn.level.Direction;
import org.yskbn.level.Map;

public class GameplayState extends BasicGameState
{
    private int stateID = -1;

    private Map map;

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
        String level =
            "**********" +
            "*P B    G*" +
            "*  *******" +
            "*  B    G*" +
            "*  *******" +
            "*  B    G*" +
            "****** ***" +
            "****** ***" +
            "*G   B   *" +
            "**********";
        this.map = new Map(level, 10, 10);

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException
    {

        map.render(graphics);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
    {
        if (container.getInput().isKeyPressed(Input.KEY_LEFT))
        {
            map.movePlayer(Direction.LEFT);
            map.displayState();
        }
        
        if (container.getInput().isKeyPressed(Input.KEY_UP))
        {
            map.movePlayer(Direction.UP);
            map.displayState();
        }

        if (container.getInput().isKeyPressed(Input.KEY_RIGHT))
        {
            map.movePlayer(Direction.RIGHT);
            map.displayState();
        }

        if (container.getInput().isKeyPressed(Input.KEY_DOWN))
        {
            map.movePlayer(Direction.DOWN);
            map.displayState();
        }
    }
}
