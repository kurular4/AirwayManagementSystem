import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	String s_no = "";
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
					MainScreen frame = new MainScreen(username, password, port);
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
	public MainScreen(String username, String password, String port) {
		this.username = username;
		this.password = password;
		this.port = port;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setTitle("Main Menu");
		JPanel panel = new JPanel();
		panel.setBounds(8, 6, 738, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Passenger Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPassengerScreen();
			}
		});
		
		btnNewButton.setBounds(23, 9, 137, 60);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Employee Info");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openEmployeeScreen();
			}
		});
		btnNewButton_1.setBounds(213, 10, 144, 59);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Airport Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openAirportScreen();
			}
		});
		btnNewButton_2.setBounds(406, 9, 145, 60);
		panel.add(btnNewButton_2);
		
		JButton btnPlaneInfo = new JButton("Plane Info");
		btnPlaneInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPlaneScreen();
			}
		});
		btnPlaneInfo.setBounds(594, 9, 132, 60);
		panel.add(btnPlaneInfo);
		
		DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("Plane_no");
	    model.addColumn("Destination Airport");
	    model.addColumn("Arrival Airport");
	    model.addColumn("Date");
	    model.addColumn("Airport");
	    model.addColumn("Schedule no");
	    
	    Object[] row = {"Plane no", "Destination Airport", "Arrival Airport", "Date", "Airport", "Schedule no"};
	    model.addRow(row);
	    listFlights(model);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(8, 438, 943, 238);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(135, 46, 116, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(135, 75, 116, 22);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(135, 104, 116, 22);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(135, 133, 116, 22);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Plane no");
		lblNewLabel.setBounds(12, 49, 56, 16);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Arrival Airport");
		lblNewLabel_2.setBounds(12, 107, 111, 16);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(12, 136, 56, 16);
		panel_2.add(lblDate);
		
		JLabel lblDestinationAirport = new JLabel("Destination Airport");
		lblDestinationAirport.setBounds(12, 78, 111, 16);
		panel_2.add(lblDestinationAirport);
		
		JLabel lblAddDeleteAnd = new JLabel("Add, Delete and Update Flight");
		lblAddDeleteAnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDeleteAnd.setBounds(12, 20, 239, 16);
		panel_2.add(lblAddDeleteAnd);
		
		JLabel lblEmployeeInfoOf = new JLabel("Employee Info of The Flight");
		lblEmployeeInfoOf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeInfoOf.setBounds(389, 20, 204, 28);
		panel_2.add(lblEmployeeInfoOf);
		
		JLabel lblPilotNo = new JLabel("Pilot No");
		lblPilotNo.setBounds(389, 67, 56, 16);
		panel_2.add(lblPilotNo);
		
		JLabel lblHostessNo = new JLabel("Hostess No");
		lblHostessNo.setBounds(388, 102, 77, 16);
		panel_2.add(lblHostessNo);
		
		textField_4 = new JTextField();
		textField_4.setBounds(477, 64, 116, 22);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(477, 99, 116, 22);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFlight(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_6.getText());
				model.fireTableDataChanged();
			}
		});
		btnAdd.setBounds(12, 200, 97, 25);
		panel_2.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFlight(textField.getText(), textField_1.getText(), textField_2.getText(), textField_6.getText(), textField_3.getText());
			}
		});
		btnUpdate.setBounds(134, 200, 97, 25);
		panel_2.add(btnUpdate);
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteFlight();
			}
		});
		btnDelete.setBounds(257, 200, 97, 25);
		panel_2.add(btnDelete);
		
		JLabel lblAirport = new JLabel("Airport");
		lblAirport.setBounds(12, 165, 56, 16);
		panel_2.add(lblAirport);
		
		textField_6 = new JTextField();
		textField_6.setBounds(135, 165, 116, 22);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_6.setText("");
				textField_5.setText("");
				textField_4.setText("");
			}
		});
		btnReset.setBounds(257, 45, 65, 25);
		panel_2.add(btnReset);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(8, 431, 943, 2);
		contentPane.add(separator_1);
		
		table = new JTable(model);
		table.setBounds(8, 105, 943, 320);
		contentPane.add(table);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            textField.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				textField_1.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				textField_2.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				textField_3.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				textField_6.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				s_no = table.getValueAt(table.getSelectedRow(), 5).toString();
				listEmployee(textField.getText().toString(), textField_4, textField_5);
	        }
	    });
	    
	}
	
	public void listFlights(DefaultTableModel model) {
	try {
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
		PreparedStatement stmt = conn.prepareStatement("select * from AIRPORT_SCHEDULE as a join SCHEDULE as s on a.schedule_no=s.schedule_no");
		ResultSet res = stmt.executeQuery();
		while(res.next()) {
			Object[] row = {res.getString(2), res.getString(3), res.getString(4), res.getString(7) ,res.getString(5), res.getString(1)};
			model.addRow(row);
		}
		conn.close();
	} catch(Exception e) {
		JOptionPane.showMessageDialog(this, e.getMessage().toString());
		System.out.print(e.getMessage().toString());
	}
}
	
	public void  listEmployee(String plane_no , JTextField pilot, JTextField hostess) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			
			PreparedStatement stmt = conn.prepareStatement("select * from AIRPORT_SCHEDULE as a join DRIVES as d on a.plane_no = d.plane_no where a.plane_no = ?");
			stmt.setInt(1, Integer.parseInt(plane_no));
			ResultSet res = stmt.executeQuery();
			String pilots = "";
			while(res.next()) {
				System.out.println(res.getString(6));
				pilots = pilots + res.getString(6);
				pilots = pilots + ", ";
			}
			
			if(pilots.length() > 0)
				pilots = pilots.substring(0, pilots.length()-2);
			pilot.setText(pilots);			
			
			PreparedStatement stmt2 = conn.prepareStatement("select * from AIRPORT_SCHEDULE as a join HOST_AT as h on a.plane_no = h.plane_no where a.plane_no = ?");
			stmt2 .setInt(1, Integer.parseInt(plane_no));
			ResultSet res2 = stmt2.executeQuery();
			String hostesses = "";
			while(res2.next()) {
				hostesses = hostesses + res2.getString(6);
				System.out.println(res2.getString(6));
				hostesses = hostesses + ", ";
			}
			if(hostesses.length() > 0)
				hostesses = hostesses.substring(0, hostesses.length()-2);
			hostess.setText(hostesses);
			
			conn.close();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
		}
	}
	
	public void addFlight(String plane_no, String dest, String arr, String date, String airport) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			String sql = "insert into airport_schedule(schedule_no, plane_no, destination_airport_code, arrival_airport_code, airport_code) values ( ?, ? ,?, ?, ?)";
			String sql2 = "insert into schedule(schedule_no, schedule_date) values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			int s_no = (int) (Math.random()*1000+1);
			ps.setLong(2, Integer.parseInt(plane_no));
			ps.setInt(1, s_no);
			ps.setInt(3, Integer.parseInt(dest));
			ps.setInt(4, Integer.parseInt(arr));
			ps.setInt(5, Integer.parseInt(airport));
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, s_no);
			ps2.setString(2, date);
			
			ps2.executeUpdate();
			ps.executeUpdate();

			conn.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "You cannot add flight with unexisting plane or unexisting airport");
		}
	}
	
	public void deleteFlight() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			String sql = "delete from airport_schedule where schedule_no = ?";
			String sql2 = "delete from schedule where schedule_no = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(s_no));
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1,Integer.parseInt(s_no));
			ps2.executeUpdate();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
		}
	}
	
	public void updateFlight(String plane_no, String dest, String arr, String airport, String date) {
		try {
			  Class.forName("org.postgresql.Driver");
			  Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			  String query = "update airport_schedule set schedule_no=?, plane_no=?, destination_airport_code=? , arrival_airport_code=? , airport_code=? where schedule_no = ?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setInt   (1, Integer.parseInt(s_no));
		      preparedStmt.setInt(2, Integer.parseInt(plane_no));
		      preparedStmt.setInt(3,Integer.parseInt(dest));
		      preparedStmt.setInt(4, Integer.parseInt(arr));
		      preparedStmt.setInt(5, Integer.parseInt(airport));
		      preparedStmt.setInt(6, Integer.parseInt(s_no));
		      
		      String query2 = "update schedule set schedule_no=?, schedule_date=? where schedule_no = ?";
		      PreparedStatement preparedStmt2= conn.prepareStatement(query2);
		      preparedStmt2.setInt(1, Integer.parseInt(s_no));
		      preparedStmt2.setString(2, date);
		      preparedStmt2.setInt(3, Integer.parseInt(s_no));
		      
		      preparedStmt2.executeUpdate();
		      preparedStmt.executeUpdate();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
		}
	}
	
	public void openPassengerScreen() {
		PassengerScreen ps = new PassengerScreen(username, password, port);
		ps.main();
	}
	
	public void openEmployeeScreen() {
		EmployeeScreen es = new EmployeeScreen(username, password, port);
		es.main();
	}
	
	public void openAirportScreen() {
		AirportScreen as = new AirportScreen(username, password, port);
		as.main();
	}
	
	public void openPlaneScreen() {
		PlaneScreen ps = new PlaneScreen(username, password, port);
		ps.main();
	}
}
