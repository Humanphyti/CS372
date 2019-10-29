package Entity.Nasties;

import Entity.*;
import TileMap.TileMap;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;

public class StepOnMan extends NastyGuys{
	//array of sprites for animation
	private ArrayList<Image> sprites=new ArrayList<Image>();
	//constructor
	public StepOnMan(TileMap tm) {
		//refers to nastyguys
		super(tm);
		//movement info/type info
		NastyType=1;
		moveSpeed = .5;
		fallSpeed = 0.15;
		maxFallSpeed = 4.0;
		//hitbox info
		width = 30;
		height = 30;
		cwidth = 20;
		cheight = 20;
		
		//toolkit Toolkit Toolkit toolkit Toolkit toolkit toolkit toolkit toolkit
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		try {
			//grab the animation images
			String str="file:///"+System.getProperty("user.dir");
			URL u = new URL(str+"/src/resources/Sprites/StepOnMan/Walk/step on man walk1.png");
			Image img = toolkit.getImage(u);
			sprites.add(img);
			//System.out.printf("%s\n", u);
			u = new URL(str+"/src/resources/Sprites/StepOnMan/Walk/step on man walk2.png");
			img = toolkit.getImage(u);
			sprites.add(img);
			
		}
		catch(Exception e) {e.printStackTrace();}
		//make an animation object for steponman
		animation = new Animation();
		//grab the frames
		animation.setFrames(sprites);
		//properly delay the frames to make it look smooth
		animation.setDelay(300);
		//make it facing right by default
		right = true;
		facingRight = true;
	}
	
	//predict where the spikeyboi will be going
	private void getNextPos() {
		//System.out.println("Here");
		if(right) {
			dx = -moveSpeed;
		}
		else if(left) {
			dx = moveSpeed;
		}
		
		// falling
		if(falling) {
			dy += fallSpeed;
			//System.out.println("here");
			//when fall to death
			if(y+dy>224) {
				//summon the Nasty Reaper, grim reaper of the NastyGuys
				doDeath();
			}
		}
		
	}
	//update the steponman
public void update() {
		
		// update position
		getNextPos();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		
		
		// if it hits a wall, go other direction
		if(right && dx == 0) {
			right = false;
			left = true;
			facingRight = false;
		}
		else if(left && dx == 0) {
			right = true;
			left = false;
			facingRight = true;
		}
		
		// update animation
		
		animation.update();
		
	}
	//MAKE THE PRETTY PICTURES!!!!
	public void draw(Graphics2D g) {
		//System.out.println("Here");
		
		setMapPosition();
		if(!dead)
		//Draw the nastyGuy
		super.draw(g);
		//death logic when dead and not falling
		if(dead&&dy==0) {
			
			try{
			///toolkit Toolkit Toolkit toolkit Toolkit toolkit toolkit toolkit toolkit
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			//Grab the death animation image
			String str="file:///"+System.getProperty("user.dir");
			URL u = new URL(str+"/src/resources/Sprites/StepOnMan/Die/step on man squish.png");
			Image img = toolkit.getImage(u);
			//kill the steponman and leave his body where you stepped on him
			g.drawImage(img, (int)xmap+(int)x,(int)ymap+(int)y, null);
			}
			
			catch(Exception e) {e.printStackTrace();};
		}
			
		
	}
}
