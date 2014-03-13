package bestroomie.gui;
/**
 * This is a background class. A User successfully add a transaction/bill, specifying the 
 * total amount, members to share, group, ways to share. All the related bill sharing users will receive an email specifying
 * the transaction details and asking him/her to approve this transaction.
 * 		
 * Invariants: 
 *       -User is in log in status		
 * **/
public class EmailNotifierBG {
	
	/**
	 * 
	 * @param Transaction Object
	 * **/
	public EmailNotifierBG() {
		
		
	}

	/***
	 * @Precondition: An transaction is created by an user.
	 * 
	 * @Postcondition: Extract all the information from that transaction and 
	 *                 create an email text and send this email to all the 
	 *                 receipts. 
	 * 				 
	 * **/
	public void sendEmailNotify() {
		
		
	}
}
