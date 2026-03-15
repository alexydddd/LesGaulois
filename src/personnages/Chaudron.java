package personnages;

public class Chaudron {
    private int quantitePotion;
    private int forcePotion;

    public Boolean resterPotion() {
        return quantitePotion != 0;
    }

    public Boolean remplirChaudron(int quantite, int forcePotion) {
        this.quantitePotion = quantite;
        this.forcePotion = forcePotion;
        return true;
    }

    public int prendreLouche() {
        if (quantitePotion > 0) {
            quantitePotion--;
        }
        return forcePotion;
    }
}
