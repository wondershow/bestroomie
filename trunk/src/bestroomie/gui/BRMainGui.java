/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import bestroomie.controller.BRAbstractController;
import bestroomie.entities.BRBill;
import bestroomie.entities.BRChore;

public class BRMainGui extends BRAbstractView implements MouseListener{
	
	private JPanel leftPanel;
	private JPanel bodyPanel;
	private BRHeadPanel headPanel;
	private BRGroupPanel groupPanel;
	private BRGrpmemPanel groupMemPanel;
	private BRBillTab billTab;
	private BRChoreTab choreTab;
	
	
	public BRHeadPanel getHeadPanel(){
		return this.headPanel;
	}
	
	public BRGroupPanel getGroupPanel(){
		return this.groupPanel;
	}
	
	public BRGrpmemPanel getGrpMemPanel(){
		return this.groupMemPanel;
	}
	
	public BRBillTab getBillTab(){
		return this.billTab;
	}
	
	public BRChoreTab getChoreTab() {
		return this.choreTab;
	}
	
	public JPanel getLeftPanel() {
		return this.leftPanel;
	}
	
	public BRMainGui(ArrayList<BRBill> oldBills, ArrayList<BRBill> impendingBills, ArrayList<BRChore> old2, String userId) {
		
		leftPanel = new JPanel();
		int wid = BRMainPanel.groupPanelWidth;
		int height = BRMainPanel.mainFrameHeight - BRMainPanel.headPanelHeight;
		
		leftPanel.setPreferredSize(new Dimension(wid,height));
		groupPanel = new BRGroupPanel();
		groupPanel.setBackground(new Color(255,0,0));
		groupMemPanel = new BRGrpmemPanel();
		groupMemPanel.setBackground(new Color(0,255,0));
		
		leftPanel.add(groupPanel,BorderLayout.CENTER);
		leftPanel.add(groupMemPanel,BorderLayout.SOUTH);
		
		choreTab = new BRChoreTab(old2);
		billTab = new BRBillTab(oldBills,impendingBills,userId);
		
		JTabbedPane jp = new JTabbedPane();
    	jp.addTab("Chore", choreTab);
    	jp.addTab("Bill", billTab);
    	
    	JPanel bodyPanel = new JPanel();
    	bodyPanel.add(leftPanel,BorderLayout.WEST);
    	bodyPanel.add(jp,BorderLayout.CENTER);
    	
    	
    	headPanel = new BRHeadPanel();
    	
    	this.add(headPanel,BorderLayout.NORTH);
    	this.add(bodyPanel,BorderLayout.CENTER);
	}
	
	
	
	public void setupUI() {
		
		
	}
	
	
	
	public static void main(String args[]) {
//		BRMainGui gui = new BRMainGui(old);
//		gui.pack();
//		gui.setResizable(false);
//		gui.setLocationRelativeTo(null);
//		gui.setVisible(true);
	}
	
	
	
	@Override
	public void registerListener(BRAbstractController a) {
		// TODO Auto-generated method stub
		for (Component c : this.getComponents())
		{
		      if (c instanceof JButton)
		      {
//		    	   System.out.println("I am reg listener in the maingui");
		           JButton tmp = (JButton)c;
		           tmp.addActionListener(a);
		      }
		 }
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		System.out.println("mouseClicked");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseEntered");
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseExited");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseReleased");
	}
}
