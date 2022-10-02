package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class TransferGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Connection con=null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static int accE;

	
	int accountE() {
		int i=accE;
		return i;
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferGUI frame = new TransferGUI();
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
	public TransferGUI() {
		JFrame frame=new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(191, 173, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Money Transfer");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblNewLabel.setBounds(201, 58, 302, 123);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Recipient's Account Number :");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_1.setBounds(57, 282, 421, 41);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.BOLD, 25));
		textField.setBounds(498, 282, 132, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setDocument(new JTextFieldLimit(9));
		
		JLabel lblNewLabel_2 = new JLabel("Re- Enter Recipient's Account Number :");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_2.setBounds(10, 350, 478, 41);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		textField_1.setBounds(498, 350, 132, 41);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setDocument(new JTextFieldLimit(9));
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GUI g=new GUI();
					accE=Integer.parseInt(textField.getText());
					int accE1=Integer.parseInt(textField_1.getText());
					try {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","");
					Statement st=con.createStatement();
					ResultSet rs= st.executeQuery("select accno,balance from account where accno="+accE);
					if(rs.next()) {
						int acc=rs.getInt(1);
						if(accE!=accE1) {
							JOptionPane.showMessageDialog(frame, "Account Number Doesn't Match..!!",
						               "", JOptionPane.ERROR_MESSAGE);
						}else if(accE==acc && accE!=(g.accountno())) {
							TransferAmount t=new TransferAmount();
							t.setVisible(true);
							dispose();
							}else if(accE==GUI.accountno) {
								JOptionPane.showMessageDialog(frame, "Error: Can't Transfer Money To the Same Account..!!",
							               "", JOptionPane.ERROR_MESSAGE);
							}
					}else {
						JOptionPane.showMessageDialog(frame, "Recipient's Account Doesn't Exist..!!",
					               "", JOptionPane.ERROR_MESSAGE);
					}
					
					}catch(SQLException ex) {
						System.out.println(ex);
					}
				}catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(frame, "Please Enter Recipient's Account Number..!!",
							"", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton.setBounds(270, 471, 163, 43);
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

