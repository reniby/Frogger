


import processing.core.PApplet;
import processing.core.PImage;
/**
 * Class to be inherited by each obstacle in that game that controls movement, drawing, and affect on the frog
 * @author Emma Waddell
 * @date 11.12.2018
 *
 */
public class Obstacles {
	
	private int x, y;
	private PApplet app;
	private PImage img;
	
	/**
	 * Constructor that sets pos and image of each obstacle
	 * @param start coordinates in ints, app, and string that will access the correct graphic
	 */
	public Obstacles (int x, int y, PApplet app, String path) {
		this.app = app;
		this.x = x;
		this.y = y;
		this.img = this.app.loadImage(path);
	}
	
	/**
	 * Resizes the graphic for each obstacle
	 * @param int for horizontal and vertical size of image
	 * @return void main functions must not have any return value, since they are declared as void
	 */
	public void size(int x, int y) {
		img.resize(x,  y);
	}
		
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	//draw obstacles
	public void draw() {
		this.app.image(img,  x,  y);
	}
	
	/**
	 * Moves obstacle
	 * @param boundaries of screen, start pos, and speed
	 * @return void main functions must not have any return value, since they are declared as void
	 */
	public void move(int left, int right, int start, int speed) {
		int newX = this.getX() + speed;
		
		boolean tooLeft = (newX < left);
		boolean tooRight = (newX > right);
		
		if (tooLeft || tooRight)
			newX = start + speed;
		
		this.setX(newX);
	}

	/**
	 * Checks if frog is at same pos as obstacles, w margins due to varying speeds
	 * @param the frog object, and the size of the obstacle
	 * @return boolean return if frog and obstacle are at same pos or not
	 */
	public boolean checkColl(Frog frog, int size) {
		boolean collision = false;
		if (this.y == frog.getY()) {
			if ((this.x <= frog.getX() + 105 && this.x >= frog.getX() + 95 ) || (this.x + size + 5 >= frog.getX() && this.x + size - 5 <= frog.getX()) || (this.x - 5 <= frog.getX() + size && this.x + size + 5 >= frog.getX() + 100) || (this.x > frog.getX() && this.x < frog.getX() + 100) || (this.x + size > frog.getX() && this.x + size < frog.getX() + 100)) 
				collision = true;
		}		
		return collision;
	}
	
	/**
	 * Checks to make sure frog is at same pos as obstacles, w margins due to varying speeds
	 * @param the frog object, and the size of the obstacle
	 * @return boolean return if frog and obstacle are at same pos or not
	 */
	public boolean checkNoColl(Frog frog, int size) {
		boolean collision = false;
		if ((this.x + 10 <= frog.getX() || this.x  - 10 <= frog.getX()) && (this.x + size + 10 >= frog.getX() + 100 || this.x + size - 10 >= frog.getX() + 100)) {
			if (this.y == frog.getY())
				collision = true;
		}
		return collision;
	}
}
