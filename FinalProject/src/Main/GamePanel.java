package Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import GameState.GameInstance;

//import GameState.GameStateManager;

//
public class GamePanel extends JPanel implements Runnable, KeyListener{
	//string to hold the filepath of the background image. Must be accessible in multiple places below.
	String bgStr;
	// dimensions of the game window
	public static final int WIDTH = 800;
	public static final int HEIGHT = 240;
	//scale of the game window. Allows us to easily and dramatically change the window size to fit various screens
	public static final int SCALE = 2;
	
	// game thread to handle continuous update processing
	private Thread thread;
	private boolean running;
	//this is the target number of milliseconds per game tick. We looked up how most real games handle game ticks and they tend to do something along these lines.
	private int targetTime = 15;
	
	// image
	private BufferedImage image;
	private Graphics2D g;
	//create an instance of the game and call its constructor
	GameInstance gInst = new GameInstance();
	
	//screen
	public GamePanel() {
		//multiply by SCALE for easily changing window size
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		//add keyboard control
		setFocusable(true);
	}
	
	//from JPanel
	public void addNotify() {
		super.addNotify();
		//new thread for keyboard input
		if(thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();	
		}
	}
	//initialize our screen. 
	private void init() throws IOException {
		//calls a function to put the intro/loading screen up for a few seconds as the game launches
		introSplash();
		//filepath for the background image
		bgStr="file:/"+System.getProperty("user.dir");
		//for some reason, it was picky and wanted backslashes
		bgStr+="/src//resources//Back_Ground//background.png";
		URL u = new URL(bgStr);
		image=ImageIO.read(u);
		g = (Graphics2D) image.getGraphics();
		//used in run()
		running = true;

		
	}
	
	public void run() {
		try {
		init();}
		catch(Exception e) {e.printStackTrace();}
		
		long start;
		long elapsed;
		long wait;
		
		// game loop
		while(running) {
			
			start = System.nanoTime();
			
			update();
			//System.out.print("here\n");
			try{draw();}
			catch (Exception e) {e.printStackTrace();};
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000;
			if(wait < 0) wait = 5;
			
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void update() {
		//System.out.println("here\n");
		gInst.update();
		//drawToScreen();
	}
	private void draw()throws IOException {
		//try{init();}
		//catch(Exception e) {e.printStackTrace();}
		URL u = new URL(bgStr);
		image=ImageIO.read(u);
		g = (Graphics2D) image.getGraphics();
		//draw the image
		gInst.draw(g);		
	}
	//function to actually place the images on the screen
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		//scaleable image
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		//throw away the Graphics one we're done
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key) {}
	//handles the actions taken on a key press
	public void keyPressed(KeyEvent key) {
		gInst.keyPressed(key.getKeyCode());
	}
	//some things happen when a key is released (for example, the character stops moving when RIGHT is released)
	public void keyReleased(KeyEvent key) {
		gInst.keyReleased(key.getKeyCode());
	}
	//intro/splash screen while the game loads
	private void introSplash() {
	try{String str="file:/"+System.getProperty("user.dir");
	//filepath for the image
	URL u = new URL(str+"/src\\resources\\Title Screen.png");
	image=ImageIO.read(u);
	g = (Graphics2D) image.getGraphics();
	Graphics g3 = getGraphics();
	//draw the scaleable image
	g3.drawImage(image, 0, 1, WIDTH*SCALE,HEIGHT*SCALE,null);
	g3.dispose();}
	catch(Exception e) {e.printStackTrace();}
	//leave the image up for three seconds before we go into the game
	try {Thread.sleep(3000);}
	catch(InterruptedException e) {e.printStackTrace();};}
}