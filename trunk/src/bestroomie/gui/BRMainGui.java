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
	
	
	
	public BRMainGui() {
		
		leftPanel = new JPanel();
		int wid = BRMainPanel.groupPanelWidth;
		int height = BRMainPanel.mainFrameHeight - BRMainPanel.headPanelHeight;
		
		leftPanel.setPreferredSize(new Dimension(wid,height));
		BRGroupPanel grpPanel = new BRGroupPanel();
		grpPanel.setBackground(new Color(255,0,0));
		BRGrpmemPanel grpMemPnl = new BRGrpmemPanel();
		grpMemPnl.setBackground(new Color(0,255,0));
		
		leftPanel.add(grpPanel,BorderLayout.CENTER);
		leftPanel.add(grpMemPnl,BorderLayout.SOUTH);
		
		BRChoreTab choreTab = new BRChoreTab();
		BRBillTab billTab = new BRBillTab();
		JTabbedPane jp = new JTabbedPane();
    	jp.addTab("Chore", choreTab);
    	jp.addTab("Bill", billTab);
    	
    	JPanel bodyPanel = new JPanel();
    	bodyPanel.add(leftPanel,BorderLayout.WEST);
    	bodyPanel.add(jp,BorderLayout.CENTER);
    	
    	
    	BRHeadPanel headPanel = new BRHeadPanel();
    	
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
