package bestroomie.controller;

import java.awt.event.ActionEvent;

import bestroomie.db.BRDBConnector;
import bestroomie.entities.BRAbstractEntity;
import bestroomie.entities.BRUser;
import bestroomie.gui.BRMainView;
import bestroomie.util.BRConst;
import bestroomie.util.BRUtil;

public class BRMainViewController extends BRAbstractController {
	
	private BRUser model;
	private BRMainView view;
	
	public BRMainViewController(BRUser m, BRMainView v) {
		this.model = m;
		this.view = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Why do you hate putin? :) !!!" + e.getActionCommand()+"111");
		if(e.getActionCommand().equals("Create Account")) {
			//If there is no name given, give an error
			
			
		} else if (e.getActionCommand().equals("Cancel")) {
			this.view.setVisible(false);
		}
	}
	
	
	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
		
	}
}
