import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JSeparator;

public class PlaneScreen extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	static String username;
	static String password;
	static String port;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaneScreen frame = new PlaneScreen(username, password, port);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlaneScreen(String username, String password, String port) {
		this.username = username;
		this.password = password;
		this.port = port;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 846, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setTitle("Plane Informations");

		DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("Plane_no");
	    model.addColumn("Made in");
	    model.addColumn("Made by");
	    model.addColumn("Distributor");
	    model.addColumn("Year");

	    Object[] row = {"Plane no", "Made in", "Made by", "Distrubitor", "Year"};
	    model.addRow(row);
		
		
	    DefaultTableModel model2 = new DefaultTableModel();
	    model2.addColumn("Plane_mechanic_no");
	    model2.addColumn("Employee_no");

	    Object[] row2 = {"Plane_mechanic_no", "Employee_no"};
	    model2.addRow(row2);
	    
	    
		JLabel lblPlanes = new JLabel("PLANES");
		lblPlanes.setBounds(369, 13, 56, 16);
		contentPane.add(lblPlanes);
		
		table = new JTable(model);
		table.setBounds(12, 42, 804, 246);
		contentPane.add(table);
		
		table_1 = new JTable(model2);
		table_1.setBounds(12, 312, 804, 150);
		contentPane.add(table_1);
		
		listPlanes(model);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	           model2.setRowCount(1);
	           listMechanics(table.getValueAt(table.getSelectedRow(), 0).toString(), model2);
	        }
	    });
	}
	
	public void listPlanes(DefaultTableModel model) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			PreparedStatement stmt = conn.prepareStatement("select * from plane");
			ResultSet res = stmt.executeQuery();
		    while(res.next()) {
		    	Object[] row = {res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)};
		    	model.addRow(row);
 		    }
			conn.close();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
		}		
	}
	
	public void listMechanics(String plane_no, DefaultTableModel model) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			PreparedStatement stmt = conn.prepareStatement("select * from plane_mechanic as pm join take_care as tc on pm.plane_mechanic_no = tc.plane_mechanic_no join plane as p on tc.plane_no = p.plane_no where p.plane_no=?");
			stmt.setInt(1, Integer.parseInt(plane_no));
			ResultSet res= stmt.executeQuery();
			  while(res.next()) {
			    	Object[] row = {res.getString(1), res.getString(2)};
			    	model.addRow(row);
	 		    }
		} catch (Exception e){
			System.out.print(e.getMessage().toString());
		}
	}
}
