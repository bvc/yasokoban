package org.yskbn.level;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Wall extends Thing
{
    public Wall(int xPos, int yPos) throws SlickException
    {
        super(xPos, yPos);

        setSymbol('*');

        canPassThrough = false;
        canPush = false;
    }

    @Override
    public void render(Graphics graphics, int x, int y)
    {
        sheet.getSprite(0,0).draw(x * spriteX, y * spriteY);
    }
}
