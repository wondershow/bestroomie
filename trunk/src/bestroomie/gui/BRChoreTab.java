/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import bestroomie.controller.BRAbstractController;

public class BRChoreTab extends BRMainPanel {

	public BRChoreTab() {
		int wid = BRMainPanel.tabWidth;
		int height = BRMainPanel.tabHeight;
		this.setPreferredSize(new Dimension(wid,height));
	}

	public static void main(String[] args) {
		BRChoreTab tab = new BRChoreTab();
		JFrame frame = new JFrame();
		JTabbedPane jp = new JTabbedPane();
		jp.addTab("Chore", tab);
		frame.add(jp);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void registerListener(BRAbstractController a) {
		// TODO Auto-generated method stub
		
	}

	
}
