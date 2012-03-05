package org.yskbn.level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level
{
    private int width;
    private int height;
    
    private String map;

    public Level()
    {
        width = 0;
        height = 0;
        map = "";
    }

    public String getMap()
    {
        return map;
    }

    public void setMap(String map)
    {
        this.map = map;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }


    public static ArrayList<Level> generateLevels()
    {
        ArrayList<Level> levels = new ArrayList<Level>();

        File folder = new File("res/level");
        File[] listOfFiles = folder.listFiles(new LevelFileFilter());

        try
        {
            for (int i = 0; i < listOfFiles.length; i++)
            {
                Level level = new Level();

                Scanner scanner = new Scanner(listOfFiles[i]);
                StringBuilder sb = new StringBuilder(level.getMap());
                while (scanner.hasNextLine())
                {
                    String line = scanner.nextLine();

                    if (line.length() > level.width)
                    {
                        level.setWidth(line.length());
                    }

                    sb.append(line);

                    level.setHeight(level.getHeight() + 1);
                }

                level.setMap(sb.toString());

                levels.add(level);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return levels;
    }
}
