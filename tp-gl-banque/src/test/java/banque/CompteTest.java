package banque;

import org.junit.Test;

public class CompteTest {

	@Test
	public void creationTest() {
		Compte compte = new Compte();
		assert (compte.getCredit() == 0 && compte.getDebit() == 0);
	}

	@Test
	public void crediterCompteTest() {
		Compte compte = new Compte();
		compte.setCredit(100);
		compte.crediterCompte(100);
		assert (compte.getCredit() == 200);
	}

	@Test
	public void debiterCompteTest() {
		Compte compte = new Compte();
		compte.setCredit(100);
		compte.debiterCompte(100);
		assert (compte.getCredit() == 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void crediterNegatifCompteTest() {
		Compte compte = new Compte();
		compte.setCredit(100);
		compte.crediterCompte(-100);
		assert (compte.getCredit() == 100);
	}

	@Test(expected = IllegalArgumentException.class)
	public void debiterNegatifCompteTest() {
		Compte compte = new Compte();
		compte.setCredit(100);
		compte.debiterCompte(-100);
		assert (compte.getCredit() == 100);
	}

	@Test
	public void soldeCompteTest() {
		Compte compte = new Compte();
		compte.setCredit(100);
		compte.crediterCompte(500);
		compte.crediterCompte(100);
		compte.debiterCompte(300);
		compte.crediterCompte(1000);
		compte.debiterCompte(3000);
		assert (compte.getCredit() == -1600);
	}

	@Test
	public void sommeOperationTest() {
		Compte compte = new Compte();
		compte.crediterCompte(500);
		compte.crediterCompte(100);
		compte.debiterCompte(300);
		compte.crediterCompte(1000);
		compte.debiterCompte(3000);
		assert (compte.sommeOperationsReleve() == -1700);
	}

	@Test
	public void releveCompteTest() {
		Compte compte = new Compte();
		compte.crediterCompte(500);
		compte.crediterCompte(100);
		compte.debiterCompte(300);
		compte.crediterCompte(1000);
		compte.debiterCompte(3000);
		compte.debiterCompte(100);
		compte.crediterCompte(1000);
		compte.debiterCompte(3000);
		compte.debiterCompte(100);
		compte.crediterCompte(100);
		assert (compte.getReleve().get(0) == -3900);
		assert (compte.getReleve().get(1) == 100);
	}

	@Test(expected = IllegalArgumentException.class)
	public void creditZeroExpectIllegalArgumentTest() {
		Compte compte = new Compte();
		compte.crediterCompte(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void debitZeroExpectIllegalArgumentTest() {
		Compte compte = new Compte();
		compte.debiterCompte(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void creditLimiteExpectIllegalArgumentTest() {
		Compte compte = new Compte();
		compte.crediterCompte(100001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void debitLimiteExpectIllegalArgumentTest() {
		Compte compte = new Compte();
		compte.debiterCompte(100001);
	}
}