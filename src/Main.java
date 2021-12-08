import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application{
	
	public static final int height=800;
	public static final int width=600;
	public static ArrayList<Bullet> currentBullets = new ArrayList<Bullet>();
	private Player testPlayer;
	public static Group root = new Group();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Canvas gameCan=new Canvas(width,height);
		GraphicsContext gameGC=gameCan.getGraphicsContext2D();
		//root.getChildren().add(gameCan);
		
		Map currentMap=new FirstMap("map1");
		PeaShooter testE=new PeaShooter(100,100);
		testPlayer = new Player(100, 500);
		root.getChildren().add(currentMap.getGraphic());
		root.getChildren().add(testPlayer.getGraphic());
		
			EventHandler<ActionEvent> eh= new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				
				currentMap.draw();
				testPlayer.draw();
				
				for(Bullet bullet : currentBullets) {
					bullet.draw();
				}
				
				collisionDetect();
				
			}
			
		};
		
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(32),eh));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();
		
		Scene s = new Scene(root,width,height);
		//s.setOnKeyPressed(testPlayer.moveHandler);
		s.setOnKeyReleased(testPlayer.stopHandler);
		s.setOnKeyPressed(testPlayer.playerInputHandler);
		
		
		primaryStage.setScene(s);
		primaryStage.show();
		
		
	}
	
	public static void createBullet(int x, int y, double[] initHeading, boolean playerOwned) {
		Bullet bullet = new Bullet(x, y, initHeading, playerOwned);
		currentBullets.add(bullet);
		root.getChildren().add(bullet.getImageView());
	}
	
	public void collisionDetect() {
		for(Bullet bullet : currentBullets) {
			if(bullet.getImageView().getBoundsInParent().intersects(testPlayer.getGraphic().getBoundsInParent())){
				testPlayer.setDead(true);
			}
		}
	}

}
