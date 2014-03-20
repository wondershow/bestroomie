import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ValidateUser {

	private static boolean firstLine=true;
	private static boolean valid=false;
	
	public static boolean validUser(String userName, String password) {
	
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

            	if (firstLine){
            		firstLine=false;
            		continue;
            	}
            
            	//Get email
            	String second = getItem(input, 2);
            	System.out.println("Second is: " + second);
            	
            	//Get password
            	String third = getItem(input, 3);
            	System.out.println("Third is: " + third);
            	
            	if ((second.equals(userName)) && (third.equals(password))){
            		valid = true;
            	}
            	
            	System.out.println();

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
	
	public static String getItem (String line, int itemNumber){
		String tempItem = line;
		
		for (int i = (itemNumber-1); i>0; i--){
			tempItem = tempItem.substring(tempItem.indexOf('\t')+1).trim();
		}
		tempItem = tempItem.substring(0, tempItem.indexOf('\t')).trim();
		return tempItem;
	}

}
