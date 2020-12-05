package core;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class handles operations performed on files.
 *
 * @author Chris Hebbs, Reece Draper
 * @version 02/12/20
 */
public class FileHandler {
    // Member Variables
    private static final String mWorkingDirectory = System.getProperty("user.dir");
    private static final String mResDirectory = String.format("%s\\res", mWorkingDirectory);
    private static final String mChampionsFileName = "champions.txt";
    private static final String mChallengeFileName = "challenges.txt";
    private String mSavedGameFileName = "savedData.txt";

    /**
     * Blank constructor to allow construction without specifying a file.
     */
    public FileHandler() {}

    /**
     * Overloaded constructor to allow construction with specific file.
     * @param fileName String value of the filename to open.
     */
    public FileHandler(String fileName){
        mSavedGameFileName = fileName;
    }

    /**
     * Method to load the champions from external file.
     * @return ArrayList<Champion> value containing the champions loaded from the file.
     */
    public ArrayList<Champion> setUpChampions() {
        File file = openFile(mChampionsFileName);
        ArrayList<Champion> championsArrayList = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                // Read data from file
                String data = reader.nextLine();
                // Split csv values
                String[] championData = data.split(",");

                // Extract common data for champions.
                // .replaceall to remove stupid encoding in file
                String championName = championData[0].replaceAll("[\uFEFF-\uFFFF]", "");
                int championSkillLevel = Integer.parseInt(championData[1]);
                int championEntryFee = Integer.parseInt(championData[3]);

                // Declare new champion
                Champion newChamp;

                // Switch dependant on championType
                String championType = championData[7];
                switch(championType){
                    case "wizard":
                        // Extract unique data for wizard class.
                        boolean isNecromancer = convertPolarToBoolean(championData[2]);
                        SpellSpeciality spellSpec = SpellSpeciality.valueOf(championData[4].toUpperCase());

                        // Create new champion
                        newChamp = new Wizard(championName, championSkillLevel, championEntryFee,
                                isNecromancer, spellSpec);
                        break;
                    case "warrior":
                        // Extract unique data for warrior class.
                        WarriorWeapon warriorWeapon = WarriorWeapon.valueOf(championData[5].toUpperCase());

                        // Create new champion
                        newChamp = new Warrior(championName, championSkillLevel, championEntryFee, warriorWeapon);
                        break;
                    case "dragon":
                        // Extract unique data for dragon class.
                        boolean championCanTalk = convertPolarToBoolean(championData[6]);

                        // Create new champion
                        newChamp = new Dragon(championName, championSkillLevel, championEntryFee, championCanTalk);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + championData[7]);
                }

                championsArrayList.add(newChamp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return championsArrayList;
    }

    /**
     * Method to load the challenges from external file.
     * @return ArrayList<Champion> value containing the challenges loaded from the file.
     */
    public ArrayList<Challenge> setUpChallenges() {
        File file = openFile(mChallengeFileName);
        ArrayList<Challenge> challengesArrayList = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()) {
                // Read data from file
                String data = reader.nextLine();
                // Split csv values
                String[] challengeData = data.split(",");

                // Remove Non-printable character that has appeared somehow
                challengeData[0] = challengeData[0].replaceAll("\\uFEFF", "");

                int challengeID = Integer.parseInt(challengeData[0]);
                ChallengeType challengeType = ChallengeType.valueOf(challengeData[1].toUpperCase());
                String enemyChampion = challengeData[2];
                int challengeSkillRequired = Integer.parseInt(challengeData[3]);
                int challengeReward = Integer.parseInt(challengeData[4]);

                Challenge newChallenge = new Challenge(challengeID, challengeType, enemyChampion,
                        challengeSkillRequired, challengeReward);

                challengesArrayList.add(newChallenge);
            }
        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return challengesArrayList;
    }

    /**
     * Writes the tournament object to a file for persistence.
     * @param obj - The object to write to the file.
     * @return whether the object was successfully written to storage. (File: savedData.txt)
     */
    public String writeObjectToFile(Object obj){
        try {
            FileOutputStream fileOut = new FileOutputStream(generateFilePath(mSavedGameFileName));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(obj);
            objectOut.close();
            return "The game was successfully saved!";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "The game wasn't saved successfully!";
        }
    }

    /**
     * Reads the tournament object to a file for persistence.
     * @param filename - String value of the filename to read from.
     * @return
     */
    public CORE ReadObjectFromFile(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(generateFilePath(filename));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            CORE obj = (CORE) objectIn.readObject();

            System.out.println("The game was successfully loaded!");
            objectIn.close();
            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Opens and returns a specified file.
     * @param fileName - String value of the name of the file to open.
     * @return the file that has been opened.
     */
    private File openFile(String fileName){
        return new File(generateFilePath(fileName));
    }

    /**
     * Generates the filepath to a specified file using the res folder.
     * @param fileName - String value of the file name.
     * @return The full path to the file.
     */
    private String generateFilePath(String fileName){
        return String.format("%s\\%s", mResDirectory, fileName);
    }

    /**
     * Converts yes/no polar data to true/false boolean data.
     * @param polar - String value of containing polar value.
     * @return true if yes, false if no.
     * @throws Exception if the value inputted is not yes or no.
     */
    private Boolean convertPolarToBoolean(String polar) throws Exception {
        if(polar.equalsIgnoreCase("yes")){
            return true;
        } else if(polar.equalsIgnoreCase("no")) {
            return false;
        } else {
            throw new Exception("Unable to parse data");
        }
    }
}
