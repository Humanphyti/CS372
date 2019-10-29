package Entity;

import Main.GamePanel;
import TileMap.TileMap;
import TileMap.Tile;

import java.awt.Rectangle;

public abstract class MapObject {
	//Holy Variables, Batman!
	protected boolean dead;
	// tile stuff
	protected TileMap tileMap;
	protected int tileSize;
	protected double xmap;
	protected double ymap;
	
	// position and vector
	protected double x;
	protected double y;
	protected double dx;
	protected double dy;
	
	// dimensions
	protected int width;
	protected int height;
	
	// collision box
	protected int cwidth;
	protected int cheight;
	
	// collision
	protected int currRow;
	protected int currCol;
	protected double xdest;
	protected double ydest;
	protected double xtemp;
	protected double ytemp;
	protected boolean topLeft;
	protected boolean topRight;
	protected boolean bottomLeft;
	protected boolean bottomRight;
	
	// animation
	protected Animation animation;
	protected int currentAction;
	protected int previousAction;
	protected boolean facingRight;
	
	// movement
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	protected boolean jumping;
	protected boolean falling;
	protected boolean canJump;
	protected double moveSpeed;
	protected double fallSpeed;
	protected double maxFallSpeed;
	protected double jumpStart;
	
	// constructor
	public MapObject(TileMap tm) {
		tileMap = tm;
		tileSize = tm.getTileSize(); 
	}
	//check if objects touch
	public boolean intersects(MapObject o) {
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();
		return r1.intersects(r2);
	}
	//get the hitbox of objects
	public Rectangle getRectangle() {
		return new Rectangle(
				(int)x - cwidth,
				(int)y - cheight,
				cwidth,
				cheight
		);
	}
	//calculate where the corners of objects are so as to make better hitboxes that are dynamic
	public void calculateCorners(double x, double y) {
		
		int leftTile = (int)(x - cwidth / 2) / tileSize;
		int rightTile = (int)(x + cwidth / 2 - 1) / tileSize;
		int topTile = (int)(y - cheight / 2) / tileSize;
		int bottomTile = (int)(y + cheight / 2 - 1) / tileSize;
		
		
		int tl = tileMap.getType(topTile, leftTile);
		int tr = tileMap.getType(topTile, rightTile);
		int bl = tileMap.getType(bottomTile, leftTile);
		int br = tileMap.getType(bottomTile, rightTile);
		
		topLeft = (tl == Tile.BLOCKED);
		topRight = (tr == Tile.BLOCKED);
		bottomLeft = (bl == Tile.BLOCKED);
		bottomRight = (br == Tile.BLOCKED);
	}
	//like it was said before, the Grim Reaper of JumpMan
	public void doDeath() {
		dead=true;
		moveSpeed=0;
		fallSpeed=0;
		maxFallSpeed=0;
		jumpStart=0;
		dy=0;
		falling=false;
		
		
	}
	//You're not a ghost yet so don't phase through the ground or the walls
	public void checkTileMapCollision() {
		
		currCol = (int)x / tileSize;
		currRow = (int)y / tileSize;
		
		xdest = x + dx;
		ydest = y + dy;
		
		xtemp = x;
		ytemp = y;
		//call calculate corners
		calculateCorners(x, ydest);
		if(dy < 0) {
			
			/*if(topLeft || topRight) {
				dy = 0;
				ytemp = currRow * tileSize + cheight / 2;
			}*/
			if (dy+ytemp <0) {ytemp=0;}
			
			else {
				//System.out.printf("%s\n",dy);
				ytemp += dy;
			}
		}
		if(dy > 0) {
			if (bottomLeft || bottomRight) {
				dy=0;
				falling=false;
				//System.out.printf("HERE%s\n",dy);
			}
			else ytemp += dy;
				
			//if(bottomLeft || bottomRight) {
				//dy = 0;
				//falling = false;
				//ytemp = (currRow + 1) * tileSize - cheight / 2;
			//}
			//else {
			//	ytemp += dy;
			//}
		}
		
		calculateCorners(xdest, y);
		if(dx < 0) {
			if(topLeft || bottomLeft) {
				dx = 0;
				xtemp = currCol * tileSize + cwidth / 2;
			}
			else {
				xtemp += dx;
			}
		}
		if(dx > 0) {
			if(topRight || bottomRight) {
				dx = 0;
				xtemp = (currCol + 1) * tileSize - cwidth / 2;
			}
			else {
				xtemp += dx;
			}
		}
		
		if(!falling) {
			calculateCorners(x, ydest + 1);
			if(!bottomLeft && !bottomRight) {
				falling = true;
			}
		}
		
	}
	//x getter
	public int getx() { return (int)x; }
	//y getter
	public int gety() { return (int)y; }
	//width getter
	public int getWidth() { return width; }
	//height getter
	public int getHeight() { return height; }
	//collision width getter
	public int getCWidth() { return cwidth; }
	//collision height getter
	public int getCHeight() { return cheight; }
	
	//set the positions
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	//set the movement vectors
	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	//set the overall map position
	public void setMapPosition() {
		xmap = tileMap.getx();
		ymap = tileMap.gety();
	}
	
	//set left
	public void setLeft(boolean b) { left = b; }
	//set right
	public void setRight(boolean b) { right = b; }
	//set up
	public void setUp(boolean b) { up = b; }
	//set down
	public void setDown(boolean b) { down = b; }
	//set jump
	public void setJumping(boolean b) { jumping = b; }
	
	//establish whether something is on screen or not and can therefore be culled
	public boolean notOnScreen() {
		return x + xmap + width < 0 ||
			x + xmap - width > GamePanel.WIDTH ||
			y + ymap + height < 0 ||
			y + ymap - height > GamePanel.HEIGHT;
	}
	
	//MAKE THE PRETTY PICTURES!!
	public void draw(java.awt.Graphics2D g) {
		//when we're facing right draw the respective animation
		if(facingRight) {
			g.drawImage(animation.getImage(),(int)(x + xmap - width / 2),(int)(y + ymap - height / 2),null);
		}
		//Otherwise draw another animation at a different place
		else {
			g.drawImage(animation.getImage(),(int)(x + xmap - width / 2 + width),(int)(y + ymap - height / 2), -width, height, null);
			}
	}
	
}