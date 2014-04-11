package bestroomie.controller;

import java.awt.event.ActionEvent;

import bestroomie.db.BRDBConnector;
import bestroomie.entities.BRAbstractEntity;
import bestroomie.entities.BRChore;
import bestroomie.gui.BRChoreTab;
import bestroomie.util.BRConst;
import bestroomie.util.BRUtil;

public class BRChoreTabController extends BRAbstractController {
	
	private BRChore model;
	private BRChoreTab view;
	
	public BRChoreTabController(BRChore m, BRChoreTab v) {
		this.model = m;
		this.view = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Chores!!!");
		if(e.getActionCommand().equals("Show Chores")) {
			
		}
	}
	
	

	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
		
	}
}
