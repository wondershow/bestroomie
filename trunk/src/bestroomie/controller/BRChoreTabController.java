package bestroomie.controller;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import bestroomie.entities.*;
import bestroomie.gui.*;
import bestroomie.util.BRConst;

public class BRChoreTabController extends BRAbstractController {
	
	private BRChore chore;
	private BRChoreTab view;
	private BRMainGuiController mainController;
	
	public BRChoreTabController(BRChore ch,BRChoreTab p,BRMainGuiController c) {
		this.view = p;
		this.chore = ch;
		this.mainController = c;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args){
		BRChore ch = new BRChore();
		ch.setChoreGroup("group1");
		ch.load();
		
		BRChoreTab p = new BRChoreTab(BRChore.getAllChoresInGrp("group1"));
		BRMainGuiController mainController = new BRMainGuiController(ch);
		BRChoreTabController c = new BRChoreTabController(ch,p,mainController);
		//c.setupGroupLists(u.getFirstGrpId());
		//p.registerListener(c);
		
		
		
		JFrame frame = new JFrame();
		frame.add(p);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
}
