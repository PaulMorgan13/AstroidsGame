

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ship extends Polygon implements KeyListener{
	int speed = 4;
		
	public Ship(Point[] inShape, Point inPosition, double inRotation){ 
		super(inShape,inPosition,inRotation); 
	}	 
	
	
	public void Move(){
		double x = position.getX();
		double y = position.getY();
		
		
		x += speed * Math.cos(2*Math.toRadians(rotation));
		y += speed * Math.sin(2*Math.toRadians(rotation));
	
		
		if (x > 1000) x = 0; 
		if (x < 0) x = 800; 
		if (y > 600) y = 0; 
		if (y < 0) y = 600; 
		
	
		position.setX(x);
		position.setY(y);
	}
	
	public void keyPressed(KeyEvent e) {

		
		if(e.getKeyCode() == e.VK_UP){
			
			rotation --;
		
		}
		if(e.getKeyCode() == e.VK_RIGHT){
			rotation ++;
		}
		if(e.getKeyCode() == e.VK_LEFT){
			rotation --;
		}  
		
		if (e.getKeyCode() == e.VK_DOWN) {
			rotation ++;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		} 
	
	public boolean collider(double x2, double y2, int r) {
	        double xD = position.getX() - x2;
	        double yD = position.getY() - y2;

	        double div= xD * xD + yD * yD;

	        return div < (25 + r)*(25 + r);
	 }


	public void setColor(Color n) {
		// TODO Auto-generated method stub
		
	}
 
	
	}
	
	//end

