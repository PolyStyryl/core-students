package core;

import java.util.ArrayList;

/**
 * This class defines the unique attributes of the Warrior.
 *
 * @author Chris Hebbs, Reece Draper
 * @version 02/12/20
 */
public class Warrior extends Champion {

    // Member Variables
    private final WarriorWeapon mWarriorWeapon;

    /**
     * The constructor for the Warrior class.
     * @param name - String value of the name of the Warrior.
     * @param skillLevel - Integer value of the skill level of the warrior.
     * @param entryFee - Integer value of the entry fee of the warrior.
     * @param weapon - WarriorWeapon value of the weapon the warrior has.
     */
    public Warrior(String name, int skillLevel, int entryFee, WarriorWeapon weapon) {
        // Run super constructor.
        super(name, skillLevel, entryFee);

        // Warriors can do fight challenges.
        ArrayList<ChallengeType> tempChallengeType = new ArrayList<>();
        tempChallengeType.add(ChallengeType.FIGHT);
        super.setChallengeTypes(tempChallengeType);

        // Store the warriors preferred weapon.
        mWarriorWeapon = weapon;

        // Warriors skill level is their entry fee divided by 100
        super.setSkillLevel(super.getEntryFee() / 100);
    }

    /**
     * Method to get string value of the Warrior.
     * @return String value of the Warrior.
     */
    @Override
    public String toString() {
        StringBuilder stringReturn = new StringBuilder();

        stringReturn.append(super.toString());
        stringReturn.append("Type: ").append("Warrior").append(" | ");
        stringReturn.append("Weapon: ").append(mWarriorWeapon);

        return stringReturn.toString();
    }
}
