package bestroomie.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import bestroomie.db.readDatabase;
import bestroomie.db.writeDatabase;

public class TestFrame extends JFrame {

	public boolean validUser = false;
	
    private PassWordDialog passDialog;

    public TestFrame() {
        passDialog = new PassWordDialog(this, true);
        passDialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new TestFrame();
                frame.getContentPane().setBackground(Color.BLACK);
                frame.setTitle("Logged In");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
    }
}

class PassWordDialog extends JDialog {

    private final JLabel jlblUsername = new JLabel("Username");
    private final JLabel jlblPassword = new JLabel("Password");

    private final JTextField jtfUsername = new JTextField(15);
    private final JPasswordField jpfPassword = new JPasswordField();

    private final JButton jbtOk = new JButton("Login");
    private final JButton jbtCancel = new JButton("Cancel");
    private final JButton jbtAddUser = new JButton("Add User");
    private final JButton jbtchangePassword = new JButton("Change Password");

    private final JLabel jlblStatus = new JLabel(" ");

    public PassWordDialog() {
        this(null, true);
    }

    public PassWordDialog(final JFrame parent, boolean modal) {
        super(parent, modal);

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

        addWindowListener(new WindowAdapter() {  
            @Override
            public void windowClosing(WindowEvent e) {  
                System.exit(0);
            }  
        });

        //Action listener for the "OK" button
        //Validates if the username/password entered is in the database
        jbtOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println(jtfUsername.getText() + ": " + jpfPassword.getText());
                if (readDatabase.validateUser(jtfUsername.getText(), jpfPassword.getText())) {
                    parent.setVisible(true);
                    setVisible(false);
                } else {
                    jlblStatus.setText("Invalid username or password");
                }
            }
        });
        
        //Action listener for the "Cancel" button
        //Exits the program
        jbtCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                parent.dispose();
                System.exit(0);
            }
        });
        
        //Action listener for the "Add User" button
        //Adds the user to the database with "N/A" for the name and the groups
        jbtAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println(jtfUsername.getText() + ": " + jpfPassword.getText());
            	writeDatabase.addUser(jtfUsername.getText(), jpfPassword.getText());
            	
                jlblStatus.setText("User Has been added");
            }
        });
        
        //Action listener for the "Change Password" button
        //Takes the given email and, if it exists in the database, changes the password for the user
        jbtchangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println(jtfUsername.getText() + ": " + jpfPassword.getText());
            	writeDatabase.changePassword(jtfUsername.getText(), jpfPassword.getText());
            	
                jlblStatus.setText("User password has been changed");
            }
        });
    }
}