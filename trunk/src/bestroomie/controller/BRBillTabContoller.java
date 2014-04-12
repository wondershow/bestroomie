/**
Author: Lei Zhang
File Creation Date: Apr 11, 2014
Class Description:
*/
package bestroomie.controller;

import java.awt.event.ActionEvent;

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
	
	
	public BRBillTabContoller( BRUser u,BRBillTab p,BRMainGuiController c) {
		// TODO Auto-generated constructor stub
		this.user = u;
		this.view = p;
		this.mainController = c;
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
		
		BRBillTab p = new BRBillTab(BRBill.getAllBillsInGrp("group1"));
		BRMainGuiController mainController = new BRMainGuiController(u);
		BRBillTabContoller c = new BRBillTabContoller(u,p,mainController);
		//c.setupGroupLists(u.getFirstGrpId());
		//p.registerListener(c);
		
		
		
		JFrame frame = new JFrame();
		frame.add(p);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
}
