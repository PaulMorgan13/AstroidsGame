
public class Asteroid2 extends Polygon{   
	int speedx=  1;
	int speedy = 1;
	public Asteroid2(Point[] inShape, Point inPosition, double inRotation){
		super(inShape,inPosition,inRotation);
	}

	public void move()
	{
		position.addToX(speedx);
		position.addToY(speedy);
		
		rotation += 1;
		
		if (position.getX() > 1000) position.setX(0); 
		if (position.getX() < 0)   position.setX(1000); 
		if (position.getY() > 600) position.setY(0); 
		if (position.getY() < 0)   position.setY(600); 
	}
}


