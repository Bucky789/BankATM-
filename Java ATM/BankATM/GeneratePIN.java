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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;

public class GeneratePIN extends JFrame {
	static Connection con=null;
	static int otp;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		otp();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneratePIN frame = new GeneratePIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static String otp() {
	    Random rnd = new Random();
	    otp =rnd.nextInt(999999);
	    return String.format("%06d", otp);
	}

	/**
	 * Create the frame.
	 */
	public GeneratePIN() {
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
		lblNewLabel.setBounds(225, 69, 253, 109);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Mobile Number For Confirmation And to Recieve OTP");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1.setBounds(10, 281, 684, 84);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.BOLD, 30));
		textField.setBounds(255, 388, 194, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setDocument(new JTextFieldLimit(10));
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String p=textField.getText();
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","");
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select ph_number from account where accno="+GUI.accountno);
					rs.next();
					if(p.equals(rs.getString(1))) {
						
						JOptionPane.showMessageDialog(frame, "OTP Sent..!!",
								"", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						System.out.println("Your OTP for Generating PIN is "+otp());
						OTP o=new OTP();
						o.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(frame, "Wrong Mobile Number..!!",
								"", JOptionPane.ERROR_MESSAGE);
					}
					

					
				}catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(frame, "Please Enter Mobile Number..!!",
							"", JOptionPane.ERROR_MESSAGE);
				}catch(SQLException ee) {
					System.out.println(ee);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton.setBounds(283, 492, 138, 41);
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
		btnNewButton_1.setBounds(283, 584, 138, 41);
		contentPane.add(btnNewButton_1);
	}
}
