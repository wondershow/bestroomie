package bestroomie.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bestroomie.entities.BRUser;
import bestroomie.gui.BRLoginView;
import bestroomie.util.BRUtil;


public class BRLoginController extends BRAbstractController {
	
	private BRUser model;
	private BRLoginView view;
	//private BR
	
	public BRLoginController(BRUser m, BRLoginView v) {
		this.model = m;
		this.view = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Fuck putin: !!!" + e.getActionCommand()+"111");
		if(e.getActionCommand().equals("Login")) {
			
			if(!this.validateEmail())
				this.view.displayView(BRAbstractController.ERROR_INVALID_EMAIL);
			else{
				if(!this.validateUser())
					this.view.displayView(BRAbstractController.ERROR_VALIDATION_FAILURE);
			}
			
//			this.validateUser();
		} else if (e.getActionCommand().equals("Cancel")) {
			this.model.reset();
			this.view.reset();
			
		} else if (e.getActionCommand().equals("Add User")) { 
			
			
		} else if (e.getActionCommand().equals("Change Password")) {
//			if(this.changePass())
				
		}
	}
	
	
	private boolean validateEmail() {
		return BRUtil.emailValidator(this.view.getuName());
	}
	
//	private boolean changePass() {
//		
//	}
	
	
	private boolean validateUser() {
		boolean res = false;
		String usrEmail = this.view.getuName();
		this.model.setUserEmail(usrEmail);
		
		//cant find a record matching this email in db
		if(!this.model.load())
			
			res =  false;
		else if(this.model.getUserPass().equals(this.view.getuName())) {
			// login successful
			res = true;
		} else {
			//password of record email cat match the user input password
			res = false;
		}
		
		return res;
	}
	
	
	public static void main(String args[]) {
		BRUser m = new BRUser("UserDB","c","d");
		BRLoginView v = new BRLoginView();
		BRLoginController c = new BRLoginController(m,v);
		v.registerListener(c);
		v.setVisible(true);
		
	}
	
	
	
}
