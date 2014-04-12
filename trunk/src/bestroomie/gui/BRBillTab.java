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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import bestroomie.controller.BRAbstractController;
import bestroomie.entities.BRBill;
import bestroomie.test.ButtonExample.JTableModel;
import bestroomie.util.CATAGORY_INDEX;

public class BRBillTab extends BRMainPanel {
	
//	private ArrayList
	private ArrayList<BRBill> oldBillList;
	private JTable oldTable;
	private JScrollPane oldScrollPane;
	
	
	public BRBillTab(ArrayList<BRBill> old) {
		int wid = BRMainPanel.tabWidth;
		int height = BRMainPanel.tabHeight;
		this.setPreferredSize(new Dimension(wid,height));
		this.oldBillList = old;
		JTableModel.setArrayList(old);
		this.setupUI();
	}
	
	public void updateBillLists(ArrayList<BRBill> old) {
		JTableModel.setArrayList(old);
		this.setupUI();
	}
	
	public void setupUI() {
//		JTable historyTable = new JTable(new HistoryJTableModel());
//		JScrollPane scrollPane = new JScrollPane(historyTable);
//		historyTable.setFillsViewportHeight(true);
		
		this.oldTable = new JTable(new JTableModel());
        this.oldScrollPane = new JScrollPane(oldTable);
		this.oldTable.setFillsViewportHeight(true);
		
		//TableCellRenderer buttonRenderer = new JTableButtonRenderer();
		//table.getColumn("Button1").setCellRenderer(buttonRenderer);
		//table.getColumn("Button2").setCellRenderer(buttonRenderer);
		this.oldTable.addMouseListener(new JTableButtonMouseListener(this.oldTable));
		
		this.add(this.oldScrollPane);
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

	
	
	
	public static class HistoryJTableModel extends AbstractTableModel {
		
		//private static 
		private static final String[] COLUMN_NAMES = new String[] {"Catagory", "Payer", "Amount", "Payee"};
		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class, String.class, Integer.class,  String.class};
		
		
		
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return COLUMN_NAMES.length;
		}

		@Override
		public int getRowCount() {
			return 0;
		}

		@Override
		public Object getValueAt(final int rowIndex, final int columnIndex) {
				switch (columnIndex) {
				case 0: return rowIndex;
				case 1: return "Text for " + rowIndex;
				case 2: // fall through
				case 3: final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button), 
										"Button clicked for row "+rowIndex);
							}
						});
						return button;
				default: return "Error";
			}
		} 
		
		
		
	}
	
	private static class JTableButtonMouseListener extends MouseAdapter {
		private final JTable table;
		
		public JTableButtonMouseListener(JTable table) {
			this.table = table;
		}

		public void mouseClicked(MouseEvent e) {
			int column = table.getColumnModel().getColumnIndexAtX(e.getX());
			int row    = e.getY()/table.getRowHeight(); 

			if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
			    Object value = table.getValueAt(row, column);
			    if (value instanceof JButton) {
			    	((JButton)value).doClick();
			    }
			}
		}
	}
	
	
	public static class JTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private static final String[] COLUMN_NAMES = new String[] {"Date", "TotalAmount", "Catagory", "Payee","Catagory"};
		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class, String.class, String.class,  String.class,String.class};
		private static ArrayList<BRBill> billList;
		
		
		
		public static void setArrayList(ArrayList<BRBill> b) {
			billList = b;
		}
		
		
		@Override public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override public int getRowCount() {
			return JTableModel.billList.size();
		}
		
		@Override public String getColumnName(int columnIndex) {
	        return COLUMN_NAMES[columnIndex];
	    }
		
		@Override public Class<?> getColumnClass(int columnIndex) {
			return COLUMN_TYPES[columnIndex];
		}
		
		
		/***
		 * private String transId;
		   private String group;
		   private CATAGORY_INDEX catagory; 
		   private String date;
		   private String[] payerList;
		    private float[] amountList; 
			private boolean[] approvalList;
			private boolean[] paidList;
			private String description;
			private float total_amount;
		 * **/
		@Override 
		public Object getValueAt(final int rowIndex, final int columnIndex) {
			BRBill b = billList.get(rowIndex);
			
			
			switch (columnIndex) {
				case 0: return b.getDate();
				case 1: return b.getTotal_amount();
				case 2: return CATAGORY_INDEX.getCatagoryString(b.getCatagory());
				case 3: return "4";
				case 4: return "5";
				default: return "Error";
			}
		}	
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
}
