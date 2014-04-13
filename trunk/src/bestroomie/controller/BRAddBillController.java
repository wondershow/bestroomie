package bestroomie.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import bestroomie.entities.BRAbstractEntity;
import bestroomie.entities.BRBill;
import bestroomie.entities.BRGroup;
import bestroomie.entities.BRUser;
import bestroomie.gui.BRAbstractView;
import bestroomie.gui.BRAddBillView;

public class BRAddBillController extends BRAbstractController {

	private BRUser uModel;
	private BRAddBillView view;
	private String uid;
	private String gid;
	private BRGroup gModel;
	
	
	
	public BRAddBillController(BRUser u, BRGroup g, BRAddBillView v) {
		this.uModel = u;
		this.view = v;
		this.gModel = g;
		this.gModel.load();
	}
	
//	public void addNewBRBill() {
//		
//		
//		
//		
//	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String args[]) {
		
		BRBill m = new BRBill();
		BRUser u = new BRUser();
		u.setUserEmail("lei@here.com");
		u.load();
		BRGroup g = new BRGroup(u.getFirstGrpId());
		g.load();
		BRAddBillView v = new BRAddBillView(g.getGroupMemberObjs(), u,g);
		System.out.println("The first groud id is " + u.getFirstGrpId());
		
		
		BRAddBillController c = new BRAddBillController(u,g,v);
		
		ArrayList<String> usrList = c.gModel.getGroupMember();
		
		System.out.println("User list size is " + usrList.size() );
		
		String oneUser = "";
		for (String s : usrList)   
			oneUser = s;
		//	System.out.println(s);
		//v.setPayeeText(oneUser);
		v.setVisible(true);
	}

}
