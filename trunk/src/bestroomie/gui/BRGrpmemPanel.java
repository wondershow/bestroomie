/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class BRGrpmemPanel extends BRMainPanel {

	public BRGrpmemPanel() {
		int wid = BRMainPanel.grpMemberPnlWidth;
		int height = BRMainPanel.grpMemberPnlHeight;
		this.setPreferredSize(new Dimension(wid,height));
	}
	
	public static void main(String args[]) {
		BRGrpmemPanel panel = new BRGrpmemPanel();
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
}
