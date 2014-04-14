package bestroomie.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bestroomie.controller.BRAbstractController;
import bestroomie.controller.BRChangePasswordController;
import bestroomie.util.BRConst;

public class ChangePasswordGUI extends BRAbstractView {
	
	private final JLabel jlblEmail = new JLabel("Email:");
	private final JLabel jlblOldPassword = new JLabel("Old Password:");
	private final JLabel jlblNewPassword = new JLabel("New Password:");
	private final JLabel jlblConfirmNewPassword = new JLabel("Confirm New Password:");

	private final JTextField jtfuName = new JTextField(15);
	private final JTextField jtfuEmail = new JTextField(20);
	private final JPasswordField jpfuOldPassword = new JPasswordField();
	private final JPasswordField jpfuNewPassword = new JPasswordField();
	private final JPasswordField jpfuConfirmNewPassword = new JPasswordField();

	private final JButton jbtChangePassword = new JButton("Change Password");
	private final JButton jbtCancel = new JButton("Cancel");
	
	private final JLabel jlblStatus = new JLabel(" ");
	
	public void reset() {
		this.jlblEmail.setText("");
		this.jlblOldPassword.setText("");
		this.jlblNewPassword.setText("");
		this.jlblConfirmNewPassword.setText("");
	}
	
	//private String uName = "";
	
	public String getuName() {
		return jtfuName.getText();
	}

	public String getuEmail() {
		return jtfuEmail.getText();
	}
	
	public String getuInputPass() {
		return jpfuOldPassword.getText();
	}
	
	public String getuInputNewPass() {
		return jpfuNewPassword.getText();
	}
	
	public String getuInputConfirmNewPass() {
		return jpfuConfirmNewPassword.getText();
	}
	
	public void setupUI() {
		
        
        JPanel p4 = new JPanel(new GridLayout(5, 1));
        p4.add(jlblEmail);
        p4.add(jtfuEmail);
        p4.add(jlblOldPassword);
        p4.add(jpfuOldPassword);
        p4.add(jlblNewPassword);
        p4.add(jpfuNewPassword);
        p4.add(jlblConfirmNewPassword);
        p4.add(jpfuConfirmNewPassword);
        p4.add(jlblStatus);

        JPanel p2 = new JPanel();
        p2.add(jbtChangePassword);
        p2.add(jbtCancel);
        
        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
		
        setLayout(new BorderLayout());
        add(p4, BorderLayout.CENTER);
        add(p5, BorderLayout.SOUTH);
        this.setTitle("Change Password");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public ChangePasswordGUI () {
		this.setupUI();
	}
	
	public static void main(String args[]) {
		ChangePasswordGUI test = new ChangePasswordGUI();
		test.setVisible(true);
	}
	
	public void displayView(String msg) {
		this.setVisible(true);
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public void displayView() {
		this.setVisible(true);
	}

	@Override
	public void registerListener(BRAbstractController a) {
		// TODO Auto-generated method stub
		jbtChangePassword.addActionListener(a);
		jbtCancel.addActionListener(a);
	}
}
