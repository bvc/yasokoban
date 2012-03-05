package org.yskbn.level.tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Floor extends Tile
{
    public Floor(int x, int y) throws SlickException
    {
        super(x, y);

        passable = true;
        this.symbol = ' ';
    }

    @Override
    public void render(Graphics graphics, int x, int y)
    {
        sheet.getSprite(0,0).draw(x * spriteX, y * spriteY);

        if (hasEntity())
        {
            entity.render(graphics, x, y);
        }
    }
}
