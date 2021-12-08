
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.GraphicsContext;


public interface Drawable {
	Image getGraphic();

	void draw(Pane root);
}
