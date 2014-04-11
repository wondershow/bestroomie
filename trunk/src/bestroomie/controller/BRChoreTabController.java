package bestroomie.controller;

import java.awt.event.ActionEvent;

import bestroomie.db.BRDBConnector;
import bestroomie.entities.BRAbstractEntity;
import bestroomie.entities.BRChore;
import bestroomie.entities.BRUser;
import bestroomie.gui.BRChoreTab;
import bestroomie.gui.BRGroupPanel;
import bestroomie.util.BRConst;
import bestroomie.util.BRUtil;

public class BRChoreTabController extends BRAbstractController {
	
	private BRChore model;
	private BRChoreTab view;
	private BRMainGuiController mainController;
	
	public BRChoreTabController( BRChore u,BRChoreTab p,BRMainGuiController c) {
		this.view = p;
		this.model = u;
		this.mainController = c;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Show Chores")) {
			System.out.println("Chores!!!");

		}
		System.out.println("Chores!!!");

	}
	
	

	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
		
	}
}
