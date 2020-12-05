package core;

import java.util.ArrayList;

/**
 * This class defines the unique attributes of the Wizard.
 *
 * @author Chris Hebbs, Reece Draper
 * @version 03/12/20
 */
public class Wizard extends Champion {
    // Member Variables
    private final boolean mIsNecromancer;
    private final SpellSpeciality mSpellSpeciality;

    /**
     * The constructor for the Wizard class.
     * @param name - String value of the name of the Wizard.
     * @param skillLevel - Integer value of the level of a Wizard.
     * @param entryFee - Integer value of the entry fee of a Wizard.
     * @param isNecromancer - Boolean value of the whether the Wizard is a Necromancer or not.
     * @param spellSpeciality - SpellSpeciality value of the spell speciality that a Wizard can have.
     * @see SpellSpeciality for possible values.
     *
     */
    public Wizard(String name, int skillLevel, int entryFee, boolean isNecromancer, SpellSpeciality spellSpeciality) {
        super(name, skillLevel, entryFee);

        mIsNecromancer = isNecromancer;
        mSpellSpeciality = spellSpeciality;

        // Wizards can fight in all 3 challenge types.
        ArrayList<ChallengeType> tempChallengeTypes = new ArrayList<>();
        tempChallengeTypes.add(ChallengeType.FIGHT);
        tempChallengeTypes.add(ChallengeType.MAGIC);
        tempChallengeTypes.add(ChallengeType.MYSTERY);
        super.setChallengeTypes(tempChallengeTypes);

        // Wizards have an entry fee of 300 gulden, but if they are also necromancers their fee is 400 gulden.
        if(mIsNecromancer) super.setEntryFee(400);
        else super.setEntryFee(300);

    }

    /**
     * Returns a string value of the wizard.
     * @return String value of of the wizard's member variables.
     */
    @Override
    public String toString() {
        StringBuilder stringReturn = new StringBuilder();

        stringReturn.append(super.toString());
        stringReturn.append("Type: ").append("Wizard").append(" | ");
        stringReturn.append("is Necromancer: ").append(mIsNecromancer).append(" | ");
        stringReturn.append("Spell Speciality: ").append(mSpellSpeciality);

        return stringReturn.toString();
    }
}
