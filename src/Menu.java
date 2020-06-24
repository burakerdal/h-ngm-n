import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings({ "unused", "serial" })
public class Menu extends JFrame {

	static Menu frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Menu();
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
	public Menu() {
		
		setTitle("h@ngm@n");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToHangman = new JLabel("");
		ImageIcon img = new ImageIcon("./img/hh2.JPG");
		lblWelcomeToHangman.setIcon(img);
		lblWelcomeToHangman.setBounds(10, 11, 664, 245);
		contentPane.add(lblWelcomeToHangman);
		
		JButton btnNewButton = new JButton("Nas\u0131l Oynan\u0131r");
		btnNewButton.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				JLabel lblrules = new JLabel("");
				lblrules.setIcon(new ImageIcon("./img/rules2.JPG"));
				lblrules.setBounds(10, 11, 664, 245);
				contentPane.add(lblrules);
				JOptionPane.showMessageDialog(lblrules, lblrules, getTitle(), 1);
				
			}
		});
		btnNewButton.setBounds(344, 286, 130, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Oyna");
		btnNewButton_1.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		btnNewButton_1.setIcon(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Version01 version01 = new Version01();
				version01.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(222, 286, 89, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblTmHaklarSakldr = new JLabel("designed by brkrdl \u00A9 2017");
		lblTmHaklarSakldr.setForeground(Color.WHITE);
		lblTmHaklarSakldr.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmHaklarSakldr.setBounds(222, 368, 238, 14);
		contentPane.add(lblTmHaklarSakldr);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("./img/fon.jpg"));
		lblNewLabel_4.setBounds(0, 0, 694, 508);
		contentPane.add(lblNewLabel_4);
	}
}
