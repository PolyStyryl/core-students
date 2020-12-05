package core;

import java.util.ArrayList;

/**
 * This class defines the unique attributes of the Dragon.
 *
 * @author Chris Hebbs, Reece Draper
 * @version 02/12/20
 */
public class Dragon extends Champion {

    // Member Variables
    private final boolean mCanTalk;

    /**
     * The constructor for the dragon.
     * @param name - String value of the name for the dragon.
     * @param skillLevel - Integer value of the skill level for the dragon.
     * @param entryFee - Integer value of the entry fee for the dragon.
     * @param canTalk - Boolean value defining whether the dragon can talk or not.
     */
    public Dragon(String name, int skillLevel, int entryFee, boolean canTalk) {
        // Run constructor from inherited class Champion.
        super(name, skillLevel, entryFee);

        // Set whether the dragon can talk.
        mCanTalk = canTalk;

        // Dragons can do fight challenges.
        ArrayList<ChallengeType> tempChallengeType = new ArrayList<>();

        tempChallengeType.add(ChallengeType.FIGHT);
        // Dragons can do mystery challenges if they can talk
        if(mCanTalk) tempChallengeType.add(ChallengeType.MYSTERY);

        super.setChallengeTypes(tempChallengeType);

        // Dragons have a fixed entry fee of 500
        super.setEntryFee(500);

        // Dragons have a fixed level of 7
        super.setSkillLevel(7);
    }

    /**
     * Returns the string value of the Dragon object's member variables.
     * @return String value of the Dragon object's member variables.
     */
    @Override
    public String toString() {
        StringBuilder stringReturn = new StringBuilder();

        stringReturn.append(super.toString());
        stringReturn.append("Type: ").append("Dragon").append(" | ");
        stringReturn.append("Can Talk: ").append(mCanTalk);

        return stringReturn.toString();
    }
}
