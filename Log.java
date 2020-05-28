


import processing.core.PApplet;
/**
 * Class to define the logs
 * @author Emma Waddell
 * @date 11.12.2018
 *
 */
public class Log extends Obstacles {
	
	PApplet app;
	private final static String PATH = "log.png";
	int speed;
	int start;
	
	/**
	 * Constructor for log that is same as for all other obstacles
	 * @param start pos and string to access image graphic
	 */
	public Log (int x, int y, PApplet app) {
		super(x, y, app, PATH);
		size(500, 80);
		speed = 6;
		start = -500;
	}
	
	/**
	 * Constructor for log that is different, since the log graphic is used multiple times
	 * @param start pos and string to access image graphic, size of obstacle, speed, and start pos of next log
	 */
	public Log (int x, int y, PApplet app, int size, int dir, int st) {
		super(x, y, app, PATH);
		size(size, 80);
		speed = dir;
		start = st;
	}
	
	/**
	 * same object explanations as for car1
	 */
	public void move() {
		super.move(-500,  1100, this.start, this.speed);
	}
		
	public boolean checkColl(Frog frog, int size) {
		return super.checkColl(frog, size);		
	}
		
	public void draw() {
		super.draw();
	}
}
