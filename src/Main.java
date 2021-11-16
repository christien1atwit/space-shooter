import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application{
	
	public static final int height=800;
	public static final int width=600;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = new Pane();
		Canvas gameCan=new Canvas(width,height);
		GraphicsContext gameGC=gameCan.getGraphicsContext2D();
		root.getChildren().add(gameCan);
		
		Map currentMap=new FirstMap("map1");
		PeaShooter testE=new PeaShooter(100,100);
		
		
		
			EventHandler<ActionEvent> eh= new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				gameGC.drawImage(currentMap.graphic,0,currentMap.yScroll);
				testE.move();
				gameGC.drawImage(testE.getGraphic(), testE.getXPos(), testE.getYPos());
			}
			
		};
		
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(32),eh));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();
		Scene s = new Scene(root,width,height);
		primaryStage.setScene(s);
		primaryStage.show();
		
		
	}

}
