package org.yskbn.level.tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Goal extends Tile
{
    private boolean hasBall;

    public Goal(int x, int y) throws SlickException
    {
        super(x, y);

        passable = true;
        hasBall = false;
        this.symbol = 'G';
    }

    public boolean isHasBall()
    {
        return hasBall;
    }

    public void setHasBall(boolean hasBall)
    {
        this.hasBall = hasBall;
    }

    @Override
    public void render(Graphics graphics, int x, int y)
    {
        sheet.getSprite(2,0).draw(x * spriteX, y * spriteY);

        if (hasEntity())
        {
            entity.render(graphics, x, y);
        }
    }
}
