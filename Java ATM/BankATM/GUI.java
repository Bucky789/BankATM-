package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.sql.*;
import java.util.Scanner;

class Connectionstart{
	static Scanner sc=new Scanner(System.in);
	static Connection con=null;
	
	
	public static void connectionstart(){

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Registered");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Drivers not found");
		}
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","");
			System.out.println("Connection established");
			
		}
		catch(SQLException e) {
			System.out.println("connection failed");
		}
	}
}

public class GUI extends Connectionstart{
	static int accountno;
	static double balance;
	static int pin;
	int accountno() {
		int i=accountno;
		return i;
	}
	int pin() {
		int i=pin;
		return i;
		}
	double bal() {
		double i=balance;
		return i;
	}

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		connectionstart();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void initialize(){
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.getContentPane().setBackground(new Color(191, 173, 245));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Bucky's Bank..!!");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblNewLabel.setBounds(85, 58, 533, 95);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Account Number :");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_1.setBounds(49, 291, 349, 79);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		textField.setBounds(394, 305, 154, 52);
		frame.getContentPane().add(textField);
		textField.setColumns(5);
		textField.setDocument(new JTextFieldLimit(9));
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = Integer.parseInt(textField.getText());
					accountno=a;
					Statement st=con.createStatement();
					String sqlquery="Select accno,balance,pin from account where accno=";
					ResultSet rs= st.executeQuery(sqlquery+a);
					if(rs.next()) {
					balance=rs.getInt(2);
					pin=rs.getInt(3);
						if(rs.getInt(1)==a) {
							MenuGUI m=new MenuGUI();
							m.setVisible(true);
							frame.dispose();							
							}
					}else {
						JOptionPane.showMessageDialog(frame, "Account Doesn't Exist..!!",
								"", JOptionPane.ERROR_MESSAGE);
		
						}
				}catch(SQLException se) {
						System.out.println(se);
					}catch(NumberFormatException n) {
						JOptionPane.showMessageDialog(frame, "Please Enter Account Number..!!",
								"", JOptionPane.ERROR_MESSAGE);
					}
			
				}
			
		});
		btnNewButton.setBounds(266, 538, 171, 52);
		frame.getContentPane().add(btnNewButton);
		
		
		
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 720, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}

 class JTextFieldLimit extends PlainDocument {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int limit;

	  JTextFieldLimit(int limit) {
	   super();
	   this.limit = limit;
	   }

	  public void insertString( int offset, String  str, javax.swing.text.AttributeSet attr ) throws BadLocationException {
	    if (str == null) return;

	    if ((getLength() + str.length()) <= limit) {
	      super.insertString(offset, str, attr);
	    }
	  }
	}