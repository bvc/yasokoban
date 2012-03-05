package org.yskbn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.yskbn.level.Direction;
import org.yskbn.level.Level;
import org.yskbn.level.Map;

import java.util.ArrayList;

public class GameplayState extends BasicGameState
{
    private int stateID = -1;

    private Map map;
    private ArrayList<Level> levels;
    private int currentLevel;

    private boolean finishedGame;

    public GameplayState(int stateID)
    {
        this.stateID = stateID;
        this.currentLevel = 0;
        this.finishedGame = false;
    }

    public GameplayState(int stateID, int currentLevel)
    {
        this.stateID = stateID;
        this.currentLevel = currentLevel;
        this.finishedGame = false;
    }

    @Override
    public int getID()
    {
        return stateID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException
    {
        this.levels = Level.generateLevels();

        Level level = levels.get(currentLevel);
        this.map = new Map(level.getMap(), level.getWidth(), level.getHeight());
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException
    {
        if (!finishedGame)
        {
            map.render(graphics);
        }
        else
        {
            graphics.drawString("YOU WIN!", Main.SCREEN_WIDTH / 2, Main.SCREEN_HEIGHT/ 2);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
    {
        if (container.getInput().isKeyPressed(Input.KEY_LEFT))
        {
            map.movePlayer(Direction.LEFT);
        }
        
        if (container.getInput().isKeyPressed(Input.KEY_UP))
        {
            map.movePlayer(Direction.UP);
        }

        if (container.getInput().isKeyPressed(Input.KEY_RIGHT))
        {
            map.movePlayer(Direction.RIGHT);
        }

        if (container.getInput().isKeyPressed(Input.KEY_DOWN))
        {
            map.movePlayer(Direction.DOWN);
        }

        if (container.getInput().isKeyPressed(Input.KEY_R))
        {
            map.reset();
        }

        if (map.isAllBlocksInGoal())
        {
            this.currentLevel++;

            if (currentLevel >= levels.size())
            {
                finishedGame = true;
            }
            else
            {
                Level level = levels.get(currentLevel);
                this.map = new Map(level.getMap(), level.getWidth(), level.getHeight());
            }
        }
    }
}
