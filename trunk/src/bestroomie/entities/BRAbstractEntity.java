package bestroomie.entities;

public abstract class BRAbstractEntity {
	protected String dbFileName;

	//To convert the model to a sring/line, that can be put into the file
	protected abstract String serilize();
	
	//TBD
	protected abstract boolean loadEntity(String s);
	
	//save this model to the database
	protected abstract boolean saveToDB();
	
	//To load a model from the database, the keyword of that model needs to be specified first
	public abstract boolean load();
 }
