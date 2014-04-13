/**
Author: Lei Zhang
File Creation Date: Apr 11, 2014
Class Description:
*/
package bestroomie.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import bestroomie.entities.BRAbstractEntity;
import bestroomie.entities.BRBill;
import bestroomie.entities.BRUser;
import bestroomie.gui.BRBillTab;
import bestroomie.gui.BRGroupPanel;

public class BRBillTabContoller extends BRAbstractController{

	private BRUser user;
	private BRBillTab view;
	private BRMainGuiController mainController;
	private ArrayList<BRBill> old;
	private ArrayList<BRBill> impending;
	
	
	public BRBillTabContoller( BRUser u, ArrayList<BRBill> oldList, ArrayList<BRBill> impendingList,BRMainGuiController c) {
		// TODO Auto-generated constructor stub
		this.user = u;
		this.old = oldList;
		this.impending = impendingList;
		this.view = new BRBillTab(oldList,impendingList,u.getUserEmail());
		this.view.setController(this);
		this.mainController = c;
	}
	
	public BRBillTab getView() {
		return this.view;
	}
	
	public void refreshUI() {
		
		
	}
	
	
	
	public void approveTransaction(int index) {
		
		BRBill b = impending.get(index);
		b.approve(this.user.getUserEmail());
		b.saveToDB();
		this.old = BRBill.getAllSettledBillInGrp(this.mainController.getSelectedGrp().getGroupId(), this.user.getUserEmail());
		this.impending = BRBill.getAllImpendingBillInGrp(this.mainController.getSelectedGrp().getGroupId(), this.user.getUserEmail());
		
		this.view = new BRBillTab(this.old,this.impending,this.user.getUserEmail());
		//this.mainController.setupGUI();
		this.view.updateBillLists(this.old,this.impending);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[]) {
		BRUser u = new BRUser();
		u.setUserEmail("lei@here.com");
		u.load();
		
		BRMainGuiController mainController = new BRMainGuiController(u);
		BRBillTabContoller c = new BRBillTabContoller(u,
													  BRBill.getAllSettledBillInGrp("group1",u.getUserEmail()),
													  BRBill.getAllImpendingBillInGrp("group1",u.getUserEmail()),
													  mainController);
		
		//c.setupGroupLists(u.getFirstGrpId());
		//p.registerListener(c);
		
		
		
		JFrame frame = new JFrame();
		frame.add(c.getView());
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
}
