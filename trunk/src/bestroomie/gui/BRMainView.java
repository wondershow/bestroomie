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

public class BRMainView extends BRAbstractView {
	
	private final JLabel mainView = new JLabel("This is the main view");

	private final JButton jbtCreateAccount = new JButton("Add Transaction");
	private final JButton jbtCancel = new JButton("Cancel");
	
	private final JLabel jlblStatus = new JLabel(" ");

	//getters
	
	//setters
	
	public void setupUI() {
        JPanel p1 = new JPanel(new GridLayout(5, 1));
        p1.add(jlblStatus);
        p1.add(mainView);

        JPanel p2 = new JPanel();
        p2.add(jbtCreateAccount);
        p2.add(jbtCancel);
        
        JPanel p3 = new JPanel(new BorderLayout());
        p3.add(p2, BorderLayout.CENTER);
		
        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public BRMainView () {
		this.setupUI();
      //%comments.
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
