package bestroomie.db;
//test
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class writeDatabase {

	private static String input;
	private static boolean firstLine=true;
	private static String name, email, password, groups;
	private static String folder = bestroomie.util.BRConst.DBFile.PATH_TO_DB_FOLDER;
	private static String fieldSeperator = bestroomie.util.BRConst.DBFile.FIELD_SEPERATOR;
	private static String groupSeperator = bestroomie.util.BRConst.DBFile.GROUP_SEPERATOR;

	public static void changePassword(String uEmail, String uPassword) {

		PrintWriter output = null;
        try {
       	//Create the output file
           output = new PrintWriter(new FileWriter(folder + "UserDB.temp"));
           
           //Open the input file
           Scanner fileinput = null;
             File inFile = new File(folder + "UserDB");
             try  {
               fileinput = new Scanner(inFile);
               //Loop through the entire file, reading it line by line
               while(fileinput.hasNext()) {
               	input = fileinput.nextLine();
               	//Skip the first line
               	if (firstLine){
               		firstLine=false;
                       output.println(input);
               		continue;
               	}
               	         	
               	//Get name
               	String name = getItem(input, 1);
//               	System.out.println("First is: " + name);
               
               	//Get email
               	email = getItem(input, 2);
//               	System.out.println("Second is: " + email);
               	
               	//Get password
               	String password = getItem(input, 3);
//               	System.out.println("Third is: " + password);

               	//Get groups
               	String groups = getItem(input, 4);
//               	System.out.println("Fourth is: " + groups);
               	
               	//if the given email address equals the database record, add the group given to the user's list of groups
               	if(uEmail.equals(email)){
               		password=uPassword;
                    output.println(name + fieldSeperator + email + fieldSeperator + password + fieldSeperator + groups + fieldSeperator);
               	}
               	else{
                    output.println(name + fieldSeperator + email + fieldSeperator + password + fieldSeperator + groups + fieldSeperator);
               	}

               }
                              
               fileinput.close();
               output.close(); 
               
               // Once everything is complete, delete old file..
               File oldFile = new File(folder + "UserDB");
               oldFile.delete();

               // Rename the new file to the old file's name
               File newFile = new File(folder + "UserDB.temp");
               newFile.renameTo(oldFile);
               
             }catch(FileNotFoundException e) {
               System.out.println(e);
               System.exit(1);
             }
             finally {
                 fileinput.close();
             }
        }catch(IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        finally {
           output.close(); 
        } 
	}
	
	//Takes a line of the database and parses the "columns" from it
	//The string must have a tab between each column and a tab at the end
	public static String getItem (String line, int itemNumber){
		String tempItem = line;
		for (int i = (itemNumber-1); i>0; i--){
			tempItem = tempItem.substring(tempItem.indexOf(fieldSeperator)+1);
			System.out.println("temp: " + tempItem);
		}
		tempItem = tempItem.substring(0, tempItem.indexOf(fieldSeperator)).trim();
		return tempItem;
	}
	
}


