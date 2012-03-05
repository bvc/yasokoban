package org.yskbn.level.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.yskbn.level.Renderable;

public abstract class Entity implements Renderable
{
    private int x;
    private int y;

    protected char symbol;

    protected int spriteX;
    protected int spriteY;

    protected SpriteSheet sheet;

    public Entity(int x, int y) throws SlickException
    {
        this.x = x;
        this.y = y;
        
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

    public abstract void render(Graphics graphics, int x, int y);

    public char getSymbol()
    {
        return symbol;
    }
}
