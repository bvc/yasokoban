package org.yskbn.level;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Block extends Thing
{
    public Block(int xPos, int yPos) throws SlickException
    {
        super(xPos, yPos);

        setSymbol('B');

        canPassThrough = false;
        canPush = true;
    }

    @Override
    public void render(Graphics graphics, int x, int y)
    {
        sheet.getSprite(1,0).draw(x * spriteX, y * spriteY);
    }
}
