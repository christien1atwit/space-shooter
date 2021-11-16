import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class PeaShooter extends Enemy{
	
	private boolean goingRight;
	
	public PeaShooter(int x, int y) {
		super(x, y);
		sizeX=32;
		sizeY=32;
		goingRight=true;
		speed=5;
		movementVector=new Double[2];
		movementVector[0]=1.0;
		movementVector[1]=0.5;
		graphic=new Image("res/peashooter.png");
		TIME_MAX=60;
		time_act=TIME_MAX;
		
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
		if(xpos>600) {
			movementVector[0]=-1.0;
		}
		if(xpos<0) {
			movementVector[0]=1.0;
		}
		time_act--;
		if(time_act<=0) {
			time_act=TIME_MAX;
			shoot();
		}
		xpos+=(int)(movementVector[0]*speed);
		ypos+=(int)(movementVector[1]*speed);
		//System.out.println(xpos);
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		System.out.println("SHOOTING");
	}

}
