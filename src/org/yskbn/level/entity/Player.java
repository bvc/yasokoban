package org.yskbn.level.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Player extends Entity
{
    public Player(int x, int y) throws SlickException
    {
        super(x, y);

        this.symbol = '@';
    }

    @Override
    public void render(Graphics graphics, int x, int y)
    {
        sheet.getSprite(0,1).draw(x * spriteX, y * spriteY);
    }
}
