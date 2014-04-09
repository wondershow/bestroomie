package bestroomie.controller;

import java.awt.event.ActionEvent;

import bestroomie.entities.BRAbstractEntity;
import bestroomie.entities.BRGroup;
import bestroomie.entities.BRUser;
import bestroomie.gui.BRAbstractView;
import bestroomie.gui.BRMainGui;

public class BRMainGuiController extends BRAbstractController {

	private BRUser user;
	private BRGroup grp;
	private BRAbstractView mainFrame;
	
	
	public void refreshUI() {
		this.mainFrame.pack();
		this.mainFrame.setResizable(false);
		this.mainFrame.setLocationRelativeTo(null);
		this.mainFrame.setVisible(true);
	}
	
	
	public BRMainGuiController(BRUser u) {
		this.user = u;
		BRMainGui gui = new BRMainGui();
		this.mainFrame = gui;
		this.refreshUI();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
		
	}
	
	public BRMainGuiController(BRUser u,BRAbstractView v) {
		this.user = u;
		this.mainFrame = v;
		this.mainFrame.setVisible(true);
	}
}
