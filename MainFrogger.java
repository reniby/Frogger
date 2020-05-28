

import java.util.ArrayList;


import processing.core.*;

/**
 * Main class for frogger game, controls movement and drawing of frog and each obstacle
 * @author Emma Waddell
 * @date 11.13.2018
 *
 */

public class MainFrogger extends PApplet {
	
	
	PImage bg;
	PImage lllives;
	PImage llives;
	PImage live;
	PImage game;
	PImage yay;
	private Frog frog;

	public final static int NUM_CAR1 = 2;
	public final static int NUM_CAR2 = 3;
	
	//create arrays for each obstacle
	private ArrayList<Car1> car = new  ArrayList<Car1>();
	private ArrayList<Car2> cars = new  ArrayList<Car2>();
	private ArrayList<FastCar> fcar = new  ArrayList<FastCar>();
	private ArrayList<Turt> turt = new  ArrayList<Turt>();
	private ArrayList<Log> llog = new  ArrayList<Log>();
	private ArrayList<Log> slog = new  ArrayList<Log>();
	
	public static void main(String[] args) {
        PApplet.main("MainFrogger");
        
    }
	
	public void settings(){
	    size(900,900);
	}

	public void setup(){
		bg = loadImage("frogback.jpg");
		this.frog = new Frog(this);
		
		//add # of obstacles (2 or 3) to each array
		int x1 = 700, y1 = 700;
		for (int i=0; i<MainFrogger.NUM_CAR1; i++) {	
			Car1 car1 = new Car1(x1, y1, this); 
			this.car.add(car1);
			x1 -= 500;
		}
		
		int x2 = 800, y2 = 500;
		for (int i=0; i<MainFrogger.NUM_CAR2; i++) {	
			Car2 car2 = new Car2(x2, y2, this); 
			this.cars.add(car2);
			x2 -= 300;
		}
		
		int x3 = 700, y3 = 600;
		for (int i=0; i<MainFrogger.NUM_CAR1; i++) {	
			FastCar fcar = new FastCar(x3, y3, this); 
			this.fcar.add(fcar);
			x3 -= 200;
		}
		
		int x4= 800, y4 = 300;
		for (int i = 0; i<MainFrogger.NUM_CAR2; i++) {
			Turt turt = new Turt(x4, y4, this);
			this.turt.add(turt);
			x4 -= 400;
		}
		
		int x5 = 100, y5 = 200;
		for (int i = 0; i<MainFrogger.NUM_CAR2; i++) {
			Log slog = new Log(x5, y5, this, 300, -6, 900);
			this.slog.add(slog);
			x5 += 450;
		}
		
		int x6 = 700, y6 = 100;
		for (int i = 0; i<MainFrogger.NUM_CAR1; i++) {
			Log llog = new Log(x6, y6, this);
			this.llog.add(llog);
			x6 -= 800;
		}
		
		lllives = loadImage("3 hearts.jpg");
		lllives.resize(200, 170);
		llives = loadImage("2 hearts.jpg");
		llives.resize(200, 170);
		live = loadImage("1 hearts.jpg");
		live.resize(200, 170);
		game = loadImage("game.png");
		game.resize(900, 900);
		yay = loadImage("yay.jpg");
		yay.resize(1300, 900);
		
		
		
	} 
	
	
	
	int lives = 0;
	public void draw(){	
		background(bg);
		
		//draw each obstacle in each array
		for (int i=0; i<this.car.size(); i++) {
			Car1 car1 = this.car.get(i);
			car1.move(); 
			car1.draw(); 
			
			//check if frog is at same pos as obstacle
			if (car1.checkColl(frog, 100)) {
				lives = frog.kill();				
			}
								
		}
		
		for (int i=0; i<this.cars.size(); i++) {
			Car2 car2 = this.cars.get(i);
			car2.move(); 
			car2.draw(); 
			
			if (car2.checkColl(frog, 100)) {
				lives = frog.kill();				
			}
		}
		
		for (int i=0; i<this.fcar.size(); i++) {
			FastCar fcar = this.fcar.get(i);
			fcar.move(); 
			fcar.draw(); 
			
			if (fcar.checkColl(frog, 100)) {
				lives = frog.kill();				
			}
		}
		
		int three = 0;
		
		for (int i=0; i<this.turt.size(); i++) {
			Turt turt = this.turt.get(i);
			turt.move(); 
			turt.draw();
			
			//check to make sure frog is at same pos as obstacle
			//using the "three" int because for some reason checkNoColl returns true, false, false if it's true so checking to make sure it's 3 falses in a row not just 1
			if (frog.getY() == 300) {
				if (!turt.checkNoColl(frog, 225)) {
					three++;
					if (three >= 3)
						lives = frog.kill();
				}
				else
					three = 0;
			}
			
		}
		
		
		for (int i=0; i<this.slog.size(); i++) {
			Log slog = this.slog.get(i);
			slog.move(); 
			slog.draw();
			
			if (frog.getY() == 200) {
				if (!slog.checkNoColl(frog, 300)) {
					three++;
					if (three >= 3)
						lives = frog.kill();
				}
				else
					three = 0;
			}
		}
		
		//here it has to be 2 falses because it never reaches 3 falses in a row
		for (int i=0; i<this.llog.size(); i++) {
			Log llog = this.llog.get(i);
			llog.move(); 
			llog.draw();
			
			if (frog.getY() == 100) {
				if (!llog.checkNoColl(frog, 500)) {
					three++;
					if (three >= 2)
						lives = frog.kill();
				}
				else
					three = 0;
			}
		}
		
		//make frog move with the obstacles in the water
		if (frog.getY() == 300) {
			frog.move(-4);
		}
		else if (frog.getY() == 200) {
			frog.move(-6);
		}
		else if (frog.getY() == 100) {
			frog.move(6);
		}
		
		//check to make sure frog doesn't ride obstacles off screen
		boolean tooLeft = (frog.getX() < -100);
		boolean tooRight = (frog.getX() > 900);
		
		if (tooLeft || tooRight)
			lives = frog.kill();
		
		this.frog.draw();
		
		//draw hearts in bottom right corner that go down with each death
		if (lives == 0)
			image(lllives, 750, 800);
		else if (lives == 1)
			image(llives, 750, 800);
		else if (lives == 2)
			image(live, 750, 800);
		else {
			image(game, 0, 0);
		}
		
		//end game if frog reaches top of play field
		if (frog.getY() == 0)
			image(yay, -200, 0);
	}
	
	/**
	 * Controls frog using arrow keys
	 * @param no parameters technically, does take in arrow key inputs
	 * @return void main functions must not have any return value, since they are declared as void
	 */
	public void keyPressed() {
		if (this.key == PConstants.CODED) {
			switch (this.keyCode) {
				case PConstants.LEFT:
					this.frog.goLeft(); //turn left
					break;
				case PConstants.RIGHT:
					this.frog.goRight(); //turn right
					break;
				case PConstants.UP:
					this.frog.goUp(); //turn up
					break;
				case PConstants.DOWN:
					this.frog.goDown(); //turn down
					break;
			}
		}
		
	}
	
}
