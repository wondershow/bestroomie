package bestroomie.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bestroomie.controller.BRAbstractController;
import bestroomie.controller.BRLoginController;
import bestroomie.test.DatePicker;
import bestroomie.util.BRConst;

public class BRAddBillView extends BRAbstractView {
	
	private final JLabel jlblDate = new JLabel("Date:");
	private final JLabel jlblAmount = new JLabel("Amount:");
	
	private final JLabel jlblPayee = new JLabel("Payee:");
	private JLabel captchLbl = null;
	JPanel captchaImgPnl;
	private JPanel motherPanel = null;
	
	private final JTextField jtfDate = new JTextField(15);
	
	private final JTextField jtfAmount = new JTextField(15);
	private final JTextField jtfPayeeTxt = new JTextField(15);
	
	private final JButton jbtOk = new JButton("Add");
	private final JButton jbtCancel = new JButton("Cancel");
	//private final JButton jbtRegister = new JButton("Register");
	//private final JButton jbtAddUser = new JButton("Add User");
	//private final JButton jbtChangePassword = new JButton("Change Password");
	
	private final JLabel jlblStatus = new JLabel(" ");
	
	private final JPanel p1 = new JPanel(new GridLayout(4, 1));
	
	public void reset() {
		this.jtfDate.setText("");
		this.jtfAmount.setText("");
		this.jtfPayeeTxt.setText("");
	}
	
	//private String uName = "";
	
	public String getuName() {
		return jtfDate.getText();
	}

	public void setuName(String uName) {
		this.jtfDate.setText(uName);
	}

	public String getuInputPass() {
		return jtfAmount.getText();
	}

	public void setuInputPass(String uInputPass) {
		//this.uInputPass = uInputPass;
	}
	
	public String getCaptchaText() {
		return jtfPayeeTxt.getText().trim();
	}
	
	public void setupCaptchaImage() {
		
		BufferedImage img;
		ImageIcon icon;
		
		try {
			img = ImageIO.read(new File(BRConst.CAPTCHA_FILE_PATH));
			icon = new ImageIcon(img);
			captchLbl = new JLabel(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void updateCaptchaImage() {
		
		BufferedImage img;
		ImageIcon icon;
		
		try {
			img = ImageIO.read(new File(BRConst.CAPTCHA_FILE_PATH));
			icon = new ImageIcon(img);
			captchLbl.setIcon(icon);
//			captchLbl = new JLabel(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private String uInputPass = "";
	
	
	
	
	
	public void setupUI() {
		
		/*
		JPanel p3 = new JPanel(new GridLayout(2, 1));
        p3.add(jlblDate);
        p3.add(jlblAmount);
        
        JPanel p4 = new JPanel(new GridLayout(2, 1));
        p4.add(jtfDate);
        p4.add(jtfAmount); */
		
		JPanel p3 = new JPanel(new GridLayout(1, 2));
		jlblDate.setHorizontalAlignment(SwingConstants.CENTER);
        p3.add(jlblDate);
        p3.add(jtfDate);
        
        JPanel p4 = new JPanel(new GridLayout(1, 2));
        jlblAmount.setHorizontalAlignment(SwingConstants.CENTER);
        p4.add(jlblAmount);
        p4.add(jtfAmount);
        
        
       
		
		
		
		jtfPayeeTxt.setText("");
		JPanel captChaTxtPnl = new JPanel(new GridLayout(1, 2));
		jlblPayee.setHorizontalAlignment(SwingConstants.CENTER);
		captChaTxtPnl.add(jlblPayee);
		captChaTxtPnl.add(jtfPayeeTxt);
		

        
     
        p1.add(p3);
        p1.add(p4);
        
        p1.add(captChaTxtPnl);

        JPanel p2 = new JPanel();
        p2.add(jbtOk);
        p2.add(jbtCancel);
        //p2.add(jbtRegister);
        //p2.add(jbtChangePassword);

        
        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
        p5.add(jlblStatus, BorderLayout.NORTH);
        jlblStatus.setForeground(Color.RED);
        jlblStatus.setHorizontalAlignment(SwingConstants.CENTER); 
		
        
		
		
		
		
		
		
		
		/**
		JPanel usrRowPnl = new JPanel(new GridLayout(1, 2));
		usrRowPnl.add(jlblDate);
		jtfDate.setText("username");
		usrRowPnl.add(jtfDate);
		
		JPanel emailRowPnl = new JPanel(new GridLayout(1, 2));
		emailRowPnl.add(jlblAmount);
		emailRowPnl.add(jtfAmount);
		
		
		
		BufferedImage img;
		ImageIcon icon;
		JLabel captchLbl = null;
		try {
			img = ImageIO.read(new File("C:/Users/aniu-lei/Desktop/tmp/image.jpg"));
			icon = new ImageIcon(img);
			captchLbl = new JLabel(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel captchaImgPnl = new JPanel(new GridLayout(1, 2));
		captchaImgPnl.add(jlblEmpty);
		captchaImgPnl.add(captchLbl);
		
		jtfPayeeTxt.setText("capthca");
		JPanel captChaTxtPnl = new JPanel(new GridLayout(1, 2));
		captChaTxtPnl.add(jlblPayee);
		captChaTxtPnl.add(jtfPayeeTxt);
		
		
		JPanel p3 = new JPanel(new GridLayout(4, 1));
        p3.add(jlblDate);
        p3.add(jlblAmount);
        p3.add(jlblEmpty);
        p3.add(jlblPayee);

        JPanel p4 = new JPanel(new GridLayout(4, 1));
        p4.add(jtfDate);
        p4.add(jtfAmount);
        p4.add(captchLbl);
        p4.add(jtfPayeeTxt);
        

        JPanel p1 = new JPanel();
        p1.add(usrRowPnl);
        p1.add(emailRowPnl);
        //p1.add(captchaImgPnl);
        //p1.add(captChaTxtPnl);
        
        

        JPanel p2 = new JPanel();
        p2.add(jbtOk);
        p2.add(jbtCancel);
        
       
		
//        JPanel p6 = new JPanel();
//        p6.add(captchLbl);
        
//        p2.add(jbtAddUser);
//        p2.add(jbtchangePassword);

        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
        p5.add(jlblStatus, BorderLayout.NORTH);
        jlblStatus.setForeground(Color.RED);
        jlblStatus.setHorizontalAlignment(SwingConstants.CENTER); **/
        
        
        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p5, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public BRAddBillView () {
		this.setupUI();
	}
	
	public static void main(String args[]) {
		
		BRAddBillView test = new BRAddBillView();
		test.setVisible(true);
	}
	
	public void displayView(String msg) {
		this.setVisible(true);
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public void setPayeeText(String s) {
		this.jtfPayeeTxt.setText(s);
	}
	
	
	public void displayView() {
		this.setVisible(true);
	}

	@Override
	public void registerListener(BRAbstractController a) {
		// TODO Auto-generated method stub
		jbtOk.addActionListener(a);
		jbtCancel.addActionListener(a);
		jtfDate.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ae) {
		    	  jtfDate.setText(new DatePicker(p1).setPickedDate());
		       }
		});
		//jbtRegister.addActionListener(a);
//		jbtAddUser.addActionListener(a);
		//jbtChangePassword.addActionListener(a);
	}
}
