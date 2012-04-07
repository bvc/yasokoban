package org.yskbn.level.tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Wall extends Tile
{
    public Wall(int x, int y) throws SlickException
    {
        super(x, y);
        
        passable = false;
        this.symbol = '#';
    }

    @Override
    public void render(Graphics graphics, int x, int y)
    {
        sheet.getSprite(1,0).draw(x * spriteX, y * spriteY);
    }
}
