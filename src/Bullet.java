import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Bullet implements Moveable, Drawable{
	private int xpos, ypos;
	private double[] movementVector;
	private int speed = 15;
	private Image graphicRaw = new Image("res/bullet.png");
	private ImageView graphic = new ImageView(graphicRaw);
	private boolean ownedByPlayer;
	private boolean destroyed=false;
	
	public Bullet(int x, int y, double[] initHeading, boolean player) {
		xpos = x;
		ypos = y;
		movementVector = initHeading;
		ownedByPlayer = player;
		graphic.setX(x);
		graphic.setY(y);
		
		if(!ownedByPlayer) {
			graphic.setRotate(180);
		}
	}

	@Override
	public ImageView getGraphic() {
		// TODO Auto-generated method stub
		return graphic;
	}
	
	public ImageView getImageView() {
		return graphic;
	}

	@Override
	public void draw() {
		if(!destroyed) {
			move();
			//gc.drawImage(graphic.getImage(), xpos, ypos);
		}
		
	}

	@Override
	public void move() {
		ypos += movementVector[1] * speed;
		graphic.setY(ypos);
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}
	public void destroy(boolean state) {
		destroyed=state;
	}

	
	
}

