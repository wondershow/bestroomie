package bestroomie.db;

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

	public static void addUser(String uEmail, String uPassword) {

		 PrintWriter output = null;
         try {
        	//Create the output file
            output = new PrintWriter(new FileWriter("userDB.temp"));
            
            //Open the input file
            Scanner fileinput = null;
              File inFile = new File("userDB");
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
                	//Output every line in the current database to the temp database
                	output.println(input);
                }
                
                //Add the given email and password to the database
                output.println("N/A" + "\t" + uEmail + "\t" + uPassword + "\t" + "N/A" + "\t");
                
                fileinput.close();
                output.close(); 
                
                // Once everything is complete, delete old file..
                File oldFile = new File("userDB");
                oldFile.delete();

                // And rename tmp file's name to old file name
                File newFile = new File("userDB.temp");
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
	
	public static void changePassword(String uEmail, String uPassword) {

		PrintWriter output = null;
        try {
       	//Create the output file
           output = new PrintWriter(new FileWriter("userDB.temp"));
           
           //Open the input file
           Scanner fileinput = null;
             File inFile = new File("userDB");
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
               		groups=groups+","+uPassword;
                    output.println(name + '\t' + email + '\t' + password + '\t' + groups + "\t");
               	}
               	else{
                    output.println(name + '\t' + email + '\t' + password + '\t' + groups + "\t");
               	}

               }
                              
               fileinput.close();
               output.close(); 
               
               // Once everything is complete, delete old file..
               File oldFile = new File("userDB");
               oldFile.delete();

               // Rename the new file to the old file's name
               File newFile = new File("userDB.temp");
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
			tempItem = tempItem.substring(tempItem.indexOf('\t')+1);
			System.out.println("temp: " + tempItem);
		}
		tempItem = tempItem.substring(0, tempItem.indexOf('\t')).trim();
		return tempItem;
	}
	
}


