package Entity;

import TileMap.TileMap;
//bless you and your brevity NastyGuys
public class NastyGuys extends MapObject{
	//variables for types and the x, y coordinates of nastyguys
	protected int NastyType;
	protected double currX;
	protected double currY;
	
	//constructor
	public NastyGuys(TileMap tm) {
		//refers to map object
		super(tm);
	}
	//Returns whether the grim reaper has struck
	public boolean isDead() {return dead;}
	
	//Jumpman impaled himself on yon spikyboi summoning a reaper
	public void hit() {
		dead=true;
	}
	//return which nastyboy Jumpman touched
	public int getType() {
		return NastyType;
	}
	
	//update nastyGuys
	public void update() {}
}
