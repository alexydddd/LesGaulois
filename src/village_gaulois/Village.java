package village_gaulois;

public class Village {

    private String nom;
    private Integer nbVillageois = 0;
    private Gaulois chef;
    private Gaulois[] villageois;

    public static final int NB_VILLAGEOIS_MAX = 30;

    // Constructeur
    public Village(String nom, Gaulois chef, int nbVillageoisMax) {
        this.nom = nom;
        this.chef = chef;
        this.villageois = new Gaulois[nbVillageoisMax];
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public Gaulois getChef() {
        return chef;
    }

    public Integer getNbVillageois() {
        return nbVillageois;
    }

    // Ajouter un villageois dans le tableau
    public void ajouterVillageois(Gaulois gaulois) {
        if (nbVillageois < villageois.length) {
            villageois[nbVillageois] = gaulois;
            nbVillageois++;
            gaulois.setVillage(this);
        } else {
            System.out.println("Le village est plein !");
        }
    }

    // Trouver un villageois par son numéro (commence à 1)
    public Gaulois trouverVillageois(int numVillageois) {
        if (numVillageois < 1 || numVillageois > nbVillageois) {
            System.out.println("Il n'y a pas autant d'habitants dans notre village !");
            return null;
        }
        return villageois[numVillageois - 1];
    }

    // Afficher le chef puis tous les villageois
    public void afficherVillageois() {
        System.out.println("Dans le village \"" + nom + "\" du chef " + chef.getNom()
                + " vivent les légendaires gaulois :");
        for (int i = 0; i < nbVillageois; i++) {
            if (villageois[i] != null) {
                System.out.println("- " + villageois[i].getNom());
            }
        }
    }

    // --- MAIN ---
    public static void main(String[] args) {

        // a. Créer le chef Abraracourcix (force 6)
        Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);

        // Créer le village avec Abraracourcix comme chef, max 30 habitants
        Village village = new Village("Village des Irréductibles", abraracourcix, 30);

        // Mettre à jour le village du chef
        abraracourcix.setVillage(village);

        // b. Vérifier que trouverVillageois(30) ne lève pas d'exception
        village.trouverVillageois(30);

        // c. Créer Astérix (force 8) et l'ajouter au village
        Gaulois asterix = new Gaulois("Astérix", 8);
        village.ajouterVillageois(asterix);

        // d. Tester trouverVillageois
        Gaulois gaulois = village.trouverVillageois(1);
        System.out.println(gaulois);
        gaulois = village.trouverVillageois(2);
        System.out.println(gaulois);

        // e. Afficher les villageois
        village.afficherVillageois();

        // g. Créer Obélix (force 25) et l'ajouter
        Gaulois obelix = new Gaulois("Obélix", 25);
        village.ajouterVillageois(obelix);

        // Afficher pour vérifier qu'Obélix est bien là
        village.afficherVillageois();

        // Créer Doublepolémix (force 4, sans village)
        Gaulois doublePolemix = new Gaulois("Doublepolémix", 4);

        // Appeler sePresenter sur abraracourcix, asterix, doublePolemix
        abraracourcix.sePresenter();
        asterix.sePresenter();
        doublePolemix.sePresenter();
    }
}
