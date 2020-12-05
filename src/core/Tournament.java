package core;
import java.io.Serializable;
import java.util.*;

/**
 * This class implements the behaviour expected from the CORE
 *  as required for 6COM1037 Cwk Assignment - Nov 2020
 * 
 * @author Chris Hebbs, Reece Draper
 * @version 01/12/20
 */

public class Tournament implements CORE, Serializable
{
    // Fields
    private final String mPlayerName;
    private int mTreasury;
    private final ArrayList<Champion> mChampionsList;
    private final ArrayList<Challenge> mChallengeList;

    //**************** CORE ************************** 
    /** Constructor requires the name of the player
     * @param pl - the name of the player
     */  
    public Tournament(String pl)
    {
       mPlayerName = pl;
       mTreasury = 1000;
       //FileHandler fh = new FileHandler();
       // Pull in Champions from stored file.
       //mChampionsList = fh.setUpChampions();
       // Pull in challenges from stored file.
       //mChallengeList = fh.setUpChallenges();
       mChampionsList = new ArrayList<>();
       mChallengeList = new ArrayList<>();
       
       setupChallenges();
       setupChampions();
    }
    
    private void setupChallenges() {
        //ADDED CHALLENGES
        Challenge ch1 = new Challenge(1, ChallengeType.MAGIC, "Borg", 3, 100);
        mChallengeList.add(ch1);

        Challenge ch2 = new Challenge(2, ChallengeType.FIGHT, "Huns", 3, 120);
        mChallengeList.add(ch2);

        Challenge ch3 = new Challenge(3, ChallengeType.MYSTERY, "Ferengi", 3, 150);
        mChallengeList.add(ch3);

        Challenge ch4 = new Challenge(4, ChallengeType.MAGIC, "Vandal", 9, 200);
        mChallengeList.add(ch4);

        Challenge ch5 = new Challenge(5, ChallengeType.MYSTERY, "Borg", 7, 90);
        mChallengeList.add(ch5);

        Challenge ch6 = new Challenge(6, ChallengeType.FIGHT, "Goth", 8, 45);
        mChallengeList.add(ch6);

        Challenge ch7 = new Challenge(7, ChallengeType.MAGIC, "Frank", 10, 200);
        mChallengeList.add(ch7);

        Challenge ch8 = new Challenge(8, ChallengeType.FIGHT, "Sith", 10, 170);
        mChallengeList.add(ch8);

        Challenge ch9 = new Challenge(9, ChallengeType.MYSTERY, "Cardashian", 9, 300);
        mChallengeList.add(ch9);

        Challenge ch10 = new Challenge(10, ChallengeType.FIGHT, "Jute", 2, 300);
        mChallengeList.add(ch10);

        Challenge ch11 = new Challenge(11, ChallengeType.MAGIC, "Celt", 2, 250);
        mChallengeList.add(ch11);

        Challenge ch12 = new Challenge(12, ChallengeType.MYSTERY, "Celt", 1, 250);
        mChallengeList.add(ch12);
    }
    
    private void setupChampions() {
        Champion c1 = new Wizard("Ganfrank", 7, 400, true, SpellSpeciality.TRANSMUTATION);
        mChampionsList.add(c1);

        Champion c2 = new Wizard("Rudolf", 6, 400, true, SpellSpeciality.INVISIBILITY);
        mChampionsList.add(c2);

        Champion c3 = new Wizard("Neon", 2, 300, false, SpellSpeciality.TRANSLOCATION);
        mChampionsList.add(c3);

        Champion c4 = new Wizard ("Krypton", 8, 300, false, SpellSpeciality.FIREBALLS);
        mChampionsList.add(c4);

        Champion c5 = new Wizard ("Hedwig", 1, 400, true, SpellSpeciality.FLYING);
        mChampionsList.add(c5);

        Champion c6 = new Warrior ("Elblond", 1, 150, WarriorWeapon.SWORD);
        mChampionsList.add(c6);

        Champion c7 = new Warrior ("Flimsi", 2, 200, WarriorWeapon.BOW);
        mChampionsList.add(c7);

        Champion c8 = new Warrior ("Argon", 9, 900, WarriorWeapon.MACE);
        mChampionsList.add(c8);

        Champion c9 = new Warrior ("Atlanta", 5, 500, WarriorWeapon.BOW);
        mChampionsList.add(c9);

        Champion c10 = new Dragon ("Drabina", 7, 500, false);
        mChampionsList.add(c10);

        Champion c11 = new Dragon ("Golum", 7, 500, true);
        mChampionsList.add(c11);

        Champion c12 = new Dragon ("Xenon", 7, 500, true);
        mChampionsList.add(c12);
    }

    //******* Implements interface CORE *******************
    /**Returns a String representation of the state of the game,
     * including the name of the player, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     * 
     * @return a String representation of the state of the game,
     * including the name of the player, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     */
    public String toString() {
        String isDefeated;
        // Convert boolean true/false to Is OK or Not OK.
        if(!isDefeated()) isDefeated = "Is OK";
        else isDefeated = "Not OK";

        return "Game State\n" +
                "==========\n\n" +
                "Player Name: " + mPlayerName + "\n" +
                "Treasury: " + mTreasury + "\n" +
                "Is Defeated: " + isDefeated + "\n" +
                "Champions: " + getTeam() + "\n";
     }
  
    /** Returns true if Treasury <=0 and the player's team has no
     * champions which can be withdrawn. 
     * @return true if Treasury <=0 and the player's team has no
     * champions which can be decommissioned. 
     */
    public boolean isDefeated(){
        for (Champion champion : mChampionsList) {
            if(champion.getState() == ChampionState.ACTIVE) {
                return false;
            }
        }
        return mTreasury <=0;
    }

    /** Returns the amount of money in the Treasury
     * @return the amount of money in the Treasury
     */
    public int getMoney(){
       return mTreasury;
    }    
    
    /**Returns a String representation of all champions in reserve
     * @return a String representation of all champions in reserve
     **/
    public String getReserve(){
        StringBuilder reserveReturn = new StringBuilder();

        for(Champion champion : mChampionsList){
            if(champion.getState() == ChampionState.WAITING){
                reserveReturn.append(champion.toString());
            }
        }

        return reserveReturn.toString();
    }
       
    /** Returns details of any champion with the given name
     * @return details of any champion with the given name
     **/
    public String getChampionDetails(String nme)
    {
        for (Champion champion : mChampionsList) {
            if(champion.getName().equalsIgnoreCase(nme)){
                return champion.toString();
            }
        }
        return "Champion not found";
    }
    
    /** returns whether champion is in reserve
    * @param nme - champion's name
    * @return true if champion in reserve, false otherwise
    */
    public boolean isInReserve(String nme) {
        for (Champion champion : mChampionsList) {
            if(champion.getName().equalsIgnoreCase(nme)) {
                return champion.getState() == ChampionState.WAITING;
            }
        }
        return false;
    }
    
 // ***************** Players Team************************   
    /** Allows a champion to be entered for the player's team, if there 
     * is enough money in the Treasury for the entry fee. The champion's
     * state is set to "active"
     * 0 if champion is entered in the player's team, 
     * 1 if champion is not in reserve, 
     * 2 if not enough money in the treasury, 
     * -1 if there is no such champion 
     * @param nme represents the name of the champion
     * @return as shown above
     **/        
    public int enterChampion(String nme){
        for (Champion champion : mChampionsList) {
            if(champion.getName().toLowerCase().equals(nme.toLowerCase())){
                switch(champion.getState()){
                    case ACTIVE:
                    case DEAD:
                        return 1;
                    case WAITING:
                        if(mTreasury >= champion.getEntryFee()){
                            champion.setState(ChampionState.ACTIVE);
                            mTreasury -= champion.getEntryFee();
                            return 0;
                        } else {
                            return 2;
                        }
                }
            }
        }
        return -1;
    }
    
        
    /** Returns true if the champion with the name is in 
     * the player's team, false otherwise.
     * @param nme is the name of the champion
     * @return returns true if the champion with the name
     * is in the player's team, false otherwise.
     **/
    public boolean isInPlayersTeam(String nme){
        for (Champion champion : mChampionsList) {
            if(champion.getName().equalsIgnoreCase(nme) && champion.getState() == ChampionState.ACTIVE){
                return true;
            }
        }
        return false;
    }
    
    
    /** Removes a champion from the team to the reserves (if they are in the team)
     * Pre-condition: isChampion()
     * 0 - if champion is retired to reserves
     * 1 - if champion not retired because dead
     * 2 - if champion not retired because not in team
     * -1 - if no such champion
     * @param nme is the name of the champion
     * @return as shown above 
     **/
    public int retireChampion(String nme){
        for (Champion champion : mChampionsList) {
            if(champion.getName().toLowerCase().equals(nme.toLowerCase())){
                switch (champion.getState()) {
                    case DEAD:
                        return 1;
                    case WAITING:
                        return 2;
                    case ACTIVE:
                        champion.setState(ChampionState.WAITING);
                        mTreasury += (champion.getEntryFee()/2);
                        return 0;
                    default:
                        break;
                }
            }
        }
        return -1;
    }
        
        
    /**Returns a String representation of the champions in the player's team
     * or the message "No champions entered"
     * @return a String representation of the champions in the player's team
     **/
    public String getTeam(){
        int championCount = 0;
        StringBuilder teamReturn = new StringBuilder();

        for (Champion champion : mChampionsList) {
            if(champion.getState() == ChampionState.ACTIVE){
                teamReturn.append(champion.toString());
                championCount += 1;
            }
        }

        if(championCount >= 1){
            return teamReturn.toString();
        } else {
            return "No champions entered";
        }
    }
    
    
//**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the number of the challenge
     * @return true if the number represents a challenge
     **/
     public boolean isChallenge(int num){
         for (Challenge challenge : mChallengeList) {
            if(challenge.getChallengeID() == num){
                return true;
            }
         }
         return false;
     }
     
    /** Provides a String representation of an challenge given by 
     * the challenge number
     * @param num the number of the challenge
     * @return returns a String representation of a challenge given by 
     * the challenge number
     **/
    public String getChallenge(int num){
        for (Challenge challenge :  mChallengeList) {
            if(challenge.getChallengeID() == num){
                return challenge.toString();
            }
        }
        return "Challenge not found";
    }
    
    /** Provides a String representation of all challenges 
     * @return returns a String representation of all challenges
     **/
    public String getAllChallenges(){
        StringBuilder sb = new StringBuilder();
        for (Challenge challenge : mChallengeList) {
            sb.append(challenge.toString());
        }

        return sb.toString();
    }
    
    /** Retrieves the challenge represented by the challenge 
     * number.Finds a champion from the team which can challenge the 
     * challenge. The results of fighting an challenge will be 
     * one of the following:  
     * 0 - challenge won, add reward to the treasury, 
     * 1 - challenge lost on battle skills  - deduct reward from
     * treasury and record champion as "dead"
     * 2 - challenge lost as no suitable champion is  available, deduct
     * the reward from treasury 
     * 3 - If a challenge is lost and player completely defeated (no money and 
     * no champions to withdraw) 
     * -1 - no such challenge 
     * @param chalNo is the number of the challenge
     * @return an int showing the result(as above) of fighting the challenge
     */ 
    public int fightChallenge(int chalNo){
        Challenge selectedChallenge = null;
        boolean suitableChampionFound = false;
        int returnvalue = 0;

        // Find the selected challenge
        for (Challenge challenge : mChallengeList) {
            if(challenge.getChallengeID() == chalNo) {
                selectedChallenge = challenge;
                break;
            }
        }

        // Selected challenge will be null if no challenge is found
        if(selectedChallenge == null){
            return -1;
        }

        // find champion available to fight
        for (Champion champion : mChampionsList) {
            if(champion.getState() == ChampionState.ACTIVE){
                for (ChallengeType challengeType : champion.getChallengeTypes()) {
                    if(selectedChallenge.getChallengeType() == challengeType) {
                        suitableChampionFound = true;

                        if(selectedChallenge.getSkillRequired() <= champion.getSkillLevel()){
                            mTreasury += selectedChallenge.getReward();
                            return 0;
                        } else {
                            mTreasury -= selectedChallenge.getReward();
                            champion.setState(ChampionState.DEAD);
                            returnvalue = 1;
                            break;
                        }
                    }
                }
                if(suitableChampionFound){
                    break;
                }
            }
        }

        if(!suitableChampionFound) {
            mTreasury -= selectedChallenge.getReward();
            returnvalue = 2;
        }

        if(isDefeated()){
            return 3;
        }

        return returnvalue;
    }
  
// These methods are not needed until Task 4.4
    // ***************   file write/read  *********************
    /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
    public void saveGame(String fname){
        FileHandler fh = new FileHandler(fname);
        System.out.println(fh.writeObjectToFile(this));
    }
    
    /** reads all information about the game from the specified file 
     * and returns a CORE reference to a Tournament object
     * @param fname name of file storing the game
     * @return the game (as a Tournament object)
     */
    public CORE loadGame(String fname){
        FileHandler fh = new FileHandler();
        return fh.ReadObjectFromFile(fname);
    }
}



