package org.yskbn.level;


import java.io.File;
import java.io.FileFilter;

public class LevelFileFilter implements FileFilter
{
    @Override
    public boolean accept(File file)
    {
        if (file.getPath().endsWith(".level") || file.getPath().endsWith(".LEVEL"))
        {
            return true;
        }

        return false;
    }
}