package core;

import java.io.Serializable;

/**
 * Enumeration WarriorWeapon
 *  Defines possible values for the weapons a warrior can have.
 *
 * @author Chris Hebbs, Reece Draper
 * @version 02/12/20
 */
public enum WarriorWeapon implements Serializable {
    // Possible values
    BOW("Bow"),
    MACE("Mace"),
    SWORD("Sword");

    // Member Variables
    private final String mType;

    /**
     * The constructor for the enum, sets the string type.
     * @param ty - String value of the type.
     */
    WarriorWeapon(String ty)
    {
        mType = ty;
    }

    /**
     * Returns the string value of the type of WarriorWeapon.
     * @return String value of the type.
     */
    public String toString()
    {
        return mType;
    }
}
