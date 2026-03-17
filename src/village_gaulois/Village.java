package village_gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;
	
	public Village(String nom, Gaulois chef, int NB_VILLAGEOIS_MAX) {
		this.nom = nom;
		assert chef != null;
		this.chef = chef;
		this.villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	}
	
	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return chef;
	}
	
	public String ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		gaulois.setVillage(this);
		nbVillageois++;
		return gaulois.getNom() + "a rejoint notre village " + nom + " !";
	}

	public Gaulois trouverVillageois(int numVillageois) {
		if ( numVillageois < 1 || numVillageois > nbVillageois) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
		return villageois[numVillageois - 1];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village " + '"' + nom + '"' + " du chef " + chef + 
				" vivent les légendaires gaulois : ");
		for (Gaulois gaulois : villageois) {
			System.out.println("- " + gaulois.getNom());
		}
	}			
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		int NB_VILLAGEOIS_MAX = 30;
		Village village = new Village("Village des Irréductibles", 
				abraracourcix, NB_VILLAGEOIS_MAX);
		village.trouverVillageois(30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillageois();
	}
}
