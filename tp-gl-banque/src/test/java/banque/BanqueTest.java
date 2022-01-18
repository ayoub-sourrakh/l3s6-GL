package banque;

import org.junit.Test;

public class BanqueTest {

	@Test
	public void creationTest() {
		Banque banque = new Banque();
		assert (banque.getComptes() == null && banque.getComptesEpargne() == null);
	}

	@Test
	public void creationDeComptes() {
		Banque banque = new Banque();
		banque.createCompte();
		banque.createCompte();
		banque.createCompteEpargne();
		banque.createCompteEpargne();
		assert (banque.getComptes().size() == 2 && banque.getComptesEpargne().size() == 2);
	}

	@Test
	public void crediterDebiterCompte() {
		Banque banque = new Banque();
		banque.createCompte();
		banque.createCompte();
		banque.createCompteEpargne();
		banque.createCompteEpargne();
		banque.crediterCompte(0, 1000);
		banque.crediterCompteEpargne(0, 300);
		banque.getComptesEpargne().get(1).crediterCompte(1000);
		banque.debiterCompteEpargne(1, 500);
		banque.debiterCompte(1, 150);
		assert (banque.getComptes().get(0).getCredit() == 1000);
		assert (banque.getComptesEpargne().get(0).getCredit() == 300);
		assert (banque.getComptes().get(1).getCredit() == -150);
		assert (banque.getComptesEpargne().get(1).getCredit() == 500);
	}

	@Test(expected = IllegalArgumentException.class)
	public void indexNonExistantTest() {
		Banque banque = new Banque();
		for (int i = 0; i < 5; i++) {
			banque.createCompte();
		}
		banque.crediterCompte(6, 500);
	}
	
	@Test
	public void virementTest() {
		Banque banque = new Banque();
		banque.createCompte();
		banque.crediterCompte(0, 600);
		banque.createCompteEpargne();
		banque.crediterCompteEpargne(0, 150);
		banque.virement(banque.getComptes().get(0),banque.getComptesEpargne().get(0),200);
		assert(banque.getComptes().get(0).getCredit() == 400 && banque.getComptesEpargne().get(0).getCredit() == 350);
	}
}
