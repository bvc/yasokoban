package org.yskbn.level.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Ball extends Entity
{
    public Ball(int x, int y) throws SlickException
    {
        super(x, y);

        this.symbol = '$';
    }

    @Override
    public void render(Graphics graphics, int x, int y)
    {
        sheet.getSprite(1,1).draw(x * spriteX, y * spriteY);

    }
}
