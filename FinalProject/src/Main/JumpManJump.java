package Main;

import javax.swing.JFrame;

//main class
public class JumpManJump {
	
	public static void main(String[] args) {
		
		
		//creates the window that the game runs in
		JFrame window = new JFrame("Tales from the Jumplands: A Jumpman Jump Game Featuring Toppy the Hat by Gondolin Studios");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//makes it so that the user cannot resize the window
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		
		
		
	}
	
}