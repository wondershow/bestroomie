/**
Author: Lei Zhang
File Creation Date: Apr 9, 2014
Class Description:
*/
package bestroomie.controller;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import bestroomie.entities.*;
import bestroomie.gui.*;
import bestroomie.util.BRConst;

public class BRGoupPanelController extends BRAbstractController {

	private BRGroupPanel view;
	private BRUser	model;
	private BRMainGuiController mainController;
	
	
	public BRGoupPanelController( BRUser u,BRGroupPanel p,BRMainGuiController c) {
		this.view = p;
		this.model = u;
		this.mainController = c;
		//this.setupGroupLists(grpList, selectedGroup);
		// TODO Auto-generated constructor stub
	}

	
	
	public void refreshUI() {
		String selectedGrp = this.mainController.getSelectedGrp().getGroupId();
		this.setupGroupLists(selectedGrp);
		this.view.registerListener(this);
	}
	
	
	/**
	 *  To dynamically add grouplist, the selected group will
	 *  be displayed in a different color 
	 * **/
	public void setupGroupLists(String selectedGroup) {
		String grpNameList[] = this.model.getUserGroup().split(BRConst.DBFile.GROUP_SEPERATOR);
		this.view.setupGroupLists(grpNameList,selectedGroup);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setupGroupLists(e.getActionCommand());
		this.mainController.setSelectedGrp(e.getActionCommand());
		this.mainController.refreshUI();
		System.out.println("I am here listening " + e.getActionCommand());
	}

	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub

	}

	public static void main(String args[]) {
		BRUser u = new BRUser();
		u.setUserEmail("lei@here.com");
		u.load();
		BRGroupPanel p = new BRGroupPanel();
		BRMainGuiController mainController = new BRMainGuiController(u);
		BRGoupPanelController c = new BRGoupPanelController(u,p,mainController);
		c.setupGroupLists(u.getFirstGrpId());
		p.registerListener(c);
		
		JFrame frame = new JFrame();
		frame.add(p);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
