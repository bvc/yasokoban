package org.yskbn.level;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public abstract class Thing
{
    private int x;
    private int y;

    private char symbol;

    protected int spriteX;
    protected int spriteY;

    protected boolean canPassThrough;
    protected boolean canPush;

    protected SpriteSheet sheet;

    public Thing(int x, int yPos) throws SlickException
    {
        this.x = x;
        this.y = yPos;
        this.canPassThrough = false;
        this.canPush = false;

        this.spriteX = 32;
        this.spriteY = 32;
        this.sheet = new SpriteSheet("res/yasokoban_sprite.png", spriteX, spriteY);
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public boolean isCanPassThrough()
    {
        return canPassThrough;
    }

    public void setCanPassThrough(boolean canPassThrough)
    {
        this.canPassThrough = canPassThrough;
    }

    public boolean isCanPush()
    {
        return canPush;
    }

    public void setCanPush(boolean canPush)
    {
        this.canPush = canPush;
    }

    public abstract void render(Graphics graphics, int x, int y);

    public char getSymbol()
    {
        return symbol;
    }

    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }
}
