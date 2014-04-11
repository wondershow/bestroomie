/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bestroomie.controller.*;
import bestroomie.util.BRConst;

public class BRGroupPanel extends BRMainPanel {
	
	JList<String> gNameList;
	private BRGoupPanelController controller;
	
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
		
		/**The following code realize the groupname display using JButton**/
		if(false) { 
			this.removeAll();
			this.repaint();
	//		System.out.println("Selected group is " + selectedGrp);
			int grpNum = groups.length;
			this.setLayout(new GridLayout(grpNum,1));
			for (int i=0;i<grpNum;i++) {
				JButton btn = new JButton(groups[i]);
				if(groups[i].equals(selectedGrp)) {
	//				System.out.println("We are adding " + selectedGrp );
					btn.setBackground(new Color(255,0,0));
				}
				this.add(btn);
			}
			this.revalidate();
		} else {
			this.removeAll();
			this.repaint();
			int grpNum = groups.length;
			this.setLayout( new BorderLayout(  ));
			JScrollPane scrollPane = new JScrollPane();
			gNameList = new JList<String>(groups);
			gNameList.setPreferredSize(new Dimension(this.groupPanelWidth*2/3, 
									   this.groupPanelHeight/2));
			
			ListSelectionModel listSelectionModel =  gNameList.getSelectionModel();
	        listSelectionModel.addListSelectionListener(this.controller);
			/** TODO set fonts**/
			//Font f = gNameList.getFont();
			//gNameList.setFont(new Font(f.getName(), Font.ITALIC,3*f.getSize()));
			
			gNameList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
			
			int selectedIndex = -1;
			for(int i=0;i<groups.length;i++)
				if(groups[i].equals(selectedGrp))
					selectedIndex = i;
			gNameList.setSelectedIndex( selectedIndex );
			
			//gNameList.addListSelectionListener(listener);
			
			
			
//			scrollPane.setViewportView(gNameList);
//			gNameList.setf
//			gNameList.setSelectedIndex(index);
//			for (int i=0;i<grpNum;i++) {
//				JRadioButton radioBtn = new JRadioButton(groups[i]);
//				group.add(radioBtn);
//				this.add(radioBtn);
//			}
			//System.out.println(gNameList.get)
			this.add(new JScrollPane(gNameList));
			this.revalidate();
			//this.registerListener(this.controller);
		}
	}

	@Override
	public void registerListener(BRAbstractController a) {
//		this.controller = (BRGoupPanelController) a;
//		// TODO Auto-generated method stub
//		System.out.println("I am here registering");
//		for (Component c : this.getComponents())
//		{
//		      if (c instanceof JList)
//		      {
//		    	  JRadioButton tmp = (JRadioButton)c;
//		          tmp.addActionListener(a);
//		      }
//		 }
	}
	
	public String getListSelectedString() {
//		System.out.println("getListSelectedString is " + gNameList.getSelectedValue());
//		String res = "";
////		for (Component c : this.getComponents())
////		{
////			  System.out.println(c.getClass().toString());
////		      if (c instanceof JList)
////		      {
////		    	  System.out.println("I am reg listener in the group panel, the has code of the traget is ");
////		    	  //JRadioButton tmp = (JRadioButton)c;
////		      }
////		 }
		
		return gNameList.getSelectedValue();
	}
	
	
	public void setController(BRGoupPanelController c) {
		this.controller = c;
	}
}