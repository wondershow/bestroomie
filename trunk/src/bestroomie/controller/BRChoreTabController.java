package bestroomie.controller;

import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JFrame;

import bestroomie.entities.*;
import bestroomie.gui.*;
import bestroomie.util.BRConst;

public class BRChoreTabController extends BRAbstractController {
	
	private BRChore chore;
	private BRChoreTab view;
	private BRMainGuiController mainController;
	
	public BRChoreTabController(BRChoreTab p,BRMainGuiController c) {
		this.view = p;
		BRChore ch = new BRChore();
		ch.setChoreGroup(c.getSelectedGrp().getGroupId());
		ch.load();
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
	
	public static void main(String[] args) throws ParseException{
		BRChore ch = new BRChore();
		ch.setChoreGroup("group1");
		ch.load();
		
		BRUser u = new BRUser();
		u.setUserEmail("lei@here.com");
		u.load();
		
		BRChoreTab p = new BRChoreTab(BRChore.getOldChoresInGrp("group1"),BRChore.getFutureChoresInGrp("group1"));
		BRMainGuiController mainController = new BRMainGuiController(u);
		mainController.setSelectedGrp("group1");
		BRChoreTabController c = new BRChoreTabController(p,mainController);
		//c.setupGroupLists(u.getFirstGrpId());
		//p.registerListener(c);
		
		JFrame frame = new JFrame();
		frame.add(p);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
}
