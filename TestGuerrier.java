import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;


/**
 * classe de test qui permet de verifier que la classe Guerrier
 * fonctionne correctement
 */

public class TestGuerrier {

	/**
	 * methode de lancement des tests
	 * @param args
	 */

	public static void main(String[] args) {
		lancer(new TestGuerrier(), args);
	}

	/**
	 * test des methodes de guerrier
	 */

	public void test_guerrier_methodes() {
		Guerrier guerrier = new Guerrier("Toto",10);
		int pv = guerrier.getPv();
		Arc arc = guerrier.getArc();
		String nom = guerrier.getNom();

		boolean b = guerrier.etreBlesse();
		guerrier.subirDegat(1);

		Arc arcN =new Arc();
		boolean resPrendre = guerrier.prendreArc(arcN);
		Arc resPoser =guerrier.poserArc();

		Guerrier victime = new Guerrier("vict");
		boolean resAttaque = guerrier.attaquer(victime);

		String guerrierS = guerrier.toString();
	}

	/**
	 * test du constructeur par defaut
	 */
	public void test_constructeur_defaut(){
		Guerrier guerrier = new Guerrier("Nano");
		assertEquals("le guerrier doit avoir 10 pv",10,guerrier.getPv());
		assertEquals("le guerrier doit le nom de Nano","Nano",guerrier.getNom());
		assertEquals("le guerrier ne doit pas avoir d'arme",null,guerrier.getArc());
	}

	/**
	 * test du constructeur avec pv negatif
	 */
	public void test_constructeur_pv_negatif(){
		Guerrier guerrier = new Guerrier("Nano",-2);
		assertEquals("le guerrier doit avoir 1 pv",1,guerrier.getPv());
		assertEquals("le guerrier doit le nom de Nano","Nano",guerrier.getNom());
		assertEquals("le guerrier ne doit pas avoir d'arme",null,guerrier.getArc());
	}

	/**
	 * test de la methode attaquer de guerrier en etant blesse
	 */

	public void test_attaquer_blesse(){
		Guerrier guerrier = new Guerrier("Toto",10);
		Guerrier victime = new Guerrier("vict");
		guerrier.subirDegat(10);
		boolean resAttaque = guerrier.attaquer(victime);
		assertEquals("le guerrier ne doit pas attaquer s'il est blesse",false,resAttaque);
	}

	/**
	 * test de la methode attaquer sans arme
	 */
	public void test_attaquer_pas_d_arme(){
		Guerrier guerrier = new Guerrier("Toto",10);
		Guerrier victime = new Guerrier("vict");
		boolean resAttaque = guerrier.attaquer(victime);
		assertEquals("le guerrier ne doit pas attaquer s'il n'a pas d'arme",false,resAttaque);
	}

	/**
	 * test de la methode attaquer sans fleche
	 */

	public void test_attaquer_pas_de_fleche(){
		Guerrier guerrier = new Guerrier("Toto",10);
		Guerrier victime = new Guerrier("vict");
		Arc arc = new Arc(1,0);
		guerrier.prendreArc(arc);
		boolean resAttaque = guerrier.attaquer(victime);
		assertEquals("le guerrier ne doit pas attaquer s'il n'a pas de fleche",false,resAttaque);
	}

	/**
	 * test de la methode attaquer
	 */

	public void test_attaquer(){
		Guerrier guerrier = new Guerrier("Toto",10);
		Guerrier victime = new Guerrier("vict");
		Arc arc = new Arc(1,1);
		guerrier.prendreArc(arc);
		boolean resAttaque = guerrier.attaquer(victime);
		assertEquals("le guerrier doit attaquer",true,resAttaque);
	}

	/**
	 * test de la methode subir degat
	 */

	public void test_subirDegat(){
		Guerrier guerrier = new Guerrier("Toto",10);
		guerrier.subirDegat(1);
		assertEquals("le guerrier doit avoir 9 pv",9,guerrier.getPv());
		guerrier.subirDegat(10);
		assertEquals("le guerrier doit avoir 0 pv",0,guerrier.getPv());
		guerrier.subirDegat(-1);
		assertEquals("le guerrier doit avoir 0 pv",0,guerrier.getPv());
	}

	/**
	 * test de la methode subir degat avec degat negatif
	 */

	public void test_subirDegat_negatif(){
		Guerrier guerrier = new Guerrier("Toto",10);
		guerrier.subirDegat(-1);
		assertEquals("le guerrier doit avoir 10 pv",10,guerrier.getPv());
	}

	/**
	 * test de la methode etreBlesse
	 */

	public void test_etreBlesse(){
		Guerrier guerrier = new Guerrier("Toto",10);
		assertEquals("le guerrier n'est pas blesse",false,guerrier.etreBlesse());
		guerrier.subirDegat(10);
		assertEquals("le guerrier est blesse",true,guerrier.etreBlesse());
	}

	/**
	 * test pour voir si le guerrier peut avoir un pv négatif
	 */

	public void test_pv_negatif(){
		Guerrier guerrier = new Guerrier("Toto",-2);
		assertEquals("le guerrier doit avoir 1 pv",1,guerrier.getPv());
	}

	/**
	 * test de la methode prendreArc
	 */

	public void test_prendreArc(){
		Guerrier guerrier = new Guerrier("Nano",10);
		Arc arc = new Arc(1,1);
		boolean resPrendre = guerrier.prendreArc(arc);
		assertEquals("le guerrier doit prendre l'arc",true,resPrendre);
		assertEquals("le guerrier doit avoir l'arc",arc,guerrier.getArc());
	}

	/**
	 * test prendreArc ayant deja un arc
	 */

public void test_prendreArc_deja_arc(){
		Guerrier guerrier = new Guerrier("Nano",10);
		Arc arc = new Arc(1,1);
		Arc arc2 = new Arc(1,1);
		guerrier.prendreArc(arc);
		boolean resPrendre = guerrier.prendreArc(arc2);
		assertEquals("le guerrier ne doit pas prendre l'arc",false,resPrendre);
		assertEquals("le guerrier doit avoir l'arc",arc,guerrier.getArc());
	}

	/**
	 * test prendreArc etre blesse
	 */

	public void test_prendreArc_etre_blesse(){
		Guerrier guerrier = new Guerrier("Nano",10);
		Arc arc = new Arc(1,1);
		guerrier.subirDegat(10);
		boolean resPrendre = guerrier.prendreArc(arc);
		assertEquals("le guerrier ne doit pas prendre l'arc",false,resPrendre);
		assertEquals("le guerrier ne doit pas avoir l'arc",null,guerrier.getArc());
	}

	/**
	 * test prendreArc arc sans parametre
	 */

	public void test_prendreArc_arc_null(){
		Guerrier guerrier = new Guerrier("Nano",10);
		boolean resPrendre = guerrier.prendreArc(null);
		assertEquals("le guerrier ne doit pas prendre l'arc",false,resPrendre);
		assertEquals("le guerrier ne doit pas avoir l'arc",null,guerrier.getArc());
	}

	/**
	 * test de la methode poserArc
	 */
	public void test_poserArc(){
		Guerrier guerrier = new Guerrier("Nano",10);
		Arc arc = new Arc(1,1);
		guerrier.prendreArc(arc);
		Arc resPoser = guerrier.poserArc();
		assertEquals("le guerrier doit poser l'arc",arc,resPoser);
		assertEquals("le guerrier ne doit pas avoir l'arc",null,guerrier.getArc());
	}

	/**
	 * test poser un arc sans arc
	 */
	public void test_poserArc_sans_arc(){
		Guerrier guerrier = new Guerrier("Nano",10);
		Arc resPoser = guerrier.poserArc();
		assertEquals("le guerrier ne doit pas poser l'arc",null,resPoser);
		assertEquals("le guerrier ne doit pas avoir l'arc",null,guerrier.getArc());
	}

	/**
	 * test de la methode toString avec arc
	 */

	public void test_tostring_avec_arc(){
		Guerrier guerrier = new Guerrier("Nano",10);
		Arc arc = new Arc(1,1);
		guerrier.prendreArc(arc);
		String res = guerrier.toString();
		assertEquals("le guerrier doit avoir l'arc",true,res.contains("arc"));
	}

	/**
	 * test de la methode toString sans arc
	 */

	public void test_tostring_sans_arc(){
		Guerrier guerrier = new Guerrier("Nano",10);
		String res = guerrier.toString();
		assertEquals("le guerrier ne doit pas avoir l'arc",false,res.contains("arc"));
	}


}
