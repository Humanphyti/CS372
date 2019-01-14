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
import javax.swing.JLayeredPane;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.List;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Font;

public class CityWindow extends JFrame implements ActionListener, MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //magic that happens from WindowBuilder
	private JPanel panel_2, panel_4, panel_3; //Panels that needed to be defined outside of initialize for functionality
	private JFrame frame; //yon frame of outputness
	Toolkit toolkit = Toolkit.getDefaultToolkit(); //default toolkit for creating sprite labels for dragging
	//URL imgURL = getClass().getResource("C:\\Dev\\Workspace\\Homework2\\src\\resources"); //unnecessary variable for separate locations of image files
	Point diffDrag; //uhhhhhhh..... something that lets the sprites be drug around the window.
	int imageX, imageY; //the x and y coordinates of the given image
	public ArrayList<Integer> labels = new ArrayList<Integer>(); //dynamic array of citizen types represented via a 1, 2, or 3
	public ArrayList<JLabel> citizen = new ArrayList<JLabel>(); //dynamic array of the images of the citizen types
	public ArrayList<Police> CityHall = new ArrayList<Police>(); // dynamic array of police in the city hall
	public ArrayList<Kid> SchoolK = new ArrayList<Kid>(); // dynamic array of kids in school
	public ArrayList<Teacher> SchoolT = new ArrayList<Teacher>();// dynamic array of teachers in school
	public ArrayList<Person> Population = new ArrayList<Person>(); // dynamic array of the entire population
	String Officer; //strings for pretty outputs
	String Kid;
	String Teacher;
	String teacherCert; // stores the certification level of a teacher
	//public ArrayList<JLabel> teacher = new ArrayList<JLabel>(); //thoughts on how to handle the images
	//public ArrayList<JLabel> kid = new ArrayList<JLabel>(); 
	Random rnd = new Random(); //initialization of random number generator
	enum candy{Twix, Reeses, Snickers, Rolo}; //enumeration of candy types for the kids
	JLayeredPane lpane; //the magical invisible box that lets me drag stuff around

	/**
	 * Launch the application.
	 * also black magic
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CityWindow window = new CityWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//function designed to create a kid when the create kid button is pressed
	public void CreateKid() {
		URL imgURL = getClass().getResource("resources/kidSprite.png");
		Image imgK = toolkit.getImage(imgURL);
		ImageIcon iconK = new ImageIcon(imgK);
		JLabel labelK = new JLabel(iconK);
		citizen.add(labelK); // add to the citizen array
		labels.add(3); //add to the labels array
		lpane.add(labelK); // add to the magical, invisible floating box
		Kid k = new Kid(randAge(), randPhoneNum(), "Bobby Lebowski", randFavCandy()); //make new walking-disease-vector 
		SchoolK.add(k); // add to school of kids
		Population.add(k); // add to population of city
	}
	//function meant to determine the kids favorite candy
	private String randFavCandy() {
		// TODO Auto-generated method stub
		int x = rnd.nextInt(4);
		if (x == 1)
			return "Twix";
		else if (x == 2)
			return "Reeses";
		else if (x==3)
			return "Snickers";
		else
			return "Rolo";
	}
	//function that determines the phone number through random number generation
	private String randPhoneNum() {
		// TODO Auto-generated method stub
		int area = rnd.nextInt(999);
		int city = rnd.nextInt(999);
		int num = rnd.nextInt(9999);
		String number = "(" + area + ")" + " " + city + "-" + num;
		return number;
	}
	//function that determines age through random number generation up 129 years old
	private int randAge() {
		int age = rnd.nextInt(130);
		return age;
	}
	//function to create a teacher on the button press
	public void CreateTeacher() {
		URL imgURL = getClass().getResource("resources/teacherSprite.png");
		Image imgT = toolkit.getImage(imgURL);
		ImageIcon iconT = new ImageIcon(imgT);
		JLabel labelT = new JLabel(iconT);
		labelT.setPreferredSize(new Dimension(40,40));
		lpane.add(labelT); //add to the invisible box
		citizen.add(labelT); //push on to citizen array
		labels.add(2); //push onto labels array
		Teacher t = new Teacher(randAge(), randPhoneNum(), "Wombold Wombo", randCert(), randGrade()); // create new teacher
		SchoolT.add(t); // add to the teacher in school array
		Population.add(t); //add to the population array
		
	}
	//function to pick the certification of the teacher
	private String randCert() {
		// TODO Auto-generated method stub
		
		int cert = rnd.nextInt(4);
		String Cert = "";
		switch(cert) {
		case 1:
			Cert = "Elementary";
			break;
		case 2:
			Cert = "Middle";
			break;
		case 3:
			Cert = "High";
			break;
		default:
			Cert = "PHS";
			break;
		}
		teacherCert = Cert;
		return Cert;
	}
	//function to determine the grade level teachers teach
	private String randGrade() {
		// TODO Auto-generated method stub
		String middle = "Middle";
		String high = "High";
		String phs = "PHS";
		int grade = rnd.nextInt(11);
		String Grade;
		switch(grade) {
		case 1:
			Grade = "First";
			break;
		case 2:
			Grade = "Second";
			break;
		case 3:
			Grade = "Third";
			break;
		case 4:
			Grade = "Fourth";
			break;
		case 5:
			Grade = "Fifth";
			break;
		case 6:
			if (teacherCert.equals(middle) || teacherCert.equals(high) || teacherCert.equals(phs))
				Grade = "Sixth";
			else
				Grade = "Kindergarten";
			break;
		case 7:
			if (teacherCert.equals(middle) || teacherCert.equals(high) || teacherCert.equals(phs))
				Grade = "Seventh";
			else
				Grade = "Kindergarten";
			break;
		case 8:
			if (teacherCert.equals(middle) || teacherCert.equals(high) || teacherCert.equals(phs))
				Grade = "Eighth";
			else
				Grade = "Kindergarten";
			break;
		case 9:
			if (teacherCert.equals(high) || teacherCert.equals(phs))
				Grade = "Ninth";
			else
				Grade = "Kindergarten";
			break;
		case 10:
			if (teacherCert.equals(high) || teacherCert.equals(phs))
				Grade = "Tenth";
			else
				Grade = "Kindergarten";
			break;
		case 11:
			if (teacherCert.equals(high) || teacherCert.equals(phs))
				Grade = "Eleventh";
			else
				Grade = "Kindergarten";
			break;
		case 12:
			if (teacherCert.equals(high) || teacherCert.equals(phs))
				Grade = "Twelfth";
			else
				Grade = "Kindergarten";
			break;
		default:
			if (teacherCert.equals(phs)) {
				Grade = "College";
			}
			else {
				Grade = "Drop Out";
			}
			break;
			
		}
		return Grade;
	}
	//function to create the officers on button press
	public void CreateOfficer() {
		URL imgURL = getClass().getResource("resources/policeSprite.png");
		Image imgO = toolkit.getImage(imgURL);
		//imgO = imgO.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon iconO = new ImageIcon(imgO);
		JLabel labelO = new JLabel(iconO);
		labelO.setPreferredSize(new Dimension(40,40));
		lpane.add(labelO); //add to the invisible box
		labels.add(1); //add to the labels array
		citizen.add(labelO); // add to the citizen array
		Police p = new Police(randAge(), randPhoneNum(), "Sean Spencer", randRole()); // create new cop
		CityHall.add(p); //add to city hall
		Population.add(p); //add to the population array
		
		
	}
	//function to create a random role for officer from enum
	private Police.policeRole randRole() {
		// TODO Auto-generated method stub
		int role = rnd.nextInt(4);
		Police.policeRole Role;
		switch(role) {
		case 1:
			Role = Police.policeRole.Captain;
			break;
		case 2:
			Role = Police.policeRole.Chief;
			break;
		case 3:
			Role = Police.policeRole.Patrol;
			break;
		case 4:
			Role = Police.policeRole.Seargent;
			break;
		default:
			Role = Police.policeRole.Patrol;
			break;
		}
		return Role;
	}

	/**
	 * Create the application.
	 */
	public CityWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("My City");
		frame.setBounds(100, 100, 1004, 796);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, 0, 0, 0, 30, 0, 0, 0, 31, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{30, 0, 29, 0, 29, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{};
		gbl_panel_1.rowWeights = new double[]{};
		panel_1.setLayout(gbl_panel_1);
		
		lpane = new JLayeredPane();
		Color newC = new Color(0f, 0f, 0f, 0f);
		lpane.setBackground(newC);
		GridBagConstraints gbc_lpane = new GridBagConstraints();
		gbc_lpane.gridheight = 25;
		gbc_lpane.gridwidth = 35;
		gbc_lpane.insets = new Insets(0,0,0,5);
		gbc_lpane.fill = GridBagConstraints.BOTH;
		gbc_lpane.gridx = 0;
		gbc_lpane.gridy = 0;
		lpane.setOpaque(true);
		panel_1.add(lpane, gbc_lpane);
		lpane.setLayout(new GridBagLayout());
		lpane.addMouseMotionListener(this);
		
		JLabel lblOfficersInCity = new JLabel("Officers in City Hall");
		GridBagConstraints gbc_lblOfficersInCity = new GridBagConstraints();
		gbc_lblOfficersInCity.gridwidth = 5;
		gbc_lblOfficersInCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblOfficersInCity.gridx = 0;
		gbc_lblOfficersInCity.gridy = 0;
		panel_1.add(lblOfficersInCity, gbc_lblOfficersInCity);
		
		
		
		JLabel lblKidsInSchool = new JLabel("Kids in School");
		GridBagConstraints gbc_lblKidsInSchool = new GridBagConstraints();
		gbc_lblKidsInSchool.fill = GridBagConstraints.VERTICAL;
		gbc_lblKidsInSchool.gridwidth = 4;
		gbc_lblKidsInSchool.insets = new Insets(0, 0, 5, 5);
		gbc_lblKidsInSchool.gridx = 14;
		gbc_lblKidsInSchool.gridy = 0;
		panel_1.add(lblKidsInSchool, gbc_lblKidsInSchool);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 128, 0));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 4;
		gbc_panel_4.gridheight = 9;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 18;
		gbc_panel_4.gridy = 0;
		panel_1.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPlayground = new JLabel("Playground");
		lblPlayground.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblPlayground, BorderLayout.CENTER);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 7;
		gbc_list.gridwidth = 5;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;
		panel_1.add(list, gbc_list);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 7;
		gbc_panel_2.gridheight = 9;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 5;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		CityHall c = new CityHall("City Hall", "911 Emergency Dr, Fire, Hell 991848");
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCityHall = new JLabel("City Hall");
		lblCityHall.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCityHall.setForeground(new Color(255, 255, 255));
		lblCityHall.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblCityHall, BorderLayout.CENTER);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.RED);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 9;
		gbc_panel_3.gridwidth = 10;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 22;
		gbc_panel_3.gridy = 0;
		panel_1.add(panel_3, gbc_panel_3);
		School s = new School("Elemntary Middle High School", "789 Safety Dr. Fire, Hell 991848");
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSchool = new JLabel("School");
		lblSchool.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchool.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblSchool, BorderLayout.CENTER);
		
		JList list_1 = new JList();
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridheight = 8;
		gbc_list_1.gridwidth = 4;
		gbc_list_1.insets = new Insets(0, 0, 5, 5);
		gbc_list_1.gridx = 14;
		gbc_list_1.gridy = 1;
		panel_1.add(list_1, gbc_list_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridheight = 9;
		gbc_panel_5.gridwidth = 2;
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 7;
		gbc_panel_5.gridy = 9;
		panel_1.add(panel_5, gbc_panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridheight = 9;
		gbc_panel_6.gridwidth = 2;
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 26;
		gbc_panel_6.gridy = 9;
		panel_1.add(panel_6, gbc_panel_6);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(128, 0, 128));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.gridheight = 2;
		gbc_panel_11.gridwidth = 5;
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 2;
		gbc_panel_11.gridy = 16;
		panel_1.add(panel_11, gbc_panel_11);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_11.rowHeights = new int[]{0, 0, 0};
		gbl_panel_11.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_11.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_11.setLayout(gbl_panel_11);
		
		JLabel lblTheSodaFountain = new JLabel("The Soda Fountain");
		lblTheSodaFountain.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblTheSodaFountain = new GridBagConstraints();
		gbc_lblTheSodaFountain.gridwidth = 4;
		gbc_lblTheSodaFountain.gridx = 0;
		gbc_lblTheSodaFountain.gridy = 1;
		panel_11.add(lblTheSodaFountain, gbc_lblTheSodaFountain);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.gridheight = 2;
		gbc_panel_7.gridwidth = 17;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 9;
		gbc_panel_7.gridy = 16;
		panel_1.add(panel_7, gbc_panel_7);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(0, 255, 255));
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.gridheight = 2;
		gbc_panel_10.gridwidth = 6;
		gbc_panel_10.insets = new Insets(0, 0, 5, 5);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 28;
		gbc_panel_10.gridy = 16;
		panel_1.add(panel_10, gbc_panel_10);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[]{0, 0};
		gbl_panel_10.rowHeights = new int[]{0, 30, 0};
		gbl_panel_10.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_10.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_10.setLayout(gbl_panel_10);
		
		JLabel lblYeOlDonut = new JLabel("Ye Ol' Donut Shop");
		GridBagConstraints gbc_lblYeOlDonut = new GridBagConstraints();
		gbc_lblYeOlDonut.gridx = 0;
		gbc_lblYeOlDonut.gridy = 1;
		panel_10.add(lblYeOlDonut, gbc_lblYeOlDonut);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.gridheight = 5;
		gbc_panel_8.gridwidth = 3;
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 16;
		gbc_panel_8.gridy = 18;
		panel_1.add(panel_8, gbc_panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.MAGENTA);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 0, 5);
		gbc_panel_9.gridheight = 3;
		gbc_panel_9.gridwidth = 35;
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 23;
		panel_1.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblResidentialAreateachers = new JLabel("Residential Area/Teachers");
		lblResidentialAreateachers.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblResidentialAreateachers, BorderLayout.NORTH);
		
		JButton btnCreateTeacher = new JButton("Create Teacher");
		btnCreateTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateTeacher();
				frame.getContentPane().validate();
				frame.getContentPane().repaint();
			}
		});
		
		panel_9.add(btnCreateTeacher, BorderLayout.CENTER);
		
		JButton btnCreateOfficer = new JButton("Create Officer");
		btnCreateOfficer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateOfficer();
				frame.getContentPane().validate();
				frame.getContentPane().repaint();
			}
		});
		panel_9.add(btnCreateOfficer, BorderLayout.EAST);
		
		JButton btnCreateKid = new JButton("Create Kid");
		btnCreateKid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateKid();
				frame.getContentPane().validate();
				frame.getContentPane().repaint();
			}
		});
		
		panel_9.add(btnCreateKid, BorderLayout.WEST);
		
		JButton btnOutputStuff = new JButton("Output Stuff");
		btnOutputStuff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < CityHall.size(); i++) {
					Officer = "Name: " + CityHall.get(i).getRole()+ " " + CityHall.get(i).getName() + " " + "Age: " + " " + CityHall.get(i).getAge() + " " + "Phone Number: " + CityHall.get(i).getPhoneNumber();
					System.out.printf("Current Police in City Hall are:\n%s\n", Officer);
				}
				for (int i = 0; i < SchoolK.size(); i++) {
					Kid = "Name: " + SchoolK.get(i).getName() + " " + "Age: " + SchoolK.get(i).getAge() + " " + "Phone Number: " + SchoolK.get(i).getPhoneNumber() + " " + "Favorite Candy: " + SchoolK.get(i).favoriteCandy;
					System.out.printf("Current Kids in school:\n%s\n", Kid);
				}
				for(int i = 0; i < SchoolT.size(); i++) {
					Teacher = "Name: " + SchoolT.get(i).getName()+ " " + "Age: " + SchoolT.get(i).getAge() + " " + "Phone Number: " + SchoolT.get(i).getPhoneNumber() + " " + "Teacher Certification: " + SchoolT.get(i).getCertification() + " " + "Teacher Grade Level: " + SchoolT.get(i).getGL();
					System.out.printf("Current Teachers in School:\n%s\n", Teacher);
				}
			}
		});
		
		frame.add(btnOutputStuff, BorderLayout.WEST);
		
		
		
		
		
	}
	//an unnecessary override just in case I need to override the default functionality
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	//attempts at painting sprites to the screen
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

	/*public boolean intersects(JLabel a) {
		//Rectangle rectb = b.getBounds();
		
		Rectangle result = SwingUtilities.computeIntersection(a.getX(), a.getY(), a.getWidth(), a.getHeight(), rectb);
		return (result.getWidth() > 0 && result.getHeight() > 0);
	}*/
	//function that handles the actual dragging of labels
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("dragging");
		JLabel label = null;
		int person = 0;
		int index = 0;
		for (int i = 0; i < lpane.getComponentCount(); i++) {
			if (lpane.getComponent(i) instanceof JLabel && lpane.getComponent(i).getBounds().contains(e.getPoint())) {
				label = (JLabel)lpane.getComponent(i);
				person = labels.get(i);
				index = i;
			}
			
		}
		if (label != null) {
			if (diffDrag == null)
				diffDrag = new Point(e.getX() - label.getBounds().x, e.getY() - label.getBounds().y);
			label.setBounds(e.getX() - diffDrag.x, e.getY() - diffDrag.y, label.getBounds().width, label.getBounds().height);
			frame.repaint();
		}
		// the below code should cause the sprites to disappear on contact with the frame but it doesn't work and I can't tell why
		//I'm leaving it functional because it breaks nothing and it might work for you
		if((person == 1) && (panel_2.getBounds().contains(e.getPoint()))) {
			lpane.remove(label);
			labels.remove(index);
		}else if ((person == 2) && (panel_3.getBounds().contains(e.getPoint())) || (panel_4.getBounds().contains(e.getPoint()))) {
			System.out.printf("Here");
			lpane.remove(label);
			labels.remove(index);
		}else if ((person == 3) && (panel_4.getBounds().contains(e.getPoint())) || (panel_3.getBounds().contains(e.getPoint()))) {
			lpane.remove(label);
			labels.remove(index);
		}
		
		
	}
	//function that does something I'm sure but I'm not 100% sure on what other than set diffDrag to Null
	public void mouseMoved(MouseEvent e) {
		diffDrag = null;
	}
}
