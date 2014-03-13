package bestroomie.gui;

import bestroomie.entities.BRBill;


/***
 * The user is logged in and the GUI displays the transactions/bills
 * in which he/she is involved.If the user approved/confirmed the transaction, this class will check if all 
 * the related users have approved the transaction, if it is approved by everyone,
 * the status of the bill in the database will changed. 
 * 
 * Invariants: 
 *       -User is in log in status
 *       -There are transactions this user has not reviewed yet
 * **/
public class TransHandlerBG {
	
	
	/**
	 * @param transaction/bill needs to reviewed. 
	 * 
	 * */
	public TransHandlerBG() {
		
		
	}
	
	/***
	 * @Precondition: The user selected a specific trsaction to handle 
	 * @Postcondition: The user clicked the approve button and the database
	 * 				   will be updated if all the involved users approved this bill,
	 *                 otherwise nothing will be done.
	 * **/
	public void approveTransaction(BRBill id) {
		
	}
	
	/**
	 * @Precondition: The user selected a specific trsaction to handle 
	 * @Postconditoin: The user clicked the reject button and a rebuttal
	 * 				   notification will be sented to the creator
	 * **/
	public void rejectTransaction(BRBill id) {
		
		
	}
}
