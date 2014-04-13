/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import bestroomie.controller.BRAbstractController;
import bestroomie.controller.BRAddBillController;
import bestroomie.controller.BRBillTabContoller;
import bestroomie.entities.BRBill;
import bestroomie.entities.BRGroup;
import bestroomie.entities.BRUser;
import bestroomie.util.CATAGORY_INDEX;

public class BRBillTab extends BRMainPanel implements ActionListener {
	
//	private ArrayList
	private JTable oldTable;
	private JTable impendingTable;
	private JScrollPane oldScrollPane;
	private JScrollPane impendingScrollPane;
	private String userId;
	private BRBillTabContoller bTabCtrl;
	private DefaultTableModel oldTableModel;
	private DefaultTableModel impendingTableModel;
	private static final String[] COLUMN_NAMES_OLD = new String[] {"Date", "TotalAmount", "Catagory", "Payee","Catagory"};
	private static final String[] COLUMN_NAMES_IMPENDING = new String[] {"Date", "TotalAmount", "Catagory", "Payee","Action"};
	private static final int COLUMN_NUM_OLD = COLUMN_NAMES_OLD.length;
	private static final int COLUMN_NUM_IMPENDING = COLUMN_NAMES_IMPENDING.length; 
	String dataOld[][];
	String dataImpending[][];
	private ArrayList<BRBill> oldBillList;
	private ArrayList<BRBill> impendingBillList;
	
	
	
	public BRBillTab(ArrayList<BRBill> old, ArrayList<BRBill> impending, String id) {
		
		this.oldBillList = old;
		this.impendingBillList = impending;
		
		int wid = BRMainPanel.tabWidth;
		int height = BRMainPanel.tabHeight;
		this.setPreferredSize(new Dimension(wid,height));
		
		dataOld = new String[old.size()][COLUMN_NUM_OLD];
		for(int i=0;i<old.size();i++) {
			BRBill tmpBill = old.get(i);
			dataOld[i][0] = tmpBill.getDate();
			dataOld[i][1] = Float.toString(tmpBill.getTotal_amount());
			dataOld[i][2] = CATAGORY_INDEX.getCatagoryString(tmpBill.getCatagory());
			dataOld[i][3] = tmpBill.getPayerListAsStr();
			dataOld[i][4] = CATAGORY_INDEX.getCatagoryString(tmpBill.getCatagory());
		}
		
//		DefaultTableModel defTableModel = new DefaultTableModel(dataOld,COLUMN_NAMES_OLD);
//	    JTable oldTable = new JTable(defTableModel);
//	    oldScrollPane = 
	    
		
		dataImpending = new String[impending.size()][COLUMN_NUM_IMPENDING];
		for(int i=0;i<impending.size();i++) {
			BRBill tmpBill = impending.get(i);
			dataImpending[i][0] = tmpBill.getDate();
			dataImpending[i][1] = Float.toString(tmpBill.getTotal_amount());
			dataImpending[i][2] = CATAGORY_INDEX.getCatagoryString(tmpBill.getCatagory());
			dataImpending[i][3] = tmpBill.getPayerListAsStr();
			dataImpending[i][4] = "Approve";
		}
		
//		ArrayList<BRBill> n = new ArrayList<BRBill> old;
//		OldJTableModel.setArrayList(old);
//		ImpendingJTableModel.setArrayList(impending);
		this.userId = id;
		this.setupUI();
	}
	
	public void setController(BRBillTabContoller c) {
		this.bTabCtrl = c;
//		ImpendingJTableModel.setController(this.bTabCtrl);
	}
	
	public void approveBill(int index) {
		this.bTabCtrl.approveTransaction(index);
		String[] tmp = new String[COLUMN_NUM_OLD];
		BRBill tmpBill = this.impendingBillList.get(index);
		this.impendingBillList.remove(index);
		System.out.println("I am modifying date" +  tmpBill.getDate());
		tmp[0] = tmpBill.getDate();
		tmp[1] = Float.toString(tmpBill.getTotal_amount());
		tmp[2] = CATAGORY_INDEX.getCatagoryString(tmpBill.getCatagory());
		tmp[3] = tmpBill.getPayerListAsStr();
		tmp[4] = CATAGORY_INDEX.getCatagoryString(tmpBill.getCatagory());
		this.oldTableModel.addRow(tmp);
	}
	
	
	public void updateBillLists(ArrayList<BRBill> old,ArrayList<BRBill> impending) {
//		OldJTableModel.setArrayList(old);
//		ImpendingJTableModel.setArrayList(impending);
//		ImpendingJTableModel.setController(this.bTabCtrl);
		System.out.println("I am removing all!!");
		this.removeAll();
		this.oldTable.removeRowSelectionInterval(1, 2);
//		this.revalidate();
//		this.repaint();
//		this.updateUI();
		//
		//this.setupUI();
	}
	
	public void setupUI() {
//		JTable historyTable = new JTable(new HistoryOldJTableModel());
//		JScrollPane scrollPane = new JScrollPane(historyTable);
//		historyTable.setFillsViewportHeight(true);
		
		this.oldTableModel = new DefaultTableModel(this.dataOld,COLUMN_NAMES_OLD);
		this.oldTable = new JTable(this.oldTableModel);
        this.oldScrollPane = new JScrollPane(this.oldTable);
		this.oldTable.setFillsViewportHeight(true);
		//this.oldTable.addMouseListener(new JTableButtonMouseListener(this.oldTable,this.impendingTableModel));
		//this.oldScrollPane.setPreferredSize( new Dimension(this.getSize().width,this.getSize().height/3)  );
		this.oldTable.setPreferredSize( new Dimension(BRMainPanel.tabWidth *9/10, BRMainPanel.tabWidth /3));
		this.oldScrollPane.setPreferredSize( new Dimension(BRMainPanel.tabWidth *9/10, BRMainPanel.tabWidth /3));
		
		
		//this.oldScrollPane.setMaximumSize( new Dimension(200,200));
		this.impendingTableModel = new DefaultTableModel(this.dataImpending,COLUMN_NAMES_IMPENDING);
		this.impendingTable = new JTable(this.impendingTableModel);
		this.impendingScrollPane = new JScrollPane(this.impendingTable);
		this.impendingTable.setFillsViewportHeight(true);
		this.impendingTable.addMouseListener(new JTableButtonMouseListener(this.impendingTable,this.impendingTableModel,this));
		this.impendingTable.setPreferredSize( new Dimension(BRMainPanel.tabWidth *9/10, BRMainPanel.tabWidth /3));
		this.impendingScrollPane.setPreferredSize( new Dimension(BRMainPanel.tabWidth *9/10, BRMainPanel.tabWidth /3));

		//this.impendingScrollPane.setPreferredSize( new Dimension()               );
		
		//table.getColumn("Button2").setCellRenderer(buttonRenderer);
		
		this.add(this.oldScrollPane,BorderLayout.NORTH);
		this.add(this.impendingScrollPane,BorderLayout.CENTER);
		JPanel p = new JPanel();
//		p.setPreferredSize(new Dimension(this.getSize().width,this.getSize().height/4));
		JButton b = new JButton("Add Bill");
		b.addActionListener(this);
//		this.add(p);
		this.add(b,BorderLayout.SOUTH);
		//this.add(comp)
	}

	public static void main(String[] args) {
		//BRBillTab tab = new BRBillTab();
//		JFrame frame = new JFrame();
//		JTabbedPane jp = new JTabbedPane();
//		jp.addTab("Bill", tab);
//		frame.add(jp);
//		frame.pack();
//		frame.setVisible(true);
//		frame.setLocationRelativeTo(null);
	}

	@Override
	public void registerListener(BRAbstractController a) {
		// TODO Auto-generated method stub
		
	}
	
	private static class JTableButtonMouseListener extends MouseAdapter {
    	private final JTable table;
    	private final DefaultTableModel model;
    	private BRBillTab parentTab;
    	
    	public JTableButtonMouseListener(JTable table,DefaultTableModel m,BRBillTab t) {
    		this.parentTab = t;
    		this.table = table;
    		this.model = m;
    	}
    	
    	

    	public void mouseClicked(MouseEvent e) {
    		int column = table.getColumnModel().getColumnIndexAtX(e.getX());
    		int row    = e.getY()/table.getRowHeight(); 
//    		this.model.addRow(new Object[]{7,7,7,7});
    		if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 4) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to approve this bill?","Warning",dialogButton);
				System.out.println("Row # is " + row);
				if(dialogResult == JOptionPane.YES_OPTION){
					this.model.removeRow(row);
					this.parentTab.approveBill(row);
//    		    Object value = table.getValueAt(row, column);
//    		    if (value instanceof JButton) {
//    		    	((JButton)value).doClick();
//    		    }
				}
    		}
    	}
	
//	public static class OldJTableModel extends AbstractTableModel {
//		private static final long serialVersionUID = 1L;
//		//private static final String[] COLUMN_NAMES = new String[] {"Date", "TotalAmount", "Catagory", "Payee","Catagory"};
//		//private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class, String.class, String.class,  String.class, JButton.class};
//		private static ArrayList<BRBill> billList;
//		
//		public static void setArrayList(ArrayList<BRBill> b) {
//			billList = b;
//		}
//		
//		@Override public int getColumnCount() {
//			return COLUMN_NAMES.length;
//		}
//
//		@Override public int getRowCount() {
//			return OldJTableModel.billList.size();
//		}
//		
//		@Override public String getColumnName(int columnIndex) {
//	        return COLUMN_NAMES[columnIndex];
//	    }
//		
//		@Override public Class<?> getColumnClass(int columnIndex) {
//			return COLUMN_TYPES[columnIndex];
//		}
//		
//		@Override 
//		public Object getValueAt(final int rowIndex, final int columnIndex) {
//			BRBill b = OldJTableModel.billList.get(rowIndex);
//			
//			
//			switch (columnIndex) {
//				case 0: return b.getDate();
//				case 1: return b.getTotal_amount();
//				case 2: return CATAGORY_INDEX.getCatagoryString(b.getCatagory());
//				case 3: return "4";
//				case 4: return "5";
//				default: return "Error";
//			}
//		}	
//	}
	
//	public static class ImpendingJTableModel extends AbstractTableModel {
//		private static final long serialVersionUID = 1L;
//		private static final String[] COLUMN_NAMES = new String[] {"Date", "TotalAmount", "Catagory", "Payee","Catagory","Approve"};
//		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class, String.class, String.class, String.class, String.class, String.class};
//		private static ArrayList<BRBill> impendingBillList;
//		private static BRBillTabContoller bTabCtrl;
//		
//		public static void setArrayList(ArrayList<BRBill> b) {
//			impendingBillList = b;
//		}
//		
//		@Override public int getColumnCount() {
//			return COLUMN_NAMES.length;
//		}
//		
//		public static void setController(BRBillTabContoller c) {
//			bTabCtrl = c;
//		}
//
//		@Override public int getRowCount() {
//			return ImpendingJTableModel.impendingBillList.size();
//		}
//		
//		@Override public String getColumnName(int columnIndex) {
//	        return COLUMN_NAMES[columnIndex];
//	    }
//		
//		@Override public Class<?> getColumnClass(int columnIndex) {
//			return COLUMN_TYPES[columnIndex];
//		}
//		
//		@Override 
//		public Object getValueAt(final int rowIndex, final int columnIndex) {
//			
//			BRBill b = ImpendingJTableModel.impendingBillList.get(rowIndex);
//			
//			switch (columnIndex) {
//				case 0: return b.getDate();
//				case 1: return b.getTotal_amount();
//				case 2: return CATAGORY_INDEX.getCatagoryString(b.getCatagory());
//				case 3: return "4";
//				case 4: return "5";
//				case 5: final JButton button = new JButton("Approve");
//						button.addActionListener(new ActionListener() {
//							public void actionPerformed(ActionEvent arg0) {
//								int dialogButton = JOptionPane.YES_NO_OPTION;
//								int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to approve this bill?","Warning",dialogButton);
//								if(dialogResult == JOptionPane.YES_OPTION){
//									//ImpendingJTableModel.bTabCtrl.approveTransaction(b.getTransId());
//									
//									bTabCtrl.approveTransaction(rowIndex);
//								}
//							}
//						});
//						return button;
//				default: return "Error";
//			}
//		}
//	}
	}
	
	private static class JTableButtonRenderer implements TableCellRenderer {
		@Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			JButton button = (JButton)value;
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
		    } else {
		    	button.setForeground(table.getForeground());
		    	button.setBackground(UIManager.getColor("Button.background"));
		    }
			return button;	
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		BRGroup grp = this.bTabCtrl.getMainController().getSelectedGrp();
		BRUser user = this.bTabCtrl.getUser();
		BRAddBillView v = new BRAddBillView(grp.getGroupMemberObjs(user.getUserEmail()), user,grp);
		BRAddBillController c = new BRAddBillController(user,grp,v);
		v.setVisible(true);
		v.setLocationRelativeTo(null);
	}
}
