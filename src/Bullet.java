import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet implements Moveable, Drawable{
	private int xpos, ypos;
	private double[] movementVector;
	private int speed = 15;
	private Image graphicRaw = new Image("res/bullet.png");
	private ImageView graphic = new ImageView(graphicRaw);
	private boolean ownedByPlayer;
	
	public Bullet(int x, int y, double[] initHeading, boolean player) {
		xpos = x;
		ypos = y;
		movementVector = initHeading;
		ownedByPlayer = player;
	}

	@Override
	public Image getGraphic() {
		// TODO Auto-generated method stub
		return graphicRaw;
	}

	@Override
	public void draw(GraphicsContext gc) {
		move();
		gc.drawImage(graphicRaw, xpos, ypos);
	}

	@Override
	public void move() {
		ypos += movementVector[1] * speed;
	}
}

