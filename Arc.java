/**
 * Class Arc (representation d'une arme qu'un guerrier peut uiliser)
 */

public class Arc {
    private int degats;
    private int fleches;

    /**
     * Constructeur constructeur d'arc par defaut
     */

    public Arc() {
        this.degats = 5;
        this.fleches = 3;
    }

    /**
     * Constructeur construction de l'arc
     * @param dg Dégat qu'inflige l'arc
     * @param fl Flèches restantes
     */

    public Arc(int dg, int fl) {

        if (dg >= 0) {
            this.degats = dg;
        } else {
            this.degats = 0;
        }

        if (fl >= 0) {
            this.fleches = fl;
        } else {
            this.fleches = 0;
        }
    }



    /**
     * Methode recharge de l'arc
     * @param nFleches Nombre de flèches
     */

    public void recharger(int nFleches) {
        if (nFleches > 0) {
            this.fleches += nFleches;
        }
    }

    /**
     * Methode pour utiliser l'arc
     * @return Degat infligé
     */

    public int utiliser() {
        if (fleches > 0) {
            fleches--;
            return degats;
        } else {
            return 0;
        }
    }

    /**
     * Getteur des dégats
     * @return dégats
     */

    public int getDegats() {
        return degats;
    }

    /**
     * Getteur des flèches
     * @return flèches
     */

    public int getFleches() {
        return fleches;
    }

    /**
     * Affichage de l'utilisation de l'arc
     * @return Nombre de degats et flèches
     */

    @Override
    public String toString() {

        return "-arc(d:" + degats + ",f:" + fleches + ")";
    }


}
