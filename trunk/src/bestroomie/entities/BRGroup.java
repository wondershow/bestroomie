package bestroomie.entities;

import java.util.ArrayList;

import bestroomie.db.BRDBConnector;
import bestroomie.util.BRConst;

public class BRGroup extends BRAbstractEntity{
	
	private String gpId;
	private ArrayList<String> gMembers;
	
	
	public BRGroup (String gid) {
		this.gpId = gid;
		gMembers = new ArrayList<String>();
		
	}
	
	public String getGroupId() {
		return this.gpId;
	}
	
	
	public void setGroupId(String id) {
		this.gpId = id;
	}
	
	public void setGroupMember(String s) {
		String tmp[] = s.split(",");
		for(int i=0;i<tmp.length;i++) {
			gMembers.add(tmp[i]);
		}
	}
	
	public ArrayList<String> getGroupMember() {
		return gMembers;
	}
	
	/***
	 * 
	 * Return all the group numbers EXCEPT the user specified by userId
	 * **/
	public ArrayList<BRUser> getGroupMemberObjs(String userId) {
		ArrayList<BRUser> res = new ArrayList<BRUser>();
		for(int i=0;i<gMembers.size();i++){
			BRUser u = new BRUser();
			if(!gMembers.get(i).equals(userId)){
				u.setUserEmail(gMembers.get(i));
				u.load();
				res.add(u);
			}
		}
		return res;
	}
	

	@Override
	protected String serilize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean loadEntity(String s) {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveToDB() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean load() {
		// TODO Auto-generated method stub
		BRDBConnector dbConn = new BRDBConnector(BRConst.DBFile.FILE_NAME_GROUPDB);
		String line = dbConn.BRDBRead(this.gpId, BRConst.DBGroupFile.COLUMN_OF_GROUP_ID);
		if (line == null) // not matching record found
			return false;
		else {
			String strArr[] = line.split(BRConst.DBFile.FIELD_SEPERATOR );
			this.setGroupId(strArr[BRConst.DBGroupFile.COLUMN_OF_GROUP_ID]);
			this.setGroupMember(strArr[BRConst.DBGroupFile.COLUMN_OF_GROUP_MEMBER]);
			
			return true;
		}
	}

	
	
	
}
