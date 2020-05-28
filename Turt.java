


import processing.core.PApplet;
/**
 * Class to define the turtles in the water
 * @author Emma Waddell
 * @date 11.12.2018
 *
 */
public class Turt extends Obstacles {
	
	PApplet app;
	private final static String PATH = "turt.jpg";
	
	/**
	 * same object explanations as for car1
	 */
	public Turt (int x, int y, PApplet app) {
		super(x, y, app, PATH);
		size(225, 90);
	}
	
	public void move() {
		super.move(-300,  900,  900, -4);
	}
	
	public boolean checkColl(Frog frog, int size) {
		return super.checkColl(frog, size);		
	}
	
	public void draw() {
		super.draw();
	}
}
