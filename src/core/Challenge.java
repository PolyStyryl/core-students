package core;

import java.io.Serializable;

/**
 * Challenge Class
 *  This class stores information about challenges.
 *
 * @author Chris Hebbs, Reece Draper
 * @version 02/12/20
 */

public class Challenge implements Serializable {
    // Member Variables
    private final int mChallengeID;
    private final ChallengeType mChallengeType;
    private final String mChallengeEnemy;
    private final int mSkillRequired;
    private final int mReward;

    // Methods
    /**
     * The constructor for the challenge class.
     * @param challengeID - Integer value for the ID of the challenge.
     * @param challengeType - ChallengeType value for the type of challenge.
     * @see ChallengeType for information on possible values.
     * @param challengeEnemy - String value for the name of the enemy to fight in the challenge.
     * @param skillRequired - Integer value of the skill level required to fight the challenge.
     * @param reward - Integer value of the reward given upon successful completion of the challenge.
     */
    public Challenge(int challengeID, ChallengeType challengeType, String challengeEnemy, int skillRequired, int reward){
        mChallengeID = challengeID;
        mChallengeType = challengeType;
        mChallengeEnemy = challengeEnemy;
        mSkillRequired = skillRequired;
        mReward = reward;
    }

    /**
     * Gets the ID of the challenge.
     * @return mChallengeID - Integer value for the ID of the challenge.
     */
    public int getChallengeID() {
        return mChallengeID;
    }

    /**
     * Gets the ChallengeType.
     * @return mChallengeType - ChallengeType value of the type for the challenge.
     * @see ChallengeType for information on possible values.
     */
    public ChallengeType getChallengeType() {
        return mChallengeType;
    }

    /**
     * Gets the skill required to fight the challenge.
     * @return mSkillRequires - Integer value of the skill required to fight the challenge.
     */
    public int getSkillRequired() {
        return mSkillRequired;
    }

    /**
     * Gets the reward for the challenge.
     * @return mReward - Integer value of the reward given for successful completion of a challenge.
     */
    public int getReward() {
        return mReward;
    }

    /**
     * Returns the string value of the challenge object's member variables.
     * @return String value of the challenge object's member variables.
     */
    public String toString() {
        return  "mChallengeID: " + mChallengeID + "\n" +
                ", mChallengeType: " + mChallengeType + "\n" +
                ", mChallengeEnemy: " + mChallengeEnemy + "\n" +
                ", mSkillRequired: " + mSkillRequired + "\n" +
                ", mReward: " + mReward + "\n\n";
    }
}
