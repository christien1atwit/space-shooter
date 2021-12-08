import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Player implements Moveable, Drawable {
	private int xpos, ypos;
	private double[] movementVector;
	private int speed = 5;
	private boolean isDead=false;
	private ImageView graphic = new ImageView("res/playersized.png");
	public EventHandler<KeyEvent> playerInputHandler;
	public EventHandler<KeyEvent> stopHandler;
	private boolean holdingUp, holdingDown, holdingLeft, holdingRight;
	
	public Player(int x, int y) {
		xpos = x;
		ypos = y;
		movementVector = new double[2];
		movementVector[0] = 0.0;
		movementVector[1] = 0.0;
		
		playerInputHandler = new EventHandler<KeyEvent>() { //Handles moving, shooting inputs

			@Override
			public void handle(KeyEvent arg0) {
				KeyCode keyPressed = arg0.getCode();
				if(keyPressed == KeyCode.SPACE) {
					if(!isDead) {
						shoot();
					}
				}
				
				switch(keyPressed) {
					case UP:
						holdingUp = true;
						movementVector[1] = -1;
						break;
					case DOWN:
						holdingDown = true;
						movementVector[1] = 1;
						break;
					case LEFT:
						holdingLeft = true;
						movementVector[0] = -1;
						break;
					case RIGHT:
						holdingRight = true;
						movementVector[0] = 1;
						break;
				}
				
			}
			
		};
		
		move();
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		if(!isDead) {
			xpos += movementVector[0] * speed;
			ypos += movementVector[1] * speed;
			//gc.drawImage(graphic, xpos, ypos);
			graphic.setX(xpos);
			graphic.setY(ypos);
		} else {
			graphic.setImage(null);
		}
		
	}

	@Override
	public void move() {
		stopHandler = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				KeyCode keyPressed = arg0.getCode();
				switch(keyPressed) {
					case UP:
						holdingUp = false;
						break;
					case DOWN:
						holdingDown = false;
						break;
					case LEFT:
						holdingLeft = false;
						break;
					case RIGHT:
						holdingRight = false;
						break;
				};
				
				if(keyPressed == KeyCode.UP || keyPressed == KeyCode.DOWN) {
					if(holdingUp) {
						movementVector[1] = -1;
					} else if(holdingDown) {
						movementVector[1] = 1;
					} else {
						movementVector[1] = 0;
					}
				}
				if(keyPressed == KeyCode.LEFT || keyPressed == KeyCode.RIGHT){
					if(holdingLeft) {
						movementVector[0] = -1;
					} else if(holdingRight) {
						movementVector[0] = 1;
					} else {
						movementVector[0] = 0;
					}
				}
			}
			
		};
	}
	
	public boolean getDead() {
		return isDead;
	}
	public void setDead(boolean state) {
		isDead=state;
	}
	
	private void shoot() {
		Main.createBullet((int)(this.xpos + new Image(graphic.getImage().getUrl()).getWidth() / 2), this.ypos, new double[] {0.0, -1.0}, true);
	}
	
	public ImageView getGraphic() {
		return graphic;
	}
	
	public int getXPos() {
		return xpos;
	}
	
	public int getYPos() {
		return ypos;
	}

}
