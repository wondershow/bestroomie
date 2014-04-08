package bestroomie.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import bestroomie.entities.BRAbstractEntity;
import bestroomie.entities.BRBill;
import bestroomie.entities.BRGroup;
import bestroomie.gui.BRAbstractView;
import bestroomie.gui.BRAddBillView;

public class BRAddBillController extends BRAbstractController {

	private BRAbstractEntity model;
	private BRAbstractView view;
	private String uid;
	private String gid;
	private BRGroup gModel;
	
	
	
	public BRAddBillController(BRAbstractEntity e, BRAbstractView v, String uid, String gid) {
		this.model = e;
		this.view = v;
		this.uid = uid;
		this.gid = gid;
		this.gModel = new BRGroup(gid);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String args[]) {
		BRAddBillView v = new BRAddBillView();
		BRBill m = new BRBill();
		BRAddBillController c = new BRAddBillController(m,v,"a@here.com","group1");
		c.gModel.load();
		ArrayList<String> usrList = c.gModel.getGroupMember();
		
		String oneUser = "";
		for (String s : usrList)   
			oneUser = s;
		//	System.out.println(s);
		v.setPayeeText(oneUser);
		v.setVisible(true);
	}

}
