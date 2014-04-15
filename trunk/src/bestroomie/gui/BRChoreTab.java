/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import bestroomie.controller.BRAbstractController;
import bestroomie.entities.BRBill;
import bestroomie.entities.BRChore;
import bestroomie.entities.BRChore;
import bestroomie.gui.BRChoreTab.JTableModel;import bestroomie.util.CATAGORY_INDEX;

public class BRChoreTab extends BRMainPanel {

//	private ArrayList
	private ArrayList<BRChore> oldChoreList;
	private ArrayList<BRChore> futureChoreList;
	private JTable oldTable;
	private JTable futureTable;
	private JScrollPane oldScrollPane;
	private JScrollPane futureScrollPane;
	private DefaultTableModel oldTableModel;
	private DefaultTableModel futureTableModel;
	String dataOld[][];
	String dataFuture[][];
	private static final String[] COLUMN_NAMES = new String[] {"Group", "Description", "Date", "Assignment","Completion"};
	private static final int COLUMN_NUM = COLUMN_NAMES.length;

	
	public BRChoreTab(ArrayList<BRChore> old, ArrayList<BRChore> future) {
		int wid = BRMainPanel.tabWidth;
		int height = BRMainPanel.tabHeight;
		this.setPreferredSize(new Dimension(wid,height));
		
		this.oldChoreList = old;
		this.futureChoreList = future;
			
		dataOld = new String[old.size()][COLUMN_NUM];
		for(int i=0;i<old.size();i++) {
			BRChore tmpChore = old.get(i);
			dataOld[i][0] = tmpChore.getChoreGroup();
			dataOld[i][1] = tmpChore.getChoreDescription();
			dataOld[i][2] = tmpChore.getChoreDate();
			dataOld[i][3] = tmpChore.getChoreAssignment();
			dataOld[i][4] = tmpChore.getChoreCompletion();
		}
		dataFuture = new String[old.size()][COLUMN_NUM];
		for(int i=0;i<future.size();i++) {
			BRChore tmpChore = future.get(i);
			dataFuture[i][0] = tmpChore.getChoreGroup();
			dataFuture[i][1] = tmpChore.getChoreDescription();
			dataFuture[i][2] = tmpChore.getChoreDate();
			dataFuture[i][3] = tmpChore.getChoreAssignment();
			dataFuture[i][4] = tmpChore.getChoreCompletion();
		}
		this.setupUI();
	}
	
	public void updateChoreLists(ArrayList<BRChore> old) {
		JTableModel.setOldArrayList(old);
		this.setupUI();
	}
	
	public void updateChoreListsFuture(ArrayList<BRChore> future) {
		JTableModel.setFutureArrayList(future);
		this.setupUI();
	}	
	
	public void setupUI() {
		this.oldTableModel = new DefaultTableModel(this.dataOld,COLUMN_NAMES);
		this.oldTable = new JTable(this.oldTableModel);
        this.oldScrollPane = new JScrollPane(this.oldTable);
		this.oldTable.setFillsViewportHeight(true);
		this.oldTable.setPreferredSize( new Dimension(BRMainPanel.tabWidth *9/10, BRMainPanel.tabWidth /3));
		this.oldScrollPane.setPreferredSize( new Dimension(BRMainPanel.tabWidth *9/10, BRMainPanel.tabWidth /3));
				
		this.oldTable.addMouseListener(new JTableButtonMouseListener(this.oldTable));
		
		this.futureTableModel = new DefaultTableModel(this.dataFuture,COLUMN_NAMES);
		this.futureTable = new JTable(this.futureTableModel);
		this.futureScrollPane = new JScrollPane(this.futureTable);
		this.futureTable.setFillsViewportHeight(true);;
		this.futureTable.setPreferredSize( new Dimension(BRMainPanel.tabWidth *9/10, BRMainPanel.tabWidth /3));
		this.futureScrollPane.setPreferredSize( new Dimension(BRMainPanel.tabWidth *9/10, BRMainPanel.tabWidth /3));
		
		this.futureTable.addMouseListener(new JTableButtonMouseListener(this.futureTable));

		this.add(this.futureScrollPane,BorderLayout.CENTER);
		this.add(this.oldScrollPane,BorderLayout.NORTH);
		
		JButton b = new JButton("Add Chore");
		this.add(b);
	}

	public static void main(String[] args) {
//		BRChoreTab tab = new BRChoreTab();
//		JFrame frame = new JFrame();
//		JTabbedPane jp = new JTabbedPane();
//		jp.addTab("Chore", tab);
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
		private static final String[] COLUMN_NAMES = new String[] {"Group", "Chore", "Date", "Assignment","Completion"};
		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class, String.class, String.class,  String.class,String.class};
		private static ArrayList<BRChore> oldChoreList;
		private static ArrayList<BRChore> futureChoreList;
		
		public static void setOldArrayList(ArrayList<BRChore> b) {
			oldChoreList = b;
		}

		public static void setFutureArrayList(ArrayList<BRChore> b) {
			futureChoreList = b;
		}
		
		@Override public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override public int getRowCount() {
			return JTableModel.futureChoreList.size();
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
			BRChore c = oldChoreList.get(rowIndex);
				
			switch (columnIndex) {
				case 0: return c.getChoreGroup();
				case 1: return c.getChoreDescription();
				case 2: return c.getChoreDate();
				case 3: return c.getChoreAssignment();
				case 4: return c.getChoreCompletion();
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
