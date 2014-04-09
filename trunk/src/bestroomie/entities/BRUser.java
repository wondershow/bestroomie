package bestroomie.entities;

import java.util.ArrayList;
import java.util.Iterator;

import bestroomie.db.BRDBConnector;
import bestroomie.util.BRConst;

/**
 * Precondition
 * Postcondition
 ***/
public class BRUser extends BRAbstractEntity{
	
	/**
	 * headline of dbfile
	 * */
	private static final String firstLine = 
			"Name" + BRConst.DBFile.FIELD_SEPERATOR 
			+ "Email" + BRConst.DBFile.FIELD_SEPERATOR 
			+ "Password" + BRConst.DBFile.FIELD_SEPERATOR + "Group";
	
	
	
	
	private String userName = "";
	private String userEmail = "";
	private String userGroup = "";
	//the correct password
	private String userPass = "";
	//the password used for verify an unlogged in user
	private String userInputPass = "";

	
	public BRUser() {
		this.dbFileName = BRConst.DBFile.FILE_NAME_USERDB;
	}
	
	
	/****/
	public BRUser(String uEmail, String uPass) {
		this.dbFileName = BRConst.DBFile.FILE_NAME_USERDB;
		this.userEmail = uEmail;
		this.userPass = uPass;
	}


	@Override
	public String serilize() {
		// TODO Auto-generated method stub
		String res = this.userName + BRConst.DBFile.FIELD_SEPERATOR 
					 + this.userEmail +  BRConst.DBFile.FIELD_SEPERATOR 
					 + this.userPass + BRConst.DBFile.FIELD_SEPERATOR  
					 + this.userGroup;
		return res;
	}

	
	@Override
	public boolean loadEntity(String s) {
		// TODO Auto-generated method stub
		String tmpStr[] = s.split(BRConst.DBFile.FIELD_SEPERATOR);
		this.userName = tmpStr[0];
		this.userEmail = tmpStr[1];
		this.userPass = tmpStr[2];
		this.userGroup = tmpStr[3];
		return true;
	}
	
	@Override
	public boolean saveToDB() {
		// TODO Auto-generated method stub
		BRDBConnector dbConn = new BRDBConnector(this.dbFileName);
		String lineStr = this.serilize();
		boolean res = dbConn.BRDBWrite(lineStr, this.userEmail, BRConst.DBUserFile.ROW_OF_USER_EMAIL);
		
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
	
	/**
	 * This function returns how many members in a given group
	 * @param grpId the group id
	 * **/
	public int getGroupSize(String grpId) {
		int res = 0;
		BRDBConnector dbConn = new BRDBConnector(BRConst.DBFile.FILE_NAME_GROUPDB);
		String line = dbConn.BRDBRead(grpId, BRConst.DBGroupFile.COLUMN_OF_GROUP_ID);
		if (line == null) // not matching record found
			res = -1;
		else {
			String strArr[] = line.split(BRConst.DBFile.FIELD_SEPERATOR );
			String tmpStr = strArr[BRConst.DBGroupFile.COLUMN_OF_GROUP_MEMBER];
			res = tmpStr.split(BRConst.DBFile.GROUP_SEPERATOR).length;
		}
		return res;
	}
	
	
	/**
	 * To return the first group that this user belongs to
	 * **/
	public String getFirstGrpId(){
		String tmp[] = this.userGroup.split(BRConst.DBFile.GROUP_SEPERATOR);
		if(tmp != null && tmp.length>=1)
			return tmp[0];
		else
			return null;
		
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
		BRDBConnector dbConn = new BRDBConnector(BRConst.DBFile.FILE_NAME_USERDB);
		String line = dbConn.BRDBRead(this.userEmail, BRConst.DBUserFile.ROW_OF_USER_EMAIL);
		if (line == null) // not matching record found
			return false;
		else {
			String strArr[] = line.split(BRConst.DBFile.FIELD_SEPERATOR );
			this.setUserGroup(strArr[BRConst.DBUserFile.ROW_OF_USER_GROUP]);
			this.setUserName(strArr[BRConst.DBUserFile.ROW_OF_USER_NAME]);
			this.setUserPass(strArr[BRConst.DBUserFile.ROW_OF_USER_PASS]);
			return true;
		}
	}
}
