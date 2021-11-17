import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Player implements Moveable, Drawable {
	private int xpos, ypos;
	private double[] movementVector;
	private int speed = 5;
	private Image graphic = new Image("res/playersized.png");
	public EventHandler<KeyEvent> moveHandler;
	public EventHandler<KeyEvent> stopHandler;
	
	public Player(int x, int y) {
		xpos = x;
		ypos = y;
		movementVector = new double[2];
		movementVector[0] = 0.0;
		movementVector[1] = 0.0;
		
		move();
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		xpos += movementVector[0] * speed;
		ypos += movementVector[1] * speed;
		gc.drawImage(graphic, xpos, ypos);
	}

	@Override
	public void move() {
		moveHandler = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				KeyCode keyPressed = arg0.getCode();
				switch(keyPressed) {
					case UP:
						movementVector[1] = -1;
						break;
					case DOWN:
						movementVector[1] = 1;
						break;
					case LEFT:
						movementVector[0] = -1;
						break;
					case RIGHT:
						movementVector[0] = 1;
						break;
				}
			}
			
		};
		stopHandler = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				KeyCode keyPressed = arg0.getCode();
				if(keyPressed == KeyCode.UP || keyPressed == KeyCode.DOWN) {
					movementVector[1] = 0;
				}
				if(keyPressed == KeyCode.LEFT || keyPressed == KeyCode.RIGHT){
					movementVector[0] = 0;
				}
			}
			
		};
	}
	
	public Image getGraphic() {
		return graphic;
	}
	
	public int getXPos() {
		return xpos;
	}
	
	public int getYPos() {
		return ypos;
	}

}
