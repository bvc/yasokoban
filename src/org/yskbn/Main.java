package org.yskbn;

import org.lwjgl.Sys;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;

import org.yskbn.system.OperatingSystem;

import java.lang.reflect.Field;

/**
 * Main class that begins program execution
 * Slick 2D scaffolding code provided by Darkhogg
 */
public class Main
{
    public static final int SCREEN_HEIGHT = 500;
    public static final int SCREEN_WIDTH = 800;

    /**
     * Sets up the proper library path to run the application on
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static void setupLibraryPath() throws SecurityException, NoSuchFieldException, IllegalAccessException
    {
        OperatingSystem os = OperatingSystem.getOperatingSystem();

        if (os == OperatingSystem.LINUX | os == OperatingSystem.MAC | os == OperatingSystem.WINDOWS)
        {
            String nativePath = new StringBuilder("natives-").append(os.getName().toLowerCase()).toString();
            
            String pathSeparator = System.getProperty("path.separator");
            String dirSeparator = System.getProperty("file.separator");
            String oldLibPath = System.getProperty("java.library.path");

            String newLibPath = new StringBuilder(oldLibPath)
                    .append(pathSeparator)
                    .append("lib")
                    .append(dirSeparator)
                    .append(nativePath)
                    .toString();

            System.setProperty("java.library.path", newLibPath);

            Field fieldPath = ClassLoader.class.getDeclaredField("sys_paths");
            fieldPath.setAccessible(true);

            if (fieldPath != null)
            {
                fieldPath.set(System.class.getClassLoader(), null);
            }
        }
    }

    /**
     * The application entry point
     * @param args Program arguments that were passed in
     */
    public static void main(String[] args)
    {
        try
        {
            setupLibraryPath();

            AppGameContainer container = new AppGameContainer(new WrapperGame());
            container.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
            container.start();
        }
        catch (Throwable ex)
        {
            displayFatalError(ex);
        }
    }

    /**
     * Displays error message in a prompt
     * @param ex Exception that was thrown from the game
     */
    static void displayFatalError(Throwable ex)
    {
        Log.error(ex);
        Sys.alert("Fatal Error", "Fatal error occurred during game execution: " + ex.toString());
        System.exit(1);
    }

    /**
     * Game wrapper which initializes and sets up the Game
     */
    public static final class WrapperGame implements Game
    {
        static
        {
            System.out.println("Initialized Game");
        }

        private final Game game = new Yasokoban();

        @Override
        public void init(GameContainer container) throws SlickException
        {
            container.setForceExit(false);
            container.setShowFPS(true);

            game.init(container);
        }

        @Override
        public void update(GameContainer container, int delta) throws SlickException
        {
            game.update(container, delta);
        }

        @Override
        public void render(GameContainer container, Graphics graphics) throws SlickException
        {
            game.render(container, graphics);
        }

        @Override
        public boolean closeRequested()
        {
            return game.closeRequested();
        }

        @Override
        public String getTitle()
        {
            return game.getTitle();
        }
    }
}
