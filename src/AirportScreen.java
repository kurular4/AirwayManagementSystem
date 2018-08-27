import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class AirportScreen extends JFrame {

	private JPanel contentPane;
	private JTable table;
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
					AirportScreen frame = new AirportScreen(username, password, port);
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
	public AirportScreen(String username, String password, String port) {
		this.username = username;
		this.password = password;
		this.port = port;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 912, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setTitle("Airport Informations");
		
		DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("Plane_no");
	    model.addColumn("Destination Airport");
	    model.addColumn("Arrival Airport");
	    model.addColumn("Date");
	    model.addColumn("Airport Code");
	    model.addColumn("Schedule no");
	    model.addColumn("Airport Name");

	    Object[] row = {"Plane no", "Destination Airport", "Arrival Airport", "Date", "Airport code", "Schedule no", "Airport Name"};
	    model.addRow(row);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 13, 179, 22);
		contentPane.add(comboBox);
		
		table = new JTable(model);
		table.setBounds(12, 62, 870, 400);
		contentPane.add(table);
		
		listAirports(comboBox);
		listFlights(comboBox.getSelectedItem().toString(), model);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				model.setRowCount(1);
				listFlights(comboBox.getSelectedItem().toString(), model);
			}
		});		
		
	}
	
	public void listAirports(JComboBox combo) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			PreparedStatement stmt = conn.prepareStatement("select * from airport_schedule as a JOIN schedule as s ON a.schedule_no = s.schedule_no join airport as ai on a.airport_code = ai.airport_code");
			ResultSet res = stmt.executeQuery();
		    while(res.next()) {
		    	combo.addItem(res.getString(9));
		    }
			conn.close();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
		}
	}
	
	public void listFlights(String name, DefaultTableModel model) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			PreparedStatement stmt = conn.prepareStatement("select * from airport_schedule as a JOIN schedule as s ON a.schedule_no = s.schedule_no join airport as ai on a.airport_code = ai.airport_code where ai.airport_name = ?");
			stmt.setString(1, name);
			ResultSet res = stmt.executeQuery();
		    while(res.next()) {
		    	Object[] row = {res.getString(2), res.getString(3) ,res.getString(4), res.getString(7), res.getString(5), res.getString(6), res.getString(9)};
		    	model.addRow(row);
		    }
			conn.close();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
		}
	}
}
