package Entity;

import java.awt.Image;
import java.util.ArrayList;


public class Animation {
	
	//Array list containing the frames of animations
	private ArrayList<Image> frames = new ArrayList<Image>();
	private int currentFrame; //the current frame of an animation
	
	private long startTime; //initialize a tick
	private long delay; //delay the animations when needed
	
	private boolean playedOnce; //check if the animation played once
	//animation constructor
	public Animation() {
		playedOnce = false;
	}
	//initialize what the starting frame of the animation will be
	public void setFrames(ArrayList<Image> frames) {
		this.frames = frames;
		currentFrame = 0;
		//System.out.println("here");
		startTime = System.nanoTime(); //start the tick
		playedOnce = false;
	}
	//set the delay
	public void setDelay(long d) { delay = d; }
	//set the current frame
	public void setFrame(int i) { currentFrame = i; }
	
	//update the screen in regard to the animations
	public void update() {
		//if delay is negative break out of update
		if(delay == -1) return;
		
		//get the frame time elapsed
		long elapsed = (System.nanoTime() - startTime) / 1000000;
		//System.out.printf("%d       %d\n",startTime, System.nanoTime());
		
		//if frame time is greater than delay enter
		if(elapsed > delay) {
			//iterate current frame
			currentFrame++;
			//grab the current time since the next frame was grabbed
			startTime = System.nanoTime();
		}
		//if the frame it's on is the last frame restart 
		if(currentFrame == frames.size()) {
			//go back to the first frame of an animation 
			currentFrame = 0;
			//know that it has been played once
			playedOnce = true;
		}
		
	}
	//frame getter
	public int getFrame() { return currentFrame; }
	//Image of animation frame getter
	public Image getImage() { return frames.get(currentFrame); }
	//played once getter
	public boolean hasPlayedOnce() { return playedOnce; }
	
}

