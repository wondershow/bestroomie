package bestroomie.controller;

import java.awt.event.ActionEvent;

import bestroomie.db.BRDBConnector;
import bestroomie.db.writeDatabase;
import bestroomie.entities.BRAbstractEntity;
import bestroomie.entities.BRUser;
import bestroomie.gui.BRAddUserToGroupGUI;
import bestroomie.util.BRConst;
import bestroomie.util.BRUtil;
import bestroomie.controller.BRMainGuiController;

public class BRAddUsertoGroupController extends BRAbstractController {
	
	private BRUser model;
	private BRAddUserToGroupGUI view;
	private BRAddUsertoGroupController mainController;
	private BRMainGuiController assistantController;
	
	public BRAddUsertoGroupController(BRUser m, BRAddUserToGroupGUI v, BRMainGuiController c, BRAddUsertoGroupController d) {
		this.model = m;
		this.view = v;
		this.assistantController = c;
		this.mainController = d;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String grpId = assistantController.getSelectedGrp().getGroupId();
		if(e.getActionCommand().equals("Add User")) {
			System.out.println("Group id: " + grpId);

			//If the email is invalid, give an error
			if(!this.validateEmail())
				this.view.displayView(BRConst.DBMessages.ERROR_INVALID_EMAIL);
			//if the user doesn't exist in the database
			else if(!this.userExists())
				this.view.displayView(BRConst.DBMessages.ERROR_USER_DOES_NOT_EXIST);
			else{
				//Add the user
				writeDatabase.addUsertoGroup(view.getuEmail(), grpId);
				this.view.displayView(BRConst.DBMessages.ADD_USER_TO_GROUP);
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
