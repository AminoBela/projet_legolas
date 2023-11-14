import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/******************
 * test classe Arc
 *******************/
public class TestArc {

	/**
	 * methode de lancement des tests
	 */

	public static void main(String[] args) {
		lancer(new TestArc(), args);
	}

	/**
	 * verifie que les méthodes sont bien appelée
	 */

	public void test_arc_methodes() {
		Arc arc = new Arc(3,5);
		assertEquals("ordre parametres est mauvais",3,arc.getDegats());
		assertEquals("ordre parametres est mauvais",5,arc.getFleches());

		arc.recharger(5);
		int dg = arc.utiliser();
		String s = arc.toString();
	}

	/**
	 * quand l'arc est recharge correctement
	 */
	
	public void test_recharger_OK() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.recharger(2);

		// verifications
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit avoir 7 fleches", 7, arc.getFleches());
	}

	/**
	 * quand l'arc est recharge avec un nombre de fleches negatif
	 */

	public void test_recharger_negatif() {
		Arc arc = new Arc(3,5);
		arc.recharger(-2);
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit toujours avoir 5 fleches", 5, arc.getFleches());
	}

	/**
	 * quand l'arc est utilise correctement
	 */

	public void test_utiliser() {
		Arc arc = new Arc(3,5);
		int dg = arc.utiliser();
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit toujours avoir 4 fleches", 4, arc.getFleches());
		assertEquals("degats retournes par utiliser", 3, dg);
	}

	/**
	 * quand l'arc est utilise sans fleches
	 */

	public void test_utiliser_sans_fleches() {
		Arc arc = new Arc(3,0);
		int dg = arc.utiliser();
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit toujours avoir 0 fleches", 0, arc.getFleches());
		assertEquals("degats retournes par utiliser", 0, dg);
	}

	/**
	 * quand l'arc est utilise avec un nombre de degats nul
	 */

	public void test_utiliser_sans_degat() {
		Arc arc = new Arc(0,5);
		int dg = arc.utiliser();
		assertEquals("arc doit toujours faire 0 degats", 0, arc.getDegats());
		assertEquals("arc doit toujours avoir 4 fleches", 4, arc.getFleches());
		assertEquals("degats retournes par utiliser", 0, dg);
	}

	/**
	 * test toString pour voir s'il retourne sous le bon format -arc(d:3,f:5)
	 */

		public void test_toString() {
			Arc arc = new Arc(3,5);
			String s = arc.toString();
			assertEquals("toString doit retourner -arc(d:3,f:5)","-arc(d:3,f:5)",s);
		}
}