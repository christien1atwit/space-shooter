import javafx.scene.image.Image;

public class FirstMap extends Map{

	public FirstMap(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		graphic=new Image("map1.png");
		yScroll=(int) graphic.getHeight()-Main.height;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		scroll();
	}

}
