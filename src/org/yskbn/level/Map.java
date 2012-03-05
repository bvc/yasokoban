package org.yskbn.level;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.yskbn.level.entity.Ball;
import org.yskbn.level.entity.Entity;
import org.yskbn.level.entity.Player;
import org.yskbn.level.tile.Floor;
import org.yskbn.level.tile.Goal;
import org.yskbn.level.tile.Tile;
import org.yskbn.level.tile.Wall;

import java.util.ArrayList;
import java.util.List;

public class Map
{
    public Tile[][] tileMap;

    private int xLength;
    private int yLength;

    List<Goal> goals;
    Player player;

    public Map(String level, int xDim, int yDim) throws SlickException
    {
        this.xLength = xDim;
        this.yLength = yDim;
        this.tileMap = new Tile[yLength][xLength];

        goals = new ArrayList<Goal>();

        for (int y = 0; y < yLength; y++)
        {
            for (int x = 0; x < xLength; x++)
            {
                if (level.charAt((y * xLength) + x) == '*')
                {
                    Wall wall = new Wall(x, y);
                    tileMap[y][x] = wall;
                }
                else if (level.charAt((y * xLength) + x) == 'B')
                {
                    Floor floor = new Floor(x, y);
                    Ball ball = new Ball(x, y);
                    floor.setEntity(ball);
                    tileMap[y][x] = floor;
                }
                else if (level.charAt((y * xLength) + x) == 'G')
                {
                    Goal goal = new Goal(x, y);
                    goals.add(goal);
                    tileMap[y][x] = goal;
                }
                else if (level.charAt((y * xLength) + x) == 'P')
                {
                    Floor floor = new Floor(x, y);
                    Player player = new Player(x, y);
                    floor.setEntity(player);
                    tileMap[y][x] = floor;
                    this.player = player;
                }
                else
                {
                    Floor floor = new Floor(x, y);
                    tileMap[y][x] = floor;
                }
            }
        }
    }

    // Call this method in the Gameplay state to display the current state
    public void displayState()
    {
        for (int y = 0; y < yLength; y++)
        {
            for (int x = 0; x < xLength; x++)
            {
                Tile tile = tileMap[y][x];
                System.out.print(tile.getSymbol());
            }
            
            System.out.print("\n");
        }

        System.out.print("\n");
        
    }

    public void render(Graphics graphics)
    {
        for (int y = 0; y < yLength; y++)
        {
            for (int x = 0; x < xLength; x++)
            {
                tileMap[y][x].render(graphics, x, y);
            }
        }
    }

    public void movePlayer(Direction direction) throws SlickException
    {
        if (canPushInDirection(direction))
        {
            pushInDirection(direction);
        }

        if (canPassThroughDirection(player, direction))
        {
            repositionPlayer(player, direction);
        }
    }

    private void repositionPlayer(Entity entity, Direction direction)
    {
        tileMap[entity.getY()][entity.getX()].setEntity(null);

        entity.setX(entity.getX() + direction.x);
        entity.setY(entity.getY() + direction.y);
        tileMap[entity.getY()][entity.getX()].setEntity(entity);
    }

    private void pushInDirection(Direction direction) throws SlickException
    {
        Entity pushable = tileMap[player.getY() + direction.y][player.getX() + direction.x].getEntity();

        if (canPassThroughDirection(pushable, direction))
        {
            tileMap[player.getY()][player.getX()].setEntity(null);

            player.setX(player.getX() + direction.x);
            player.setY(player.getY() + direction.y);
            tileMap[player.getY()][player.getX()].setEntity(player);

            pushable.setX(pushable.getX() + direction.x);
            pushable.setY(pushable.getY() + direction.y);

            Tile targetTile = tileMap[pushable.getY()][pushable.getX()];
            targetTile.setEntity(pushable);
        }
    }

    public boolean isAllBlocksInGoal()
    {
        for (Goal goal: goals)
        {
            if (goal.hasBall() == false)
            {
                return false;
            }
        }

        return true;
    }

    private boolean canPassThroughDirection(Entity entity, Direction direction)
    {
        if (outOfBounds(entity, direction))
        {
            return false;
        }

        Tile tile = tileMap[entity.getY() + direction.y][entity.getX() + direction.x];
        return tile.isPassable() && !tile.hasEntity();
    }

    private boolean canPushInDirection(Direction direction)
    {
        if (outOfBounds(player, direction))
        {
            return false;
        }

        Tile tile = tileMap[player.getY() + direction.y][player.getX() + direction.x];
        return tile.isPassable() && tile.hasEntity();
    }

    private boolean outOfBounds(Entity entity, Direction direction)
    {
        return (entity.getY() + direction.y >= yLength ||
                entity.getY() + direction.y < 0 ||
                entity.getX() + direction.x >= xLength ||
                entity.getX() + direction.x < 0);
    }
}
