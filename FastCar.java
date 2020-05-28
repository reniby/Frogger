


import processing.core.PApplet;
/**
 * Class to define the faster car in the middle
 * @author Emma Waddell
 * @date 11.12.2018
 *
 */
public class FastCar extends Obstacles {
	
	PApplet app;
	private final static String PATH = "fastcar.png";
	
	/**
	 * same object explanations as for car1
	 */
	public FastCar (int x, int y, PApplet app) {
		super(x, y, app, PATH);
		size(100, 90);
	}
	
	public void move() {
		super.move(-100,  900,  -100, 7);
	}
	
	public boolean checkColl(Frog frog, int size) {
		return super.checkColl(frog, size);		
	}
	
	public void draw() {
		super.draw();
	}
}
