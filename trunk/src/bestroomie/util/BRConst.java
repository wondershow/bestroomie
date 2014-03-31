package bestroomie.util;

/**
 * We keep all the project wide variables here, such as 
 * the file name of databases, the field seperator
 * **/
public final class BRConst {
	
	private BRConst() {}
	
	public static final String CAPTCHA_FILE_PATH = "brfolder/capfile.jpg";
	public static final int CAPTCHA_IMG_WIDTH = 120;
	public static final int CAPTCHA_IMG_HEIGHT = 30;
	
	
	public static final class GUISettings {
		
		public static final int MAIN_GUI_WIDTH = 800;
		public static final int MAIN_GUI_HEIGH = 500;
		public static final String MAIN_GUI_TITTLE = "BestRoomie";
		
		
	}
	
	public static final class DBMessages {
		public static final String ERROR_VALIDATION_FAILURE = "The user name and password dont match";
		public static final String ERROR_REG_FAILURE_USER_EXISTS = "The input email already exists in the system";
		public static final String ERROR_USER_DOES_NOT_EXIST = "The email address does not exist in the system";
		public static final String ERROR_INVALID_EMAIL = "The input email is invalid";
		public static final String ERROR_WRONG_CAPTCHA = "Please input correct captcha";
		public static final String ERROR_PASSWORDS_DO_NOT_MATCH = "Passwords do not match";
		public static final String ERROR_NO_NAME = "Name can not be blank";
		public static final String ERROR_NO_PASSWORD = "Password can not be blank";
		public static final String ERROR_USER_ALREADY_EXISTS = "A user with that email already exists";
		public static final String USER_ADDED = "You were successfully registered!  Welcome!";
		public static final String PASSWORD_CHANGED = "Your password was successfully changed";
	}
	
	public static final class DBFile {
		private DBFile(){}
		public static final String FILE_NAME_USERDB = "UserDB";
		public static final String FILE_NAME_CHORESDB = "ChoresDB";
		public static final String FILE_NAME_GROUPDB = "GroupDB";
		public static final String FILE_NAME_TRANSDB = "TransactionDB";
		public static final String PATH_TO_DB_FOLDER = "brfolder/dbfolder/";
		public static final String FIELD_SEPERATOR = ":";
		public static final String GROUP_SEPERATOR = ",";
	}
	
	/**
	 * Definition of db file (user db)
	 * **/
	public static final class DBUserFile{
		private DBUserFile(){}
		public static final int TOTAL_NUM_OF_ROWS = 4;
		
		//first row, user name(row number is 0)
		public static final int ROW_OF_USER_NAME = 0;
		public static final String ROW_0_FILED_NAME = "Name";
		
		//email row
		public static final int ROW_OF_USER_EMAIL = 1;
		public static final String ROW_1_FIELD_NAME = "Email";
		
		public static final int ROW_OF_USER_PASS = 2;
		public static final String ROW_2_FIELD_NAME = "Password";
		
		public static final int ROW_OF_USER_GROUP = 3;
		public static final String ROW_3_FIELD_NAME = "Group";
	}
	
	
}
