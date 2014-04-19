package bestroomie.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import bestroomie.controller.BRAbstractController;

public class BRSettings extends BRAbstractView {

	private static final long serialVersionUID = 1L;
	static String changePassword = "Change Password";
	static String createGroup = "Create Group";
	static String addUser = "Add user to Group";
	static String removeUser = "Remove User from Group";
	JRadioButton chngePasswordButtn, createGroupButtn, deleteGroupButtn, addUserButton, removeUserButton, importButton, exportButton;
	JButton submitButton = new JButton("Submit");

	public BRSettings() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(50,50));
		// Create the radio buttons.
		chngePasswordButtn = new JRadioButton(changePassword);
		chngePasswordButtn.setSelected(true);
		createGroupButtn = new JRadioButton(createGroup);
		createGroupButtn.setSelected(false);
		addUserButton = new JRadioButton(addUser);
		addUserButton.setSelected(false);
		removeUserButton = new JRadioButton(removeUser);
		removeUserButton.setSelected(false);

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(chngePasswordButtn);
		group.add(createGroupButtn);
		group.add(addUserButton);
		group.add(removeUserButton);

		// this.add(settingsBtn,BorderLayout.EAST);
		submitButton.setSize(4, 4);
		mainPanel.add(submitButton, BorderLayout.SOUTH);

		// Put the radio buttons in a column in a panel.
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(chngePasswordButtn);
		radioPanel.add(createGroupButtn);
		radioPanel.add(addUserButton);
		radioPanel.add(removeUserButton);
		mainPanel.add(radioPanel, BorderLayout.LINE_START);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.setOpaque(true); // content panes must be opaque
		this.setContentPane(mainPanel);
		this.setTitle("Settings");
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// Display the window.
		this.pack();
		
	}

	public static void main(String[] args) {
		BRSettings brSettings = new BRSettings();
		brSettings.setVisible(true);
	}

	public String getSelectedRadioButtonText() {
		if (chngePasswordButtn.isSelected()) {
			return chngePasswordButtn.getText();
		}
		if (createGroupButtn.isSelected()) {
			return createGroupButtn.getText();
		}
		if (addUserButton.isSelected()) {
			return addUserButton.getText();
		}
		if (removeUserButton.isSelected()) {
			return removeUserButton.getText();
		}
		return null;
	}

	@Override
	public void registerListener(BRAbstractController a) {
		// Register a listener for the radio buttons.
		submitButton.addActionListener(a);
	}
}
