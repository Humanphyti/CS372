import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class HelloWindow extends JFrame implements ActionListener, MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	//URL imgURL = getClass().getResource("C:\\Dev\\Workspace\\Homework2\\src\\resources");
	
	int imageX, imageY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWindow window = new HelloWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void CreateKid() {
		Image imgK = toolkit.getImage("resources/kidSprite.PNG");
		ImageIcon iconK = new ImageIcon(imgK);
		JLabel labelK = new JLabel(iconK);
		
		frame.add(labelK);
	}
		
	public void CreateTeacher() {
		Image imgT = toolkit.getImage("resources/teacherSprite.PNG");
		ImageIcon iconT = new ImageIcon(imgT);
		JLabel labelT = new JLabel(iconT);
		frame.add(labelT);
	}
		
	public void CreateOfficer() {
		Image imgO = toolkit.getImage("resources/policeSprite.PNG");
		imgO = imgO.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon iconO = new ImageIcon(imgO);
		JLabel labelO = new JLabel(iconO);
		frame.add(labelO);
	}

	/**
	 * Create the application.
	 */
	public HelloWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("My City");
		frame.setBounds(100, 100, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 31, 0, 0, 29, 30, 30, 0, 0, 29, 0, 0, 0, 0, 29, 0, 30, 0, 30, 0, 0, 29, 0, 0, 0, 0, 0, 31, 0, 31, 0, 0};
		gridBagLayout.rowHeights = new int[]{30, 30, 0, 0, 0, 0, 0, 30, 0, 0, 0, 30, 30, 0, 29, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblOfficersInCity = new JLabel("Officers in City Hall");
		GridBagConstraints gbc_lblOfficersInCity = new GridBagConstraints();
		gbc_lblOfficersInCity.gridwidth = 3;
		gbc_lblOfficersInCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblOfficersInCity.gridx = 1;
		gbc_lblOfficersInCity.gridy = 0;
		frame.getContentPane().add(lblOfficersInCity, gbc_lblOfficersInCity);
		
		JLabel lblKidsInSchool = new JLabel("Kids in School");
		GridBagConstraints gbc_lblKidsInSchool = new GridBagConstraints();
		gbc_lblKidsInSchool.gridwidth = 3;
		gbc_lblKidsInSchool.insets = new Insets(0, 0, 5, 5);
		gbc_lblKidsInSchool.gridx = 16;
		gbc_lblKidsInSchool.gridy = 0;
		frame.getContentPane().add(lblKidsInSchool, gbc_lblKidsInSchool);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 3;
		gbc_list.gridheight = 6;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		frame.getContentPane().add(list, gbc_list);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 9;
		gbc_panel.gridheight = 7;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 4;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCityHall = new JLabel("City Hall");
		lblCityHall.setForeground(new Color(255, 255, 255));
		lblCityHall.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCityHall, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 128, 0));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.gridwidth = 3;
		gbc_panel_7.gridheight = 7;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 19;
		gbc_panel_7.gridy = 0;
		frame.getContentPane().add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPlayground = new JLabel("School\r \nPlayground");
		lblPlayground.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblPlayground, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 9;
		gbc_panel_1.gridheight = 7;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 22;
		gbc_panel_1.gridy = 0;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSchool = new JLabel("School");
		lblSchool.setBackground(new Color(255, 0, 0));
		lblSchool.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblSchool, BorderLayout.CENTER);
		
		JList list_1 = new JList();
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.gridheight = 6;
		gbc_list_1.gridwidth = 3;
		gbc_list_1.insets = new Insets(0, 0, 5, 5);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 16;
		gbc_list_1.gridy = 1;
		frame.getContentPane().add(list_1, gbc_list_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 7;
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 7;
		gbc_panel_2.gridy = 7;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridheight = 5;
		gbc_panel_4.gridwidth = 2;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 24;
		gbc_panel_4.gridy = 7;
		frame.getContentPane().add(panel_4, gbc_panel_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(138, 43, 226));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridheight = 2;
		gbc_panel_6.gridwidth = 4;
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 3;
		gbc_panel_6.gridy = 12;
		frame.getContentPane().add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JButton btnCreateKid = new JButton("Create Kid");
		GridBagConstraints gbc_btnCreateKid = new GridBagConstraints();
		gbc_btnCreateKid.gridwidth = 2;
		gbc_btnCreateKid.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateKid.gridx = 0;
		gbc_btnCreateKid.gridy = 0;
		panel_6.add(btnCreateKid, gbc_btnCreateKid);
		
		JLabel lblTheSweets = new JLabel("The Sweets");
		GridBagConstraints gbc_lblTheSweets = new GridBagConstraints();
		gbc_lblTheSweets.gridwidth = 2;
		gbc_lblTheSweets.gridx = 0;
		gbc_lblTheSweets.gridy = 1;
		panel_6.add(lblTheSweets, gbc_lblTheSweets);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 17;
		gbc_panel_3.gridheight = 2;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 9;
		gbc_panel_3.gridy = 12;
		frame.getContentPane().add(panel_3, gbc_panel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridheight = 2;
		gbc_panel_5.gridwidth = 4;
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 26;
		gbc_panel_5.gridy = 12;
		frame.getContentPane().add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JButton btnDonut = new JButton("Create Officer");
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateOfficer();
			}
		});
		GridBagConstraints gbc_btnDonut = new GridBagConstraints();
		gbc_btnDonut.insets = new Insets(0, 0, 5, 0);
		gbc_btnDonut.gridx = 0;
		gbc_btnDonut.gridy = 0;
		panel_5.add(btnDonut, gbc_btnDonut);
		
		JLabel lblYeOlDonut = new JLabel("Ye Ol' Donut Shop");
		lblYeOlDonut.setForeground(new Color(0, 0, 0));
		lblYeOlDonut.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_lblYeOlDonut = new GridBagConstraints();
		gbc_lblYeOlDonut.gridx = 0;
		gbc_lblYeOlDonut.gridy = 1;
		panel_5.add(lblYeOlDonut, gbc_lblYeOlDonut);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.gridheight = 7;
		gbc_panel_8.gridwidth = 2;
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 14;
		gbc_panel_8.gridy = 14;
		frame.getContentPane().add(panel_8, gbc_panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.CYAN);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.gridheight = 3;
		gbc_panel_9.gridwidth = 30;
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 1;
		gbc_panel_9.gridy = 21;
		frame.getContentPane().add(panel_9, gbc_panel_9);
		
		JButton btnCreateTeacher = new JButton("Create Teacher");
		panel_9.add(btnCreateTeacher);
		
		
		JLabel lblTeacherHomesresidentialArea = new JLabel("Teacher Homes/Residential Area");
		panel_9.add(lblTeacherHomesresidentialArea);
		
		btnCreateTeacher.addActionListener(e -> CreateTeacher());
		btnCreateKid.addActionListener(e -> CreateKid());
		btnDonut.addActionListener(e-> CreateOfficer());
		
		addMouseMotionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(imgT, 0, 0, this);
		g2.drawImage(imgO, 10, 10, this);
		g2.drawImage(imgK, 30, 30, this);
		
	}*/
	
	/*public void paintO(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(imgO, 2, 2, this);
	}
	
	public void paintK(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(imgO, 2, 2, this);
	}*/

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		imageX = e.getX();
		imageY = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

}
