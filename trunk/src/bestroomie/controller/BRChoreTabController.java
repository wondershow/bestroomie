package bestroomie.controller;

import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JFrame;

import bestroomie.controller.*;
import bestroomie.entities.*;
import bestroomie.gui.*;
import bestroomie.util.BRConst;

public class BRChoreTabController extends BRAbstractController {
	
	private BRChore chore;
	private BRChoreTab view;
	private static BRMainGuiController mainController;
	
	public BRChoreTabController(BRChoreTab p,BRMainGuiController c) {
		this.view = p;
		BRChore ch = new BRChore();
		ch.setChoreGroup(c.getSelectedGrp().getGroupId());
		ch.load();
		this.chore = ch;
		this.mainController = c;
	}
	
	public void refreshUI(){
		String grpId = mainController.getSelectedGrp().getGroupId();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) throws ParseException{
		String grpId = mainController.getSelectedGrp().getGroupId();

		
		BRChore ch = new BRChore();
		ch.setChoreGroup(grpId);
		System.out.println("Group ID under chores is: " + grpId);
		ch.load();
		
		BRUser u = new BRUser();
		u.setUserEmail(mainController.getUser().getUserEmail());
		u.load();
		
		BRChoreTab p = new BRChoreTab(BRChore.getOldChoresInGrp(grpId),BRChore.getFutureChoresInGrp(grpId));
		BRMainGuiController mainController = new BRMainGuiController(u);
		mainController.setSelectedGrp(mainController.getSelectedGrp().getGroupId());
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
