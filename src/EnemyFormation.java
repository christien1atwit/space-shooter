
public abstract class EnemyFormation {
	protected Enemy[] myEnemies;
	protected int[] yBounds=new int[2];//[0] first bound [1] second bound
	protected boolean didSpawn=false;
	
	public EnemyFormation(int firBound, int secBound) {
		yBounds[0]=firBound;
		yBounds[1]=secBound;
	}

	public int[] getYBounds() {
		return yBounds;
	}
	
	public boolean didSpawn() {
		return didSpawn;
	}
	
	public void setSpawn(boolean value) {
		didSpawn=value;
	}
	
	public Enemy[] getMyEnemies() {
		return myEnemies;
	}
	
}
