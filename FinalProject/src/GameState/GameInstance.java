package GameState;

import Main.GamePanel;
import TileMap.*;
import Entity.*;
//import Entity.Enemies.*;
import Entity.Nasties.SpikeyBoi;
import Entity.Nasties.StepOnMan;

import java.awt.*;
import java.awt.event.KeyEvent;
//import java.util.ArrayList;
import java.util.ArrayList;

//Class for the 1st and currently only level in the game
public class GameInstance {
	
	private TileMap tileMap;
	
	private int width=0;
	private JumpMan player;
	
	//Array to hold the information on all of the bad guys within the level
	private ArrayList<NastyGuys> nasties;
		
	//constructor for the level
	public GameInstance() { init(); }
	
	//initalizes and calls of the functions for the level 
	public void init() {
	
		tileMap = new TileMap(30);
		
		//System.out.println(System.getProperty("user.dir"));
		//load all of the empty air tiles 
		tileMap.loadTiles("/src/resources/Back_Ground/air.png");
		//load all of the "meatloaf" blocks 
		tileMap.loadTiles("/src/resources/Back_Ground/foreground.png");
		//load all of the blocks that the player can jump to
		tileMap.loadTiles("/src/resources/Back_Ground/box to jump on.png");
		tileMap.setPosition(0, 0);
		
		
		//put the character jumpman onto the tilemap at postion 100,100
		player = new JumpMan(tileMap);
		player.setPosition(100, 100);
		
		//function that creates all of the enemies for the level
		populateEnemies();
		
				
	}
	
	//function that creates all of the enemies for the level
	private void populateEnemies() {
		//array list that holds each bady guy for the level
		nasties = new ArrayList<NastyGuys>();
		//System.out.println("Here");
		
		//create objects for each of the enemy type
		SpikeyBoi s;
		StepOnMan st;
		//fill an array with coordinates for each of the spawn locations of the step on men
		Point[] points2 = new Point[] {
				new Point(380, 150),
				new Point(1800, 150),
				new Point(1900, 150),
				//new Point(1800, 200)
			};
		//fill an array with coordinates for each of the spawn locations of the spikeybois
		Point[] points = new Point[] {
			new Point(350, 150),
			new Point(500, 150),
			new Point(550, 150),
			new Point(600, 150),
			new Point(1650, 150),
			new Point(1850, 150)
		};
		
		//create the nastyguys objects and fill the array list with their infomation
		for(int i = 0; i < points.length; i++) {
			s = new SpikeyBoi(tileMap);
			s.setPosition(points[i].x, points[i].y);
			nasties.add(s);
		}
		for(int i = 0; i < points2.length; i++) {
			st = new StepOnMan(tileMap);
			st.setPosition(points2[i].x, points2[i].y);
			nasties.add(st);
		}
		
	}
	//update function for the player and contact between the player and a nastyguy 
	public void update() {
		
		// update player
		player.update();
		
		for(int i = 0; i < nasties.size(); i++) 
			nasties.get(i).update();
			
		player.checkAttack(nasties);
		//System.out.print("here2\n");
		tileMap.setPosition(GamePanel.WIDTH / 2 - player.getx(),GamePanel.HEIGHT / 2 - player.gety());	
		//System.out.printf("%d", bg.getWidth());		
	}
	//make pretty pictures!!!!!
	public void draw(Graphics2D g) {
		
		// draw tilemap
		tileMap.draw(g, player.getX());
		
		// draw player
		player.draw(g);
		
		// draw enemies
		for(int i = 0; i < nasties.size(); i++) {
			nasties.get(i).draw(g);
		}
	}
	//function to determine what key is pressed
	public void keyPressed(int k) {
		//System.out.println("here");
		//if they press left
		if(k == KeyEvent.VK_LEFT) player.setLeft(true);
		//if they press right
		if(k == KeyEvent.VK_RIGHT) player.setRight(true);
		//if they press space
		if(k == KeyEvent.VK_SPACE) {
			//System.out.print(player.canJump());
			if (player.canJump()) { player.setJumping(true);}
			player.setJump(false);
		}
	}
	//function to see if the player has released a key
	public void keyReleased(int k) {
		//System.out.println("HERE");
		//if they release the left key
		if(k == KeyEvent.VK_LEFT) player.setLeft(false);
		//if they release the right key
		if(k == KeyEvent.VK_RIGHT) player.setRight(false);
	}
	
}












