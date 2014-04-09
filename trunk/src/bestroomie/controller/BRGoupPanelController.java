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

	
	/**
	 *  To dynamically add grouplist, the selected group will
	 *  be displayed in a different color 
	 * **/
	public void setupGroupLists(String selectedGroup) {
		String grpNameList[] = this.model.getUserGroup().split(BRConst.DBFile.GROUP_SEPERATOR);
		int grpNum = grpNameList.length;
		this.view.setLayout(new GridLayout(grpNum,1));
		for (int i=0;i<grpNum;i++) {
			JButton btn = new JButton(grpNameList[i]);
			if(grpNameList[i].equals(selectedGroup))
				btn.setBackground(new Color(255,0,0));
			this.view.add(btn);
			System.out.println("I am adding the btn #" + i);
		}
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
		BRUser u = new BRUser();
		u.setUserEmail("lei@here.com");
		u.load();
		BRGroupPanel p = new BRGroupPanel();
		BRGoupPanelController c = new BRGoupPanelController(u,p,null);
		c.setupGroupLists(u.getFirstGrpId());
		
		
		JFrame frame = new JFrame();
		frame.add(p);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
