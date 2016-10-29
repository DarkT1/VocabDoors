package src;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class ListofRequirements {

	static JFrame frmComets;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListofRequirements window = new ListofRequirements();
					window.frmComets.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListofRequirements() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		ImageIcon img = new ImageIcon(getClass().getResource("/Doors.png"));
		
		frmComets = new JFrame();
		frmComets.setBackground(Color.BLACK);
		frmComets.setTitle("");
		frmComets.setAlwaysOnTop(true);

		frmComets.getContentPane().setBackground(Color.WHITE);
		frmComets.setBounds(100, 100, 403, 492);
		frmComets.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmComets.getContentPane().setLayout(null);
		frmComets.setResizable(false);
		frmComets.setLocationRelativeTo(null);
		JLabel lblListOfRequirements = new JLabel("Instructions");
		lblListOfRequirements.setBounds(10, 11, 377, 42);
		lblListOfRequirements.setForeground(Color.CYAN);
		lblListOfRequirements.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblListOfRequirements.setHorizontalAlignment(SwingConstants.CENTER);
		frmComets.getContentPane().add(lblListOfRequirements);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 397, 63);
		frmComets.getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 64, 377, 360);

		frmComets.getContentPane().add(scrollPane);

		JTextArea txtrRequirementsThis = new JTextArea();
		txtrRequirementsThis.setWrapStyleWord(true);
		txtrRequirementsThis.setForeground(Color.CYAN);
		txtrRequirementsThis.setBackground(Color.BLACK);

		txtrRequirementsThis.setLineWrap(true);
		txtrRequirementsThis.setText(
				"Hi Player One,\r\n\r\nYou have just awoken in a hotel maze. \r\nYou will be wandering for eternity through endless doors of vocab.\r\nHow exciting,right?\r\nYou have a magical tablet that changes after each door you go through.\r\n\r\nIt looks like they have words on them that are definitions to the name tags on the doors.\r\nHopefully, if you match them, you can continue to progress through the hotel\r\nfor all of eternity, instead of being stuck in one place for all of eternity.....\r\n\r\n//////////////////Controls/////////////////\r\nHold down the number keys \" 1 \", \"2\" , \"3\", the first door being the one to the left, and the second door being the one to the right.\r\n\r\nUsing the number keys will allow you to choose the doors that you want to go through\r\nIf you change your mind on choosing a door release the key before .4 seconds. \r\nBut, hey... Whats the worse that can happen? A locked door at a hotel?\r\n\r\n////////////////////////////////////////////\r\nA High Score Count in the bottom right corner\r\nwill keep track of how many doors you progress through\r\nduring your eternal stay.\r\n////////////////////////////////////////////\r\nIf a wrong door is chosen, the words, \"locked\", will appear, and you will have .5 seconds before you can choose another door as you walk back to your earlier position.\r\nIf the correct door is chosen, the door will open, and it will \r\ntake a second for you to walk through.\r\n\r\nEnjoy Your Eternal Wandering at the Hotel!!!!\r\n\r\nPS: \r\nYou can escape by closing the window at any time ^_^");
		txtrRequirementsThis.setCaretPosition(0);
		scrollPane.setViewportView(txtrRequirementsThis);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 435, 397, 29);
		frmComets.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Return");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frmComets.dispose();
				welcomePage.main(null);

			}
		});
		btnNewButton.setForeground(Color.CYAN);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(0, 0, 397, 29);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 64, 397, 400);
		frmComets.getContentPane().add(panel_2);

	}
}
