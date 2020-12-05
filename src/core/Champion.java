package core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This super class stores common member variables and methods about all champions.
 *
 * @author Chris Hebbs, Reece Draper
 * @version 02/12/20
 */
public class Champion implements Serializable {

    // Member Variables
    private final String mName;
    private int mSkillLevel;
    private int mEntryFee;
    private ChampionState mState;
    private ArrayList<ChallengeType> mChallengeTypes = new ArrayList<>();

    // Methods
    /**
     * The constructor for the champion.
     * @param name - String value of the name of the champion
     * @param skillLevel - Integer value of the skill level of the champion.
     * @param entryFee - Integer value of the entry fee of the champion.
     */
    public Champion(String name, int skillLevel, int entryFee) {
        mName = name;
        mSkillLevel = skillLevel;
        mEntryFee = entryFee;

        // On creation set the champion to a waiting state so that all new champions are in reserve.
        mState = ChampionState.WAITING;
    }

    /**
     * Gets the name of the champion.
     * @return String value of name of the champion.
     */
    public String getName() {
        return mName;
    }

    /**
     * Gets the skill level of the champion.
     * @return Integer value of the skill level of the champion.
     */
    public int getSkillLevel() {
        return mSkillLevel;
    }

    /**
     * Sets the skill level of the champion.
     * @param skillLevel Integer value of the new skill level of the champion.
     */
    public void setSkillLevel(int skillLevel) {
        mSkillLevel = skillLevel;
    }

    /**
     * Gets the entry fee of the champion.
     * @return Integer value of the entry fee of the champion.
     */
    public int getEntryFee() {
        return mEntryFee;
    }

    /**
     * Sets the entry fee of the champion.
     * @param mEntryFee Integer value of the entry fee of the champion.
     */
    public void setEntryFee(int mEntryFee) {
        this.mEntryFee = mEntryFee;
    }

    /**
     * Gets the state of the champion.
     * @return ChampionState value of the state of the champion.
     * @see ChampionState for possible values.
     */
    public ChampionState getState() {
        return mState;
    }

    /**
     * Sets the value of the champion.
     * @param state ChampionState value of the state of the champion.
     * @see ChampionState for possible values.
     */
    public void setState(ChampionState state) {
        mState = state;
    }

    /**
     * Gets the challenge types that the champion can challenge.
     * @return ArrayList<ChallengeType> value of the types of challenges that a champion can challenge.
     * @see ChallengeType for possible values.
     */
    public ArrayList<ChallengeType> getChallengeTypes() {
        return mChallengeTypes;
    }

    /**
     * Sets the challenge types that the champion can challenge.
     * @param mChallengeTypes ArrayList<ChallengeType> value of the types of challenges that a champion can challenge.
     */
    public void setChallengeTypes(ArrayList<ChallengeType> mChallengeTypes) {
        this.mChallengeTypes = mChallengeTypes;
    }

    /**
     * Returns a string value of the member variables stored inside the object.
     * @return String value of the object's member variables.
     */
    public String toString() {
        StringBuilder stringReturn = new StringBuilder();

        stringReturn.append("\n");
        stringReturn.append("Name: ").append(mName).append(" | ");
        stringReturn.append("Skill Level: ").append(mSkillLevel).append(" | ");
        stringReturn.append("Entry Fee: ").append(mEntryFee).append(" | ");
        stringReturn.append("State: ").append(mState.toString()).append(" | ");

        return stringReturn.toString();
    }
}

