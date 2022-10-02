package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckBalance extends JFrame {
	static Connection con;
	static String name;
	static String acctype;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBalance frame = new CheckBalance();
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
	public CheckBalance() {
		
		try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","");
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery("select name,accounttype,balance from account where accno="+GUI.accountno);
		rs.next();
		name=rs.getString(1);
		acctype=rs.getString(2);
		
		}catch(SQLException e) {
			System.out.println(e);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(191, 173, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name Of Customer : "+name);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(45, 202, 649, 115);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Balance");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblNewLabel_1.setBounds(279, 73, 146, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Balance :₹ "+GUI.balance);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_2.setBounds(206, 372, 469, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Account Type : "+acctype);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_3.setBounds(124, 495, 551, 49);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.main(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton.setBounds(284, 599, 135, 35);
		contentPane.add(btnNewButton);
	}
}
