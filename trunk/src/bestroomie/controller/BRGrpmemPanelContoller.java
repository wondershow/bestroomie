/**
Author: Lei Zhang
File Creation Date: Apr 13, 2014
Class Description:
*/
package bestroomie.controller;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bestroomie.entities.BRGroup;
import bestroomie.entities.BRUser;
import bestroomie.gui.BRGrpmemPanel;
import bestroomie.gui.BRMainPanel;

public class BRGrpmemPanelContoller {
	private BRUser model;
	private BRGrpmemPanel view;
	private JList<String> gNameList;
	private BRGroup group;
	private ArrayList<BRUser> grpUseList;
	private BRMainGuiController mainController;
	
	public BRGrpmemPanelContoller(BRGrpmemPanel p, BRMainGuiController m) {
		this.model = m.getUser();
		this.view = p;
		this.mainController = m;
		this.refreshUI();
		// TODO Auto-generated constructor stub
	}
	
	public void refreshUI () {
		
		this.group = this.mainController.getSelectedGrp();
		
		
		this.view.removeAll();
		
		grpUseList = this.group.getGroupMemberObjs(this.model.getUserEmail());  
		grpUseList.add(this.model);
		
		//System.out.println("grpUseList is" + grpUseList.size());
		String groups[] = new String[grpUseList.size()];
		
		for(int i=0;i<grpUseList.size();i++)
			groups[i] = grpUseList.get(i).getUserName();
		

		
		
		
		gNameList = new JList<String>(groups);
		gNameList.setPreferredSize(new Dimension(BRMainPanel.grpMemberPnlWidth*9/10, 
				BRMainPanel.grpMemberPnlHeight/2));
		
		
		this.view.add(new JLabel("Members of " + this.group.getGroupId()));
		this.view.add(new JScrollPane(gNameList));
	}

	public static void main(String args[]) {
		
		
	}
}
