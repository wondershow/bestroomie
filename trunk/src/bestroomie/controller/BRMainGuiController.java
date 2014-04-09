package bestroomie.controller;

import java.awt.event.ActionEvent;

import bestroomie.entities.BRAbstractEntity;
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
		System.out.println("I am here!!!");
		headController.setUpView();
		groupController.setupGroupLists(this.user.getFirstGrpId());
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
		
		
		this.setSelectedGrp(this.user.getFirstGrpId());
		headController = new BRHeadPanelController(this.user,this.mainFrame.getHeadPanel(),this);
		groupController = new BRGoupPanelController(this.user,this.mainFrame.getGroupPanel(),this);
		
		
		
		
		//this.refreshUI();
	}
	
	
	
	public void setupGUI() {
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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
}
