/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
 */
package bestroomie.controller;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import bestroomie.entities.BRAbstractEntity;
import bestroomie.entities.BRUser;
import bestroomie.gui.BRHeadPanel;
import bestroomie.gui.ChangePasswordGUI;
import bestroomie.entities.*;
import bestroomie.gui.*;
import bestroomie.util.BRConst;

public class BRHeadPanelController extends BRAbstractController {

	private BRUser model;
	private BRHeadPanel view;
	private BRMainGuiController mainController;

	/**
	 * @param u
	 *            the entity of login user
	 * @param b
	 *            the view of the headpanel
	 * @param grpId
	 *            the id of the group that all the other tabs on main gui are
	 *            displaying
	 * **/
	public BRHeadPanelController(BRUser u, BRHeadPanel b, BRMainGuiController c) {
		this.model = u;
		this.view = b;
		this.mainController = c;
		this.refreshUI();
		this.view.registerListener(this);
		this.view.getBrSettings().registerListener(this);
	}

	/**
	 * TO set up all the gui parts, extracting data from model according to
	 * references.
	 * **/
	public void refreshUI() {
		String grpId = mainController.getSelectedGrp().getGroupId();
		System.out.println("The grop id in the maincontroller is " + grpId);
		String userName = this.model.getUserName();

		int numInGrp = this.model.getGroupSize(grpId);
		
		this.view.setText(this.model.getUserName(), grpId, numInGrp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("HeadPanelController is responding "
				+ e.getActionCommand());
		if (e.getActionCommand().equals("Settings")) {
			this.view.getBrSettings().setVisible(true);
		}
		if (e.getActionCommand().equals("Submit")) {
			String selectedRadioButtonText = this.view.getBrSettings()
					.getSelectedRadioButtonText();
			System.out.println(selectedRadioButtonText);
			if (selectedRadioButtonText.equals("Change Password")) {
				BRUser m = new BRUser("c", "d");
				ChangePasswordGUI v = new ChangePasswordGUI();
				BRChangePasswordController c = new BRChangePasswordController(
						m, v);
				v.registerListener(c);
				v.setVisible(true);
			}
		}
	}

	@Override
	protected void goToController(BRAbstractEntity e, BRAbstractController b) {
		// TODO Auto-generated method stub

	}

	public static void main(String args[]) {
		BRUser u = new BRUser();
		u.setUserEmail("lei@here.com");
		u.load();
		BRHeadPanel p = new BRHeadPanel();
		BRMainGuiController m = new BRMainGuiController(u);
		BRHeadPanelController c = new BRHeadPanelController(u, p, m);
		// p.getBrSettings().registerListener(c);
		// p.registerListener(c);
		JFrame frame = new JFrame();
		frame.add(p);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
