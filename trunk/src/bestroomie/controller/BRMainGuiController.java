package bestroomie.controller;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import bestroomie.entities.*;
import bestroomie.gui.*;

public class BRMainGuiController extends BRAbstractController {

	private BRUser user;
	private BRGroup grp;
	private BRMainGui mainFrame;
	private	BRHeadPanelController headController;
	private BRGoupPanelController groupController;
	private BRGroupPanel userPanel;
	
	public void refreshUI() {
		this.mainFrame.pack();
		this.mainFrame.setResizable(false);
		this.mainFrame.setLocationRelativeTo(null);
		this.mainFrame.setVisible(true);
		this.headController.refreshUI();
		this.groupController.refreshUI();
	}

	/**
	 * To update the selected group by passing 
	 * group id
	 * **/
	public void setSelectedGrp(String grpId) {
		grp = new BRGroup(grpId);
		grp.load();
	}
	
	/**
	 ***/
	public BRGroup getSelectedGrp(){
		return this.grp;
	}
	
	
	public BRMainGuiController(BRUser u) {
		this.user = u;
		BRMainGui gui = new BRMainGui();
		this.mainFrame = gui;
		
		//Initialize a default group
		this.setSelectedGrp(this.user.getFirstGrpId());
		
		//Initialize all the subcontrollers
		this.headController = new BRHeadPanelController(this.user,this.mainFrame.getHeadPanel(),this);
		this.groupController = new BRGoupPanelController(this.user,this.mainFrame.getGroupPanel(),this);
		
		
		
		this.refreshUI();
//		//
//		this.groupController.setupGroupLists(this.user.getFirstGrpId());
//		this.mainFrame.getGroupPanel().registerListener(this.groupController);
//		this.mainFrame.getHeadPanel().registerListener(this.headController);
//		System.out.println("The target should be " + this.groupController.toString());
		//this.mainFrame.registerListener(headController);
		//this.refreshUI();
	}
	
	
	
	public void setupGUI() {
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("I am doing action performed in the main gui controller.");
	}
	
	
	

	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
		
	}
	
	public BRMainGuiController(BRUser u,BRMainGui v) {
		this.user = u;
		this.mainFrame = v;
		this.mainFrame.setVisible(true);
	}
	
	public static void main(String args[]) {
		BRUser user = new BRUser();
		user.setUserEmail("lei@here.com");
		user.load();
		BRMainGuiController mainGui = new BRMainGuiController(user);
		mainGui.refreshUI();
		
		/*
		BRUser u = new BRUser();
		u.setUserEmail("lei@here.com");
		u.load();
		BRGroupPanel p = new BRGroupPanel();
		BRMainGuiController mainController = new BRMainGuiController(u);
		BRGoupPanelController c = new BRGoupPanelController(u,p,mainController);
		c.setupGroupLists(u.getFirstGrpId());
		p.registerListener(c);
		
		JFrame frame = new JFrame();
		frame.add(p);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);*/
	}
}
