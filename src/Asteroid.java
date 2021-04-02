

public class Asteroid extends Polygon{ 
	int speedX = 4;
	int speedY = 3;
	public Asteroid(Point[] inShape, Point inPosition, double inRotation){ 
		super(inShape,inPosition,inRotation);  
	}  
	
	
	public void move(){
			
	 position.addToX(speedX);
	 position.addToY(speedY); 
	 rotation+=5; 
	 //this allows some asteroids to bounce off the walls
	 if(position.getX() > 970 || position.getX() < 3){
		 speedX = -speedX;
	 }
	 if(position.getY() > 545 || position.getY() < 3){
		 speedY = -speedY;
	 }
	}
} 
	
