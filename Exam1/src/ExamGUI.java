import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ExamGUI {

	private JFrame frame; //Application Frame
	Toolkit toolkit = Toolkit.getDefaultToolkit(); //toolkit for outputting images
	public ArrayList<Shapes> shape = new ArrayList<Shapes>(); //ArrayList to hold all the shapes, not sure it acutally does Anything atm.
	private DefaultListModel shapey = new DefaultListModel(); //list that feeds the JList
	private Shapes clicked; //initializing outside Initialize() to use in other functions
	private String[] prtsTemp; // holder of the various parts from the various lines from the CSV
	private JLabel label;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamGUI window = new ExamGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExamGUI() {
		initialize();
		readFile(); //summon the CSV parser
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 899, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		JTextArea txtrPlaceholder = new JTextArea();
		
		frame.getContentPane().add(txtrPlaceholder, BorderLayout.EAST);
		
		starterCircle(); //necessary but I'm unsure why, probably has to do with when and how I remove the previous shape image
		
		JList<Shapes> list = new JList<Shapes>(shapey); //prepares the JList to handle shape objects
		JScrollPane scrollpane = new JScrollPane(list); //ties the scroll bar to the JList
		MouseListener mouseListener = new MouseAdapter() { //lets you click on stuff
			public void mouseClicked(MouseEvent e) { 
				if(e.getClickCount() == 2) {
					clicked = list.getSelectedValue(); //stores the selected object for later conditionals
					frame.getContentPane().remove(label); //clears the previous shape
					createShapes(); //calls the createShapes function
					frame.getContentPane().validate(); //validate the contents of the screen
					frame.getContentPane().repaint(); //repaint the screen
					
					txtrPlaceholder.setText(outputInfo()); //display the detailed info in the JTextArea
					
				}
			}
		};
		
		list.addMouseListener(mouseListener); //add the mouse listener to the list
		frame.getContentPane().add(scrollpane, BorderLayout.WEST); //add the scrollPane to the frame
		
		
		
		
		
	}
	//create the initial shape but make it invisible
	public void starterCircle() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resources/circle.jpg");
		//System.out.print(imgURL);
		Image img = toolkit.getImage(imgURL);
		ImageIcon icon = new ImageIcon(img);
		label = new JLabel(icon);
		label.setVisible(false); //set the image to be invisible
		frame.getContentPane().add(label); //add it to the frame
	}
	//create and display the various shapes using the clicked item to determine which shape
	public void createShapes() {
		if(clicked.getType().contains("circle")) {
			URL imgURL = getClass().getResource("/resources/circle.jpg");
			Image imgC = toolkit.getImage(imgURL);
			ImageIcon iconC = new ImageIcon(imgC);
			label = new JLabel(iconC);
			frame.getContentPane().add(label);
		}else if(clicked.getType().contains("square")) {
			URL imgURL = getClass().getResource("/resources/square.jpg");
			Image imgS = toolkit.getImage(imgURL);
			ImageIcon iconS = new ImageIcon(imgS);
			label = new JLabel(iconS);
			frame.getContentPane().add(label);
		}else if(clicked.getType().contains("rectangle")) {
			frame.getContentPane().remove(label);
			URL imgURL = getClass().getResource("/resources/rectangle.png");
			Image imgR = toolkit.getImage(imgURL);
			ImageIcon iconR = new ImageIcon(imgR);
			label = new JLabel(iconR);
			frame.getContentPane().add(label);
		} else if(clicked.getType().contains("triangle")) {
			URL imgURL = getClass().getResource("/resources/triangle.png");
			Image imgT = toolkit.getImage(imgURL);
			ImageIcon iconT = new ImageIcon(imgT);
			label = new JLabel(iconT);
			frame.getContentPane().add(label);

		}
	}
	//output the formatted detailed info about each shape using the clicked item to determine which shape
	public String outputInfo() {
		return clicked.getDetailString();
	}

	//the CSV parser
	public void readFile() {
		String curdir = System.getProperty("user.dir");
		curdir += "/src/resources"; //get into the correct folder for the CSV
        File cd = new File(curdir);
        File[] files = cd.listFiles();
        for (File f: files) {
            if (f.getName().endsWith(".csv")) { //grab the CSV file from resources
                try (FileInputStream is = new FileInputStream(f)) {
                    InputStreamReader ir = new InputStreamReader(is);
                    BufferedReader rdr = new BufferedReader(ir);
                    String line = rdr.readLine(); //grab the first line
                    
                    while(line != null) {
                    	prtsTemp = null; // reinitialize the prtsTemp string array for reasons
                    	for (int i = 0; i < line.length(); i++) {
                    		prtsTemp = line.split(","); //add the various attributes to the prtsTemp string array
                    	}
                    	addShapes(prtsTemp); // pass the prtsTemp String array to be used to create shape objects
                    	line = rdr.readLine(); //grab the next line
                    }
                    
                }
                
                    /*System.out.printf("%s: %s\n", f.getName(), line);*/
                catch (Exception ex) { System.out.printf("Failed for %s\n", f.getName());
                ex.printStackTrace(); //debugging
                }
            }
        }
        
	}
	//add the different shape objects to the ArrayList of shapes and the JList of shapes
	public void addShapes(String[] prts) {
		String type, ID, color, temp;
		int radius = 0, side =0, length = 0, width = 0, side1 = 0, side2 = 0, side3 = 0;
		if (prts[0].contains("circle") || prts[0].contains("square")) { //check if I'm dealing with a circle or a square
			type = prts[0].replace("\"", ""); //remove the quotes
			ID = prts[1].replaceAll(" ", ""); //remove the whitespace
			
			temp = prts[2].replaceAll(" ", ""); //remove the whitespace
			if (prts[0].contains("circle")) //check if it's a circle
				radius = Integer.parseInt(temp); //grab the string number and make it an int
			else
				side = Integer.parseInt(temp);
			color = prts[3].replaceAll("\"", "");//remove the quotes
			if (prts[0].contains("circle")) {	//check if it's a circle
				Circle c = new Circle(type, ID, radius, color); //create a new circle object
				shape.add(c); //add it to shape
				shapey.addElement(c); //add it to shapey
			} else {
				Square s = new Square(type, ID, side, color); //create a square object
				shape.add(s); //add it to shape
				shapey.addElement(s); //add it to shapey;
			}
						
		} else if (prts[0].contains("rectangle")) { //check if it's a rectangle and do the same stuff except the conditional as was done it circle and square
			type = prts[0].replace("\"", "");
			ID = prts[1].replaceAll(" ", "");
			//System.out.print(ID);
			temp = prts[2].replaceAll(" ", "");
			length = Integer.parseInt(temp);
			//System.out.print(length + " ");
			temp = prts[3].replaceAll(" ", "");
			width = Integer.parseInt(temp);
			color = prts[4].replaceAll("\"", "");
			Rectangle r = new Rectangle(type, ID, length, width, color);
			shape.add(r);
			shapey.addElement(r);
		} else if (prts[0].contains("triangle")) { //check if it's a triangle and do the same stuff except the conditional as was done it circle and square
			type = prts[0].replace("\"", "");
			ID = prts[1].replaceAll(" ", "");
			temp = prts[2].replaceAll(" ", "");
			side1 = Integer.parseInt(temp);
			temp = prts[3].replaceAll(" ", "");
			side2 = Integer.parseInt(temp);
			temp = prts[4].replaceAll(" ", "");
			side3 = Integer.parseInt(temp);
			color = prts[5].replaceAll("\"", "");
			Triangle t = new Triangle(type, ID, side1, side2, side3, color);
			shape.add(t);
			shapey.addElement(t);
		}
	}
	
}
