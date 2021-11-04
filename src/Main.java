import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = new Pane();
		Scene s = new Scene(root,600,800);
		primaryStage.setScene(s);
		primaryStage.show();
		Canvas gameCan=new Canvas(600,800);
		GraphicsContext gameGC=gameCan.getGraphicsContext2D();
		root.getChildren().add(gameCan);
		PeaShooter testE=new PeaShooter(100,100);
		gameGC.drawImage(testE.getGraphic(), 0, 0);
		
		
	}

}
