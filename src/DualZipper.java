
public class DualZipper extends EnemyFormation {

	public DualZipper(int firBound, int secBound) {
		super(firBound, secBound);
		myEnemies=new Enemy[] {new Zipper(200,0), new Zipper(300,-50)};
	}
	
}
