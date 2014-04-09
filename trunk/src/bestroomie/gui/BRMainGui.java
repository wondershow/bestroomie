/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.gui;

import java.awt.*;

import javax.swing.*;

import bestroomie.controller.BRAbstractController;

public class BRMainGui extends BRAbstractView{
	
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
	
	public BRMainGui() {
		
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
		
		choreTab = new BRChoreTab();
		billTab = new BRBillTab();
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
		BRMainGui gui = new BRMainGui();
		gui.pack();
		gui.setResizable(false);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
	}
	
	
	
	@Override
	public void registerListener(BRAbstractController a) {
		// TODO Auto-generated method stub
		
	}
}
