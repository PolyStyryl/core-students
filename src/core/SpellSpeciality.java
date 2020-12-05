package core;

import java.io.Serializable;

/**
 * Enumeration SpellSpeciality
 *  Contains the possible values for the Spell Specialities a Wizard can have.
 *
 * @author Chris Hebbs, Reece Draper
 * @version 02/12/20
 */
public enum SpellSpeciality implements Serializable {
    // Possible values
    FIREBALLS("fireballs"),
    FLYING("flying"),
    INVISIBILITY("invisibility"),
    TRANSLOCATION("translocation"),
    TRANSMUTATION("transmutation");

    // Member Variables
    private final String mType;

    /**
     * The constructor for the enum, sets the string type.
     * @param ty - String value of the type.
     */
    SpellSpeciality(String ty) {
        mType = ty;
    }

    /**
     * Returns the string value of the Spell Speciality.
     * @return String value of the type.
     */
    public String toString() {
        return mType;
    }
}
