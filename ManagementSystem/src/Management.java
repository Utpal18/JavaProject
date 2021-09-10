import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Management {

	private JFrame frame;
	private JTextField book_id;
	private JTextField book_name;
	private JTextField book_edition;
	private JTextField book_price;
	private JTextField book_author;
	private JTable table;
	private JTextField book_search;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management window = new Management();
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
	public Management() {
		initialize();
		Connect();
		table_load(); 
	}
	
	
	Connection connection;
	ResultSet rs;
	
	
	public void Connect()
	{
		try {
			String url = "jdbc:mysql://localhost:3306/book_store";
        	String user = "root";
        	String pass = "Utpal@9843";
        	

			
			connection= DriverManager.getConnection(url,user,pass);
		}
		catch (SQLException ex) {
			
		}
	}
	
	
	// Viewing the table
	
	public void table_load() {
		
		try {
			PreparedStatement preparedStmt = connection.prepareStatement("select * from books");
			rs = preparedStmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel (rs));
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	

			
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 883, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Store");
		lblNewLabel.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 25));
		lblNewLabel.setBounds(301, -36, 239, 108);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Book Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 63, 428, 223);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Book ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 48, 103, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Book Name:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 83, 103, 13);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Edition:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 119, 103, 13);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Price:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(10, 151, 103, 13);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Author:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(10, 186, 103, 13);
		panel.add(lblNewLabel_1_4);
		
		book_id = new JTextField();
		book_id.setBounds(111, 46, 208, 19);
		panel.add(book_id);
		book_id.setColumns(10);
		
		book_name = new JTextField();
		book_name.setColumns(10);
		book_name.setBounds(111, 81, 208, 19);
		panel.add(book_name);
		
		book_edition = new JTextField();
		book_edition.setColumns(10);
		book_edition.setBounds(111, 117, 208, 19);
		panel.add(book_edition);
		
		book_price = new JTextField();
		book_price.setColumns(10);
		book_price.setBounds(111, 149, 208, 19);
		panel.add(book_price);
		
		book_author = new JTextField();
		book_author.setColumns(10);
		book_author.setBounds(111, 184, 208, 19);
		panel.add(book_author);
		
		JScrollPane list = new JScrollPane();
		list.setBounds(445, 62, 372, 269);
		frame.getContentPane().add(list);
		
		table = new JTable();
		list.setViewportView(table);
		
		
		// adding the data
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int b_id;
				String b_name,b_edition,b_author;
				int b_price;
				

				
				b_id = Integer.parseInt(book_id.getText());
				b_name = book_name.getText();
				b_edition = book_edition.getText();
				b_price = Integer.parseInt(book_price.getText());
				b_author = book_author.getText();
				
					try {
						
						String query = " insert into books (book_id,book_name,edition,price,author)"
                                + " values (?,?,?,?,?)";

                        Statement sta = connection.createStatement();
                        
                        PreparedStatement preparedStmt = connection.prepareStatement(query);
                        preparedStmt.setInt (1, b_id);
                        preparedStmt.setString (2, b_name);
                        preparedStmt.setString (3, b_edition);
                        preparedStmt.setInt (4, b_price);
                        preparedStmt.setString (5, b_author);
              
                        
                        
                        preparedStmt.execute();
						JOptionPane.showMessageDialog(null,"Record added Successfully.");
						
						//clears the screen after adding
					book_id.setText("");
					book_name.setText("");
					book_edition.setText("");						
					book_price.setText("");
					book_author.setText("");
					book_id.requestFocus();
						
					}
					catch (SQLException el) {
						el.printStackTrace();
					}
				
				
				
				
			}
		});
		btnNewButton.setBounds(41, 296, 98, 35);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setFont(new Font("Montserrat", Font.BOLD, 12));
		
		
		// Updating data
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(178, 296, 98, 35);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
				
				
			}	
		});
		btnUpdate.setFont(new Font("Montserrat", Font.BOLD, 12));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = " delete from books where book_id=?";
				
				 int bid;
					bid  = Integer.parseInt(book_search.getText());
					
					 try {
						 PreparedStatement preparedStmt = connection.prepareStatement(query);
					
						 preparedStmt.setInt(1, bid);
						 preparedStmt.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Deleted Successfully.");
				            table_load();
				           
				            book_id.setText("");
							book_name.setText("");
							book_edition.setText("");						
							book_price.setText("");
							book_author.setText("");
							book_id.requestFocus();
								
						}
		 
			            catch (SQLException e1) {
							
							e1.printStackTrace();
						}
				
				
				
				
				
				
			}
		});
		btnDelete.setBounds(312, 296, 98, 35);
		frame.getContentPane().add(btnDelete);
		btnDelete.setFont(new Font("Montserrat", Font.BOLD, 12));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 353, 428, 61);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_5 = new JLabel("Book ID:");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_5.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(22, 25, 103, 13);
		panel_1.add(lblNewLabel_1_5);
		
		
		
		
		// searching of books
		
		book_search = new JTextField();
		book_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				 try {
			          
			            String id = book_search.getText();

			            PreparedStatement preparedStmt = connection.prepareStatement("select book_id,book_name,edition,price,author from books where book_id = ?");
			            preparedStmt.setString(1, id);
			                ResultSet rs = preparedStmt.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String bookid= rs.getString(1);
			                String bookname = rs.getString(2);
			                String bookedition = rs.getString(3);
			                String bookprice = rs.getString(4);
			                String bookauthor = rs.getString(5);
			                
			               book_id.setText(bookid);
			               book_name.setText(bookname);
			               book_edition.setText(bookedition);
			               book_price.setText(bookprice);
			               book_author.setText(bookauthor);
			             
			                
			                
			            }   
			            else
			            {
			            	  book_id.setText("");
				               book_name.setText("");
				               book_edition.setText("");
				               book_price.setText("");
				               book_author.setText("");
			                 
			            }
			            


			        } 
				
				 catch (SQLException ex) {
			           
			        }
				
			}
		});
		book_search.setColumns(10);
		book_search.setBounds(121, 23, 208, 19);
		panel_1.add(book_search);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				book_id.setText("");
				book_name.setText("");
				book_edition.setText("");						
				book_price.setText("");
				book_author.setText("");
				book_id.requestFocus();
				
			}
		});
		btnClear.setFont(new Font("Montserrat", Font.BOLD, 12));
		btnClear.setBounds(586, 367, 98, 35);
		frame.getContentPane().add(btnClear);
		
		JButton btnNewButton_1_1 = new JButton("Exit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1_1.setFont(new Font("Montserrat", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(717, 367, 98, 35);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					PreparedStatement preparedStmt = connection.prepareStatement("select * from books");
					rs = preparedStmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel (rs));
				}
				catch (SQLException f){
					f.printStackTrace();
				}
				
			}
			
				
			
		});
		btnNewButton_1.setFont(new Font("Montserrat", Font.BOLD, 10));
		btnNewButton_1.setBounds(729, 336, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
	}
}
