/**
 * BRWriteDatabase will open a new database file, copy the contents of the array into it, and 
 * replace the old database file with the newly created file
 *   
 * Invariants:
 * There will always be a group selected
 *     @invariant group != Null
 * There will always be a user logged on
 *     @invariant user != Null
 * There will always be a fileName selected
 *     @invariant fineName != Null    
 */
public class BRWriteDatabase {

	/**
	 * BRWriteDatabase will open a new database file, copy the contents of the array into it, and 
	 * replace the old database file with the newly created file 
	 * 
	 * @pre fileName != Null
	 * @post DBArray.length() > 0
	 */
	public void readDatabase(String fileName) {...}
	
	/**
	 * This takes the multi-dimensional array and serializes it into the database format
	 * 
	 * @pre DBArray.length() > 0
	 * @post DBLine != Null
	 */
	public static String serializeArray (Array[][] DBArray){...}	
	
}