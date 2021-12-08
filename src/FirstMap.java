import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FirstMap extends Map{

	public FirstMap(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		graphic=new ImageView("res/map1.png");
		Image tempImg= new Image("res/map1.png");
		yScroll=Main.height-(int)tempImg.getHeight();
		//graphic.setX(0);
		graphic.setY(yScroll);
		scrollSp=5;
		enemyForms=new EnemyFormation[] {new TriplePea(-6900,-6000),new TriplePea(-5800,-5700),new DualZipper(-5750,-5600)};
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		spawnEnemies();
		scroll();
		updateEnemies();
		cleanUp();
		//System.out.println(currentEnemies.size());
		
	}

	@Override
	public ImageView getGraphic() {
		// TODO Auto-generated method stub
		return graphic;
	}


}
