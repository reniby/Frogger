


import processing.core.PApplet;
/**
 * Class to define the second car
 * @author Emma Waddell
 * @date 11.12.2018
 *
 */
public class Car2 extends Obstacles {
	
	PApplet app;
	private final static String PATH = "car2.png";
	
	/**
	 * same object explanations as for car1
	 */
	public Car2 (int x, int y, PApplet app) {
		super(x, y, app, PATH);
		size(100, 90);
	}
	
	public void move() {
		super.move(-100,  900,  900, -3);
	}
	
	public boolean checkColl(Frog frog, int size) {
		return super.checkColl(frog, size);		
	}
	
	public void draw() {
		super.draw();
	}
}