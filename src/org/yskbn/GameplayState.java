package org.yskbn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

public class GameplayState extends BasicGameState
{
    private int stateID = -1;

    private String map =
            "**********" +
            "*S B    G*" +
            "*  *******" +
            "*  B    G*" +
            "*  *******" +
            "*  B    G*" +
            "****** ***" +
            "****** ***" +
            "*G   B   *" +
            "**********";
    private int yLength = 10;
    private int xLength = 10;


    private SpriteSheet sheet;

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
        sheet = new SpriteSheet("res/yasokoban_sprite.png", 32, 32);

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException
    {
        for (int y = 0; y < yLength; y++)
        {
            for (int x = 0; x < xLength; x++)
            {
                if (map.charAt((y * xLength) + x) == '*')
                {
                    sheet.getSprite(0,0).draw(x * 32, y * 32);
                }
                else if (map.charAt((y * xLength) + x) == 'B')
                {
                    sheet.getSprite(1,0).draw(x * 32, y * 32);
                }
                else if (map.charAt((y * xLength) + x) == 'G')
                {
                    sheet.getSprite(2,0).draw(x * 32, y * 32);
                }
                else if (map.charAt((y * xLength) + x) == 'S')
                {
                    sheet.getSprite(3,0).draw(x * 32, y * 32);
                }
                else
                {
                    sheet.getSprite(0,1).draw(x * 32, y * 32);
                }
            }
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
    {
        if (container.getInput().isKeyPressed(Input.KEY_LEFT))
        {
            Log.debug("LEFT");
        }
        
        if (container.getInput().isKeyPressed(Input.KEY_UP))
        {
            Log.debug("UP");
        }

        if (container.getInput().isKeyPressed(Input.KEY_RIGHT))
        {
            Log.debug("RIGHT");
        }

        if (container.getInput().isKeyPressed(Input.KEY_DOWN))
        {
            Log.debug("DOWN");
        }
    }
}
