import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BRChore {

	private JFrame frmBrchore;
	private JTable table;
	private JTextField txtKate;
	private JTextField txtCook;
	private JTextField txtWeekly;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BRChore window = new BRChore();
					window.frmBrchore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BRChore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrchore = new JFrame();
		frmBrchore.setTitle("BRChore");
		frmBrchore.setBounds(100, 100, 612, 415);
		frmBrchore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBrchore.getContentPane().setLayout(null);
		
		JLabel lblChoreList = new JLabel("Chore List");
		lblChoreList.setBounds(10, 28, 102, 15);
		frmBrchore.getContentPane().add(lblChoreList);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 291, 50, 15);
		frmBrchore.getContentPane().add(lblName);
		
		JLabel lblTask = new JLabel("Task");
		lblTask.setBounds(144, 291, 29, 15);
		frmBrchore.getContentPane().add(lblTask);
		
	
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel(
				new String[][] {
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
					},
					new String[] {
						"Name", "Task", "Frequency", "Finish"
					}
				);
		table.setModel(model);
		table.setBounds(10, 64, 576, 130);
//		JScrollPane jspane = new JScrollPane(table);
		frmBrchore.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Frequency");
		lblNewLabel.setBounds(275, 291, 66, 15);
		frmBrchore.getContentPane().add(lblNewLabel);
		
		txtKate = new JTextField();
		txtKate.setText("Kate");
		txtKate.setBounds(45, 288, 66, 21);
		frmBrchore.getContentPane().add(txtKate);
		txtKate.setColumns(10);
		
		txtCook = new JTextField();
		txtCook.setText("Cook");
		txtCook.setBounds(183, 288, 66, 21);
		frmBrchore.getContentPane().add(txtCook);
		txtCook.setColumns(10);
		
		txtWeekly = new JTextField();
		txtWeekly.setText("weekly");
		txtWeekly.setBounds(341, 288, 109, 21);
		frmBrchore.getContentPane().add(txtWeekly);
		txtWeekly.setColumns(10);
		
		 File file=new File(System.getProperty("user.dir")+"\\task.txt");
		 BufferedReader br = null;
		 try {
			   br=new BufferedReader(new FileReader(file));
		 }
		 catch (FileNotFoundException e) {
			   e.printStackTrace();
		 }

		 String line;
		 try {
			 while((line=br.readLine())!=null){
				 String Info[] = new String[4]; 
			     Info = line.split("\\,");
			     model.addRow(Info);
			 }
		 }
		 catch (IOException e1) {
			   e1.printStackTrace();
		}
		 
		 
		JButton btnNewButton_Add = new JButton("Add");
		btnNewButton_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Info[] = new String[4];
				Info[0] = txtKate.getText();
				Info[1] = txtCook.getText();
				Info[2] = txtWeekly.getText();
				Info[3] = "No";
				model.addRow(Info);
			}
		});
		btnNewButton_Add.setBounds(475, 287, 93, 23);
		frmBrchore.getContentPane().add(btnNewButton_Add);
		 
		 
	}
}
