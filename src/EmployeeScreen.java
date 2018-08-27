import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EmployeeScreen extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
    private String which;
    private JLabel lblPilotNo;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblSsn;
    private JLabel lblStartDate;
    private JLabel lblSalary;
    private JLabel lblName;
    private JLabel lblGender;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JButton btnReset;
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
					EmployeeScreen frame = new EmployeeScreen(username, password, port);
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
	public EmployeeScreen(String username, String password, String port) {
		this.username = username;
		this.password = password;
		this.port = port;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1063, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setTitle("Employee Informations");

		DefaultTableModel modelPilot = new DefaultTableModel();
		modelPilot.addColumn("Pilot no");
		modelPilot.addColumn("Employee no");
		modelPilot.addColumn("Level");
		modelPilot.addColumn("Ssn");
		modelPilot.addColumn("Start Date");
		modelPilot.addColumn("Salary");
		modelPilot.addColumn("Name");
		modelPilot.addColumn("Gender");
	    Object[] row = {"Pilot no", "Employee no",  "Level", "Ssn", "Start Date", "Salary", "Name", "Gender"};
	    modelPilot.addRow(row);
	    
	    DefaultTableModel modelHostess = new DefaultTableModel();
	    modelHostess.addColumn("Hostess no");
	    modelHostess.addColumn("Employee no");
	    modelHostess.addColumn("Level");
	    modelHostess.addColumn("Ssn");
	    modelHostess.addColumn("Start Date");
	    modelHostess.addColumn("Salary");
	    modelHostess.addColumn("Name");
	    modelHostess.addColumn("Gender");
	    Object[] row2 = {"Hostess no", "Employee no", "Level", "Ssn", "Start Date", "Salary", "Name", "Gender"};
	    modelHostess.addRow(row2);
	    
	    DefaultTableModel modelMechanic = new DefaultTableModel();
	    modelMechanic.addColumn("Pilot no");
	    modelMechanic.addColumn("Employee no");
	    modelMechanic.addColumn("Ssn");
	    modelMechanic.addColumn("Start Date");
	    modelMechanic.addColumn("Salary");
	    modelMechanic.addColumn("Name");
	    modelMechanic.addColumn("Gender");
	    Object[] row3 = {"Mechanic no", "Employee no", "Ssn", "Start Date", "Salary", "Name", "Gender"};
	    modelMechanic.addRow(row3);
	    
	    
		JButton btnPilot = new JButton("Pilot");
		btnPilot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelPilot.setRowCount(1);
				 lblNewLabel_1.setVisible(true);
				textField_2.setVisible(true);
				which = "pilot";
				table.setVisible(true);
				table_1.setVisible(false);
				table_2.setVisible(false);
				lblPilotNo.setText("Pilot no");
				lblNewLabel.setText("Employee no");
				lblNewLabel_1.setText("Level");
				lblSsn.setText("Ssn");
				lblStartDate.setText("Start Date");
				lblSalary.setText("Salary");
				lblName.setText("Name");
				lblGender.setText("Gender");
			    textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				listPilots(modelPilot);
			}
		});
		
		btnPilot.setBounds(12, 13, 97, 25);
		contentPane.add(btnPilot);
		
		JButton btnHostess = new JButton("Hostess");
		btnHostess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelHostess.setRowCount(1);
				which = "hostess";
				table_1.setVisible(true);
				table.setVisible(false);
				table_2.setVisible(false);
				lblPilotNo.setText("Hostess no");
				lblNewLabel.setText("Employee no");
				lblNewLabel_1.setText("Level");
				lblSsn.setText("Ssn");
				lblStartDate.setText("Start Date");
				lblSalary.setText("Salary");
				lblName.setText("Name");
				lblGender.setText("Gender");
			    textField.setText("");
			    lblNewLabel_1.setVisible(true);
				textField_2.setVisible(true);
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				listHostesses(modelHostess);
			}
		});
		btnHostess.setBounds(121, 13, 97, 25);
		contentPane.add(btnHostess);
		
		JButton btnMechanic = new JButton("Mechanic");
		btnMechanic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelMechanic.setRowCount(1);
				which = "mechanic";
				table_2.setVisible(true);
				table_1.setVisible(false);
				table.setVisible(false);
				lblPilotNo.setText("Mechanic no");
				lblNewLabel.setText("Employee no");
				lblNewLabel_1.setVisible(false);
				textField_2.setVisible(false);
				lblSsn.setText("Ssn");
				lblStartDate.setText("Start Date");
				lblSalary.setText("Salary");
				lblName.setText("Name");
				lblGender.setText("Gender");
			    textField.setText("");
				textField_1.setText("");
				//textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				listMechanics(modelMechanic);
			}
		});
		btnMechanic.setBounds(230, 13, 97, 25);
		contentPane.add(btnMechanic);
	
		table = new JTable(modelPilot);
		table.setBounds(12, 55, 1021, 275);
		contentPane.add(table);
		
		table_1 = new JTable(modelHostess);
		table_1.setBounds(12, 55, 1021, 275);
		contentPane.add(table_1);

		table_2 = new JTable(modelMechanic);
		table_2.setBounds(12, 55, 1021, 275);
		contentPane.add(table_2);
		
		lblPilotNo = new JLabel("Pilot no");
		lblPilotNo.setBounds(12, 366, 78, 16);
		contentPane.add(lblPilotNo);
		
		lblNewLabel = new JLabel("Employee no");
		lblNewLabel.setBounds(12, 411, 78, 16);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Level");
		lblNewLabel_1.setBounds(12, 453, 78, 16);
		contentPane.add(lblNewLabel_1);
		
		lblSsn = new JLabel("Ssn");
		lblSsn.setBounds(254, 366, 78, 16);
		contentPane.add(lblSsn);
		
		lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(254, 411, 78, 16);
		contentPane.add(lblStartDate);
		
		lblSalary = new JLabel("Salary");
		lblSalary.setBounds(254, 453, 71, 16);
		contentPane.add(lblSalary);
		
		lblName = new JLabel("Name");
		lblName.setBounds(500, 366, 78, 16);
		contentPane.add(lblName);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(500, 411, 78, 16);
		contentPane.add(lblGender);
		
		textField = new JTextField();
		textField.setBounds(102, 363, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 408, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(102, 450, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(338, 363, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(339, 408, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(338, 450, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(567, 363, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(567, 408, 116, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(which.equals("pilot"))
					addPilot(textField_3.getText(), textField_6.getText(), textField_7.getText(), "", textField_1.getText(), textField_4.getText(), textField_5.getText(), textField.getText(), textField_2.getText());
				else if(which.equals("hostess"))
					addHostess(textField_3.getText(), textField_6.getText(), textField_7.getText(), "", textField_1.getText(), textField_4.getText(), textField_5.getText(), textField.getText(), textField_2.getText());
				else if(which.equals("mechanic"))
					addMechanic(textField_3.getText(), textField_6.getText(), textField_7.getText(), "", textField_1.getText(), textField_4.getText(), textField_5.getText(), textField.getText());
			}
		});
		
		btnAdd.setBounds(12, 519, 97, 25);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(which.equals("pilot"))
					updatePilot(textField_3.getText(), textField_6.getText(), textField_7.getText(), "", textField_1.getText(), textField_4.getText(), textField_5.getText(), textField.getText(), textField_2.getText());
				else if(which.equals("hostess"))
					updateHostess(textField_3.getText(), textField_6.getText(), textField_7.getText(), "", textField_1.getText(), textField_4.getText(), textField_5.getText(), textField.getText(), textField_2.getText());
				else if(which.equals("mechanic"))
					updateMechanic(textField_3.getText(), textField_6.getText(), textField_7.getText(), "", textField_1.getText(), textField_4.getText(), textField_5.getText(), textField.getText());
			}
		});
		btnUpdate.setBounds(143, 519, 97, 25);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(which.equals("pilot"))
					deletePilot(textField.getText(), textField_1.getText(), textField_3.getText());
				else if(which.equals("hostess"))
					deleteHostess(textField.getText(), textField_1.getText(), textField_3.getText());
				else if(which.equals("mechanic"))
					deleteMechanic(textField.getText(), textField_1.getText(), textField_3.getText());
			}
		});
		btnDelete.setBounds(284, 519, 97, 25);
		contentPane.add(btnDelete);
		
		btnReset = new JButton("Reset");
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
			}
		});
		btnReset.setBounds(418, 519, 97, 25);
		contentPane.add(btnReset);
		
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	try {
	            textField.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				textField_1.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				textField_2.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				textField_3.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				textField_4.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				textField_5.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				textField_6.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
				textField_7.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
	        	} catch(Exception e) {
	        		
	        	}
	        }
	    });
		
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	try {
	            textField.setText(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
				textField_1.setText(table_1.getValueAt(table_1.getSelectedRow(), 1).toString());
				textField_2.setText(table_1.getValueAt(table_1.getSelectedRow(), 2).toString());
				textField_3.setText(table_1.getValueAt(table_1.getSelectedRow(), 3).toString());
				textField_4.setText(table_1.getValueAt(table_1.getSelectedRow(), 4).toString());
				textField_5.setText(table_1.getValueAt(table_1.getSelectedRow(), 5).toString());
				textField_6.setText(table_1.getValueAt(table_1.getSelectedRow(), 6).toString());
				textField_7.setText(table_1.getValueAt(table_1.getSelectedRow(), 7).toString());
	        	} catch (Exception e) {
	        		
	        	}
	        }
	    });
		
		table_2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	try {
	            textField.setText(table_2.getValueAt(table_2.getSelectedRow(), 0).toString());
				textField_1.setText(table_2.getValueAt(table_2.getSelectedRow(), 1).toString());
				//textField_2.setText(table_2.getValueAt(table_2.getSelectedRow(), 2).toString());
				textField_3.setText(table_2.getValueAt(table_2.getSelectedRow(), 2).toString());
				textField_4.setText(table_2.getValueAt(table_2.getSelectedRow(), 3).toString());
				textField_5.setText(table_2.getValueAt(table_2.getSelectedRow(), 4).toString());
				textField_6.setText(table_2.getValueAt(table_2.getSelectedRow(), 5).toString());
				textField_7.setText(table_2.getValueAt(table_2.getSelectedRow(), 6).toString());
	        	} catch (Exception e) {
	        		
	        	}
	        }
	    });


	}
	
	public void listPilots(DefaultTableModel model) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			PreparedStatement stmt = conn.prepareStatement("select * from PILOT AS p JOIN EMPLOYEE AS e ON p.employee_no = e.employee_no join PERSON as pe on e.ssn = pe.ssn");
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				Object[] row = {res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(6), res.getString(7), res.getString(9), res.getString(10), res.getString(11)};
				model.addRow(row);
			}
			conn.close();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
	        System.exit(0);
		}
	}
	
	public void listHostesses(DefaultTableModel model) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			PreparedStatement stmt = conn.prepareStatement("select * from HOSTESS AS p JOIN EMPLOYEE AS e ON p.employee_no = e.employee_no join PERSON as pe on e.ssn = pe.ssn");
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				Object[] row = {res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(6), res.getString(7), res.getString(9), res.getString(10), res.getString(11)};
				model.addRow(row);
			}
			conn.close();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
	        System.exit(0);
		}
	}
	
	public void listMechanics(DefaultTableModel model) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			PreparedStatement stmt = conn.prepareStatement("select * from PLANE_MECHANIC AS p JOIN EMPLOYEE AS e ON p.employee_no = e.employee_no join PERSON as pe on e.ssn = pe.ssn");
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				Object[] row = {res.getString(1), res.getString(2), res.getString(3), res.getString(5), res.getString(6), res.getString(8), res.getString(9), res.getString(10)};
				model.addRow(row);
			}
			conn.close();
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
	        System.exit(0);
		}
	}
	
	public void addPilot(String ssn, String name, String gender, String birthdate, String employee_no, String start_date, String salary, String pilot_no, String level) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			String sql = "insert into person(ssn, name, gender, bdate) values (?, ?, ?, ?)";
			String sql2 = "insert into employee(ssn, employee_no, start_date, salary) values(?, ?, ?, ?)";
			String sql3 = "insert into pilot(pilot_no, employee_no, level) values(?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(ssn));
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setString(4, birthdate);
			ps.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, Integer.parseInt(ssn));
			ps2.setInt(2, Integer.parseInt(employee_no));
			ps2.setString(3, start_date);
			ps2.setInt(4, Integer.parseInt(salary));
			ps2.executeUpdate();
			
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setInt(1, Integer.parseInt(pilot_no));
			ps3.setInt(2, Integer.parseInt(employee_no));
			ps3.setInt(3, Integer.parseInt(level));
			ps3.executeUpdate();
			
			conn.close();
		} catch(Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}
	
	public void addHostess(String ssn, String name, String gender, String birthdate, String employee_no, String start_date, String salary, String hostess_no, String level) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			String sql = "insert into person(ssn, name, gender, bdate) values (?, ?, ?, ?)";
			String sql2 = "insert into employee(ssn, employee_no, start_date, salary) values(?, ?, ?, ?)";
			String sql3 = "insert into hostess(hostess_no, employee_no, level) values(?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(ssn));
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setString(4, birthdate);
			ps.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, Integer.parseInt(ssn));
			ps2.setInt(2, Integer.parseInt(employee_no));
			ps2.setString(3, start_date);
			ps2.setInt(4, Integer.parseInt(salary));
			ps2.executeUpdate();
			
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setInt(1, Integer.parseInt(hostess_no));
			ps3.setInt(2, Integer.parseInt(employee_no));
			ps3.setInt(3, Integer.parseInt(level));
			ps3.executeUpdate();
			
			conn.close();
		} catch(Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}
	
	public void addMechanic(String ssn, String name, String gender, String birthdate, String employee_no, String start_date, String salary, String mechanic_no) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			String sql = "insert into person(ssn, name, gender, bdate) values (?, ?, ?, ?)";
			String sql2 = "insert into employee(ssn, employee_no, start_date, salary) values(?, ?, ?, ?)";
			String sql3 = "insert into plane_mechanic(plane_mechanic_no, employee_no) values(?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(ssn));
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setString(4, birthdate);
			ps.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, Integer.parseInt(ssn));
			ps2.setInt(2, Integer.parseInt(employee_no));
			ps2.setString(3, start_date);
			ps2.setInt(4, Integer.parseInt(salary));
			ps2.executeUpdate();
			
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setInt(1, Integer.parseInt(mechanic_no));
			ps3.setInt(2, Integer.parseInt(employee_no));
			ps3.executeUpdate();
			
			conn.close();
		} catch(Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}
	
	public void deletePilot(String pilot_no, String employee_no, String ssn) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			String sql = "delete from pilot where pilot_no=?";
			String sql2 = "delete from employee where employee_no=?";
			String sql3 = "delete from person where ssn=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(pilot_no));
			ps.executeUpdate();

			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, Integer.parseInt(employee_no));
			ps2.executeUpdate();
			
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setInt(1, Integer.parseInt(ssn));
			ps3.executeUpdate();
			
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
		}
	}
	
	public void deleteHostess(String hostess_no, String employee_no, String ssn) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			String sql = "delete from hostess where hostess_no=?";
			String sql2 = "delete from employee where employee_no=?";
			String sql3 = "delete from person where ssn=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(hostess_no));
			ps.executeUpdate();

			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, Integer.parseInt(employee_no));
			ps2.executeUpdate();
			
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setInt(1, Integer.parseInt(ssn));
			ps3.executeUpdate();
			
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
		}
	}
	
	public void deleteMechanic(String plane_mechanic_no, String employee_no, String ssn) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			String sql = "delete from plane_mechanic where plane_mechanic_no=?";
			String sql2 = "delete from employee where employee_no=?";
			String sql3 = "delete from person where ssn=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(plane_mechanic_no));
			ps.executeUpdate();

			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, Integer.parseInt(employee_no));
			ps2.executeUpdate();
			
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setInt(1, Integer.parseInt(ssn));
			ps3.executeUpdate();
			
		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
		}
	}
	
	public void updatePilot(String ssn, String name, String gender, String birthdate, String employee_no, String start_date, String salary, String pilot_no, String level) {
		try {
			  Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			  String sql = "update person set ssn=?, name=?, gender=?, bdate=? where ssn=?";
			  String sql2 = "update employee set ssn=?, employee_no=?, start_date=?, salary=? where employee_no=?";
			  String sql3 = "update pilot set pilot_no=?, employee_no=?, level=? where pilot_no=?";
			  
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1, Integer.parseInt(ssn));
			 ps.setString(2, name);
			 ps.setString(3, gender);
			 ps.setString(4, birthdate);
			 ps.setInt(5, Integer.parseInt(ssn));
			 ps.executeUpdate();
			 
		    PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, Integer.parseInt(ssn));
			ps2.setInt(2, Integer.parseInt(employee_no));
			ps2.setString(3, start_date);
			ps2.setInt(4, Integer.parseInt(salary));
			ps2.setInt(5, Integer.parseInt(employee_no));
			ps2.executeUpdate();
			
		    PreparedStatement ps3 = conn.prepareStatement(sql3);
		    ps3.setInt(1, Integer.parseInt(pilot_no));
		    ps3.setInt(2, Integer.parseInt(employee_no));
		    ps3.setInt(3, Integer.parseInt(level));
		    ps3.setInt(4, Integer.parseInt(pilot_no));
		    ps3.executeUpdate();

		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
		}
	}
	
	public void updateHostess(String ssn, String name, String gender, String birthdate, String employee_no, String start_date, String salary, String hostess_no, String level) {
		try {
			  Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			  String sql = "update person set ssn=?, name=?, gender=?, bdate=? where ssn=?";
			  String sql2 = "update employee set ssn=?, employee_no=?, start_date=?, salary=? where employee_no=?";
			  String sql3 = "update hostess set hostess_no=?, employee_no=?, level=? where hostess_no=?";
			  
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1, Integer.parseInt(ssn));
			 ps.setString(2, name);
			 ps.setString(3, gender);
			 ps.setString(4, birthdate);
			 ps.setInt(5, Integer.parseInt(ssn));
			 ps.executeUpdate();
			 
		    PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, Integer.parseInt(ssn));
			ps2.setInt(2, Integer.parseInt(employee_no));
			ps2.setString(3, start_date);
			ps2.setInt(4, Integer.parseInt(salary));
			ps2.setInt(5, Integer.parseInt(employee_no));
			ps2.executeUpdate();
			
		    PreparedStatement ps3 = conn.prepareStatement(sql3);
		    ps3.setInt(1, Integer.parseInt(hostess_no));
		    ps3.setInt(2, Integer.parseInt(employee_no));
		    ps3.setInt(3, Integer.parseInt(level));
		    ps3.setInt(4, Integer.parseInt(hostess_no));
		    ps3.executeUpdate();

		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
		}
	}
	
	public void updateMechanic(String ssn, String name, String gender, String birthdate, String employee_no, String start_date, String salary, String mechanic_no) {
		try {
			  Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/airwaydb",username, password);
			  String sql = "update person set ssn=?, name=?, gender=?, bdate=? where ssn=?";
			  String sql2 = "update employee set ssn=?, employee_no=?, start_date=?, salary=? where employee_no=?";
			  String sql3 = "update plane_mechanic set plane_mechanic_no=?, employee_no=? where plane_mechanic_no=?";
			  
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1, Integer.parseInt(ssn));
			 ps.setString(2, name);
			 ps.setString(3, gender);
			 ps.setString(4, birthdate);
			 ps.setInt(5, Integer.parseInt(ssn));
			 ps.executeUpdate();
			 
		    PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, Integer.parseInt(ssn));
			ps2.setInt(2, Integer.parseInt(employee_no));
			ps2.setString(3, start_date);
			ps2.setInt(4, Integer.parseInt(salary));
			ps2.setInt(5, Integer.parseInt(employee_no));
			ps2.executeUpdate();
			
		    PreparedStatement ps3 = conn.prepareStatement(sql3);
		    ps3.setInt(1, Integer.parseInt(mechanic_no));
		    ps3.setInt(2, Integer.parseInt(employee_no));
		    ps3.setInt(3, Integer.parseInt(mechanic_no));
		    ps3.executeUpdate();

		} catch(Exception e) {
			System.out.print(e.getMessage().toString());
		}
	}	
}
