package bestroomie.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class readDatabase {
	//Variable to identify if you are on the first line
	private static boolean firstLine=true;
	//Variable to identify if the user is valid
	private static boolean valid=false;
	private static String email, password;
	
	public static boolean validateUser(String userName, String password) {
	
		firstLine=true;
		valid=false;
		
		 //Open the input file
        Scanner fileinput = null;
          String input;
          File inFile = new File("userDB");
          try
          {
            fileinput = new Scanner(inFile);
            while(fileinput.hasNext())
            {
            	input = fileinput.nextLine();
            	
            	//Skip the first line
            	if (firstLine){
            		firstLine=false;
            		continue;
            	}
            
            	//Get email
            	email = getItem(input, 2);
            	System.out.println("Second is: " + email);
            	
            	//Get password
            	password = getItem(input, 3);
            	System.out.println("Third is: " + password);
            	
            	//If the supplied email and password matches a database entry, make valid=true
            	if ((email.equals(userName)) && (password.equals(password))){
            		valid = true;
            	}
            	
            }
            fileinput.close();
          }catch(FileNotFoundException e)
          {
            System.out.println(e);
            System.exit(1);
          }
          finally
          {
              fileinput.close();
          }	
          return valid;
	}
	
	//Takes a line of the database and parses the "columns" from it
	//The string must have a tab between each column and a tab at the end
	public static String getItem (String line, int itemNumber){
		String tempItem = line;
		
		for (int i = (itemNumber-1); i>0; i--){
			tempItem = tempItem.substring(tempItem.indexOf('\t')+1).trim();
		}
		tempItem = tempItem.substring(0, tempItem.indexOf('\t')).trim();
		return tempItem;
	}

}
