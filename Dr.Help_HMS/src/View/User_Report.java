/*
 * ITMD 510 - Object Oriented Application Development - Fall 2017
 * 
 * 
 * Project Name: Dr.Help -> Health Care Management System
 * 
 * 
 * Developed By: Anantharaman Chandar - A20403439
 *               Ashok Ramasami       - A20441032
 * 				 Gowrisankar Arumugam - A20400590					  -
 * 
 * Instructor: Prof. James Papademas 
*/

package View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.ResultSetFetch;

public class User_Report {

	public void getUserAppointment(String Start_Date, String End_Date) 
	{
		Models.ResultSetFetch MRS = new ResultSetFetch();
		Vector<Vector<Object>> records = new Vector<Vector<Object>>();
		Vector<String> columns = new Vector<String>();
		try
		{
			
		ResultSet rs = ResultSetFetch.getUserAppointment(Start_Date, End_Date);
		java.sql.ResultSetMetaData metaData = rs.getMetaData();
		int columnsCount = metaData.getColumnCount();

		// get column names from table!
		String cols = "";

		for (int i = 1; i <= columnsCount; i++) {
			cols = metaData.getColumnName(i);
			columns.add(cols);
		}
		// get row data from table!
		while (rs.next()) {
			Vector<Object> row = new Vector<Object>(columnsCount);

			for (int i = 1; i <= columnsCount; i++) {
				row.addElement(rs.getObject(i));
			}
			records.addElement(row);
		}
		rs.close();

		DefaultTableModel model = new DefaultTableModel(records, columns);

		JTable table = new JTable(model);
		
		JFrame frame = new JFrame("Doc_Report");
		frame.setSize(1500, 1500);
		frame.add(new JScrollPane(table));
		//frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
