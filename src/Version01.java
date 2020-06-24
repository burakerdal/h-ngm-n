import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

@SuppressWarnings({ "serial", "unused" })
public class Version01 extends JFrame {

	static Version01 frame;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Version01();
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
	/*
	tuþlar Q harfindeki gibi olacak
	tuþlarýn labelleri arraye alýnacak
	sýfýrla ve baþla metod yapýlacak
	kod kýsaltýlacak
	*/
	
	
	private static int count =0;
	private static int pr = -1;
	private static String in = "";
	private static String hints ="";
	private static int hintchance =5;
	private static int týklanma =0;
	private static boolean firstSýfýrla = true;
	private static boolean gosterIpucu = false;
	private static boolean baslat = false;
	private static boolean firstBaþla = true;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JLabel lblAdams;
	private static JLabel lblNewLabel_1;
	private static JLabel lblNewLabel_2;
	private static JLabel lblNewLabel_3;
	private static JLabel lblcategory;
	private static ImageIcon[]images = new ImageIcon[6];
	private static JLabel[] labels = new JLabel[32];

	private static JLabel label_1;
	private static JLabel label_2;
	private static JLabel label_3;
	private static JLabel label_4;
	private static JLabel label_5;
	private static JLabel label_6;
	private static JLabel label_7;
	private static JLabel label_8;
	private static JLabel label_9;
	private static JLabel label_10;
	private static JLabel label_11;
	private static JLabel label_12;
	private static JLabel label_13;
	private static JLabel label_14;
	private static JLabel label_15;
	private static JLabel label_16;
	private static JLabel label_17;
	private static JLabel label_18;
	private static JLabel label_19;
	private static JLabel label_20;
	private static JLabel label_21;
	private static JLabel label_22;
	private static JLabel label_23;
	private static JLabel label_24;
	private static JLabel label_25;
	private static JLabel label_26;
	private static JLabel label_27;
	private static JLabel label_28;
	private static JLabel label_29;
	private static JLabel label_30;
	private static JLabel label_31;
	
	private static LinkedQueue board = new LinkedQueue();
	private static LinkedQueue word = new LinkedQueue();
	private static LinkedQueue missing = new LinkedQueue();
	private static LinkedQueue hint = new LinkedQueue();
	private static LinkedQueue hint2 = new LinkedQueue();
	private static LinkedQueue hint3 = new LinkedQueue();
	private static LinkedQueue hint4 = new LinkedQueue();
	private static LinkedQueue hint5 = new LinkedQueue();
	
	private static LinkedQueue[] categories = new LinkedQueue[4];
	
	private static JButton btnIpucu;
	
    Game play = new Game();
    private static JMenuItem mnýtmehirler;
    private static JMenuItem mnýtmTakmlar;
    private static JMenuItem mnýtmUnluler;
    private static JMenuItem mnýtmUlkeler;
    private static JMenuItem mnýtmYazarlar;
    private static JLabel lblNewLabel_4;
	
	public Version01() {
		setTitle("h@ngm@n");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/logo.png"));
		
		categories[0] = new LinkedQueue();
		categories[1] = new LinkedQueue();
		categories[2] = new LinkedQueue();
		categories[3] = new LinkedQueue();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 540);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(new Color(0, 128, 0));
		setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("KATEGOR\u0130LER");
		mnOptions.setForeground(Color.WHITE);
		mnOptions.setFont(new Font("Atiba", Font.BOLD, 12));
		menuBar.add(mnOptions);
		
		JMenu mnHelp = new JMenu("YARDIM");
		mnHelp.setForeground(Color.WHITE);
		mnHelp.setFont(new Font("Atiba", Font.BOLD, 12));
		menuBar.add(mnHelp);
		
		JMenuItem mnýtmHangmanHakknda = new JMenuItem("Nas\u0131l Oynan\u0131r");
		mnýtmHangmanHakknda.setHorizontalAlignment(SwingConstants.CENTER);
		mnýtmHangmanHakknda.setFont(new Font("Atiba", Font.PLAIN, 12));
		mnýtmHangmanHakknda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JLabel lblrules = new JLabel("");
				lblrules.setIcon(new ImageIcon("./img/rules2.JPG"));
				lblrules.setBounds(10, 11, 664, 245);
				contentPane.add(lblrules);
				JOptionPane.showMessageDialog(lblrules, lblrules, getTitle(), 1);
			}
		});
		mnýtmHangmanHakknda.setIcon(new ImageIcon("./img/question.png"));
		mnHelp.add(mnýtmHangmanHakknda);
		
		JMenuItem mnýtmk = new JMenuItem("\u00C7\u0131k\u0131\u015F");
		mnýtmk.setHorizontalAlignment(SwingConstants.CENTER);
		mnýtmk.setFont(new Font("Atiba", Font.PLAIN, 12));
		mnýtmk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int decide = JOptionPane.showConfirmDialog(null, "Çýkmak istediðinizden emin misiniz?");
				if(decide==0)
				{
					System.exit(0);
				}	
			}
		});
		mnýtmk.setIcon(new ImageIcon("./img/exit.png"));
		mnHelp.add(mnýtmk);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		images[0]=new ImageIcon("./img/adam0.JPG");
		images[1]=new ImageIcon("./img/adam1.JPG");
		images[2]=new ImageIcon("./img/adam2.JPG");
		images[3]=new ImageIcon("./img/adam3.JPG");
		images[4]=new ImageIcon("./img/adam4.JPG");
		
		lblAdams = new JLabel("");
		lblAdams.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdams.setIcon(images[0]);
		lblAdams.setBounds(30, 26, 243, 322);
		contentPane.add(lblAdams);
		
		lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setFont(new Font("Atiba", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(39, 380, 218, 37);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(310, 380, 354, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Kalan Tahmin");
		lblNewLabel.setFont(new Font("Atiba", Font.PLAIN, 14));
		lblNewLabel.setBounds(325, 35, 141, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Atiba", Font.PLAIN, 14));
		textField.setEditable(false);
		textField.setBounds(520, 35, 42, 20);
		textField.setText(String.valueOf(play.getTahminhakký()));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblScore = new JLabel("Skor");
		lblScore.setFont(new Font("Atiba", Font.PLAIN, 14));
		lblScore.setBounds(325, 65, 88, 20);
		contentPane.add(lblScore);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Atiba", Font.PLAIN, 14));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(520, 65, 42, 20);
		textField_1.setText(String.valueOf(play.getScore()));
		contentPane.add(textField_1);
		
		JLabel lblMisses = new JLabel("Olmayan Harfler");
		lblMisses.setFont(new Font("Atiba", Font.PLAIN, 14));
		lblMisses.setBounds(325, 95, 185, 23);
		contentPane.add(lblMisses);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(520, 95, 115, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(310, 206, 325, 36);
		contentPane.add(textField_3);
	
		lblcategory = new JLabel("(Kategori)");
		lblcategory.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblcategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblcategory.setBounds(310, 169, 325, 33);
		contentPane.add(lblcategory);
		
		mnýtmUlkeler = new JMenuItem("\u00DClkeler");
		mnýtmUlkeler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mnýtmUlkeler.setSelected(true);
				mnýtmehirler.setSelected(false);
				mnýtmTakmlar.setSelected(false);
				mnýtmUnluler.setSelected(false);
				
				addQueue(categories[0],hint, "./txt/ülkeler.txt");
				play.choose(categories[0], board, word, missing,hint);
				lblcategory.setText("(\u00DClkeler)");	
			}
		});
		mnýtmUlkeler.setIcon(new ImageIcon("./img/z1.png"));
		mnýtmUlkeler.setHorizontalAlignment(SwingConstants.CENTER);
		mnýtmUlkeler.setFont(new Font("Atiba", Font.PLAIN, 12));
		mnOptions.add(mnýtmUlkeler);
		
		mnýtmehirler = new JMenuItem("\u015Eehirler");
		mnýtmehirler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mnýtmUlkeler.setSelected(false);
				mnýtmehirler.setSelected(true);
				mnýtmTakmlar.setSelected(false);
				mnýtmUnluler.setSelected(false);
				
				addQueue(categories[1],hint2, "./txt/sehirler.txt");
				play.choose(categories[1], board, word, missing,hint2);
				lblcategory.setText("(\u015Eehirler)");	
			}
		});
		mnýtmehirler.setIcon(new ImageIcon("./img/z2.png"));
		mnýtmehirler.setFont(new Font("Atiba", Font.PLAIN, 12));
		mnýtmehirler.setHorizontalAlignment(SwingConstants.CENTER);
		mnOptions.add(mnýtmehirler);
		
		mnýtmTakmlar = new JMenuItem("Tak\u0131mlar");
		mnýtmTakmlar.setIcon(new ImageIcon("./img/z3.png"));
		mnýtmTakmlar.setFont(new Font("Atiba", Font.PLAIN, 12));
		mnýtmTakmlar.setHorizontalAlignment(SwingConstants.CENTER);
		mnýtmTakmlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mnýtmUlkeler.setSelected(false);
				mnýtmehirler.setSelected(false);
				mnýtmTakmlar.setSelected(true);
				mnýtmUnluler.setSelected(false);
				
				addQueue(categories[2],hint3, "./txt/takimlar.txt");
				play.choose(categories[2], board, word, missing,hint3);
				lblcategory.setText("(Futbol Tak\u0131mlar\u0131)");	
			}
		});
		mnOptions.add(mnýtmTakmlar);
		
		mnýtmUnluler = new JMenuItem("\u00DCnl\u00FCler");
		mnýtmUnluler.setIcon(new ImageIcon("./img/z4.png"));
		mnýtmUnluler.setFont(new Font("Atiba", Font.PLAIN, 12));
		mnýtmUnluler.setHorizontalAlignment(SwingConstants.CENTER);
		mnýtmUnluler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mnýtmUlkeler.setSelected(false);
				mnýtmehirler.setSelected(false);
				mnýtmTakmlar.setSelected(false);
				mnýtmUnluler.setSelected(true);
				
				addQueue(categories[3],hint4, "./txt/ünlüler.txt");
				play.choose(categories[3], board, word, missing,hint4);
				lblcategory.setText("(\u00DCnl\u00FCler)");		
			}
		});
		mnOptions.add(mnýtmUnluler);
		
			
		labels[0] = new JLabel("");
		labels[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(baslat)
				{
					if(labels[0].isEnabled())
					{										
							in="q";
							tus(play,in);																					
					}
					labels[0].setEnabled(false);
				}
				
			}
		});
		labels[0].setIcon(new ImageIcon("./img/Letter Q pink.png"));
		labels[0].setBounds(319, 292, 16, 16);
		contentPane.add(labels[0]);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_1.isEnabled())
				{
					in="w";
					tus(play, in);

				}
				label_1.setEnabled(false);
			}
		});
		label_1.setIcon(new ImageIcon("./img/Letter W pink.png"));
		label_1.setBounds(345, 292, 16, 16);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_2.isEnabled())
				{
					in="e";
					tus(play, in);
					
				}
				label_2.setEnabled(false);
			}
		});
		label_2.setIcon(new ImageIcon("./img/Letter E pink.png"));
		label_2.setBounds(371, 292, 16, 16);
		contentPane.add(label_2);
		
		label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_3.isEnabled())
				{
					in="r";
					tus(play, in);
					
				}
				label_3.setEnabled(false);
			}
		});
		label_3.setIcon(new ImageIcon("./img/Letter R pink.png"));
		label_3.setBounds(397, 292, 16, 16);
		contentPane.add(label_3);
		
		label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_4.isEnabled())
				{
					in="t";
					tus(play, in);
				
				}
				label_4.setEnabled(false);
			}
		});
		label_4.setIcon(new ImageIcon("./img/Letter T pink.png"));
		label_4.setBounds(423, 292, 16, 16);
		contentPane.add(label_4);
		
		label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_5.isEnabled())
				{
					in="y";
					tus(play, in);
					
				}
				label_5.setEnabled(false);
			}
		});
		label_5.setIcon(new ImageIcon("./img/Letter Y pink.png"));
		label_5.setBounds(449, 292, 16, 16);
		contentPane.add(label_5);
		
		label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_6.isEnabled())
				{
					in="u";
					tus(play, in);
					
				}
				label_6.setEnabled(false);
			}
		});
		label_6.setIcon(new ImageIcon("./img/Letter U pink.png"));
		label_6.setBounds(475, 292, 16, 16);
		contentPane.add(label_6);
		
		label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_7.isEnabled())
				{
					in="ý";
					tus(play, in);
				}
				label_7.setEnabled(false);
			}
		});
		label_7.setIcon(new ImageIcon("./img/Letter I pink.png"));
		label_7.setBounds(501, 292, 16, 16);
		contentPane.add(label_7);
		
		label_8 = new JLabel("");
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_8.isEnabled())
				{
					in="o";
					tus(play, in);
				}
				label_8.setEnabled(false);
			}
		});
		label_8.setIcon(new ImageIcon("./img/Letter O pink.png"));
		label_8.setBounds(527, 292, 16, 16);
		contentPane.add(label_8);
		
		label_9 = new JLabel("");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_9.isEnabled())
				{
					in="p";
					tus(play, in);
				}
				label_9.setEnabled(false);
			}
		});
		label_9.setIcon(new ImageIcon("./img/Letter P pink.png"));
		label_9.setBounds(553, 292, 16, 16);
		contentPane.add(label_9);
		
		label_10 = new JLabel("");
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_10.isEnabled())
				{
					in="ð";
					tus(play, in);
				}
				label_10.setEnabled(false);
			}
		});
		label_10.setIcon(new ImageIcon("./img/Letter G violet.png"));
		label_10.setBounds(579, 292, 16, 16);
		contentPane.add(label_10);
		
		label_11 = new JLabel("");
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_11.isEnabled())
				{
					in="ü";
					tus(play, in);
				}
				label_11.setEnabled(false);
			}
		});
		label_11.setIcon(new ImageIcon("./img/Letter U violet.png"));
		label_11.setBounds(605, 292, 16, 16);
		contentPane.add(label_11);
		
		label_12 = new JLabel("");
		label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_12.isEnabled())
				{
					in="a";
					tus(play, in);
					
				}
				label_12.setEnabled(false);
			}
		});
		label_12.setIcon(new ImageIcon("./img/Letter A pink.png"));
		label_12.setBounds(329, 317, 16, 16);
		contentPane.add(label_12);
		
		label_13 = new JLabel("");
		label_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_13.isEnabled())
				{
					in="s";
					tus(play, in);
				}
				label_13.setEnabled(false);
			}
		});
		label_13.setIcon(new ImageIcon("./img/Letter S pink.png"));
		label_13.setBounds(355, 317, 16, 16);
		contentPane.add(label_13);
		
		label_14 = new JLabel("");
		label_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_14.isEnabled())
				{
					in="d";
					tus(play, in);
				}
				label_14.setEnabled(false);
			}
		});
		label_14.setIcon(new ImageIcon("./img/Letter D pink.png"));
		label_14.setBounds(381, 317, 16, 16);
		contentPane.add(label_14);
		
		label_15 = new JLabel("");
		label_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_15.isEnabled())
				{
					in="f";
					tus(play, in);
				}
				label_15.setEnabled(false);
			}
		});
		label_15.setIcon(new ImageIcon("./img/Letter F pink.png"));
		label_15.setBounds(407, 317, 16, 16);
		contentPane.add(label_15);
		
		label_16 = new JLabel("");
		label_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_16.isEnabled())
				{
					in="g";
					tus(play, in);
				}
				label_16.setEnabled(false);
			}
		});
		label_16.setIcon(new ImageIcon("./img/Letter G pink.png"));
		label_16.setBounds(433, 317, 16, 16);
		contentPane.add(label_16);
		
		label_17 = new JLabel("");
		label_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_17.isEnabled())
				{
					in="h";
					tus(play, in);
				}
				label_17.setEnabled(false);
			}
		});
		label_17.setIcon(new ImageIcon("./img/Letter H pink.png"));
		label_17.setBounds(459, 317, 16, 16);
		contentPane.add(label_17);
		
		label_18 = new JLabel("");
		label_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_18.isEnabled())
				{
					in="z";
					tus(play, in);
				}
				label_18.setEnabled(false);
			}
		});
		label_18.setIcon(new ImageIcon("./img/Letter Z pink.png"));
		label_18.setBounds(339, 344, 16, 16);
		contentPane.add(label_18);
		
		label_19 = new JLabel("");
		label_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_19.isEnabled())
				{
					in="x";
					tus(play, in);
				}
				label_19.setEnabled(false);
			}
		});
		label_19.setIcon(new ImageIcon("./img/Letter X pink.png"));
		label_19.setBounds(365, 344, 16, 16);
		contentPane.add(label_19);
		
		label_20 = new JLabel("");
		label_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_20.isEnabled())
				{
					in="c";
					tus(play, in);
				}
				label_20.setEnabled(false);
			}
		});
		label_20.setIcon(new ImageIcon("./img/Letter C pink.png"));
		label_20.setBounds(391, 344, 16, 16);
		contentPane.add(label_20);
		
		label_21 = new JLabel("");
		label_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_21.isEnabled())
				{
					in="j";
					tus(play, in);
				}
				label_21.setEnabled(false);
			}
		});
		label_21.setIcon(new ImageIcon("./img/Letter J pink.png"));
		label_21.setBounds(485, 317, 16, 16);
		contentPane.add(label_21);
		
		label_22 = new JLabel("");
		label_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_22.isEnabled())
				{
					in="k";
					tus(play, in);
				}
				label_22.setEnabled(false);
			}
		});
		label_22.setIcon(new ImageIcon("./img/Letter K pink.png"));
		label_22.setBounds(511, 317, 16, 16);
		contentPane.add(label_22);
		
		label_23 = new JLabel("");
		label_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_23.isEnabled())
				{
					in="l";
					tus(play, in);
				}
				label_23.setEnabled(false);
			}
		});
		label_23.setIcon(new ImageIcon("./img/Letter L pink.png"));
		label_23.setBounds(537, 317, 16, 16);
		contentPane.add(label_23);
		
		label_24 = new JLabel("");
		label_24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_24.isEnabled())
				{
					in="þ";
					tus(play, in);
				}
				label_24.setEnabled(false);
			}
		});
		label_24.setIcon(new ImageIcon("./img/Letter S violet.png"));
		label_24.setBounds(563, 317, 16, 16);
		contentPane.add(label_24);
		
		label_25 = new JLabel("");
		label_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_25.isEnabled())
				{
					in="i";
					tus(play, in);
				}
				label_25.setEnabled(false);
			}
		});
		label_25.setIcon(new ImageIcon("./img/Letter I violet.png"));
		label_25.setBounds(589, 317, 16, 16);
		contentPane.add(label_25);
		
		label_26 = new JLabel("");
		label_26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_26.isEnabled())
				{
					in="v";
					tus(play, in);
				}
				label_26.setEnabled(false);
			}
		});
		label_26.setIcon(new ImageIcon("./img/Letter V pink.png"));
		label_26.setBounds(417, 344, 16, 16);
		contentPane.add(label_26);
		
		label_27 = new JLabel("");
		label_27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_27.isEnabled())
				{
					in="b";
					tus(play, in);
				}
				label_27.setEnabled(false);
			}
		});
		label_27.setIcon(new ImageIcon("./img/Letter B pink.png"));
		label_27.setBounds(443, 344, 16, 16);
		contentPane.add(label_27);
		
		label_28 = new JLabel("");
		label_28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_28.isEnabled())
				{
					in="n";
					tus(play, in);
				}
				label_28.setEnabled(false);
			}
		});
		label_28.setIcon(new ImageIcon("./img/Letter N pink.png"));
		label_28.setBounds(469, 344, 16, 16);
		contentPane.add(label_28);
		
		label_29 = new JLabel("");
		label_29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_29.isEnabled())
				{
					in="m";
					tus(play, in);
				}
				label_29.setEnabled(false);
			}
		});
		label_29.setIcon(new ImageIcon("./img/Letter M pink.png"));
		label_29.setBounds(495, 344, 16, 16);
		contentPane.add(label_29);
		
		label_30 = new JLabel("");
		label_30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_30.isEnabled())
				{
					in="ö";
					tus(play, in);
				}
				label_30.setEnabled(false);
			}
		});
		label_30.setIcon(new ImageIcon("./img/Letter O violet.png"));
		label_30.setBounds(521, 344, 16, 16);
		contentPane.add(label_30);
		
		label_31 = new JLabel("");
		label_31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_31.isEnabled())
				{
					in="ç";
					tus(play, in);
				}
				label_31.setEnabled(false);
			}
		});
		label_31.setIcon(new ImageIcon("./img/Letter C violet.png"));
		label_31.setBounds(547, 344, 16, 16);
		contentPane.add(label_31);		
		
		
		JButton btnStart = new JButton("Ba\u015Fla");
		btnStart.setFont(new Font("Atiba", Font.PLAIN, 14));
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.BLACK);
				boolean first = false;
				
				if(!mnýtmUlkeler.isSelected()&& !mnýtmehirler.isSelected() && !mnýtmTakmlar.isSelected() && !mnýtmUnluler.isSelected() && !mnýtmYazarlar.isSelected())
				{
					JOptionPane.showMessageDialog(null, "Lütfen öncelikle bir kategori seçiniz",getTitle(), JOptionPane.WARNING_MESSAGE);
                    first=true;
				}
				
				if(!first)
				{
					baslat=true;
					count=0;
					lblAdams.setIcon(images[0]);
					play.setWrongGuess(0);
					play.setTahminhakký(5);
					//play.setScore(0);
					týklanma=0;
					btnIpucu.setEnabled(false);
					gosterIpucu=false;
					textField.setText(String.valueOf(play.getTahminhakký()));
					textField_1.setText(String.valueOf(play.getScore()));			
					play.delete(missing);
					textField_2.setText(play.getMissing().display2(missing));											
					labels[0].setEnabled(true);
					label_1.setEnabled(true);
					label_2.setEnabled(true);
					label_3.setEnabled(true);
					label_4.setEnabled(true);
					label_5.setEnabled(true);
					label_6.setEnabled(true);
					label_7.setEnabled(true);
					label_8.setEnabled(true);
					label_9.setEnabled(true);
					label_10.setEnabled(true);
					label_11.setEnabled(true);
					label_12.setEnabled(true);
					label_13.setEnabled(true);
					label_14.setEnabled(true);
					label_15.setEnabled(true);
					label_16.setEnabled(true);
					label_17.setEnabled(true);
					label_18.setEnabled(true);
					label_19.setEnabled(true);
					label_20.setEnabled(true);
					label_21.setEnabled(true);
					label_22.setEnabled(true);
					label_23.setEnabled(true);
					label_24.setEnabled(true);
					label_25.setEnabled(true);
					label_26.setEnabled(true);
					label_27.setEnabled(true);
					label_28.setEnabled(true);
					label_29.setEnabled(true);
					label_30.setEnabled(true);
					label_31.setEnabled(true);
					lblNewLabel_1.setText("");
					lblNewLabel_2.setText("");
					
					
					if(mnýtmUlkeler.isSelected())
					{			
						
						play.step1();
						while(play.getBoard().size()==0)
						{
							play.step1();
						}
						textField_3.setText(play.getBoard().display1(board));
				
						
					}
					else if(mnýtmehirler.isSelected())
					{
						
						play.step1();
						while(play.getBoard().size()==0)
						{
							play.step1();
						}
						textField_3.setText(play.getBoard().display1(board));				
					
					}
					else if(mnýtmTakmlar.isSelected())
					{
						
						play.step1();
						while(play.getBoard().size()==0)
						{
							play.step1();
						}
						textField_3.setText(play.getBoard().display1(board));
						
					}
					else if(mnýtmUnluler.isSelected())
					{
						
						play.step1();
						while(play.getBoard().size()==0)
						{
							play.step1();
						}
						textField_3.setText(play.getBoard().display1(board));
						
					}
				}
				
				
				
			}
		});
		btnStart.setBounds(430, 253, 90, 23);
		contentPane.add(btnStart);
		
		JButton btnSfrla = new JButton("SIFIRLA");
		btnSfrla.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnSfrla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean first = false;
				
				if(!mnýtmUlkeler.isSelected()&& !mnýtmehirler.isSelected() && !mnýtmTakmlar.isSelected() && !mnýtmUnluler.isSelected() && !mnýtmYazarlar.isSelected())
				{
					JOptionPane.showMessageDialog(null, "Lütfen öncelikle bir kategori seçiniz",getTitle(), JOptionPane.WARNING_MESSAGE);
                    first=true;
				}
				
				if(!first)
				{
					
					mnýtmUlkeler.setSelected(false);
					mnýtmehirler.setSelected(false);
					mnýtmTakmlar.setSelected(false);
					mnýtmUnluler.setSelected(false);
					týklanma=0;
					gosterIpucu=false;
					lblcategory.setText("(Kategori)");
					lblAdams.setIcon(images[0]);
					play.setWrongGuess(0);
					play.setTahminhakký(5);
					play.setScore(0);
					btnIpucu.setEnabled(false);
					textField.setText(String.valueOf(play.getTahminhakký()));
					textField_1.setText(String.valueOf(play.getScore()));				
					play.delete(missing);		
					textField_2.setText(play.getMissing().display2(missing));								
					textField_3.setText("");
					lblNewLabel_1.setText("");
					lblNewLabel_1.setForeground(Color.BLACK);
					lblNewLabel_2.setText("");
					labels[0].setEnabled(true);
					label_1.setEnabled(true);
					label_2.setEnabled(true);
					label_3.setEnabled(true);
					label_4.setEnabled(true);
					label_5.setEnabled(true);
					label_6.setEnabled(true);
					label_7.setEnabled(true);
					label_8.setEnabled(true);
					label_9.setEnabled(true);
					label_10.setEnabled(true);
					label_11.setEnabled(true);
					label_12.setEnabled(true);
					label_13.setEnabled(true);
					label_14.setEnabled(true);
					label_15.setEnabled(true);
					label_16.setEnabled(true);
					label_17.setEnabled(true);
					label_18.setEnabled(true);
					label_19.setEnabled(true);
					label_20.setEnabled(true);
					label_21.setEnabled(true);
					label_22.setEnabled(true);
					label_23.setEnabled(true);
					label_24.setEnabled(true);
					label_25.setEnabled(true);
					label_26.setEnabled(true);
					label_27.setEnabled(true);
					label_28.setEnabled(true);
					label_29.setEnabled(true);
					label_30.setEnabled(true);
					label_31.setEnabled(true);
					hintchance=5;
					lblNewLabel_3.setText(String.valueOf(hintchance)+"/5");
					count=0;
				}
				
			}
		});
		btnSfrla.setBounds(545, 140, 90, 23);
		contentPane.add(btnSfrla);
		
		
		btnIpucu = new JButton("\u0130PUCU");
		btnIpucu.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnIpucu.setEnabled(false);
		btnIpucu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				týklanma++;
				if(btnIpucu.isEnabled()&& !gosterIpucu)
				{
					pr=hintchance;
					hints=play.getHintstr();
					JOptionPane.showMessageDialog(null, hints,getTitle(), 1);
                    hintchance--;            
                    lblNewLabel_3.setText(String.valueOf(hintchance)+"/5");
                    gosterIpucu=true;
				}		
				if(gosterIpucu&&týklanma>1)
				{
					JOptionPane.showMessageDialog(null, hints,getTitle(), 1);
				}
				
			}
		});
		btnIpucu.setBounds(319, 140, 89, 23);
		contentPane.add(btnIpucu);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setText("5/5");
		lblNewLabel_3.setBounds(420, 140, 107, 18);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("./img/fon.jpg"));
		lblNewLabel_4.setBounds(0, 0, 694, 508);
		contentPane.add(lblNewLabel_4);
		
		
	
		
		
		
		
		
		
		

		
		
		
		
		
	}
	
	public static void addQueue(LinkedQueue q,LinkedQueue hint,String path)
	{
		String line = null;
		try{
			FileReader freader = new FileReader(path);
			BufferedReader bfreader = new BufferedReader(freader);
			
			try {
				while((line = bfreader.readLine()) != null){
				
					String []words=line.split(";");
					
					for (int i = 0; i < words.length; i++) {
						if(i==0)
						{
							q.enqueue(words[i].toLowerCase());
						}
						else
						{
							hint.enqueue(words[i]);
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bfreader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch(FileNotFoundException ex){
			System.out.println("File not found!");
		}
	}
	
	public static void tus(Game play,String on)
	{
		
		
		play.run(on);
		if(play.getWrongGuess()<6)
		{
           
			textField.setText(String.valueOf(play.getTahminhakký()));
			textField_1.setText(String.valueOf(play.getScore()));
			textField_2.setText(play.getMissing().display2(missing));
			textField_3.setText(play.getBoard().display1(board));
			
			lblAdams.setIcon(images[play.getWrongGuess()]);  if(play.getWrongGuess()==4&&hintchance>0){btnIpucu.setEnabled(true);} 
			
			if(play.getWrongGuess()==5)
			{
				lblNewLabel_1.setForeground(Color.RED);
				lblNewLabel_1.setText("KAYBETTÝN");
				lblNewLabel_2.setText("Doðru cevap "+play.getWord().display1(word).toUpperCase());
			}
			if(play.getDoldu()>0)
			{
				count=count+play.getDoldu();
			}					
			if((count!=0&&count==play.getWord().size()))
			{
				
				lblNewLabel_1.setForeground(Color.YELLOW);lblNewLabel_1.setText("KAZANDIN");
			}
			else if((count!=play.getWord().size()))
			{
				int eq =0;
				for (int i = 0; i < board.size(); i++) {
					if(board.peek().equals(word.peek()))
					{
						eq++;
					}
					board.enqueue(board.dequeue());
					word.enqueue(word.dequeue());
				}
				if(eq==word.size())
				{							
					lblNewLabel_1.setForeground(Color.YELLOW);lblNewLabel_1.setText("KAZANDIN");
					
				}
			}

		}
		
	}
}
