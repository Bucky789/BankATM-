package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Domestic extends JFrame {

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
					Domestic frame = new Domestic();
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
	public Domestic() {
		setBackground(new Color(191, 173, 245));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(191, 173, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Domestic Services ");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblNewLabel.setBounds(176, 33, 351, 108);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(191, 173, 245));
		panel.setBounds(45, 155, 613, 385);
		contentPane.add(panel);
		
		JButton btnNewButton_1 = new JButton("Withdrawal");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton_1.setBounds(0, 0, 204, 96);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WithdrawGui w=new WithdrawGui();
				w.setVisible(true);
				dispose();
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Deposit");
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepositGui w=new DepositGui();
				w.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(408, 0, 204, 96);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Money Transfer");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferGUI t=new TransferGUI();
				t.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(0, 143, 204, 96);
		panel.add(btnNewButton_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(204, 96, 204, 96);
		panel.add(label_1);
		
		JButton btnNewButton_3 = new JButton("Check Balance");
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BalanceGUI bg=new BalanceGUI();
				bg.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(408, 143, 204, 96);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("PIN Change");
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PINChange p=new PINChange();
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(0, 288, 204, 96);
		panel.add(btnNewButton_4);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(204, 192, 204, 96);
		panel.add(label_2);
		
		JButton btnNewButton_5 = new JButton("Transactions");
		btnNewButton_5.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton_5.setFocusable(false);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mini m=new Mini();
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(408, 288, 204, 96);
		panel.add(btnNewButton_5);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(0, 288, 204, 96);
		panel.add(label_3);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(408, 288, 204, 96);
		panel.add(label_5);
		
		JLabel label = new JLabel("");
		label.setBounds(252, 174, 204, 96);
		contentPane.add(label);
		
		JButton btnNewButton_6 = new JButton("Generate Pin");
		btnNewButton_6.setFocusable(false);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeneratePIN g=new GeneratePIN();
				g.setVisible(true);
				dispose();
			}
		});
		btnNewButton_6.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btnNewButton_6.setBounds(252, 574, 204, 96);
		contentPane.add(btnNewButton_6);
	}
}
