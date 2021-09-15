import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin window = new UserLogin();
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
	public UserLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 695, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login To Your Account");
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 24));
		lblNewLabel.setBounds(198, 10, 338, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1.setBounds(72, 93, 142, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(72, 146, 142, 44);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(199, 102, 219, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 160, 219, 28);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String userName = textField.getText();
                String password = passwordField.getText();
                
                String url = "jdbc:mysql://127.0.0.1:3306/book_store";
            	String user = "root";
            	String pass = "Utpal@9843";
            	
                try {
                    Connection connection = (Connection) DriverManager.getConnection(url, user, pass);

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select user_name, password from registration where user_name=? and password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();

                    if (rs.next()) {
                    	JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                    	frame.dispose();
                    	Management call = new Management();   
                    	call.runMain();
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
			}
				
				
			
		});
		btnNewButton.setFont(new Font("Montserrat", Font.BOLD, 12));
		btnNewButton.setBounds(72, 219, 346, 28);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 65, 459, 253);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Registration callAcc = new Registration();
				callAcc.runRegis();
				
				
			}
		});
		btnRegister.setFont(new Font("Montserrat", Font.BOLD, 12));
		btnRegister.setBounds(48, 191, 346, 28);
		panel.add(btnRegister);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/Login.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(493, 10, 203, 308);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
