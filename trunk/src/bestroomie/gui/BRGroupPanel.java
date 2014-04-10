/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import bestroomie.controller.*;
import bestroomie.util.BRConst;

public class BRGroupPanel extends BRMainPanel {
	
	
	public BRGroupPanel () {
		this.setPreferredSize(new Dimension(BRMainPanel.groupPanelWidth,BRMainPanel.groupPanelHeight));
		JButton btn = new JButton("");
		this.add(btn);
	}
	
	
	
	public static void main(String args[]) {
		BRGroupPanel panel = new BRGroupPanel();
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	/**
	 *  To dynamically add grouplist, the selected group will
	 *  be displayed in a different color 
	 * **/
	public void setupGroupLists(String groups[], String selectedGrp) {
		
		this.removeAll();
		this.repaint();
		
		
		System.out.println("Selected group is " + selectedGrp);
		int grpNum = groups.length;
		this.setLayout(new GridLayout(grpNum,1));
		for (int i=0;i<grpNum;i++) {
			JButton btn = new JButton(groups[i]);
			if(groups[i].equals(selectedGrp)) {
				System.out.println("We are adding " + selectedGrp );
				btn.setBackground(new Color(255,0,0));
			}
			this.add(btn);
		}
		this.revalidate();
	}

	@Override
	public void registerListener(BRAbstractController a) {
		// TODO Auto-generated method stub
		System.out.println("I am here registering");
		for (Component c : this.getComponents())
		{
		      if (c instanceof JButton)
		      {
		    	   System.out.println("I am reg listener in the group panel, the has code of the traget is " + a.toString());
		           JButton tmp = (JButton)c;
		           tmp.addActionListener(a);
		      }
		 }
	}
}