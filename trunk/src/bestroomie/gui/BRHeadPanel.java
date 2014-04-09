/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.gui;

import javax.swing.*;
import java.awt.*;


/***
 * 
 * This is where the settings guy should work on
 * **/
public class BRHeadPanel extends BRMainPanel {
	
	
	public BRHeadPanel () {
		this.setPreferredSize(new Dimension(this.headPanelWidth,this.headPanelHeight));
		JButton jbt = new JButton("Settings");
		this.add(jbt);
	}
	
	
	
	public static void main(String args[]) {
		BRHeadPanel panel = new BRHeadPanel();
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
