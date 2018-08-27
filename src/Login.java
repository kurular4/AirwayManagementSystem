import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDbUsername = new JLabel("db username");
		lblDbUsername.setBounds(124, 79, 84, 16);
		contentPane.add(lblDbUsername);
		
		JLabel lblDbPassword = new JLabel("db password");
		lblDbPassword.setBounds(124, 125, 84, 16);
		contentPane.add(lblDbPassword);
		
		textField = new JTextField();
		textField.setBounds(238, 76, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(238, 122, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(238, 212, 116, 25);
		contentPane.add(btnLogin);
		
		JLabel lblPort = new JLabel("port");
		lblPort.setBounds(124, 168, 56, 16);
		contentPane.add(lblPort);
		
		textField_2 = new JTextField();
		textField_2.setText("5432");
		textField_2.setBounds(238, 165, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openMainScreen(textField.getText(), textField_1.getText(), textField_2.getText());
				setVisible(false);
			}
		});
	}
	
	public void openMainScreen(String username, String password, String port) {
		MainScreen ms = new MainScreen(username, password, port);
		ms.main();
	}
}
