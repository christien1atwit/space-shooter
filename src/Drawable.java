
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.GraphicsContext;


public interface Drawable {
	ImageView getGraphic();

	void draw();
}
