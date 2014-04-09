/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.controller;

import java.awt.event.ActionEvent;

import bestroomie.entities.*;
import bestroomie.gui.*;
import bestroomie.util.BRConst;

public class BRHeadPanelController extends BRAbstractController{

	private BRUser model;
	private BRHeadPanel view;
	private BRMainGuiController mainController;
	
	/**
	 * @param u the entity of login user
	 * @param b the view of the headpanel
	 * @param grpId the id of the group that all the other tabs on main gui are displaying
	 * **/
	public BRHeadPanelController(BRUser u, BRHeadPanel b, BRMainGuiController c) {
		this.model = u;
		this.view = b;
		this.mainController = c;
		this.setUpView();
	}

	/***
	 * To setup the view
	 * **/
	public void setUpView() {
		String grpId = mainController.getSelectedGrp().getGroupId();
		String userName = this.model.getUserName();
		if(userName.trim()!="")
			this.view.setWelcomeLbl(this.model.getUserName());
		else
			this.view.setWelcomeLbl("NoName");
		
		int numInGrp = this.model.getGroupSize(grpId);
		
		this.view.setGrpStatsLbl(numInGrp, grpId);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
		
	}

}
