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
		enemyForms=new EnemyFormation[] {new TriplePea(-6900,-6000),new TriplePea(-5800,-5700),new DualZipper(-5750,-5600),new DualZipper(-5500,-5450),
		new TriplePea(-5450,-5000),new TriplePea(-5350,-5000),new TriplePea(-5250,-5000),new DualZipper(-5250,-5000),new DualZipper(-5000,-4000),
		new TriplePea(-4000,-1000),new TriplePea(-3000,-1000),new TriplePea(-2000,-1000),new TriplePea(-1000,-1000),new TriplePea(-500,0),
		new DualZipper(-3500,0),new DualZipper(-3200,0),new DualZipper(-3000,0),new DualZipper(-2500,0),new DualZipper(-1500,0)};
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
