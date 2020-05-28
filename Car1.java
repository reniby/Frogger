


import processing.core.PApplet;

/**
 * Class to define the first car
 * @author Emma Waddell
 * @date 11.12.2018
 *
 */
public class Car1 extends Obstacles {
	
	PApplet app;
	//defines path so can be sent to super class
	private final static String PATH = "car1.png";
	
	/**
	 * Constructor that calls super and resizes
	 * @param start coordinates and app
	 */
	public Car1 (int x, int y, PApplet app) {
		super(x, y, app, PATH);
		size(100, 90);
	}
	
	//calls super and uses parameters left bound, right bound, start pos, and speed
	public void move() {
		super.move(-100,  900,  900, -5);
	}
	
	/**
	 * Checks for collision from super
	 * @param the frog object, and the size of the obstacle
	 * @return boolean return if frog and obstacle are at same pos or not
	 */
	public boolean checkColl(Frog frog, int size) {
		return super.checkColl(frog, size);		
	}
	
	public void draw() {
		super.draw();
	}
}
