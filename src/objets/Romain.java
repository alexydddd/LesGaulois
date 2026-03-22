package romain;

import objets.Equipement;

public class Romain {

    private String nom;
    private int force;

    // Section 3 : équipements
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0;

    // Constructeur
    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
        assert isInvariantVerified() : "Invariant violé à la création : force négative !";
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getForce() {
        return force;
    }

    // -------------------------------------------------------
    // Section 2a : invariant privé
    // "la force d'un Romain est toujours positive ou nulle"
    // -------------------------------------------------------
    private boolean isInvariantVerified() {
        return force >= 0;
    }

    // -------------------------------------------------------
    // recevoirCoup avec précondition + postcondition
    // -------------------------------------------------------
    public void recevoirCoup(int forceCoup) {
        // Précondition : la force du coup reçu est positive
        assert forceCoup > 0 : "Précondition violée : forceCoup doit être positif !";

        int forceAvant = force; // pour la postcondition

        force -= forceCoup;
        if (force < 1) {
            force = 0;
            parler("J'abandonne !");
        } else {
            parler("Aïe");
        }

        // Postcondition : la force a diminué (ou est à 0)
        assert force <= forceAvant : "Postcondition violée : la force n'a pas diminué !";

        // Invariant
        assert isInvariantVerified() : "Invariant violé après recevoirCoup !";
    }

    public void parler(String texte) {
        System.out.println(nom + " dit : " + texte);
    }

    // -------------------------------------------------------
    // Section 3d : sEquiper avec switch sur nbEquipement
    // -------------------------------------------------------
    public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 2:
                // Déjà deux équipements
                System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;
            case 1:
                // Un équipement : vérifier si c'est le même
                if (equipements[0] == equipement) {
                    afficherPossedeDeja(equipement);
                } else {
                    ajouterEquipement(equipement);
                }
                break;
            default:
                // Aucun équipement
                ajouterEquipement(equipement);
                break;
        }
    }

    // Méthode privée : évite la duplication de code
    private void ajouterEquipement(Equipement equipement) {
        equipements[nbEquipement] = equipement;
        nbEquipement++;
        System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
    }

    private void afficherPossedeDeja(Equipement equipement) {
        System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
    }

    // -------------------------------------------------------
    // MAIN
    // -------------------------------------------------------
    public static void main(String[] args) {

        // --- Section 2a : test invariant ---
        // Pour tester l'AssertionError : mettre -6 et activer -ea dans VM arguments
        Romain minus = new Romain("Minus", 6);

        // --- Section 3a : afficher les énumérés ---
        System.out.println(Equipement.CASQUE);
        System.out.println(Equipement.BOUCLIER);

        // --- Section 3d : tester sEquiper ---
        // deux casques, un bouclier, puis encore un casque
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
    }
}
