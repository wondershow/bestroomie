/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.gui;

import javax.swing.JPanel;

import bestroomie.controller.BRAbstractController;


/**
 * 
 * 
 * */
public abstract class BRMainPanel extends JPanel	{
	
	public static final int mainFrameWidth = 800;
	public static final int mainFrameHeight = 600;
	
	public static final int headPanelHeight = 120;
	public static final int groupPanelHeight = 200;
	public static final int grpMemberPnlHeight = 300;
	
	public static final int headPanelWidth = mainFrameWidth;
	public static final int groupPanelWidth = 200;
	public static final int grpMemberPnlWidth = 200;
	
	public static final int tabWidth = 450;
	public static final int tabHeight = 450;
	//
	
	public abstract void registerListener(BRAbstractController a);
	
}
