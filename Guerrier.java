/**
 * Classe Guerrier
 */

public class Guerrier {
    private String nom;
    private int pv;
    private Arc arc;

    /**
     * Constructeur de la classe Guerrier par defaut
     */

    public Guerrier(String pNom) {
        this.nom = pNom;
        this.pv = 10;
        this.arc = null;
    }

    /**
     * Constructeur de la classe Guerrier avec parametres
     * @param pNom Nom du guerrier
     * @param p Nombre de points de vie
     */

    public Guerrier(String pNom, int p) {
        this.nom = pNom;
        if (p <= 1) {
            this.pv = 1;
        } else {
            this.pv = p;
        }
        this.arc = null;
    }

    /**
     * Getteur des points de vie
     * @return
     */

    public int getPv() {
        return this.pv;
    }

    /**
     * Getteur du nom
     * @return Nom du guerrier
     */

    public String getNom() {
        return this.nom;
    }

    /**
     * Getteur de l'arc
     * @return Arc du guerrier
     */

    public Arc getArc() {
        return this.arc;
    }

    /**
     * Methode qui permet de savoir si le guerrier est blessé
     * @return true si le guerrier est blessé, false sinon
     */

    public boolean etreBlesse() {
        return this.pv <= 0;
    }

    /**
     * Methode qui permet de faire subir des dégats au guerrier
     * @param degat Nombre de dégats
     */

    public void subirDegat(int degat) {
        if (degat > 0) {
            this.pv -= degat;
            if (this.pv < 0) {
                this.pv = 0;
            }
        }
    }

    /**
     * Methode pour de prendre un arc
     * @param arc l'Arc à prendre
     * @return vrai si l'arc est pris, faux sinon
     */

    public boolean prendreArc(Arc arc) {
        if (this.arc == null && !this.etreBlesse() && arc != null) {
            this.arc = arc;
            return true;
        }
        return false;
    }

    /**
     * Methode pour poser l'arc
     * @return l'arc posé
     */

    public Arc poserArc() {
        if (!etreBlesse() && this.arc != null) {
            Arc arcPose = this.arc;
            this.arc = null;
            return arcPose;
        }
        return null;
    }

    /**
     * Methode pour attaquer un guerrier (voir si c'est possible)
     * @param victime Guerrier à attaquer
     * @return vrai si l'attaque est réussie, faux sinon
     */

    public boolean attaquer(Guerrier victime) {
        if (this.pv > 0 && this.arc != null && victime != null) {
            int degats = this.arc.utiliser();
            if (degats > 0) {
                victime.subirDegat(degats);
                return true;
            }
        }
        return false;
    }

    /**
     * Methode pour afficher l'état du guerrier
     * @return  Etat du guerrier (nom et points de vie)
     */

    public String toString() {
        if (this.arc != null) {
            return this.nom + "(" + this.pv + ")-arc(d:" + this.arc.getDegats() + ",f:" + this.arc.getFleches() + ")";
        }
        return this.nom + "(" + this.pv + ")";
    }
}



