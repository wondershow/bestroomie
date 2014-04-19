package bestroomie.db;
//test
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import bestroomie.util.BRConst;

public class BRDBConnector {
	protected String dbFileName = "";
	protected String fldSeperator = "";
		
	public BRDBConnector(String fileName) {
		this.fldSeperator = BRConst.DBFile.FIELD_SEPERATOR;
		//System.out.println("The file name is " + fileName);
		this.dbFileName = fileName;
	}

	/**
	 * To read/return a specific line from a file,
	 * The line is specified by the id and field count 
	 * @param id, the identifier of record corresponds to that line
	 * @param fieldCount, in which row of that file is the keyword(the row # starts from 0)
	 *  */
	public String BRDBRead(String id,int fieldCount) {
		String res = null;
		String dbFileFullPath = BRConst.DBFile.PATH_TO_DB_FOLDER + this.dbFileName;
		FileReader fr;
		BufferedReader br;
		String strInputLine = "";
		
		try {
			fr = new FileReader(dbFileFullPath);
			br = new BufferedReader(fr);
			strInputLine = br.readLine();
			
			String[] fields;
			
			while(strInputLine != null) {
				strInputLine = strInputLine.trim();
				if(strInputLine.equals("")) continue; //handles empty lines
				fields = strInputLine.split(this.fldSeperator);
				//System.out.println("Lines is " + strInputLine + ", match id is " + id + ", that field is " + fields[fieldCount]);
				//find the matching line
				if(fields[fieldCount].equals(id)) {
					res = strInputLine;
					break;
				}
				strInputLine = br.readLine();
			}
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = null;
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	/**
	 * To read/return all the matched  lines from a file,
	 * The lines are specified by the patternStr and field count 
	 * @patternStr
	 * @fieldCount 
	 ***/
	public ArrayList<String> getAllMatchedRecords(String patternStr,int fieldCount) {
		
		ArrayList<String> res = new ArrayList<String>();
		
		String dbFileFullPath = BRConst.DBFile.PATH_TO_DB_FOLDER + this.dbFileName;
		FileReader fr;
		BufferedReader br;
		String strInputLine = "";
		
		try {
			fr = new FileReader(dbFileFullPath);
			br = new BufferedReader(fr);
			strInputLine = br.readLine();
			
			String[] fields;
			
			while(strInputLine != null) {
				strInputLine = strInputLine.trim();
				if(strInputLine.equals("")) {
					strInputLine = br.readLine();
					continue; //handles empty lines
				}
				fields = strInputLine.split(this.fldSeperator);
				//find the matching line
				if(fields[fieldCount].equals(patternStr)) {
					res.add(strInputLine);
				}
				strInputLine = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = null;
			e.printStackTrace();
		}
		return res;
	}
	
	
	/***
	 * To write a line to a data file, if that line exists, update it,
	 * otherwise write a new line to the file
	 * @param line, the lines that needs to be updated to the file
	 * @param id, the identifier of record corresponds to that line
	 * @param fieldCount, in which row of that file is the keyword(the row # starts from 0)
	 * **/
	public boolean BRDBWrite(String line,String id, int fieldCount) {
		boolean res = true;
		boolean needToWriteNewLine = true;
		FileReader fr;
		BufferedReader br;
		PrintWriter output = null;
		String strInputLine = "";
		String tmpFileFullPath = BRConst.DBFile.PATH_TO_DB_FOLDER + BRConst.DBFile.FILE_NAME_TRANSDB + "tmp";
		String dbFileFullPath = BRConst.DBFile.PATH_TO_DB_FOLDER + BRConst.DBFile.FILE_NAME_TRANSDB;
		
		
		try {
			output = new PrintWriter(new FileWriter(tmpFileFullPath));
			fr = new FileReader(dbFileFullPath);
			br = new BufferedReader(fr);
			
			
			strInputLine = br.readLine();
			String[] fields; 
			while(strInputLine != null) {
				fields = strInputLine.split(this.fldSeperator);
				//write only when the keyword does not exist in the file
				if(fields[fieldCount].equals(id)) {
					System.out.println("I am writing:");
					System.out.println(line);
					output.println(line);
					needToWriteNewLine = false;
				}
				else
					output.println(strInputLine);

				strInputLine = br.readLine();
			}
			
			if(needToWriteNewLine)
				output.println(line);
			output.close();
			br.close();
			
			//to delete the old file and replace it with the swap file
			File oldFile = new File(dbFileFullPath);
			oldFile.delete();
			File newFile = new File(tmpFileFullPath);
			newFile.renameTo(oldFile);
			
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}
        
		return res;
	}
	
	public boolean BRDBWriteUserDB(String line,String id, int fieldCount) {
		boolean res = true;
		boolean needToWriteNewLine = true;
		FileReader fr;
		BufferedReader br;
		PrintWriter output = null;
		String strInputLine = "";
		String tmpFileFullPath = BRConst.DBFile.PATH_TO_DB_FOLDER + BRConst.DBFile.FILE_NAME_USERDB + "tmp";
		String dbFileFullPath = BRConst.DBFile.PATH_TO_DB_FOLDER + BRConst.DBFile.FILE_NAME_USERDB;
		
		
		try {
			output = new PrintWriter(new FileWriter(tmpFileFullPath));
			fr = new FileReader(dbFileFullPath);
			br = new BufferedReader(fr);
			
			
			strInputLine = br.readLine();
			String[] fields; 
			while(strInputLine != null) {
				fields = strInputLine.split(this.fldSeperator);
				//write only when the keyword does not exist in the file
				if(fields[fieldCount].equals(id)) {
					System.out.println("I am writing:");
					System.out.println(line);
					output.println(line);
					needToWriteNewLine = false;
				}
				else
					output.println(strInputLine);

				strInputLine = br.readLine();
			}
			
			if(needToWriteNewLine)
				output.println(line);
			output.close();
			br.close();
			
			//to delete the old file and replace it with the swap file
			File oldFile = new File(dbFileFullPath);
			oldFile.delete();
			File newFile = new File(tmpFileFullPath);
			newFile.renameTo(oldFile);
			
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}
        
		return res;
	}
	
	public static void main(String args[]) {
		BRDBConnector test = new BRDBConnector("userDB");
		String testLine = "lei:lei@here.com:FOO:group1,	";
		boolean res = test.BRDBWrite(testLine, "lei@here.com", 1);
		
		String res1 = test.BRDBRead("lei@here.com", 1);
		//System.out.println(res1);
	}
	
}
