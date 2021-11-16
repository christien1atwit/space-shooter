import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public abstract class Enemy implements Drawable, Moveable {

	protected int xpos,ypos;
	protected int sizeX,sizeY;
	protected Image graphic;
	protected boolean isDead;
	protected int speed;
	protected Double[] movementVector;
	protected int TIME_MAX;
	protected int time_act;
	
	//protected BulletPattern bulletPat;
	
	public Enemy(int x,int y) {
		xpos=x;
		ypos=y;
		isDead=false;
	}
	
	public abstract void shoot();
	
	public int getXPos() {
		return xpos;
	}
	public int getYPos() {
		return ypos;
	}
	public int getSizeX() {
		return sizeX;
	}
	public int getSizeY() {
		return sizeY;
	}
	public Image getGraphic() {
		return graphic;
	}
	
	
}
