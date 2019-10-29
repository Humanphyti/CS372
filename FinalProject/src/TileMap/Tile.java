package TileMap;

import java.awt.Image;

//class for a tile object
public class Tile {
	//the class has an image associated with it as well as an int that corresponds with a type
	private Image image;
	private int type;
	
	// tile types
	//the tiles can either be a tile that can be passed through or one that is solid
	public static final int NORMAL = 0;
	public static final int BLOCKED = 1;
	
	//constructor for the tile class
	public Tile(Image image, int type) {
		this.image = image;
		this.type = type;
	}
	//returns the image in the tile
	public Image getImage() { return image; }
	//returns the type of tile 
	public int getType() { return type; }
	
}
