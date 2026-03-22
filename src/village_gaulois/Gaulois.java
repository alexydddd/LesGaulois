package village_gaulois;

public class Gaulois {

    private String nom;
    private Integer force;
    private Village village;

    // Constructeur
    public Gaulois(String nom, Integer force) {
        this.nom = nom;
        this.force = force;
        this.village = null;
    }

    // Getters / Setters
    public String getNom() {
        return nom;
    }

    public Integer getForce() {
        return force;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    // Parler
    public void parler(String texte) {
        System.out.println(nom + " dit : " + texte);
    }

    // prendreParole (version sans argument)
    private String prendreParole() {
        return nom + " prend la parole.";
    }

    // toString
    @Override
    public String toString() {
        return nom;
    }

    // frapper un romain
    public void frapper(romain.Romain romain) {
        System.out.println(nom + " frappe " + romain.getNom() + " !");
        romain.recevoirCoup(force);
    }

    // boirePotion
    public void boirePotion(Integer forcePotion) {
        force += forcePotion;
        parler("Par Toutatis !");
    }

    // sePresenter
    public void sePresenter() {
        if (village != null && village.getChef().equals(this)) {
            // C'est le chef du village
            System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom
                    + ". Je suis le chef le village : " + village.getNom() + "\"");
        } else if (village != null) {
            // Habitant d'un village
            System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom
                    + ". J'habite le village : " + village.getNom() + "\"");
        } else {
            // Sans village
            System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom
                    + ". Je voyage de villages en villages.\"");
        }
    }
}
