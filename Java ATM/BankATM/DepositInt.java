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
import java.awt.event.ActionEvent;

public class DepositInt extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static float a;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositInt frame = new DepositInt();
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
	public DepositInt() {
		JFrame frame=new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(191, 173, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("International Deposit");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblNewLabel.setBounds(146, 25, 411, 88);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Amount :");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_1.setBounds(125, 161, 219, 67);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		textField.setBounds(354, 161, 179, 67);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("USD");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					a=Float.parseFloat(textField.getText());
					USDD w=new USDD();
					w.setVisible(true);
					dispose();
				}catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(frame, "Please Enter Amount..!!",
							"", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnNewButton.setBounds(81, 312, 194, 56);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("GBP");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					a=Float.parseFloat(textField.getText());
					GBPD w=new GBPD();
					w.setVisible(true);
					dispose();
				}catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(frame, "Please Enter Amount..!!",
							"", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnNewButton_1.setBounds(81, 444, 194, 56);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("EUR");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					a=Float.parseFloat(textField.getText());
					EURD w=new EURD();
					w.setVisible(true);
					dispose();
				}catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(frame, "Please Enter Amount..!!",
							"", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnNewButton_2.setBounds(405, 312, 194, 56);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("JPY");
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					a=Float.parseFloat(textField.getText());
					JPYD w=new JPYD();
					w.setVisible(true);
					dispose();
				}catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(frame, "Please Enter Amount..!!",
							"", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnNewButton_3.setBounds(405, 446, 194, 54);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("CAD");
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					a=Float.parseFloat(textField.getText());
					CADD w=new CADD();
					w.setVisible(true);
					dispose();
				}catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(frame, "Please Enter Amount..!!",
							"", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnNewButton_4.setBounds(244, 570, 194, 56);
		contentPane.add(btnNewButton_4);
	}

}
