import java.util.ArrayList;

import javafx.scene.image.Image;

public abstract class Map implements Drawable{
	protected Image graphic;//Graphic of the map
	protected int yScroll;//Vertical postion of the map starts negative top of the map is yScroll=0
	protected int scrollSp;//How much the Map scrolls up per frame
	protected EnemyFormation[] enemyForms; //Array of EnemyFormations 
	protected ArrayList<Enemy> currentEnemies = new ArrayList<Enemy>();//ArrayList of enemies that are on-screen/active
	protected String name;
	//Soundstream Music
	
	public Map(String name) {
		this.name=name;
	}
	
	protected void scroll() {
		System.out.println("yScroll: "+yScroll);
		if(yScroll<0) {
			yScroll+=scrollSp;
		}
	}
	
	protected void spawnEnemies() {
		for(int i=0;i<enemyForms.length;i++) {
			System.out.println("Lower Bound: "+enemyForms[i].yBounds[0]);
			if(enemyForms[i].yBounds[0]<=yScroll && enemyForms[i].yBounds[1]>=yScroll) {
				if(!enemyForms[i].didSpawn()) {
					enemyForms[i].setSpawn(true);
					//System.out.println("spawn");
					Enemy[] toPlace=enemyForms[i].getMyEnemies();
					for(int e=0; e<toPlace.length;e++) {
						currentEnemies.add(toPlace[e]);
					}
				}
			}
		}
	}
	
	public void cleanUp() {
		ArrayList<Enemy> toRemove = new ArrayList<Enemy>();
		for(int i=currentEnemies.size()-1;i>=0;i--) {
			if(currentEnemies.get(i).isDead) {
				toRemove.add(currentEnemies.get(i));
			}
		}
		if(toRemove!=null) {
			for(Enemy e:toRemove) {
				currentEnemies.remove(e);
			}
		}
	}
	
	
	
}
