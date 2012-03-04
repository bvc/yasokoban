package org.yskbn.level;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Goal extends Thing
{
    public Goal(int xPos, int yPos) throws SlickException
    {
        super(xPos, yPos);

        setSymbol('G');

        canPassThrough = true;
        canPush = false;
        isGoal = true;
    }

    @Override
    public void render(Graphics graphics, int x, int y)
    {
        sheet.getSprite(2,0).draw(x * spriteX, y * spriteY);
    }
}
