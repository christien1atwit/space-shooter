import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public abstract class Enemy implements Drawable, Moveable {

	protected int xpos,ypos;
	protected int sizeX,sizeY;
	protected Image graphic;
	//private BulletPattern bulletPat;
	
	public Enemy(int x,int y) {
		xpos=x;
		ypos=y;
	}
	
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
