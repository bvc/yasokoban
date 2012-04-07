package org.yskbn.level.tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.yskbn.level.entity.Ball;
import org.yskbn.level.entity.Entity;

public class Goal extends Tile
{
    private boolean hasBall;

    public Goal(int x, int y) throws SlickException
    {
        super(x, y);

        passable = true;
        hasBall = false;
        this.symbol = '.';
    }

    public boolean hasBall()
    {
        return hasBall;
    }
    
    @Override
    public void setEntity(Entity entity)
    {
        this.hasBall = entity != null && entity instanceof Ball;

        this.entity = entity;
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
