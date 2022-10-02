package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class GPIN extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Connection con=null;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	static int PINE;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GPIN frame = new GPIN();
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
	public GPIN() {
		JFrame frame=new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(191, 173, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Generate PIN");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblNewLabel.setBounds(225, 58, 253, 123);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter New PIN :");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_1.setBounds(132, 271, 235, 41);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.BOLD, 60));
		passwordField.setBounds(377, 271, 163, 41);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		passwordField.setDocument(new JTextFieldLimit(6));
		
		JLabel lblNewLabel_2 = new JLabel("Re- Enter New PIN :");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_2.setBounds(77, 341, 278, 41);
		contentPane.add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Segoe UI", Font.BOLD, 60));
		passwordField_1.setBounds(377, 341, 163, 41);
		contentPane.add(passwordField_1);
		passwordField_1.setColumns(10);
		passwordField_1.setDocument(new JTextFieldLimit(6));
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					PINE=Integer.parseInt(passwordField.getText());
					int PINE1=Integer.parseInt(passwordField_1.getText());
					try {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","");
					Statement st=con.createStatement();
						if(PINE!=PINE1) {
							JOptionPane.showMessageDialog(frame, "PIN Doesn't Match..!!",
						               "", JOptionPane.ERROR_MESSAGE);
						}else {
							st.executeUpdate("update account set pin="+PINE+" where accno="+GUI.accountno);
							JOptionPane.showMessageDialog(frame, "PIN Created Successfully..!!",
						               "", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							GUI.main(null);
						}
					
					
					}catch(SQLException ex) {
						System.out.println(ex);
					}
				}catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(frame, "Please Enter New PIN..!!",
							"", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton.setBounds(270, 471, 163, 41);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Transaction Cancelled..!!",
						"", JOptionPane.ERROR_MESSAGE);
				dispose();
				GUI.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton_1.setBounds(270, 548, 163, 41);
		contentPane.add(btnNewButton_1);
	}
}

