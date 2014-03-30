package bestroomie.controller;

import java.awt.event.ActionEvent;

import bestroomie.db.BRDBConnector;
import bestroomie.entities.BRAbstractEntity;
import bestroomie.entities.BRUser;
import bestroomie.gui.UserRegisterGUI;
import bestroomie.util.BRConst;
import bestroomie.util.BRUtil;

public class BRRegisterController extends BRAbstractController {
	
	private BRUser model;
	private UserRegisterGUI view;
	
	public BRRegisterController(BRUser m, UserRegisterGUI v) {
		this.model = m;
		this.view = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Why do you hate putin? :) !!!" + e.getActionCommand()+"111");
		if(e.getActionCommand().equals("Create Account")) {
			//If there is no name given, give an error
			if (view.getuName().equals(""))
				this.view.displayView(BRConst.DBMessages.ERROR_NO_NAME);
			//If the email is not valid, give an error
			else if(!this.validateEmail())
				this.view.displayView(BRConst.DBMessages.ERROR_INVALID_EMAIL);
			//If the passwords don't match, give an error
			else if (!this.validateSamePassword())
				this.view.displayView(BRConst.DBMessages.ERROR_PASSWORDS_DO_NOT_MATCH);
			//If there is no password, give an error
			else if (view.getuInputPass().equalsIgnoreCase(""))
				this.view.displayView(BRConst.DBMessages.ERROR_NO_PASSWORD);
			else{
				//If the user (email) already exists in the system, give an error
				if(!this.userExists())
					this.view.displayView(BRConst.DBMessages.ERROR_USER_ALREADY_EXISTS);
				//If the user was added successfully, tell them then close the registration window
				else{
					this.view.displayView(BRConst.DBMessages.USER_ADDED);
					this.view.setVisible(false);
				}
			}
			
		} else if (e.getActionCommand().equals("Cancel")) {
			this.view.setVisible(false);
		}
	}
	
	
	private boolean validateEmail() {
		return BRUtil.emailValidator(this.view.getuEmail());
	}
	
	private boolean validateSamePassword() {
		if (this.view.getuInputPass().equals(this.view.getuInputConfirmPass()))
			return true;
		else
			return false;	
	}
	
	private boolean userExists() {
		boolean res = false;
		String usrEmail = this.view.getuEmail();
		this.model.setUserEmail(usrEmail);
		
		//found record with same email
		if(this.model.load()){
			res =  false;
		} else {
			//Print the user email that will be registered and the full line to be added to the DB
			System.out.println(this.model.getUserEmail() + "  Will be registered");
			String userLine = this.view.getuName()+":"+this.view.getuEmail()+":"+this.view.getuInputPass()+":"+",";
			System.out.println(userLine);
			
			//Add the line to the user to the DB
			BRDBConnector dbConn = new BRDBConnector(BRConst.DBFile.FILE_NAME_USERDB);
			dbConn.BRDBWrite(userLine, this.view.getuEmail(), BRConst.DBUserFile.ROW_OF_USER_EMAIL);
			
			// Registration was successful
			res = true;
		}
		
		return res;
	}
	
	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
		
	}
}
