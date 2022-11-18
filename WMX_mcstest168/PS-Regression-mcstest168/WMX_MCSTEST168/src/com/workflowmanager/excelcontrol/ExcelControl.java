package com.workflowmanager.excelcontrol;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.workflowmanager.datasource.Xls_Reader;

public class ExcelControl extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final String sheetName = "Executable Suite";
	private boolean DEBUG = false;
	public static Xls_Reader xls = null;
	static JTable table;
	DefaultTableModel dtm;
	static String frameTitle = "Workflow Manager: Automation Test Case Controller";
	String panelTitle = "Workflow Manager Automation Test Suite";

	public ExcelControl() {
		super(new GridLayout(1,0));

		//Populate data from excel
		try {
		populateDataFromExcel();
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading data. Please check the Excel!");
		}


		table.setPreferredScrollableViewportSize(new Dimension(800, 300));
		table.setFillsViewportHeight(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);

		//center Align text
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		//table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		if (DEBUG) {
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					printDebugData(table);
				}
			});
		}
		// Set custom price color renderer
		//		TableRowColorRenderer colorRenderer = new TableRowColorRenderer();
		//		table.setDefaultRenderer(Object.class, colorRenderer);

		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(800, 300));
		scrollpane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), panelTitle ,
				TitledBorder.CENTER, TitledBorder.TOP));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(scrollpane);
		panel.setAlignmentY(CENTER_ALIGNMENT);		
		panel.setAlignmentX(CENTER_ALIGNMENT);		

		//Add Save Button
		JButton saveBtn = new JButton("SAVE");
		//saveBtn.setPreferredSize(new Dimension(20, 30));
		saveBtn.setAlignmentY(CENTER_ALIGNMENT);
		saveBtn.setAlignmentX(CENTER_ALIGNMENT);
		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveToExcel();
			}
		});
		panel.add(saveBtn);

		add(panel);

	}

	private void populateDataFromExcel() {
		dtm = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column == 3)
					return true;
				else
					return false;
			}
		};
		dtm.setColumnIdentifiers(new Object[]{"Sno", "Test Scenario", "Test Case", "Runmode"});

		int sno = 1;
		for(int i=2; i <= xls.getRowCount(sheetName) ;i++ ){
			String testScenario = xls.getCellData(sheetName, "Test Scenario", i);
			String testCase = xls.getCellData(sheetName, "Test Case", i);
			String runmode = xls.getCellData(sheetName, "Runmode", i);
			boolean executable = false;
			if(runmode.equalsIgnoreCase("Y"))
				executable = true; 
			//add row in dtm
			dtm.addRow(new Object[]{sno++, testScenario, testCase, executable});
		}

		table = new JTable(dtm) {
			private static final long serialVersionUID = 1L;

			/*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Integer.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table.setModel(dtm);		
	}
	private void saveToExcel() {
		//Iterate through the dtm and write the data to excel.
		try {
			for (int i = 0; i < dtm.getRowCount(); i++) {
				boolean value = (boolean) dtm.getValueAt(i, 3);
				String data = "N";
				if(value)
					data = "Y";
				xls.setCellData(sheetName, "Runmode", i+2, data);
			}
			JOptionPane.showMessageDialog(null, "Your changes have been saved Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Your changes could not be saved. Please try again!");
		}
	}
	private void printDebugData(JTable table) {
		int numRows = table.getRowCount();
		int numCols = table.getColumnCount();
		javax.swing.table.TableModel model = table.getModel();

		System.out.println("Value of data: ");
		for (int i=0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j=0; j < numCols; j++) {
				System.out.print("  " + model.getValueAt(i, j));
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame(frameTitle);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		ExcelControl newContentPane = new ExcelControl();
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);
		frame.setLocation(200, 100);

		//Display the window.
		frame.pack();
		frame.setVisible(true);

	}

	public static void main(String[] args) {

		excelSetup();

		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	static void excelSetup(){
		xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\workflowmanager\\datasource\\DataSourceFile_WorkFlowManager.xlsx");
	}
	
}