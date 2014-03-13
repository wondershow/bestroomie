package bestroomie.gui;
import java.util.ArrayList;

import bestroomie.entities.*;

/**
 * PreCondition: When a user successfully logs in and if has a bill to share with 
 * 				 other group members, he then chooses to add a transaction. 
 * 
 * PostCondition: The GUI will display a "Transaction added" message for the user and
 * 				 all the bill sharers will be sent an email asking to confirm this bill.
 * 				  meanwhile, a transaction record will be added to the database and the record
 * 				will be tagged as Unsettled.
 * @author aniu-lei
 * **/
public class TransManageGUI {
	
	BRUser transManager;
	ArrayList<BRGroup> groupList;
	
	/**
	 * PreCondition: When a user successfully logs in and 
	 * @param user(user id)
	 * @return TransManageGUI
	 * **/
	public TransManageGUI() {
		
		
	}
	
	/**
	 * PreCondition: The user entered the transaction management UI. 
	 * 
	 * PostCondition: The user approves an existing trans or the user add a new trans
	 * **/
	public void showTransactions() {
		
		
	}
	
	/***
	 * PreCondition: The user clicked on the "Edit new transaction button"
	 * PostCondition: The user fill in the transactions details, such as 
	 * 				  bill undertakers, amounts, ..... These information 
	 * 				  will be added to the database. 
	 * 
	 * **/
	public void addTransaction() {
		
		
	}
	
}
