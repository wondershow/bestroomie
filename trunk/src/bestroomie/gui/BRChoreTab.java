/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.gui;

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
import javax.swing.table.TableCellRenderer;

import bestroomie.controller.BRAbstractController;
import bestroomie.entities.BRChore;
import bestroomie.entities.BRChore;
import bestroomie.gui.BRChoreTab.JTableModel;import bestroomie.util.CATAGORY_INDEX;

public class BRChoreTab extends BRMainPanel {

	private final JButton jbtShowChores = new JButton("Show Chores");
//	private ArrayList
	private ArrayList<BRChore> oldChoreList;
	private JTable oldTable;
	private JScrollPane oldScrollPane;
	
	public BRChoreTab(ArrayList<BRChore> old) {
		int wid = BRMainPanel.tabWidth;
		int height = BRMainPanel.tabHeight;
		this.setPreferredSize(new Dimension(wid,height));
		this.oldChoreList = old;
		JTableModel.setArrayList(old);
		this.setupUI();
	}
	
	public void updateChoreLists(ArrayList<BRChore> old) {
		JTableModel.setArrayList(old);
		this.setupUI();
	}
	
	public void setupUI() {
		this.oldTable = new JTable(new JTableModel());
        this.oldScrollPane = new JScrollPane(oldTable);
		this.oldTable.setFillsViewportHeight(true);
		
		this.oldTable.addMouseListener(new JTableButtonMouseListener(this.oldTable));
		
		this.add(this.oldScrollPane);
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
		System.out.println("test");
		jbtShowChores.addActionListener(a);

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
		private static ArrayList<BRChore> choreList;
		
		
		
		public static void setArrayList(ArrayList<BRChore> b) {
			choreList = b;
		}
		
		
		@Override public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override public int getRowCount() {
			return JTableModel.choreList.size();
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
			BRChore c = choreList.get(rowIndex);
			
			
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
