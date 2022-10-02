package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;


public class WithdrawGui extends JFrame {
	static Connection con=null;
	static int a;
	static double fbal;
	
	/**
	 * 
	 */
	
	int valw() {//Returns the value of entered amount
		int i=a;
		return i;
	}
	double fbal() {
		double i=fbal;
		return i;
	}
	private static final long serialVersionUID = 1L;
	Connection c=null;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawGui frame = new WithdrawGui();
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
	public WithdrawGui() {
		
		JFrame frame=new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(191, 173, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Domestic Withdraw");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblNewLabel.setBounds(161, 42, 381, 187);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Amount : ₹");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_1.setBounds(108, 279, 245, 48);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.BOLD, 30));
		textField.setBounds(363, 287, 209, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					a=Integer.parseInt(textField.getText());//Entered amount
					try {	
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","");
					fbal=GUI.balance-a;
					
						WithdrawConfirm w=new WithdrawConfirm();
						w.setVisible(true);
						dispose();
					
				
				}catch(SQLException se) {
					System.out.println(se);
				}
				}catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(frame, "Please Enter Amount..!!",
							"", JOptionPane.ERROR_MESSAGE);
				}
				}
		}
		);
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton.setBounds(256, 443, 191, 55);
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
		btnNewButton_1.setBounds(256, 541, 191, 55);
		contentPane.add(btnNewButton_1);
	}
}
