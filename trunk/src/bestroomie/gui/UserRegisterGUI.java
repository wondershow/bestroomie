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
import bestroomie.util.BRConst;

public class UserRegisterGUI extends BRAbstractView {
	
	private final JLabel jlblName = new JLabel("Name:");
	private final JLabel jlblEmail = new JLabel("Email:");
	private final JLabel jlblPassword = new JLabel("Password:");
	private final JLabel jlblConfirmPassword = new JLabel("Confirm Password:");

	private final JTextField jtfuName = new JTextField(15);
	private final JTextField jtfuEmail = new JTextField(20);
	private final JPasswordField jpfuPassword = new JPasswordField();
	private final JPasswordField jpfuConfirmPassword = new JPasswordField();

	private final JButton jbtCreateAccount = new JButton("Create Account");
	private final JButton jbtCancel = new JButton("Cancel");
	
	private final JLabel jlblStatus = new JLabel(" ");
	
	public void reset() {
		this.jlblName.setText("");
		this.jlblEmail.setText("");
		this.jlblPassword.setText("");
		this.jlblConfirmPassword.setText("");
	}
	
	//private String uName = "";
	
	public String getuName() {
		return jtfuName.getText();
	}

	public String getuEmail() {
		return jtfuEmail.getText();
	}
	
	public String getuInputPass() {
		return jpfuPassword.getText();
	}
	
	public String getuInputConfirmPass() {
		return jpfuConfirmPassword.getText();
	}
	
	public void setupUI() {
		
        
        JPanel p4 = new JPanel(new GridLayout(5, 1));
        p4.add(jlblName);
        p4.add(jtfuName);
        p4.add(jlblEmail);
        p4.add(jtfuEmail);
        p4.add(jlblPassword);
        p4.add(jpfuPassword);
        p4.add(jlblConfirmPassword);
        p4.add(jpfuConfirmPassword);
        p4.add(jlblStatus);

        JPanel p2 = new JPanel();
        p2.add(jbtCreateAccount);
        p2.add(jbtCancel);
        
        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
		
        setLayout(new BorderLayout());
        add(p4, BorderLayout.CENTER);
        add(p5, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Register");
		
	}
	
	public UserRegisterGUI () {
		this.setupUI();
	}
	
	public static void main(String args[]) {
		UserRegisterGUI test = new UserRegisterGUI();
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
		jbtCreateAccount.addActionListener(a);
		jbtCancel.addActionListener(a);
	}
}
