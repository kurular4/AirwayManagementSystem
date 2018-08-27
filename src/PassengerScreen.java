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
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassengerScreen extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private final JLabel lblFlghts = new JLabel("FLIGHTS");
	private JTable table_1;
	private JLabel lblEmployees;
	private JPanel panel;
	private JSeparator separator;
	private JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblTicketInformation;
	private JLabel lblTicketNo;
	private JLabel lblPassengerNo;
	private JLabel lblNewLabel_2;
	private JLabel lblArrival;
	private JLabel lblSeatNo;
	private JLabel lblDate;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JButton btnAdd_1;
	private JButton btnDelete_1;
	private JButton btnUpdate_1;
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
					PassengerScreen frame = new PassengerScreen(username, password, port);
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
	public PassengerScreen(String username, String password, String port) {
		this.username = username;
		this.password = password;
		this.port = port;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1074, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setTitle("Passenger Informations");
		
	    DefaultTableModel model2 = new DefaultTableModel();
	    model2.addColumn("Ssn");
	    model2.addColumn("Name");
	    model2.addColumn("Gender");
	    model2.addColumn("Birthdate");
	    model2.addColumn("Passenger No");

	    Object[] row = {"Ssn", "Name", "Gender", "Birthdate", "Passenger No"};
	    model2.addRow(row);
	    
		listPassengers(model2);
		table_1 = new JTable(model2);
		table_1.setBounds(0, 42, 1056, 293);
		contentPane.add(table_1);
		
		lblEmployees = new JLabel("PASSENGERS");
		lblEmployees.setBounds(475, 13, 98, 16);
		contentPane.add(lblEmployees);
		
		panel = new JPanel();
		panel.setBounds(10, 367, 502, 293);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(135, 49, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 52, 56, 16);
		panel.add(lblName);
		
		JLabel lblBirthdate = new JLabel("Birthdate");
		lblBirthdate.setBounds(12, 81, 56, 16);
		panel.add(lblBirthdate);
		
		JLabel lblSsn = new JLabel("Ssn");
		lblSsn.setBounds(12, 110, 56, 16);
		panel.add(lblSsn);
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setBounds(12, 139, 56, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Passenger No");
		lblNewLabel_1.setBounds(12, 168, 97, 16);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(135, 78, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(135, 107, 116, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(135, 136, 116, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(135, 165, 116, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblAddDeleteAnd = new JLabel("Add, Delete and Update Passenger");
		lblAddDeleteAnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDeleteAnd.setBounds(12, 13, 270, 23);
		panel.add(lblAddDeleteAnd);
		
		JButton btnAdd = new JButton("Add ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPassenger(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText());
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				model2.setRowCount(1);
				listPassengers(model2);
			}
		});
		
		btnAdd.setBounds(12, 205, 97, 25);
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePassenger(textField_2.getText());
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            textField.setText(table_1.getValueAt(table_1.getSelectedRow(), 1).toString());
				textField_1.setText(table_1.getValueAt(table_1.getSelectedRow(), 3).toString());
				textField_2.setText(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
				textField_3.setText(table_1.getValueAt(table_1.getSelectedRow(), 2).toString());
				textField_4.setText(table_1.getValueAt(table_1.getSelectedRow(), 4).toString());
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				fetchTicket(textField_4.getText(), textField_5, textField_6, textField_7, textField_8, textField_9, textField_10);
				textField_6.setText(textField_4.getText());
	        }
	    });
		
		btnDelete.setBounds(135, 205, 97, 25);
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePassenger(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText());
			}
		});
		
		btnUpdate.setBounds(262, 205, 97, 25);
		panel.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
					textField_9.setText("");
					textField_10.setText("");
		
			}
		});
		btnReset.setBounds(263, 48, 74, 25);
		panel.add(btnReset);
		
		separator = new JSeparator();
		separator.setBounds(0, 348, 1056, 2);
		contentPane.add(separator);
		
		panel_1 = new JPanel();
		panel_1.setBounds(542, 367, 502, 293);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblTicketInformation = new JLabel("Ticket Information");
		lblTicketInformation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTicketInformation.setBounds(12, 0, 269, 39);
		panel_1.add(lblTicketInformation);
		
		lblTicketNo = new JLabel("Ticket No");
		lblTicketNo.setBounds(12, 52, 89, 16);
		panel_1.add(lblTicketNo);
		
		lblPassengerNo = new JLabel("Passenger No");
		lblPassengerNo.setBounds(12, 80, 89, 16);
		panel_1.add(lblPassengerNo);
		
		lblNewLabel_2 = new JLabel("Destination");
		lblNewLabel_2.setBounds(12, 109, 89, 16);
		panel_1.add(lblNewLabel_2);
		
		lblArrival = new JLabel("Arrival");
		lblArrival.setBounds(12, 138, 73, 16);
		panel_1.add(lblArrival);
		
		lblSeatNo = new JLabel("Seat no");
		lblSeatNo.setBounds(12, 166, 56, 16);
		panel_1.add(lblSeatNo);
		
		lblDate = new JLabel("Date");
		lblDate.setBounds(12, 195, 56, 16);
		panel_1.add(lblDate);
		
		textField_5 = new JTextField();
		textField_5.setBounds(131, 49, 116, 22);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(131, 77, 116, 22);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(131, 106, 116, 22);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(131, 135, 116, 22);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(131, 163, 116, 22);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(131, 192, 116, 22);
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		
		btnAdd_1 = new JButton("Add");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTicket(textField_5.getText(), textField_6.getText(), textField_7.getText(), textField_8.getText(), textField_9.getText(), textField_10.getText());
			}
		});
		btnAdd_1.setBounds(12, 236, 97, 25);
		panel_1.add(btnAdd_1);
		
		btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteTicket(textField_5.getText());
			}
		});
		btnDelete_1.setBounds(131, 236, 97, 25);
		panel_1.add(btnDelete_1);
		
		btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTicket(textField_5.getText(), textField_6.getText(), textField_7.getText(), textField_8.getText(), textField_9.getText(), textField_10.getText());
			}
		});
		btnUpdate_1.setBounds(261, 236, 97, 25);
		panel_1.add(btnUpdate_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(524, 348, 9, 325);
		contentPane.add(separator_1);
	}
	
	public void listPassengers(DefaultTableModel model) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			PreparedStatement stmt = conn.prepareStatement("select * from PERSON AS PA JOIN PASSENGER AS PE ON PA.ssn = PE.ssn");
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				Object[] row = {res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(6)};
				model.addRow(row);
			}
			conn.close();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
	        System.exit(0);
		}
	}
	
	public void addPassenger(String name, String birthdate, String ssn, String gender, String passenger_no) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			String sql = "insert into person(ssn, name, gender, bdate) values ( ?, ? ,?, ?)";
			String sql2 = "insert into passenger(ssn, passenger_no) values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, Integer.parseInt(ssn));
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setString(4, birthdate);
			ps.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setLong(1, Integer.parseInt(ssn));
			ps2.setLong(2, Integer.parseInt(passenger_no));
			ps2.executeUpdate();
			
			conn.close();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
	        System.exit(0);
		}
	}
	
	public void deletePassenger(String ssn) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			String sql = "delete from passenger where ssn = ?";
			String sql2 = "delete from person where ssn = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, Integer.parseInt(ssn));
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setLong(1,Integer.parseInt(ssn));
			ps2.execute();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
	        System.exit(0);
		}
	}
	
	public void updatePassenger(String name, String birthdate, String ssn, String gender, String passenger_no) {
		try {
			  Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			  String query = "update person set ssn=?, name=?, gender=?, bdate=?  where ssn = ?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setInt   (1, Integer.parseInt(ssn));
		      preparedStmt.setString(2, name);
		      preparedStmt.setString(3, gender);
		      preparedStmt.setString(4, birthdate);
		      preparedStmt.setInt(5, Integer.parseInt(ssn));

		      String query2 = "update passenger set ssn=?, passenger_no=?  where ssn = ?";
		      PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
		      preparedStmt2.setInt(1, Integer.parseInt(ssn));
		      preparedStmt2.setInt(2, Integer.parseInt(passenger_no));
		      preparedStmt2.setInt(3, Integer.parseInt(ssn));

		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
		      preparedStmt2.executeUpdate();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
	        System.exit(0);
		}
	}
	
	public void fetchTicket(String passno, JTextField ticket_no, JTextField passenger_no, JTextField dest, JTextField arr, JTextField seat, JTextField date) {
		try {
			  Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			  String query = "select * from passenger as p join ticket as t on ?=t.passenger_no";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setInt(1, Integer.parseInt(passno));
			 ResultSet res = preparedStmt.executeQuery();
			  while(res.next()) {
				  ticket_no.setText(""+res.getInt(3));
				  passenger_no.setText(""+res.getInt(2));
				  dest.setText(""+res.getInt(5));
				  arr.setText(""+res.getInt(6));
				  seat.setText(res.getString(7));
				  date.setText(res.getString(8));
			 }
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
	        System.exit(0);
		}
	}
	
	public void addTicket(String ticket_no, String passenger_no, String destination_airport_code, String arrival_airport_code, String seat_no, String date) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			String sql = "insert into ticket(ticket_no, passenger_no, destination_airport_code, arrival_airport_code, seat_no, date) values ( ?, ? ,?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, Integer.parseInt(ticket_no));
			ps.setLong(2, Integer.parseInt(passenger_no));
			ps.setLong(3, Integer.parseInt(destination_airport_code));
			ps.setLong(4, Integer.parseInt(arrival_airport_code));
			ps.setString(5, seat_no);
			ps.setString(6, date);
			ps.executeUpdate();
			conn.close();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
	        System.exit(0);
		}
	}
	
	public void updateTicket(String ticket_no, String passenger_no, String destination_airport_code, String arrival_airport_code, String seat_no, String date) {
		try {
			  Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			  String query = "update ticket set ticket_no=?, passenger_no=?, destination_airport_code=?, arrival_airport_code=?, seat_no=?, date=? where ticket_no = ?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setInt   (1, Integer.parseInt(ticket_no));
		      preparedStmt.setInt(2, Integer.parseInt(passenger_no));
		      preparedStmt.setInt(3, Integer.parseInt(destination_airport_code));
		      preparedStmt.setInt(4, Integer.parseInt(arrival_airport_code));
		      preparedStmt.setString(5, seat_no);
		      preparedStmt.setString(6, date);
		      preparedStmt.setInt(7, Integer.parseInt(ticket_no));
			  preparedStmt.executeUpdate();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
	        System.exit(0);
		}
	}
	
	public void deleteTicket(String ticket_no) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			String sql = "delete from ticket where ticket_no = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, Integer.parseInt(ticket_no));
			ps.executeUpdate();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
	        System.exit(0);
		}
	}
}
