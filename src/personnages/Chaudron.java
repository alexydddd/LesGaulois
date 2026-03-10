package personnages;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;
	
	public void resterPotion() {
		if ( this.quantitePotion > 0 ) {
			return true;
		}
	}
}
