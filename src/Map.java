import javafx.scene.image.Image;

public abstract class Map implements Drawable{
	protected Image graphic;
	protected int yScroll;
	protected int scrollSp;
	//EnemyFormation Array
	protected String name;
	//Soundstream Music
	
	public Map(String name) {
		this.name=name;
	}
	
	public void scroll() {
		if(yScroll>0) {
			yScroll-=scrollSp;
		}
	}
	
	
	
	
	
}
