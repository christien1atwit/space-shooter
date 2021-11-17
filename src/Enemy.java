import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public abstract class Enemy implements Drawable, Moveable {

	protected int xpos,ypos;//uses top left corner for x/y position
	protected int sizeX,sizeY; //Size of enemy in pixels, to be used for hitbox
	protected Image graphic; //Image for enemy
	protected boolean isDead; //Notes if enemy is destroyed
	protected int speed; //how much an enemy moves each frame
	protected Double[] movementVector; //Direction of enemy
	protected int TIME_MAX; //Maximum amount of frames until enemy shoots
	protected int time_act;// frames until the enemy shoots
	
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
