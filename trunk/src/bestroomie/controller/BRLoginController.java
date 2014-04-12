package bestroomie.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bestroomie.entities.BRAbstractEntity;
import bestroomie.entities.BRUser;
import bestroomie.gui.BRLoginView;
import bestroomie.gui.UserRegisterGUI;
import bestroomie.gui.ChangePasswordGUI;
import bestroomie.gui.BRMainView;
import bestroomie.util.BRConst;
import bestroomie.util.BRUtil;


public class BRLoginController extends BRAbstractController {
	
	private BRUser model;
	private BRLoginView view;
	private int captchaWord;
	//private BR
	
	public BRLoginController(BRUser m, BRLoginView v) {
		this.model = m;
		this.view = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Login")) {
			
			if(!this.validateCaptcha())
				this.view.displayView(BRConst.DBMessages.ERROR_WRONG_CAPTCHA);
			else if(!this.validateEmail())
				this.view.displayView(BRConst.DBMessages.ERROR_INVALID_EMAIL);
			else{
				if(!this.validateUser())
					this.view.displayView(BRConst.DBMessages.ERROR_VALIDATION_FAILURE);
				else{
					BRUser m = new BRUser("c","d");
					BRMainView v = new BRMainView();
					BRMainViewController c = new BRMainViewController(m,v);
					v.registerListener(c);
					v.setVisible(true);	
				}
			}
			
		} else if (e.getActionCommand().equals("Cancel")) {
			this.model.reset();
			this.view.reset();

		} else if (e.getActionCommand().equals("Register")) {
			BRUser m = new BRUser("c","d");
			UserRegisterGUI v = new UserRegisterGUI();
			BRRegisterController c = new BRRegisterController(m,v);
			v.registerListener(c);
			v.setVisible(true);	

		} else if (e.getActionCommand().equals("Change Password")) {
			BRUser m = new BRUser("c","d");
			ChangePasswordGUI v = new ChangePasswordGUI();
			BRChangePasswordController c = new BRChangePasswordController(m,v);
			v.registerListener(c);
			v.setVisible(true);					
		}
	}
	
	
	private boolean validateCaptcha() {
		String captchaTxt = Integer.toString(this.captchaWord);
		if(captchaTxt.equals(this.view.getCaptchaText()))
			return true;
		else
			return false;
	}
	
	private boolean validateEmail() {
		return BRUtil.emailValidator(this.view.getuName());
	}
	
	private boolean validateUser() {
		boolean res = false;
		String usrEmail = this.view.getuName();
		this.model.setUserEmail(usrEmail);
		
		//cant find a record matching this email in db
		if(!this.model.load()){
			res =  false;
		} else if(this.model.getUserPass().equals(this.view.getuInputPass())) {
			System.out.println("this.model.getUserPass() = " + this.model.getUserPass() 
					+ " this.view.getuInputPass() " + this.view.getuInputPass());
			// login successful
			System.out.println("It matches");
			res = true;
		} else {
			System.out.println("this.model.getUserPass() = " + this.model.getUserPass() 
					+ " this.view.getuInputPass() " + this.view.getuInputPass());
			//password of record email cat match the user input password
			res = false;
		}
		
		return res;
	}
	
	public static void main(String args[]) {
		BRUser m = new BRUser("c","d");
		BRLoginView v = new BRLoginView();
		BRLoginController c = new BRLoginController(m,v);
		c.genCaptcha();
		v.updateCaptchaImage();
		v.registerListener(c);
		v.setVisible(true);
	}
	
	
	private void genCaptcha() {
		captchaWord = BRUtil.generateCaptcha(BRConst.CAPTCHA_IMG_WIDTH, BRConst.CAPTCHA_IMG_HEIGHT);
		
	}
	
	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
		
	}
}
