/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.gui;

import javax.swing.*;

import bestroomie.controller.BRAbstractController;

import java.awt.*;


/***
 * 
 * This is where the settings guy should work on
 * **/
public class BRHeadPanel extends BRMainPanel {
	
	private JLabel welcomeLbl;
	private JLabel grpStatsLbl;
	private JButton settingsBtn;
	
	
	public void setGrpStatsLbl(int memNum, String gName) {
		String tmpStr = "There are " +  memNum + " Members in Group " +  gName + ". ";
		this.grpStatsLbl.setText(tmpStr);
	}
	
	public void setWelcomeLbl(String uName) {
		String tmpStr = "Welcome customer " + uName + ". ";
		this.welcomeLbl.setText(tmpStr);
	}
	
	public BRHeadPanel () {
		this.setPreferredSize(new Dimension(this.headPanelWidth,this.headPanelHeight));
		
		welcomeLbl = new JLabel("");
		//this.setWelcomeLbl(userName);
		
		grpStatsLbl = new JLabel("");
		//this.setGrpStatsLbl(grpMemNum, grpName);
		
		settingsBtn = new JButton("Settings");
		this.add(welcomeLbl,BorderLayout.WEST);
		this.add(grpStatsLbl,BorderLayout.CENTER);
		this.add(settingsBtn,BorderLayout.EAST);
	}
	
	public static void main(String args[]) {
		BRHeadPanel panel = new BRHeadPanel();
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void registerListener(BRAbstractController a) {
		// TODO Auto-generated method stub
		settingsBtn.addActionListener(a);
	}
}
