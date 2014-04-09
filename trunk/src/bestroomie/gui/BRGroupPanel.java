/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class BRGroupPanel extends BRMainPanel {
	
	
	public BRGroupPanel () {
		this.setPreferredSize(new Dimension(BRMainPanel.groupPanelWidth,BRMainPanel.groupPanelHeight));
	}
	
	
	
	public static void main(String args[]) {
		BRGroupPanel panel = new BRGroupPanel();
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}