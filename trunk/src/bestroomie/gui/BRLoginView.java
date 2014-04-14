package bestroomie.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
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
import bestroomie.util.BRConst;

public class BRLoginView extends BRAbstractView {
	
	private final JLabel jlblUsername = new JLabel("Username:");
	private final JLabel jlblPassword = new JLabel("Password:");
	private final JLabel jlblEmpty = new JLabel("Captcha:");
	private final JLabel jlblCaptcha = new JLabel("Input Captcha:");
	private JLabel captchLbl = null;
	JPanel captchaImgPnl;
	private JPanel motherPanel = null;
	
	private final JTextField jtfUsername = new JTextField(15);
	
	private final JTextField jtfCaptchaTxt = new JTextField(15);
	
	private final JPasswordField jpfPassword = new JPasswordField();
	
	private final JButton jbtOk = new JButton("Login");
	private final JButton jbtCancel = new JButton("Cancel");
	private final JButton jbtRegister = new JButton("Register");
	//private final JButton jbtAddUser = new JButton("Add User");
	private final JButton jbtChangePassword = new JButton("Change Password");
	
	private final JLabel jlblStatus = new JLabel(" ");
	
	
	public void reset() {
		this.jtfUsername.setText("");
		this.jpfPassword.setText("");
		this.jtfCaptchaTxt.setText("");
	}
	
	//private String uName = "";
	
	public String getuName() {
		return jtfUsername.getText();
	}

	public void setuName(String uName) {
		this.jtfUsername.setText(uName);
	}

	public String getuInputPass() {
		return jpfPassword.getText();
	}

	public void setuInputPass(String uInputPass) {
		//this.uInputPass = uInputPass;
	}
	
	public String getCaptchaText() {
		return jtfCaptchaTxt.getText().trim();
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
        p3.add(jlblUsername);
        p3.add(jlblPassword);
        
        JPanel p4 = new JPanel(new GridLayout(2, 1));
        p4.add(jtfUsername);
        p4.add(jpfPassword); */
		
		JPanel p3 = new JPanel(new GridLayout(1, 2));
		jlblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        p3.add(jlblUsername);
        p3.add(jtfUsername);
        
        JPanel p4 = new JPanel(new GridLayout(1, 2));
        jlblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        p4.add(jlblPassword);
        p4.add(jpfPassword);
        
        
        setupCaptchaImage();
		captchaImgPnl = new JPanel(new GridLayout(1, 2));
		captchaImgPnl.add(jlblEmpty);
		jlblEmpty.setHorizontalAlignment(SwingConstants.CENTER);
		captchaImgPnl.add(captchLbl);
		
		
		
		jtfCaptchaTxt.setText("");
		JPanel captChaTxtPnl = new JPanel(new GridLayout(1, 2));
		jlblCaptcha.setHorizontalAlignment(SwingConstants.CENTER);
		captChaTxtPnl.add(jlblCaptcha);
		captChaTxtPnl.add(jtfCaptchaTxt);
		

        
        JPanel p1 = new JPanel(new GridLayout(4, 1));
        p1.add(p3);
        p1.add(p4);
        p1.add(captchaImgPnl);
        p1.add(captChaTxtPnl);

        JPanel p2 = new JPanel();
        p2.add(jbtOk);
        p2.add(jbtCancel);
        p2.add(jbtRegister);
        p2.add(jbtChangePassword);

        
        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
        p5.add(jlblStatus, BorderLayout.NORTH);
        jlblStatus.setForeground(Color.RED);
        jlblStatus.setHorizontalAlignment(SwingConstants.CENTER); 
		
        
		
		
		
		
		
		
		
		/**
		JPanel usrRowPnl = new JPanel(new GridLayout(1, 2));
		usrRowPnl.add(jlblUsername);
		jtfUsername.setText("username");
		usrRowPnl.add(jtfUsername);
		
		JPanel emailRowPnl = new JPanel(new GridLayout(1, 2));
		emailRowPnl.add(jlblPassword);
		emailRowPnl.add(jpfPassword);
		
		
		
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
		
		jtfCaptchaTxt.setText("capthca");
		JPanel captChaTxtPnl = new JPanel(new GridLayout(1, 2));
		captChaTxtPnl.add(jlblCaptcha);
		captChaTxtPnl.add(jtfCaptchaTxt);
		
		
		JPanel p3 = new JPanel(new GridLayout(4, 1));
        p3.add(jlblUsername);
        p3.add(jlblPassword);
        p3.add(jlblEmpty);
        p3.add(jlblCaptcha);

        JPanel p4 = new JPanel(new GridLayout(4, 1));
        p4.add(jtfUsername);
        p4.add(jpfPassword);
        p4.add(captchLbl);
        p4.add(jtfCaptchaTxt);
        

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
        this.setTitle("Login");
		
	}
	
	public BRLoginView () {
		this.setupUI();
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
		jbtRegister.addActionListener(a);
//		jbtAddUser.addActionListener(a);
		jbtChangePassword.addActionListener(a);
	}
}
