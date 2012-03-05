package org.yskbn.level.tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.yskbn.level.Renderable;
import org.yskbn.level.entity.Entity;

public abstract class Tile implements Renderable
{
    private int x;
    private int y;

    protected char symbol;
    
    protected int spriteX;
    protected int spriteY;

    protected boolean passable;
    protected Entity entity;

    protected SpriteSheet sheet;

    public Tile(int x, int y) throws SlickException
    {
        this.x = x;
        this.y = y;

        this.spriteX = 32;
        this.spriteY = 32;

        this.entity = null;
        this.sheet = new SpriteSheet("res/yasokoban_sprite.png", spriteX, spriteY);
    }

    public boolean isPassable()
    {
        return passable;
    }

    public void setPassable(boolean passable)
    {
        this.passable = passable;
    }

    public void setEntity(Entity entity)
    {
        this.entity = entity;
    }

    public Entity getEntity()
    {
        return entity;
    }

    public boolean hasEntity()
    {
        return this.entity != null;
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

    public char getSymbol()
    {
        if (hasEntity())
        {
            return entity.getSymbol();
        }

        return symbol;
    }

    public abstract void render(Graphics graphics, int x, int y);
}
