package Entity;

import TileMap.*;

import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class JumpMan extends MapObject {
	
	// player stuff
	
	
	// animations
	private ArrayList<ArrayList<Image>> sprites = new ArrayList<ArrayList<Image>>();
	//private final int[] numFrames = {1, 2, 1};
	
	
	// animation actions
	private static final int IDLE = 0;
	private static final int WALKING = 1;
	private static final int JUMPING = 2;
	private static final int DEAD = 3;
	
	//constructor of JumpMan
	public JumpMan(TileMap tm) {
		
		super(tm);
		//jumpman hitbox size
		width = 30;
		height = 30;
		cwidth = 20;
		cheight = 20;
		//movement attributes
		moveSpeed = 2;
		fallSpeed = 0.15;
		maxFallSpeed = 4.0;
		jumpStart = -4.2;
		//starts facing right
		facingRight = true;
		//toolkit toolkit toolkit toolkit toolkit toolkit
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//array list of images of animations
		ArrayList<Image> imgA = new ArrayList<Image>();

		
		// load sprites
		try {
			//idle animation
			String str="file:///"+System.getProperty("user.dir");
			//System.out.print(str+s);
			URL u = new URL(str+"/src/resources/Sprites/JumpMan/Run/spritewalk_0.png");
			Image img = toolkit.getImage(u);
			imgA.add(img);
			sprites.add(imgA);
			//walking animation
			imgA = new ArrayList<Image>();
			u = new URL(str+"/src/resources/Sprites/JumpMan/Run/spriteWalk_0.png");
			img = toolkit.getImage(u);
			imgA.add(img);
			u = new URL(str+"/src/resources/Sprites/JumpMan/Run/spriteWalk_1.png");
			img = toolkit.getImage(u);
			imgA.add(img);
			sprites.add(imgA);
			//jumping animation
			imgA = new ArrayList<Image>();
			u = new URL(str+"/src/resources/Sprites/JumpMan/Jump/Jumpman jump.png");
			img = toolkit.getImage(u);
			imgA.add(img);
			sprites.add(imgA);
			//dying animation
			imgA = new ArrayList<Image>();
			u = new URL(str+"/src/resources/Sprites/JumpMan/Die/JMandeath_animation.png");
			img = toolkit.getImage(u);
			imgA.add(img);
			sprites.add(imgA);
				
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println("here");
		animation = new Animation(); //make an instance of an animation object 
		currentAction = IDLE; //initialize to idle pose
		animation.setFrames(sprites.get(IDLE)); //grab the idle animation frames
		animation.setDelay(400);//set the delay between animation frames
		
	}
	//check to see if collisions happen so Jumpman can die
	public void checkAttack(ArrayList<NastyGuys> nasties) {
		
		//loop through enemies
		for(int i = 0; i < nasties.size(); i++) {
			
			NastyGuys nast = nasties.get(i);
			//System.out.println("Here");
			// check enemy collision
			if(intersects(nast)&&nast.getType()==0) {
				currentAction=DEAD;
				doDeath();
			}
			//check other enemy collision
			else if(intersects(nast)&&nast.getType()==1) {
				nast.doDeath();
			}
			
		}
		
	}
	//uhhhhhh...
	public void hit() {
		//jump on top of jumponman
	}
	//get the x coordinate of JumpMan
	public int getX() {
		return (int) x;
	}
	
	//Get the location of where JumpMan is going next
	private void getNextPosition() {
		
		// movement
		if(left) {
			dx -= moveSpeed;
		}
		else if(right) {
			dx += moveSpeed;
		}
		
						
		// jumping
		if(jumping) {
			dy = jumpStart;
			jumping=false;
			//System.out.printf("%s\n", dy);
		}
		
		
	}
	//return if he can in fact jump
	public boolean canJump() {
		return canJump;
	}
	//set canJump to boolean
	public void setJump (boolean j) {
		canJump=j;
	}
	
	//update the Jumpman objects
	public void update() {
	
		//System.out.printf("%s\n", dy);
		//if already in the air can jump
		if (dy ==0) canJump=true;
		//otherwise can't jump :'(
		else canJump=false;
		//update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		
		//if he falls murder him
		if (ydest > 224) {
			//basically the grim reaper
			doDeath();
		}
		//KILL HIM!!!!!
		if (currentAction == DEAD) {
			animation.setFrames(sprites.get(DEAD));
			animation.setDelay(-1);//System.out.printf("%s", dead);
		}
		//set the current actio to jump and do it *insert Palpatine*
		else if(dy != 0) {
			if(currentAction != JUMPING) {
				currentAction = JUMPING;
				//System.out.println("here");
				animation.setFrames(sprites.get(JUMPING));
				animation.setDelay(-1);
				width = 30;
			}
		}
		//a liesurely stroll down the greek kingdom full of meatloaf
		else if(dx != 0) {
			if(currentAction != WALKING) {
				//System.out.println("here");
				currentAction = WALKING;
				animation.setFrames(sprites.get(WALKING));
				animation.setDelay(150);
				width = 30;
			}
		}
		
		
		else{
			//this is why Jumpman's fat
			if(currentAction != IDLE) {
				//System.out.println("here");
				currentAction = IDLE;
				animation.setFrames(sprites.get(IDLE));
				animation.setDelay(-1);
				width = 30;
			}
		}
		//if you fail choose to succeed instead
		if (dx!=0) dx=0;
		//recalculate the fall speed
		if (dy < maxFallSpeed&&falling) dy+=fallSpeed;
		//update the animations
		animation.update();
	}
	//MAKE THE PRETTY PICTURES!
	public void draw(Graphics2D g) {
		
		//if dead from the MapObject is true you fail.
		if(super.dead) {
			try {
			//call the losing splashscreen	
			String str="file:///"+System.getProperty("user.dir");
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			URL u = new URL(str+"/src/resources/You Lose.png");
			Image img = toolkit.getImage(u);
			g.drawImage(img, 0, 1, null);
			
		} catch (Exception ex) {;}
		}
		//set the win condition
		if(x>2800) {
			try {
				
				String str="file:///"+System.getProperty("user.dir");
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				URL u = new URL(str+"/src/resources/You Win.png");
				Image img = toolkit.getImage(u);
				g.drawImage(img, 0, 1, null);
				
			} catch (Exception ex) {;}
		}
		//set your position on the map
		setMapPosition();
		//actually do some drawing of MapObjects Graphics
		super.draw(g);

	}
	
}