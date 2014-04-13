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
		this.transId = transId;
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
		String res = "";
		for(int i=0;i<payerList.length;i++)
			res = payerList+",";
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

	public CATAGORY_INDEX getCatagory() {
		return catagory;
	}

	public void setCatagory(CATAGORY_INDEX catagory) {
		this.catagory = catagory;
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
	protected boolean saveToDB() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean load() {
		BRDBConnector dbConn = new BRDBConnector(BRConst.DBFile.FILE_NAME_TRANSDB);
		String line = dbConn.BRDBRead(this.transId, BRConst.DBTransFile.COLUMN_OF_TABLE_KEY);
		
		System.out.println(line);
		
		if (line == null) // not matching record found
			return false;
		else {
			String strArr[] = line.split(BRConst.DBFile.FIELD_SEPERATOR );
			//this.setTransId(line);
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
			return true;
		}
		// TODO Auto-generated method stub
	}
	
	
	
	
	public static void main(String s[]) {
		BRBill b = new BRBill();
		b.setTransId("lei@here.com201404111937");
		b.load();
		System.out.println(b.getDate());
		
	}
	
	public static ArrayList<BRBill> getAllBillsInGrp(String group) {
		ArrayList<BRBill> res = new ArrayList<BRBill>();
		BRDBConnector dbConn = new BRDBConnector(BRConst.DBFile.FILE_NAME_TRANSDB);
		ArrayList<String> lines = dbConn.getAllMatchedRecords(group, BRConst.DBTransFile.COLUMN_NUM_OF_GROUPID);
		for(int i=0;i<lines.size();i++){
			BRBill bill = new BRBill();
			String line = lines.get(i);
			
			String strArr[] = line.split(BRConst.DBFile.FIELD_SEPERATOR );
			//this.setTransId(line);
			bill.setGroup(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_GROUPID]);
			//this.setAllocation(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_AMOUNT]);
			int tmpInt = Integer.parseInt(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_CATAGORYID]);
			bill.setCatagory(CATAGORY_INDEX.fromInteger(tmpInt) );
			bill.setDate(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_DATE]);
			bill.setPayerList(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_PAYERID]);
			bill.setAmntList(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_AMOUNT]);
			bill.setApprovalList(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_APPROVAL]);
			bill.setPaidList(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_PAID]);
			bill.setDescription(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_DESCTIPTION]);
			bill.setTotal_amount(Float.parseFloat(strArr[BRConst.DBTransFile.COLUMN_NUM_OF_TOTAL].trim()));
			
			res.add(bill);
		}
		return res;
	} 
}
