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
import bestroomie.controller.BRLoginController;


public class BRLoginView extends BRAbstractView {
	
	private final JLabel jlblUsername = new JLabel("Username");
	private final JLabel jlblPassword = new JLabel("Password");
	private final JTextField jtfUsername = new JTextField(15);
	private final JPasswordField jpfPassword = new JPasswordField();
	
	private final JButton jbtOk = new JButton("Login");
	private final JButton jbtCancel = new JButton("Cancel");
	private final JButton jbtAddUser = new JButton("Add User");
	private final JButton jbtchangePassword = new JButton("Change Password");
	
	private final JLabel jlblStatus = new JLabel(" ");
	
	
	public void reset() {
		this.jtfUsername.setText("");
		this.jpfPassword.setText("");
	}
	
	//private String uName = "";
	
	public String getuName() {
		return jtfUsername.getText();
	}

	public void setuName(String uName) {
		this.jtfUsername.setText(uName);
	}

	public String getuInputPass() {
		return jpfPassword.getPassword().toString();
	}

	public void setuInputPass(String uInputPass) {
		//this.uInputPass = uInputPass;
	}

	private String uInputPass = "";
	
	public BRLoginView () {
		JPanel p3 = new JPanel(new GridLayout(2, 1));
        p3.add(jlblUsername);
        p3.add(jlblPassword);

        JPanel p4 = new JPanel(new GridLayout(2, 1));
        p4.add(jtfUsername);
        p4.add(jpfPassword);

        JPanel p1 = new JPanel();
        p1.add(p3);
        p1.add(p4);

        JPanel p2 = new JPanel();
        p2.add(jbtOk);
        p2.add(jbtCancel);
        p2.add(jbtAddUser);
        p2.add(jbtchangePassword);

        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
        p5.add(jlblStatus, BorderLayout.NORTH);
        jlblStatus.setForeground(Color.RED);
        jlblStatus.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p5, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		
		BRLoginView test = new BRLoginView();
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
		jbtOk.addActionListener(a);
		jbtCancel.addActionListener(a);
		jbtAddUser.addActionListener(a);
		jbtchangePassword.addActionListener(a);
	}
}
