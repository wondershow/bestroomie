package bestroomie.entities;

import bestroomie.db.BRDBConnector;
import bestroomie.util.BRConst;

public class BRChore extends BRAbstractEntity{

	private String choreGroup = "";
	private String choreDescription = "";
	private String choreDate = "";
	private String choreAssignment = "";
	private String choreCompletion = "";
	
	/**
	 * headline of dbfile
	 * */
	private static final String firstLine = 
			"Group" + BRConst.DBFile.FIELD_SEPERATOR 
			+ "choreDescription" + BRConst.DBFile.FIELD_SEPERATOR 
			+ "Date" + BRConst.DBFile.FIELD_SEPERATOR
			+ "Assignment" + BRConst.DBFile.FIELD_SEPERATOR
			+ "Comletion";
	
		
	public String getChoreGroup() {
		return choreGroup;
	}

	public void setChoreGroup(String choreGroup) {
		this.choreGroup = choreGroup;
	}

	public String getChoreDescription() {
		return choreDescription;
	}

	public void setChoreDescription(String choreDescription) {
		this.choreDescription = choreDescription;
	}

	public String getChoreDate() {
		return choreDate;
	}

	public void setChoreDate(String choreDate) {
		this.choreDate = choreDate;
	}

	public String getChoreAssignment() {
		return choreAssignment;
	}

	public void setChoreAssignment(String choreAssignment) {
		this.choreAssignment = choreAssignment;
	}

	public String getChoreCompletion() {
		return choreCompletion;
	}

	public void setChoreCompletion(String choreCompletion) {
		this.choreCompletion = choreCompletion;
	}

	public BRChore(){
		
	}
	
	
	@Override
	public String serilize() {
		// TODO Auto-generated method stub
		String res = this.choreGroup + BRConst.DBFile.FIELD_SEPERATOR 
					 + this.choreDescription +  BRConst.DBFile.FIELD_SEPERATOR 
					 + this.choreDate + BRConst.DBFile.FIELD_SEPERATOR  
					 + this.choreAssignment  + BRConst.DBFile.FIELD_SEPERATOR 
					 + this.choreCompletion ;
		return res;
	}
	
	
	@Override
	public boolean loadEntity(String s) {
		// TODO Auto-generated method stub
		String tmpStr[] = s.split(BRConst.DBFile.FIELD_SEPERATOR);
		this.choreGroup = tmpStr[bestroomie.util.BRConst.DBChoreFile.COLUMN_OF_GROUP];
		this.choreDescription = tmpStr[bestroomie.util.BRConst.DBChoreFile.COLUMN_OF_DESCRIPTION];
		this.choreDate = tmpStr[bestroomie.util.BRConst.DBChoreFile.COLUMN_OF_DATE];
		this.choreAssignment = tmpStr[bestroomie.util.BRConst.DBChoreFile.COLUMN_OF_ASSIGNMENT];
		this.choreCompletion = tmpStr[bestroomie.util.BRConst.DBChoreFile.COLUMN_OF_COMPLETION];
		return true;
	}
	
	//to reset all the fields
	public void reset() {
		this.choreGroup = "";
		this.choreDescription = "";
		this.choreDate = "";
		this.choreAssignment = "";
		this.choreCompletion = "";
	}
	
	@Override
	public boolean load() {
		// TODO Auto-generated method stub
		BRDBConnector dbConn = new BRDBConnector(BRConst.DBFile.FILE_NAME_CHORESDB);
		String line = dbConn.BRDBRead(this.choreGroup, BRConst.DBChoreFile.COLUMN_OF_GROUP);
		if (line == null) // not matching record found
			return false;
		else {
			String strArr[] = line.split(BRConst.DBFile.FIELD_SEPERATOR );
			this.setChoreGroup(strArr[BRConst.DBChoreFile.COLUMN_OF_GROUP]);
			this.setChoreDescription(strArr[BRConst.DBChoreFile.COLUMN_OF_DESCRIPTION]);
			this.setChoreDate(strArr[BRConst.DBChoreFile.COLUMN_OF_DATE]);
			this.setChoreAssignment(strArr[BRConst.DBChoreFile.COLUMN_OF_ASSIGNMENT]);
			this.setChoreCompletion(strArr[BRConst.DBChoreFile.COLUMN_OF_COMPLETION]);
			return true;
		}
	}
	
	@Override
	public boolean saveToDB() {
		// TODO Auto-generated method stub
		BRDBConnector dbConn = new BRDBConnector(this.dbFileName);
		String lineStr = this.serilize();
		boolean res = dbConn.BRDBWrite(lineStr, this.choreGroup, BRConst.DBUserFile.ROW_OF_USER_EMAIL);
		
		return res;
	}
	
}
