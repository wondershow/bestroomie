package bestroomie.entities;

import java.util.ArrayList;

import bestroomie.db.BRDBConnector;
import bestroomie.util.BRConst;
import bestroomie.util.CATAGORY_INDEX;

public class BRBill extends BRAbstractEntity{
	
	/**
	 * 
	 * transactionID:group:title:date:assignment:amount:approval:paid:total
	 * transactionID : group: catagory : date: payer: amount : approval : paid : description : total_amount
	   a@b.com201404132.31pm:group1:Beer:20140413:user1,user2:23.30,45.20:yes,yes:no,no
	 * 
	 * 
	 * **/
	/**
	transactionID : group: catagory : date: payers: allocated_amount : payers_approval : payers_if_paid : description : total_amount
	 * */
	private String transId;
	private String createrUser;
	private String group;
	private CATAGORY_INDEX catagory; 
	private String date;
	private String[] payerList;
	private float[] amountList; 
	private boolean[] approvalList;
	private boolean[] paidList;
	private String description;
	private float total_amount;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		String tmp[] = transId.split(BRConst.DBTransFile.ID_CONNECTOR);
		this.createrUser = tmp[0];
		this.transId = transId;
	}
	
	public String getCreator() {
		
		return this.createrUser;
	}
	

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String[] getPayerList() {
		return payerList;
	}
	
	public String getPayerListAsStr() {
		String res = payerList[0];
		if(payerList.length>1) {
			for(int i=1;i<payerList.length;i++)
				res += "," + payerList[i];
		}
		return res;
	}
	

	public void setPayerList(String payer) {
		this.payerList = payer.split(BRConst.DBFile.SUBFIELD_SEPERATOR);
	}

	public float[] getAmntList() {
		return amountList;
	}

	public void setAmntList(String s) {
		String tmp[] = s.split(BRConst.DBFile.SUBFIELD_SEPERATOR);
		this.amountList = new float[tmp.length];
		for(int i=0;i<tmp.length;i++)
			this.amountList[i] = Float.parseFloat(tmp[i]);
	}
	
	public String getAmntAsStr() {
		String res = String.valueOf(amountList[0]);
		if(amountList.length>1) {
			for(int i=1;i<amountList.length;i++)
				res += "," + amountList[i];
		}
		return res;
	}

	public boolean[] getApprovalList() {
		return approvalList;
	}

	public void setApprovalList(String s) {
		String tmp[] = s.split(BRConst.DBFile.SUBFIELD_SEPERATOR);
		this.approvalList = new boolean[tmp.length];
		for(int i=0;i<tmp.length;i++) {
			if(tmp[i].equals("no"))
				this.approvalList[i] = false;
			else
				this.approvalList[i] = true;
		} 
	}
	
	public String getApprovalAsStr() {
		String res = ""; 
		if(approvalList[0])
			res = "yes";
		else
			res = "no";
		if(approvalList.length>1) {
			for(int i=1;i<approvalList.length;i++)
				if(approvalList[i])
					res += "," + "yes";
				else
					res += "," + "no";
		}
		return res;
	}

	public boolean[] getPaidList() {
		return this.paidList;
	}

	public void setPaidList(String s) {
		String tmp[] = s.split(BRConst.DBFile.SUBFIELD_SEPERATOR);
		this.paidList = new boolean[tmp.length];
		for(int i=0;i<tmp.length;i++) {
			if(tmp[i].equals("no"))
				this.paidList[i] = false;
			else
				this.paidList[i] = true;
		}
	}
	
	public String getPaidAsStr() {
		String res = ""; 
		if(paidList[0])
			res = "yes";
		else
			res = "no";
		if(paidList.length>1) {
			for(int i=1;i<paidList.length;i++)
				if(paidList[i])
					res += "," + "yes";
				else
					res += "," + "no";
		}
		return res;
	}

	public CATAGORY_INDEX getCatagory() {
		return catagory;
	}

	public void setCatagory(CATAGORY_INDEX catagory) {
		this.catagory = catagory;
	}
	
	@Override
	protected String serilize() {
		String res = "";
		/**
		 * transactionID : group: catagory : date: payer_list: allocated_amount : payers_approval : payers_if_paid : description : total_amount
			a@b.com_201404132.31pm:group1:2:20140413:user1,user2:23.30,45.20:yes,yes:no,no: asdf : 68.50
		 * 
		 * **/
		res += this.transId + BRConst.DBFile.FIELD_SEPERATOR;
		res += this.group + BRConst.DBFile.FIELD_SEPERATOR;
		res += String.valueOf(CATAGORY_INDEX.toInt(this.catagory)) + BRConst.DBFile.FIELD_SEPERATOR;
		res += this.getDate() + BRConst.DBFile.FIELD_SEPERATOR;
		res += this.getPayerListAsStr() + BRConst.DBFile.FIELD_SEPERATOR;
		res += this.getAmntAsStr() + BRConst.DBFile.FIELD_SEPERATOR;
		res += this.getApprovalAsStr() + BRConst.DBFile.FIELD_SEPERATOR;
		res += this.getPaidAsStr() + BRConst.DBFile.FIELD_SEPERATOR;
		res += this.getDescription()+ BRConst.DBFile.FIELD_SEPERATOR;
		res += String.valueOf(this.getTotal_amount());
		
		return res;
	}

	@Override
	protected boolean loadEntity(String s) {
		return false;
	}

	@Override
	public boolean saveToDB() {
		BRDBConnector dbConn = new BRDBConnector(BRConst.DBFile.FILE_NAME_TRANSDB);
		String lineStr = this.serilize();
		boolean res = dbConn.BRDBWrite(lineStr, this.getTransId(), BRConst.DBTransFile.COLUMN_NUM_OF_TRANSID);
		return res;
	}

	/**
	 * To split the string from database,
	 * put all the corresponding fields into group object
	 * **/
	private void loadGroup(String line) {
		String strArr[] = line.split(BRConst.DBFile.FIELD_SEPERATOR );
		//this.setTransId(line);
		this.setTransId(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_TRANSID]);
		this.setGroup(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_GROUPID]);
		//this.setAllocation(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_AMOUNT]);
		int tmpInt = Integer.parseInt(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_CATAGORYID]);
		this.setCatagory(CATAGORY_INDEX.fromInteger(tmpInt) );
		this.setDate(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_DATE]);
		this.setPayerList(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_PAYERID]);
		this.setAmntList(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_AMOUNT]);
		this.setApprovalList(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_APPROVAL]);
		this.setPaidList(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_PAID]);
		this.setDescription(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_DESCTIPTION]);
		this.setTotal_amount(Float.parseFloat(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_TOTAL].trim()));
	}
	
	
	
	
	@Override
	public boolean load() {
		BRDBConnector dbConn = new BRDBConnector(BRConst.DBFile.FILE_NAME_TRANSDB);
		String line = dbConn.BRDBRead(this.transId, BRConst.DBTransFile.COLUMN_OF_TABLE_KEY);
		
//		System.out.println(line);
		
		if (line == null) // not matching record found
			return false;
		else {
			this.loadGroup(line);
			return true;
		}
		// TODO Auto-generated method stub
	}
	
	
	
	
	public static void main(String s[]) {
//		BRBill b = new BRBill();
//		b.setTransId("lei@here.com201404111937");
//		b.load();
//		System.out.println(b.getDate());
		ArrayList<BRBill> list = BRBill.getAllSettledBillInGrp("group1", "lei@here.com");
		ArrayList<BRBill> list1 = BRBill.getAllImpendingBillInGrp("group1", "lei@here.com");
		//System.out.println("List1 size is " + list1.size());
		list.get(0).approve("matt@here.com");
		System.out.println(list.get(0).serilize());
		list.get(0).saveToDB();
		
	}
	
	
	/***
	 * Get all the settled transactions that in the group(specified by groupid), 
	 * the user has approved or he started
	 * @group the group id
	 * @user the user id
	 * ***/
	public static ArrayList<BRBill> getAllSettledBillInGrp(String group, String usrId) {
		ArrayList<BRBill> res = new ArrayList<BRBill>();
		BRDBConnector dbConn = new BRDBConnector(BRConst.DBFile.FILE_NAME_TRANSDB);
		ArrayList<String> lines = dbConn.getAllMatchedRecords(group, BRConst.DBTransFile.COLUMN_NUM_OF_GROUPID);
		for(int i=0;i<lines.size();i++){
			BRBill bill = new BRBill();
			String line = lines.get(i);
			
			bill.loadGroup(line);
			
			String tmpPayerList[] = bill.getPayerList();
			boolean tmpIfAppriedList[] = bill.getApprovalList() ;
			
			if(bill.getCreator().equals(usrId))
				res.add(bill);
			else {
				for(int j=0;j<tmpPayerList.length;j++) {
					if(tmpPayerList[j].equals(usrId) && tmpIfAppriedList[j]) {
						res.add(bill);
						break;
					}
				}
			}
		}
		return res;
	}
	
	/***
	 * Get all the impending transactions that in the group(specified by groupid), 
	 * the user has approved or he started
	 * @group the group id
	 * @user the user id
	 * ***/
	public static ArrayList<BRBill> getAllImpendingBillInGrp(String group, String usrId) {
		ArrayList<BRBill> res = new ArrayList<BRBill>();
		BRDBConnector dbConn = new BRDBConnector(BRConst.DBFile.FILE_NAME_TRANSDB);
		ArrayList<String> lines = dbConn.getAllMatchedRecords(group, BRConst.DBTransFile.COLUMN_NUM_OF_GROUPID);
		for(int i=0;i<lines.size();i++){
			BRBill bill = new BRBill();
			String line = lines.get(i);
			
			bill.loadGroup(line);
			
			String tmpPayerList[] = bill.getPayerList();
			boolean tmpIfAppriedList[] = bill.getApprovalList() ;
		
			for(int j=0;j<tmpPayerList.length;j++) {
				if(tmpPayerList[j].equals(usrId) && !tmpIfAppriedList[j]) {
					res.add(bill);
					break;
				}
			}
		}
		return res;
		
	}
	
	/***
	 * This function "Improves" an impending transaction for user specified by parameter "userId"
	 * **/
	public void approve(String userId) {
		for(int i=0;i<this.payerList.length;i++) {
			if(this.payerList[i].equals(userId)) {
				this.approvalList[i] = true;
				break;
			}
		}
	}
}
