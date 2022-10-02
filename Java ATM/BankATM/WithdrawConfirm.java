package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class WithdrawConfirm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Connection con=null;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					USDW frame = new USDW();
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
	public WithdrawConfirm() {
		WithdrawGui c=new WithdrawGui();
		JFrame frame=new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 720);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Segoe UI", Font.BOLD, 40));
		contentPane.setBackground(new Color(191, 173, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entered Amount is :₹"+c.valw());
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel.setBounds(54, 79, 640, 107);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter PIN to Confirm the Transaction");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_1.setBounds(89, 278, 525, 47);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						@SuppressWarnings("deprecation")
						int a=Integer.parseInt(passwordField.getText());
						if(a==GUI.pin && GUI.balance>=c.valw()) {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","");
					Statement st=con.createStatement();
					st.executeUpdate("insert into transactions (accno,type,amount,balance,date) values("+GUI.accountno+",'Withdrawl',"+(c.valw())+","+(c.fbal())+",curdate())");
					st.executeUpdate("update account set balance="+(c.fbal())+" where accno="+GUI.accountno);
					JOptionPane.showMessageDialog(frame, "Transaction Successful..!!",
				               "", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					GUI.main(null);
						}else if(a==GUI.pin && GUI.balance<c.valw()) {
							JOptionPane.showMessageDialog(frame, "Error: Insufficient Balance..!!",
						               "", JOptionPane.ERROR_MESSAGE);
							GUI.main(null);
							dispose();
						}
							else {
							JOptionPane.showMessageDialog(frame, "Incorrect PIN..!!",
						               "", JOptionPane.ERROR_MESSAGE);
						}
					}catch(SQLException re) {
						System.out.println(re);
					}catch(NumberFormatException n) {
						JOptionPane.showMessageDialog(frame, "Please Enter PIN..!!",
								"", JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton.setBounds(267, 468, 163, 41);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.BOLD, 60));
		passwordField.setBounds(267, 355, 166, 55);
		contentPane.add(passwordField);
		passwordField.setDocument(new JTextFieldLimit(6));
		
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
