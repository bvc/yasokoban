package org.yskbn.level;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Player extends Thing
{
    public Player(int xPos, int yPos) throws SlickException
    {
        super(xPos, yPos);

        setSymbol('P');

        canPassThrough = false;
        canPush = false;
    }

    @Override
    public void render(Graphics graphics, int x, int y)
    {
        sheet.getSprite(3,0).draw(x * spriteX, y * spriteY);
    }
}
