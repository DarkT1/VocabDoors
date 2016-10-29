package src;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class welcomePage {
	static boolean runmp4 = false;
	private JFrame frmThankYouFor;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcomePage window = new welcomePage();
					window.frmThankYouFor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public welcomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ImageIcon Names = (new ImageIcon(getClass().getResource("/Names.png")));
		ImageIcon credits = (new ImageIcon(getClass().getResource("/credits.png")));
		ImageIcon Doors = (new ImageIcon(getClass().getResource("/Doors.png")));
		ImageIcon Title = (new ImageIcon(getClass().getResource("/Hotel-Escape.png")));
		
		frmThankYouFor = new JFrame();
		
		frmThankYouFor.setResizable(false);

		frmThankYouFor.setAlwaysOnTop(true);
		frmThankYouFor.setTitle("");
		frmThankYouFor.setBounds(100, 100, 712, 494);
		frmThankYouFor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThankYouFor.setLocationRelativeTo(null);
		frmThankYouFor.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 709, 470);
		frmThankYouFor.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 102, 709, 118);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel Credits = new JLabel("");
		Credits.setBounds(10, 0, 689, 39);
		panel_1.add(Credits);
		Credits.setHorizontalAlignment(SwingConstants.CENTER);
		Credits.setIcon(credits);
		
		JLabel lblAnthonyNguyen = new JLabel("Brian Trinh");
		lblAnthonyNguyen.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnthonyNguyen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAnthonyNguyen.setBounds(225, 28, 247, 39);
		panel_1.add(lblAnthonyNguyen);
		
		JLabel label_1 = new JLabel("Anthony Nguyen");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(225, 50, 247, 39);
		panel_1.add(label_1);
		
		JLabel lblPeriod = new JLabel("Period 6");
		lblPeriod.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeriod.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPeriod.setBounds(225, 79, 247, 39);
		panel_1.add(lblPeriod);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 0, 709, 102);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 709, 102);
		panel_2.add(label);
		label.setIcon(Title);
	
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 219, 709, 251);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton requirements = new JButton("Instructions");
		requirements.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				frmThankYouFor.dispose();
				ListofRequirements.main(null);

			}
		});
		requirements.setFont(new Font("Tahoma", Font.BOLD, 10));
		requirements.setForeground(Color.BLACK);
		requirements.setBackground(Color.LIGHT_GRAY);
		requirements.setBounds(0, 215, 160, 30);
		panel_3.add(requirements);

		JButton start = new JButton("Start!");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmThankYouFor.dispose();
				runmp4 = true;
			}
		});
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmThankYouFor.dispose();
				runmp4 = true;

			}
		});
		start.setForeground(Color.BLACK);
		start.setFont(new Font("Tahoma", Font.BOLD, 15));
		start.setBackground(Color.LIGHT_GRAY);
		start.setBounds(270, 136, 160, 45);
		panel_3.add(start);
		
		JLabel BottomLabel = new JLabel("");
		BottomLabel.setBounds(0, 0, 709, 245);
		panel_3.add(BottomLabel);
		BottomLabel.setIcon(Doors);
	}
}
