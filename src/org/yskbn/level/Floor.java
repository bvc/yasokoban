package org.yskbn.level;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Floor extends Thing
{
    public Floor(int xPos, int yPos) throws SlickException
    {
        super(xPos, yPos);

        setSymbol(' ');

        canPassThrough = true;
        canPush = false;
    }

    @Override
    public void render(Graphics graphics, int x, int y)
    {
        sheet.getSprite(0,1).draw(x * spriteX, y * spriteY);
    }
}
