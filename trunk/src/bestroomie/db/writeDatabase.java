package bestroomie.db;
//testagain
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
	private static String groupSeperator = bestroomie.util.BRConst.DBFile.SUBFIELD_SEPERATOR;
	private static int nameLocation = bestroomie.util.BRConst.DBUserFile.ROW_OF_USER_NAME+1;
	private static int emailLocation = bestroomie.util.BRConst.DBUserFile.ROW_OF_USER_EMAIL+1;
	private static int passwordLocation = bestroomie.util.BRConst.DBUserFile.ROW_OF_USER_PASS+1;
	private static int groupsLocation = bestroomie.util.BRConst.DBUserFile.ROW_OF_USER_GROUP+1;


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
               	name = getItem(input, nameLocation);
               	System.out.println("First is: " + name);
               
               	//Get email
               	email = getItem(input, emailLocation);
               	System.out.println("Second is: " + email);
               	
               	//Get password
               	password = getItem(input, passwordLocation);
               	System.out.println("Third is: " + password);

               	//Get groups
               	groups = getItem(input, groupsLocation);
               	System.out.println("Fourth is: " + groups);
               	
               	//if the given email address equals the database record, add the group given to the user's list of groups
               	if(uEmail.equals(email)){
               		password=uPassword;
                    output.println(name + fieldSeperator + email + fieldSeperator + password + fieldSeperator + groups);
               	}
               	else{
                    output.println(name + fieldSeperator + email + fieldSeperator + password + fieldSeperator + groups);
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
	
	public static void addUsertoGroup(String uEmail, String newGroup) {

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
               	name = getItem(input, nameLocation);
               	System.out.println("First is: " + name);
               
               	//Get email
               	email = getItem(input, emailLocation);
               	System.out.println("Second is: " + email);
               	
               	//Get password
               	password = getItem(input, passwordLocation);
               	System.out.println("Third is: " + password);

               	//Get groups
               	groups = getItem(input, groupsLocation);
               	System.out.println("Fourth is: " + groups);
               	
               	
               	//if the given email address equals the database record, add the group given to the user's list of groups
               	if(uEmail.equals(email)){
                   	//If the user isn't in a group, make the given group their only group, otherwise add it to the list
                   	if(groups.charAt(0) == ','){
                   		System.out.println("Only one group");
                   		groups = newGroup;
                   	}
                   	else if (groups.contains(newGroup)){
                   		System.out.println("Already in the group");
                   	}
                   	else{
                   		System.out.println ("New group  list: " + groups + groupSeperator + newGroup);
                   		groups += groupSeperator + newGroup;
                   	}
                    output.println(name + fieldSeperator + email + fieldSeperator + password + fieldSeperator + groups);
               	}
               	else{
                    output.println(name + fieldSeperator + email + fieldSeperator + password + fieldSeperator + groups);
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
	
	public static void removeUserFromGroup(String uEmail, String grouptoRemove) {

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
               	name = getItem(input, nameLocation);
               	System.out.println("First is: " + name);
               
               	//Get email
               	email = getItem(input, emailLocation);
               	System.out.println("Second is: " + email);
               	
               	//Get password
               	password = getItem(input, passwordLocation);
               	System.out.println("Third is: " + password);

               	//Get groups
               	groups = getItem(input, groupsLocation);
               	System.out.println("Fourth is: " + groups);
               	
               	
               	//if the given email address equals the database record, add the group given to the user's list of groups
               	if(uEmail.equals(email)){
                   	//If the user isn't in a group, make the given group their only group, otherwise add it to the list
                   	if (groups.contains(grouptoRemove)){
                   		System.out.println("Already in the group");
                   		if (groups.indexOf(grouptoRemove) == 0){
                   			System.out.println("group is at the start");
                   			
                       		groups = groups.replaceAll(grouptoRemove, "");
                   			
                       		if (groups.length() == 0){
                   				groups = ",";
                   			}
                       		if (groups.length()>1 && groups.charAt(0) == ','){
                   				groups = groups.substring(1);
                   			}
                   		}
                   		else if (groups.indexOf(grouptoRemove)+grouptoRemove.length() == groups.length()){
                   			System.out.println("group is at the end");
                       		groups = groups.replaceAll(','+grouptoRemove, "");
                   		}
                   		else {
                   			System.out.println("Group is in the middle");
                       		groups = groups.replaceAll(','+grouptoRemove, "");
                   		}
                   	}
                   	else{
                   	}
                    output.println(name + fieldSeperator + email + fieldSeperator + password + fieldSeperator + groups);
               	}
               	else{
                    output.println(name + fieldSeperator + email + fieldSeperator + password + fieldSeperator + groups);
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
		try{
			tempItem = tempItem.substring(0, tempItem.indexOf(fieldSeperator)).trim();
			System.out.println("temp: " + tempItem);
		}catch(IndexOutOfBoundsException e){
			System.out.println("catch temp: " + tempItem);
		}
		return tempItem;
	}
	
}


