/**
 * BRReadDatabase will read the specified database file into a multi-dimensional array in order to 
 * be used by the function calling this class.
 * 
 * Invariants:
 * There will always be a group selected
 *     @invariant group != Null
 * There will always be a user logged on
 *     @invariant user != Null
 * There will always be a fileName selected
 *     @invariant fineName != Null    
 */
public class BRReadDatabase {

	/**
	 * This operation opens and reads the database file into a multi-dimensional array
	 * 
	 * @pre fileName != Null
	 * @post DBArray.length() > 0
	 */
	public void readDatabase(String fileName) {...}
	
	/**
	 * This takes a single line of the database, parses, and returns the desired item number from it.
	 * If your database is split up into 3 attributes (user name, email, group) item number 3 is "group"
	 * 
	 * @pre line != Null && (totalItems <= itemNumber > 0)
	 * @post getItem != Null
	 */
	public String getItem (String line, int itemNumber){...}	
	
}