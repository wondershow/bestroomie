package bestroomie.entities;

import java.util.ArrayList;
import java.util.Iterator;

import bestroomie.db.BRDBConnector;

/**
 * Precondition
 * Postcondition
 ***/
public class BRUser extends BRAbstractEntity{
	
	// which row in the file stores the identifier
	private static final int ROW_OF_NAME = 0;
	private static final int ROW_OF_ID = 1;
	private static final int ROW_OF_PASSWORD = 2;
	private static final int ROW_OF_GROUP = 3;
	
	private static final String firstLine = 
			"Name" + BRAbstractEntity.FIELD_SEPERATOR 
			+ "Email" + BRAbstractEntity.FIELD_SEPERATOR 
			+ "Password" + BRAbstractEntity.FIELD_SEPERATOR + "Group";
	
	
	
	
	private String userName = "";
	private String userEmail = "";
	private String userGroup = "";
	//the correct password
	private String userPass = "";
	//the password used for verify an unlogged in user
	private String userInputPass = "";

	
	
	/****/
	public BRUser(String fName, String uEmail, String uPass) {
		this.fileName = fName;
		this.userEmail = uEmail;
		this.userPass = uPass;
	}


	@Override
	public String serilize() {
		// TODO Auto-generated method stub
		String res = this.userName + super.FIELD_SEPERATOR 
					 + this.userEmail +  super.FIELD_SEPERATOR
					 + this.userPass + super.FIELD_SEPERATOR 
					 + this.userGroup;
		return res;
	}

	
	@Override
	public boolean loadEntity(String s) {
		// TODO Auto-generated method stub
		String tmpStr[] = s.split(BRAbstractEntity.FIELD_SEPERATOR);
		this.userName = tmpStr[0];
		this.userEmail = tmpStr[1];
		this.userPass = tmpStr[2];
		this.userGroup = tmpStr[3];
		return true;
	}
	
	@Override
	public boolean saveToDB() {
		// TODO Auto-generated method stub
		BRDBConnector dbConn = new BRDBConnector(this.fileName,super.FIELD_SEPERATOR);
		String lineStr = this.serilize();
		boolean res = dbConn.BRDBWrite(lineStr, this.userEmail, BRUser.ROW_OF_ID);
		
		return res;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserInputPass() {
		return userInputPass;
	}

	public void setUserInputPass(String userInputPass) {
		this.userInputPass = userInputPass;
	}
		
	public static void main(String args) {
		
	}

	//to reset all the fields
	public void reset() {
		this.userEmail = "";
		this.userGroup = "";
		this.userInputPass = "";
		this.userName = "";
		this.userPass = "";
	}

	@Override
	public boolean load() {
		// TODO Auto-generated method stub
		BRDBConnector dbConn = new BRDBConnector(this.fileName,super.FIELD_SEPERATOR);
		String line = dbConn.BRDBRead(this.userEmail, ROW_OF_ID);
		if (line == null) // not matching record found
			return false;
		else {
			String strArr[] = line.split(super.FIELD_SEPERATOR);
			this.setUserGroup(strArr[ROW_OF_GROUP]);
			this.setUserName(strArr[ROW_OF_NAME]);
			this.setUserPass(strArr[ROW_OF_PASSWORD]);
			return true;
		}
	}
}
