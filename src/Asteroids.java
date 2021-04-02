
/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
Original code by Dan Leyzberg and Art Simon
Modified by Megan Owen
 */
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class Asteroids extends Game {
	private int counter = 0;
	Asteroid A1 = new Asteroid(new Point[] {new Point(20,10),new Point (30,10), new Point(40,20), new Point(40,30), new Point(30,40),new Point(20,40),new Point(10,30), new Point(10,20)},new Point (100,100),0);
	Asteroid A2 = new Asteroid(new Point[] {new Point(20,10),new Point (30,10), new Point(40,20), new Point(40,30), new Point(30,40),new Point(20,40),new Point(10,30), new Point(10,20)},new Point (200,20),0);
	Asteroid A3= new Asteroid(new Point[] {new Point(40,20),new Point (60,20), new Point(80,40), new Point(80,60), new Point(60,80),new Point(40,80),new Point(20,60), new Point(20,40)},new Point (789,350),0);
	Asteroid A4= new Asteroid(new Point[] {new Point(20,10),new Point (30,10), new Point(40,20), new Point(40,30), new Point(30,40),new Point(20,40),new Point(10,30), new Point(10,20)},new Point (402,20),0);
	Asteroid A5= new Asteroid(new Point[] {new Point(20,10),new Point (30,10), new Point(40,20), new Point(40,30), new Point(30,40),new Point(20,40),new Point(10,30), new Point(10,20)},new Point (70,350),0); 
	Asteroid A6= new Asteroid(new Point[] {new Point(20,10),new Point (30,10), new Point(40,20), new Point(40,30), new Point(30,40),new Point(20,40),new Point(10,30), new Point(10,20)},new Point (640,400),0);  
	Asteroid A7= new Asteroid(new Point[] {new Point(60,30),new Point (90,30), new Point(120,60), new Point(120,90), new Point(90,120),new Point(60,120),new Point(30,90), new Point(30,60)},new Point (40,500),0);  
	//Wrapping Asteroids 
	Asteroid2 AW1= new Asteroid2(new Point[] {new Point(20,10),new Point (30,10), new Point(40,20), new Point(40,30), new Point(30,40),new Point(20,40),new Point(10,30), new Point(10,20)},new Point (1000,909),0); 
	Asteroid2 AW2= new Asteroid2(new Point[] {new Point(20,10),new Point (30,10), new Point(40,20), new Point(40,30), new Point(30,40),new Point(20,40),new Point(10,30), new Point(10,20)},new Point (1000,-99),0); 
	Asteroid2 AW3= new Asteroid2(new Point[] {new Point(20,10),new Point (30,10), new Point(40,20), new Point(40,30), new Point(30,40),new Point(20,40),new Point(10,30), new Point(10,20)},new Point (135,56),0); 

	
	Asteroid[] aster = {A1,A2,A3,A4,A5,A6,A7};
	Asteroid2[] asterW = {AW1,AW2,AW3};
	
	Ship ship1 = new Ship(new Point[] {new Point(20,10), new Point(60,30),new Point(20,50),new Point(30,30)},new Point(500,300),0);  
	
	
	public Asteroids() {
		super("Asteroids!",1000,600);
		this.setFocusable(true);
		this.requestFocus(); 
		this.addKeyListener(ship1);
	}

	public void paint(Graphics brush) {
		brush.setColor(Color.orange);
		brush.fillRect(0,0,width,height);

		// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		counter++;
		brush.setColor(Color.white);
		brush.drawString("Counter is " + counter,10,10); 
		
		ship1.paint(brush);
		ship1.Move(); 
		for(Asteroid oz: aster){
			oz.paint(brush);
			oz.move() ; 
			if(ship1 != null && aster  != null) if(ship1.collider(oz.position.getX()-1, oz.position.getY()-1,1))  { 
				ship1 = null;}
			}
			
	
		for(Asteroid2 p: asterW){
			p.paint(brush);
			p.move(); 
			if(ship1 != null && asterW  != null) if(ship1.collider(p.position.getX()-1, p.position.getY()-1,1))   ship1 = null;{
	
			}
		}
		

		
		} 
	

	public static void main (String[] args) { 
		
		Asteroids a = new Asteroids();
		a.repaint();   
	
	}


}