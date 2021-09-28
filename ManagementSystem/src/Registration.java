import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class Registration {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public void runRegis() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(112, 128, 144));
		frame.setBounds(100, 100, 737, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setForeground(new Color(255, 250, 240));
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 24));
		lblNewLabel.setBounds(233, 11, 291, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(38, 56, 648, 288);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name:");
		lblNewLabel_1.setForeground(new Color(255, 250, 240));
		lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(10, 26, 108, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email ID:");
		lblNewLabel_1_1.setForeground(new Color(255, 250, 240));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 63, 108, 27);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("User Name:");
		lblNewLabel_1_2.setForeground(new Color(255, 250, 240));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 100, 108, 27);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password:");
		lblNewLabel_1_3.setForeground(new Color(255, 250, 240));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(10, 137, 108, 27);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Address:");
		lblNewLabel_1_3_1.setForeground(new Color(255, 250, 240));
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(10, 174, 108, 27);
		panel.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Phone No:");
		lblNewLabel_1_3_2.setForeground(new Color(255, 250, 240));
		lblNewLabel_1_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_2.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1_3_2.setBounds(10, 211, 108, 27);
		panel.add(lblNewLabel_1_3_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(230, 230, 250));
		textField.setBounds(219, 26, 329, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(230, 230, 250));
		textField_1.setColumns(10);
		textField_1.setBounds(219, 68, 329, 24);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(230, 230, 250));
		textField_2.setColumns(10);
		textField_2.setBounds(219, 105, 329, 24);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(230, 230, 250));
		textField_3.setColumns(10);
		textField_3.setBounds(219, 177, 329, 24);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(230, 230, 250));
		textField_4.setColumns(10);
		textField_4.setBounds(219, 214, 329, 24);
		panel.add(textField_4);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(230, 230, 250));
		passwordField.setBounds(219, 142, 329, 24);
		panel.add(passwordField);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(230, 230, 250));
		btnClear.setFont(new Font("Montserrat", Font.BOLD, 10));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");						
				textField_4.setText("");
				passwordField.setText("");
				textField_3.setText("");
				textField.requestFocus();
				
			
			
			}
		});
		btnClear.setBounds(506, 369, 85, 21);
		frame.getContentPane().add(btnClear);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(230, 230, 250));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String fullName = textField.getText();
                String emailId = textField_1.getText();
                String userName = textField_2.getText();
                String mobileNumber = textField_4.getText();
				String password = passwordField.getText();
				String address = textField_3.getText();
                
            	String url = "jdbc:mysql://127.0.0.1:3306/book_store";
            	String user = "root";
            	String pass = "Utpal@9843";

                String greet = "" + fullName;
                greet += " \n";
                
                if (fullName.isEmpty() && emailId.isEmpty() && userName.isEmpty() && mobileNumber.isEmpty() && password.isEmpty()) {
                	JOptionPane.showMessageDialog(btnSubmit, "Enter valid details");
                }else {
                	try {
                        Connection connection = DriverManager.getConnection(url,user,pass);
                        

                        String query = " insert into registration (name, user_name, email_id, password, mobile_number, address)"
                                + " values (?, ?, ?, ?, ?, ?)";

                        Statement sta = connection.createStatement();
                       
                       
                        PreparedStatement preparedStmt = connection.prepareStatement(query);

                        preparedStmt.setString (1, fullName);
                        preparedStmt.setString (2, userName);
                        preparedStmt.setString (3, emailId);
                        preparedStmt.setString (4, password);
                        preparedStmt.setString (5, mobileNumber);
                        preparedStmt.setString (6, address);
                        
                        
                        boolean x = preparedStmt.execute();
                        if (x == true) {
                            JOptionPane.showMessageDialog(btnSubmit, "Account not created");
                        } else {
                            JOptionPane.showMessageDialog(btnSubmit,
                                "Welcome, " + greet + "Your account is sucessfully created");
                        }
                        connection.close();
                        
                        frame.dispose();
                        UserLogin callLogin = new UserLogin();
                        callLogin.main(null);
                        
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
				
				
				
			}
			}
		});
		btnSubmit.setFont(new Font("Montserrat", Font.BOLD, 10));
		btnSubmit.setBounds(601, 369, 85, 21);
		frame.getContentPane().add(btnSubmit);
	}
}
