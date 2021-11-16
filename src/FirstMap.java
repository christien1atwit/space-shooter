import javafx.scene.image.Image;

public class FirstMap extends Map{

	public FirstMap(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		graphic=new Image("res/map1.png");
		yScroll=Main.height-(int)graphic.getHeight();
		scrollSp=5;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		scroll();
	}

	@Override
	public Image getGraphic() {
		// TODO Auto-generated method stub
		return null;
	}


}
