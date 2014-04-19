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
import bestroomie.controller.BRAddUsertoGroupController;
import bestroomie.util.BRConst;

public class BRAddUserToGroupGUI extends BRAbstractView {
	
	private final JLabel jlblEmail = new JLabel("Email of user to add to group:");

	private final JTextField jtfuEmail = new JTextField(20);

	private final JButton jbtAddUser = new JButton("Add User");
	private final JButton jbtCancel = new JButton("Cancel");
	
	private final JLabel jlblStatus = new JLabel(" ");
	
	public void reset() {
		this.jlblEmail.setText("");
	}
	
	//private String uName = "";
	


	public String getuEmail() {
		return jtfuEmail.getText();
	}
	
	public void setupUI() {
		
        
        JPanel p4 = new JPanel(new GridLayout(3, 1));
        p4.add(jlblStatus);
        p4.add(jlblEmail);
        p4.add(jtfuEmail);
        p4.add(jlblStatus);

        JPanel p2 = new JPanel();
        p2.add(jbtCancel);
        p2.add(jbtAddUser);
        
        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
		
        setLayout(new BorderLayout());
        add(p4, BorderLayout.CENTER);
        add(p5, BorderLayout.SOUTH);
        this.setTitle("Add User");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public BRAddUserToGroupGUI () {
		this.setupUI();
	}
	
	public static void main(String args[]) {
		BRAddUserToGroupGUI test = new BRAddUserToGroupGUI();
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
		jbtAddUser.addActionListener(a);
		jbtCancel.addActionListener(a);
	}
}
