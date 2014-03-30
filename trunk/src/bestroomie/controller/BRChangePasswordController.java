package bestroomie.controller;

import java.awt.event.ActionEvent;

import bestroomie.db.BRDBConnector;
import bestroomie.entities.BRAbstractEntity;
import bestroomie.entities.BRUser;
import bestroomie.gui.ChangePasswordGUI;
import bestroomie.util.BRConst;
import bestroomie.util.BRUtil;

public class BRChangePasswordController extends BRAbstractController {
	
	private BRUser model;
	private ChangePasswordGUI view;
	
	public BRChangePasswordController(BRUser m, ChangePasswordGUI v) {
		this.model = m;
		this.view = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Why do you hate putin? :) !!!" + e.getActionCommand()+"111");
		if(e.getActionCommand().equals("Change Password")) {
			//If there is no email given, give an error
			//if the user doesn't exist in the database
			//If the old password doesn't match
			//if the new passwords don't match
			//if the new password is blank
			
			
		} else if (e.getActionCommand().equals("Cancel")) {
			this.view.setVisible(false);
		}
	}
	
	
	private boolean validateEmail() {
		return BRUtil.emailValidator(this.view.getuEmail());
	}
	
	private boolean validateSamePassword() {
		if (this.view.getuInputNewPass().equals(this.view.getuInputConfirmNewPass()))
			return true;
		else
			return false;	
	}
	
	private boolean userExists() {
		boolean res = false;
		String usrEmail = this.view.getuEmail();
		this.model.setUserEmail(usrEmail);
		
		//If did not find record with same email
		if(!this.model.load()){
			res =  false;
		} else {
			
			// Change was successful
			res = true;
		}
		
		return res;
	}
	
	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
		
	}
}
