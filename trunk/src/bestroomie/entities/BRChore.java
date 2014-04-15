package bestroomie.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import bestroomie.db.BRDBConnector;
import bestroomie.util.BRConst;
import bestroomie.util.CATAGORY_INDEX;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
		return this.choreGroup;
	}

	public void setChoreGroup(String choreGroup) {
		this.choreGroup = choreGroup;
	}

	public String getChoreDescription() {
		return this.choreDescription;
	}

	public void setChoreDescription(String choreDescription) {
		this.choreDescription = choreDescription;
	}

	public String getChoreDate() {
		return this.choreDate;
	}

	public void setChoreDate(String choreDate) {
		this.choreDate = choreDate;
	}

	public String getChoreAssignment() {
		return this.choreAssignment;
	}

	public void setChoreAssignment(String choreAssignment) {
		this.choreAssignment = choreAssignment;
	}

	public String getChoreCompletion() {
		return this.choreCompletion;
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
	
	public static ArrayList<BRChore> getOldChoresInGrp(String group) throws ParseException {
		
		//Set the current Date
	 	Calendar cal = Calendar.getInstance();
	 	cal.add(Calendar.DATE, 0);
	 	   
		ArrayList<BRChore> oldres = new ArrayList<BRChore>();
		BRDBConnector dbConn = new BRDBConnector(BRConst.DBFile.FILE_NAME_CHORESDB);
		
		ArrayList<String> lines = dbConn.getAllMatchedRecords(group, BRConst.DBChoreFile.COLUMN_OF_GROUP);
		for(int i=0;i<lines.size();i++){
			BRChore oldchore = new BRChore();
			String line = lines.get(i);
			
			String strArr[] = line.split(BRConst.DBFile.FIELD_SEPERATOR );
			
			//Parse a date from the database
		 	DateFormat df = new SimpleDateFormat("yyyyMMdd");
		 	String lineDate = strArr[BRConst.DBChoreFile.COLUMN_OF_DATE];
		 	Date someDate =   df.parse(lineDate);
		 		   
		 	oldchore.setChoreGroup(strArr[BRConst.DBChoreFile.COLUMN_OF_GROUP]);
		 	oldchore.setChoreDescription(strArr[BRConst.DBChoreFile.COLUMN_OF_DESCRIPTION]);
		 	oldchore.setChoreDate(strArr[BRConst.DBChoreFile.COLUMN_OF_DATE]);
		 	oldchore.setChoreAssignment(strArr[BRConst.DBChoreFile.COLUMN_OF_ASSIGNMENT]);
		 	oldchore.setChoreCompletion(strArr[BRConst.DBChoreFile.COLUMN_OF_COMPLETION]);
		 	   
		 	//If the date is in the future, skip to the next item
		 	if (someDate.compareTo(cal.getTime()) != 1 )
		 		oldres.add(oldchore);
		}
		return oldres;
	} 

	public static ArrayList<BRChore> getFutureChoresInGrp(String group) throws ParseException {
		
		//Set the current Date
	 	Calendar cal = Calendar.getInstance();
	 	cal.add(Calendar.DATE, 0);
	 
		ArrayList<BRChore> futureres = new ArrayList<BRChore>();
		BRDBConnector dbConn = new BRDBConnector(BRConst.DBFile.FILE_NAME_CHORESDB);
		System.out.println("Chores DB: " + BRConst.DBFile.FILE_NAME_CHORESDB);
		
		ArrayList<String> lines = dbConn.getAllMatchedRecords(group, BRConst.DBChoreFile.COLUMN_OF_GROUP);
		System.out.println("lines: " + lines.size());
		for(int i=0;i<lines.size();i++){
			BRChore futurechore = new BRChore();
			String line = lines.get(i);
			System.out.println("Chores line: " + line);
			
			String strArr[] = line.split(BRConst.DBFile.FIELD_SEPERATOR );

			//Parse a date from the database
		 	DateFormat df = new SimpleDateFormat("yyyyMMdd");
		 	String lineDate = strArr[BRConst.DBChoreFile.COLUMN_OF_DATE];
		 	System.out.println(lineDate);
		 	Date someDate =   df.parse(lineDate);
			
		 	futurechore.setChoreGroup(strArr[BRConst.DBChoreFile.COLUMN_OF_GROUP]);
		 	futurechore.setChoreDescription(strArr[BRConst.DBChoreFile.COLUMN_OF_DESCRIPTION]);
		 	futurechore.setChoreDate(strArr[BRConst.DBChoreFile.COLUMN_OF_DATE]);
		 	futurechore.setChoreAssignment(strArr[BRConst.DBChoreFile.COLUMN_OF_ASSIGNMENT]);
		 	futurechore.setChoreCompletion(strArr[BRConst.DBChoreFile.COLUMN_OF_COMPLETION]);

		 	//If the date is in future, add it
		 	if (someDate.compareTo(cal.getTime()) == 1 )
		 		futureres.add(futurechore);
 	}
		return futureres;
	} 
	
}
