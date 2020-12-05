package core;

/**
 * Details of your team
 * 
 * @author Reece Draper, Chris Hebbs
 * @version 29/11/2020
 */
public class Teamwork
{
    private final String[] details = new String[7];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team
        // It will help us if the surname of programmer1 comes
        // alphabetically before the surname of programmer2
        details[0] = "Team Rocket";
        details[1] = "Draper";
        details[2] = "Reece";
        details[3] = "19014711";
        details[4] = "Hebbs";
        details[5] = "Chris";
        details[6] = "17064221";
    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
