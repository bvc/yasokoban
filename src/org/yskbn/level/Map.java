package org.yskbn.level;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.List;

public class Map
{
    public Thing[][] thingMap;

    private int xLength;
    private int yLength;

    List<Block> blocks;
    Player player;

    public Map(String level, int xDim, int yDim) throws SlickException
    {
        this.xLength = xDim;
        this.yLength = yDim;
        this.thingMap = new Thing[yLength][xLength];

        blocks = new ArrayList<Block>();

        for (int y = 0; y < yLength; y++)
        {
            for (int x = 0; x < xLength; x++)
            {
                if (level.charAt((y * xLength) + x) == '*')
                {
                    Wall wall = new Wall(x, y);
                    thingMap[y][x] = wall;
                }
                else if (level.charAt((y * xLength) + x) == 'B')
                {
                    Block block = new Block(x, y);
                    blocks.add(block);
                    thingMap[y][x] = block;
                }
                else if (level.charAt((y * xLength) + x) == 'G')
                {
                    Goal goal = new Goal(x, y);
                    thingMap[y][x] = goal;
                }
                else if (level.charAt((y * xLength) + x) == 'P')
                {
                    Player player = new Player(x, y);
                    thingMap[y][x] = player;
                    this.player = player;
                }
                else
                {
                    Floor floor = new Floor(x, y);
                    thingMap[y][x] = floor;
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
                System.out.print(thingMap[y][x].getSymbol());
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
                thingMap[y][x].render(graphics, x, y);
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
            swapThingsFrom(player, direction);
        }
    }

    private void swapThingsFrom(Thing thing, Direction direction)
    {
        Thing something = thingMap[thing.getY() + direction.y][thing.getX() + direction.x];

        something.setX(thing.getX());
        something.setY(thing.getY());
        thingMap[something.getY()][something.getX()] = something;

        player.setX(player.getX() + direction.x);
        player.setY(player.getY() + direction.y);
        thingMap[player.getY()][player.getX()] = player;
    }

    private void pushInDirection(Direction direction) throws SlickException
    {
        Thing pushable = thingMap[player.getY() + direction.y][player.getX() + direction.x];

        if (canPushIntoGoal(pushable, direction))
        {
            pushable.setX(pushable.getX() + direction.x);
            pushable.setY(pushable.getY() + direction.y);
            thingMap[pushable.getY()][pushable.getX()] = pushable;

            thingMap[player.getY()][player.getX()] = new Floor(player.getX(), player.getY());

            player.setX(player.getX() + direction.x);
            player.setY(player.getY() + direction.y);
            thingMap[player.getY()][player.getX()] = player;

            ((Block) pushable).setInGoal(true);
        }

        if (canPassThroughDirection(pushable, direction))
        {
            Thing availableSpace = thingMap[pushable.getY() + direction.y][pushable.getX() + direction.x];

            pushable.setX(availableSpace.getX());
            pushable.setY(availableSpace.getY());
            thingMap[pushable.getY()][pushable.getX()] = pushable;

            availableSpace.setX(player.getX());
            availableSpace.setY(player.getY());
            thingMap[availableSpace.getY()][availableSpace.getX()] = availableSpace;

            player.setX(player.getX() + direction.x);
            player.setY(player.getY() + direction.y);
            thingMap[player.getY()][player.getX()] = player;
        }
    }

    public boolean isAllBlocksInGoal()
    {
        for (Block block : blocks)
        {
            if (block.isInGoal() == false)
            {
                return false;
            }
        }
        
        return true;
    }

    private boolean canPassThroughDirection(Thing thing, Direction direction)
    {
        if (outOfBounds(thing, direction))
        {
            return false;
        }

        Thing something = thingMap[thing.getY() + direction.y][thing.getX() + direction.x];
        return something.canPassThrough;
    }

    private boolean canPushInDirection(Direction direction)
    {
        if (outOfBounds(player, direction))
        {
            return false;
        }

        Thing something = thingMap[player.getY() + direction.y][player.getX() + direction.x];
        return something.canPush;
    }

    private boolean canPushIntoGoal(Thing thing, Direction direction)
    {
        if (outOfBounds(thing, direction))
        {
            return false;
        }

        Thing something = thingMap[thing.getY() + direction.y][thing.getX() + direction.x];
        return something.isGoal;
    }

    private boolean outOfBounds(Thing thing, Direction direction)
    {
        return (thing.getY() + direction.y >= yLength ||
                thing.getY() + direction.y < 0 ||
                thing.getX() + direction.x >= xLength ||
                thing.getX() + direction.x < 0);
    }
}
