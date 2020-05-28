

import processing.core.PApplet;
import processing.core.PImage;
/**
 * Class that controls the frog's image and movement thru the game
 * @author Emma Waddell
 * @date 11.12.2018
 *
 */
public class Frog {

	PApplet app;
	/**
	 * defines the path to access the photo graphic
	 */
	private final static String FROG_IMAGE_PATH = "frog.png";
	private PImage img;
	private int x, y, count = 0;
	
	/**
	 * Constructor to set start pos, image, and size
	 * @param app
	 */
	public Frog (PApplet app) {
		this.app = app;
		
		//set starting pos for frog
		this.setX(400);
		this.setY(800); 
		
		this.img = this.app.loadImage(Frog.FROG_IMAGE_PATH);
		img.resize(100, 100);
	}
	
	public void draw() {
		this.app.image(this.img, this.getX(), this.getY());
	}

	/**
	 * Moves frog 100 in each direction
	 * @param technically none, key input
	 * @return void main functions must not have any return value, since they are declared as void
	 */
	public void goLeft() {
		if (getX() > 0)
			this.setX(this.getX() - 100);
		
	}

	public void goRight() {
		if (getX() < 800)
			this.setX(this.getX() + 100);
		
	}

	public void goUp() {
		if (getY() > 0)
			this.setY(this.getY() - 100);
		
	}

	public void goDown() {
		if (getY() < 800)
			this.setY(this.getY() + 100);
		
	}
	
	/**
	 * Counts how many lives lost (up to 3), moves frog to start pos
	 * @param none
	 * @return void main functions must not have any return value, since they are declared as void
	 */
	public int kill() {
		count++;
		this.setY(800);
		this.setX(400);
		return count;		
	}

	/**
	 * Gets x pos of frog
	 * @param none
	 * @return int showing x pos
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets frog's x pos
	 * @param desired pos of frog (int)
	 * @return void main functions must not have any return value, since they are declared as void
	 */
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Moves frog if on a water obstacle that is also moving
	 * @param speed of obstacle (int)
	 * @return void main functions must not have any return value, since they are declared as void
	 */
	public void move(int speed) {
		int newX = this.getX() + speed;
		
		this.setX(newX);
	}
}
