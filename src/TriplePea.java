
public class TriplePea extends EnemyFormation {

	public TriplePea(int firBound, int secBound) {
		super(firBound, secBound);
		myEnemies=new Enemy[] {new PeaShooter(0,0),new PeaShooter(200,0),new PeaShooter(400,0)};
	}
	
	

}

