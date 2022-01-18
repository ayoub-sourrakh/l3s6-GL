package banque;

import org.junit.Test;

public class CompteEpargneTest {

	@Test
	public void creationTest() {
		CompteEpargne compteEpargne = new CompteEpargne();
		assert (compteEpargne.getCredit() == 0 && compteEpargne.getDebit() == 0);
	}

	@Test
	public void crediterCompteEpargneTest() {
		CompteEpargne compteEpargne = new CompteEpargne();
		compteEpargne.setCredit(100);
		compteEpargne.crediterCompte(100);
		assert (compteEpargne.getCredit() == 200);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void debiterCompteEpargneTest() {
		CompteEpargne compteEpargne = new CompteEpargne();
		compteEpargne.setCredit(100);
		compteEpargne.debiterCompte(101);
	}
		
	

}
