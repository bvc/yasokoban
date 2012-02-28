package org.yskbn.system;

import java.util.regex.Pattern;

/**
 * Enum used to identify Operating System family
 */
public enum OperatingSystem
{
    WINDOWS("Windows", ".*windows.*"),
    MAC("Mac", "mac.*"),
    LINUX("Linux", ".*linux.*");

    private final String name;
    private final String regex;

    private OperatingSystem(final String name, final String regex)
    {
        if (name == null | regex == null)
        {
            throw new NullPointerException("No operating system or regex provided");
        }
        
        this.name = name;
        this.regex = regex;
    }
    
    public String getName()
    {
        return name;
    }

    public static OperatingSystem findByName(final String osName)
    {
        final String lowerCaseOsName = osName.toLowerCase();

        for (final OperatingSystem os : values())
        {
            if (Pattern.matches(os.regex, lowerCaseOsName))
            {
                return os;
            }
        }

        return null;
    }

    public static OperatingSystem getOperatingSystem()
    {
        return findByName(System.getProperty("os.name"));
    }
}
