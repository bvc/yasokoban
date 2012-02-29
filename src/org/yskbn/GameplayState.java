package org.yskbn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameplayState extends BasicGameState
{
    private int stateID = -1;

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
        // Make sprite position with 32 x 32 cells




    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException
    {
        sheet.getSprite(0,0).draw();
        // draw sprite image from cell 0, 0

        sheet.getSprite(1,0).draw(32, 0);
        // draw sprite image from cell 1, 0
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
    {
        if (container.getInput().isKeyPressed(Input.KEY_LEFT))
        {
            System.out.println("LEFT");
        }
        
        if (container.getInput().isKeyPressed(Input.KEY_UP))
        {
            System.out.println("UP");
        }

        if (container.getInput().isKeyPressed(Input.KEY_RIGHT))
        {
            System.out.println("RIGHT");
        }

        if (container.getInput().isKeyPressed(Input.KEY_DOWN))
        {
            System.out.println("DOWN");
        }
    }
}
