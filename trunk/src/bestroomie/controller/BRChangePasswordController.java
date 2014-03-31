package bestroomie.controller;

import java.awt.event.ActionEvent;

import bestroomie.db.BRDBConnector;
import bestroomie.db.writeDatabase;
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
		if(e.getActionCommand().equals("Change Password")) {
			//If the email is invalid, give an error
			if(!this.validateEmail())
				this.view.displayView(BRConst.DBMessages.ERROR_INVALID_EMAIL);
			//if the user doesn't exist in the database
			else if(!this.userExists())
				this.view.displayView(BRConst.DBMessages.ERROR_USER_DOES_NOT_EXIST);
			//If the old password doesn't match, give an error
			else if(!(this.model.getUserPass().equals(this.view.getuInputPass()))) {
				this.view.displayView(BRConst.DBMessages.ERROR_VALIDATION_FAILURE);
			}
			//if the new passwords don't match, give an error
			else if (!(this.view.getuInputNewPass().equals(this.view.getuInputConfirmNewPass())))
				this.view.displayView(BRConst.DBMessages.ERROR_PASSWORDS_DO_NOT_MATCH);
			//If there is no new password, give an error
			else if (view.getuInputNewPass().equalsIgnoreCase(""))
				this.view.displayView(BRConst.DBMessages.ERROR_NO_PASSWORD);
			else{
				//Change the user's password
				writeDatabase.changePassword(this.view.getuEmail(), this.view.getuInputNewPass());	
				
				this.view.displayView(BRConst.DBMessages.PASSWORD_CHANGED);
			}
		} else if (e.getActionCommand().equals("Cancel")) {
			this.view.setVisible(false);
		}
	}
	
	
	private boolean validateEmail() {
		return BRUtil.emailValidator(this.view.getuEmail());
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
