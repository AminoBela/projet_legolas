/**
 * Classe ProgCombat pour utiliser les classes Guerrier et Arc
 */

public class ProgCombat {

    /**
     * Main pour utiliser les classes Guerrier et Arc avec deux combattants legolas et ugluk
     * @param args
     */

    public static void main(String[] args) {
        // creation du personnaje Legolas (constructeur guerrier)
        Guerrier legolas = new Guerrier("Legolas", 4);

        // creation du personnaje ugluk (constructeur guerrier)
        Guerrier orc = new Guerrier("Ugluk", 3);

        // Afficher l'état des guerriers avant le combat
        System.out.println("État initial :");
        System.out.println(legolas);
        System.out.println(orc);
        System.out.println("");

        // attaque d'Ugluk par Legolas (Legolas n'a pas d'arme)
        System.out.println("Apres attaque de Legolas sur Ugluk :");
        legolas.attaquer(orc);
        System.out.println(legolas);
        System.out.println(orc);
        System.out.println("Ugluk a perdu 0 pv!! Legolas n'a pas d'arme!!");
        System.out.println("");

        // créer un arc elfique 2 dégat 1 flèche
        Arc arcElfique = new Arc(2, 1);

        // Legolas prends l'arcElfique
        legolas.prendreArc(arcElfique);
        System.out.println("Legolas prends l'arc elfique :");
        System.out.println(legolas);
        System.out.println("");


        // Faire attaquer Ugluk par Legolas avec l'arcElfique
        legolas.attaquer(orc);
        System.out.println("Apres attaque de Legolas sur Ugluk :");
        System.out.println(legolas);
        System.out.println(orc);
        System.out.println("Ugluk a perdu 2 pv!!");
        System.out.println("");

        // Faire attaquer Ugluk par Legolas sans flèche (zero degat)
        legolas.attaquer(orc);
        System.out.println("Apres attaque de Legolas sur Ugluk :");
        System.out.println(legolas);
        System.out.println(orc);
        System.out.println("Ugluk n'a perdu de pv, il n'y a plus de flèches chez Legolas!!");
        System.out.println("");

        // Créer un arc orcArc avec 5 dégats et 3 flèches et le donner a ugluk
        Arc orcArc = new Arc(5, 3);
        System.out.println("Legolas prends l'arc elfique :");
        orc.prendreArc(orcArc);
        System.out.println(orc);
        System.out.println("");

        //Ugluk attaque Legolas avec l'arc orcArc
        System.out.println("Apres attaque d'Ugluk sur Legolas :");
        orc.attaquer(legolas);
        System.out.println(legolas);
        System.out.println(orc);
        System.out.println("Legolas a perdu 5 pv, il est blessé!!");
        System.out.println("");

        // creation d'un nouveau guerrier Arwen avec 10 pv
        Guerrier arwen = new Guerrier("Arwen", 10);

        //Arwen prnds l'arc elfique constitue precedemment
        arwen.prendreArc(arcElfique);
        System.out.println("Arwen prends l'arc elfique :");
        System.out.println(arwen);
        System.out.println("");

        // Recharger l'arc elfique avec 1 flèche
        System.out.println("Arwen recharge l'arc elfique avec une fleche :");
        arcElfique.recharger(1);
        System.out.println(arcElfique);
        System.out.println("");

        // Faire attaquer Ugluk par Arwen
        System.out.println("Apres attaque d'Arwen sur Ugluk :");
        arwen.attaquer(orc);
        System.out.println(orc);
        System.out.println("Ugluk a perdu 2 pv, il est blessé!!");
        System.out.println("");

        // Faire attaquer Arwen par Ugluk
        System.out.println("Apres attaque d'Ugluk sur Arwen :");
        orc.attaquer(arwen);
        System.out.println(arwen);
        System.out.println(orc);
        System.out.println("Arwen n'a pas perdu du pv, Ugluk est blessé!!");
        System.out.println("");

        // Afficher l'état des guerriers après le combat
        System.out.println("État final :");
        System.out.println(legolas);
        System.out.println(orc);
        System.out.println(arwen);
        System.out.println("Les elfes ont gagné!!");
        System.out.println("");
    }
}
