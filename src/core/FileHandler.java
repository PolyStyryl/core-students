package core;

import java.io.*;

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
     * Generates the file path to a specified file using the res folder.
     * @param fileName - String value of the file name.
     * @return The full path to the file.
     */
    private String generateFilePath(String fileName){
        return String.format("%s\\%s", mResDirectory, fileName);
    }
}
