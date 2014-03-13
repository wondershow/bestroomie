/**
 * BRChore provides a GUI interface and functional methods to handle the assignment,
 * completion verification, tracking, and reporting of group chores.
 * 
 * BRChore will initially have a blank text box, showing no chores.  BRChore will not interact with the database to provide content to the GUI or to make updates
 * until the user selects one of its buttons, which causes the program to show all chores, update
 * a chore as completed, or add a chore to the group.
 * 
 * Invariants:
 * There will always be a group selected
 *     @invariant group != Null
 * There will always be a user logged on
 *     @invariant user != Null    
 */

public class BRChore extends JFrame implements ActionListener {
	
	/**
	 * Constructor: Creates new form BRChore GUI
	 */
	public BRChore() {...}
	
	/**
	 * This operation is called from within the constructor to initialize the form
	 */
	private void initComponents(){...}
	
	/**
	 * This operation listens for button clicks in order to provide the appropriate actions
	 */
	public void actionperformed(ActionEvent e){
		
		/**
		 * This operation searches ChoresDB for all current chores for a selected group.
		 * The chores identified are displayed on the GUI
		 * 
		 * @pre group != Null
		 * @post BRChore text box is populated with all chores for a selected group
		 */
		if (e.getSource() = showChores){...}
		
		/**
		 * This operation will identify the chore that is checked and change the completion status 
		 * in ChoresDB for the selected chore and selected group to equal "completed"
		 * 
		 * @pre group != Null && chore != Null  && chore status = "not completed"
		 * @post chore status = "completed"
		 */
		if (e.getSource() = checkCompleted){...}
		
		/**
		 * This operation adds a chore and its frequency to ChoresDB for a selected group
		 * 
		 * @pre group != Null && chore != Null  && frequency != Null
		 * @post ChoresDB is updated with the given chore and frequency for the selected group
		 */
		if (e.getSource() = addChore){...}
	}
	
	/**
	 * This operation displays the output derived from showChores
	 */
	public void setDisplay(String s){...}
	
	/**
	 * This operation gets the chore name from the user input
	 * @pre group != Null
	 * @post chore != Null
	 */
	public String getChore(){...}
	
	/**
	 * This operation displays the output derived from showChores
	 * @pre group != Null
	 * @post frequency != Null
	 * 	 */
	public String getFrequency(){...}

	
}