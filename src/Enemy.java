import javafx.scene.shape.Rectangle;

public abstract class Enemy implements Drawable, Moveable {

	private int xpos,ypos;
	private int sizeX,sizeY;
	private Rectangle graphic;
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
	public Rectangle getGraphic() {
		return graphic;
	}
	
	
}
