package bestroomie.gui;
import java.util.ArrayList;

import bestroomie.entities.*;

/**
 * After a user successfully logged in, he can choose the Transaction Management 
 * Tab. This GUI maily handles add/delete/display of transactions related to 
 * that user. It will update database correspondingly. 
 * 

 * Invariants: 
 *       User is in log in status
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
	public void showTransactions(ArrayList<BRGroup> list) {
		
		
	}
	
	/***
	 * PreCondition: The user clicked on the "Edit new transaction button"
	 * PostCondition: The user fill in the transactions details, such as 
	 * 				  bill undertakers, amounts, ..... These information 
	 * 				  will be added to the database. 
	 * 
	 * **/
	public void addTransaction(BRBill bill) {
		
		
	}
	
	/***
	 * PreCondition: The user clicked on the "Edit new transaction button", 
	 * 				 The user is the owner of that group
	 * PostCondition: If the bill is tagged as settled(all involvers have cleared 
	 * 				  debts on this bill), this trans will be delted from the 
	 * 				  database, otherwise return an "Deletion Failure" message.
	 * 
	 * **/
	public void deleteTransaction(BRBill bill) {
		
		
	}
}
