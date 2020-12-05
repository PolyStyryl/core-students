package core;

import java.io.*;

/**
 * Enumeration ChallengeType
 *  Defines possible values for the types of challenges that can be fought.
 * 
 * @author Chris Hebbs, Reece Draper
 * @version 02/12/20
 */
public enum ChallengeType
{
    // Possible values
    MAGIC("Magic"),
    FIGHT("Fight"),
    MYSTERY ("Mystery");

    // Member Variables
    private final String type;

    /**
     * The constructor for the enum, sets the string type.
     * @param ty - String value of the type.
     */
    ChallengeType(String ty)
    {
        type = ty;
    }

    /**
     * Returns the string value of the Challenge Type.
     * @return String value of the type.
     */
    public String toString()
    {
        return type;
    }
}