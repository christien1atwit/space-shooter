import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class FirstMap extends Map{

	public FirstMap(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		graphic=new Image("res/map1.png");
		yScroll=Main.height-(int)graphic.getHeight();
		scrollSp=5;
		enemyForms=new EnemyFormation[] {new TriplePea(-6900,-6000),new TriplePea(-5800,-5700),new DualZipper(-5750,-5600)};
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		spawnEnemies();
		scroll();
		updateEnemies(gc);
		cleanUp();
		//System.out.println(currentEnemies.size());
		
	}

	@Override
	public Image getGraphic() {
		// TODO Auto-generated method stub
		return null;
	}


}
