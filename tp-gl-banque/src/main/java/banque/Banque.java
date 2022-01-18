package banque;

import java.util.ArrayList;

public class Banque {
	private ArrayList<Compte> comptes;
	private ArrayList<CompteEpargne> comptesEpargne;

	public Banque() {
		this.comptes = null;
		this.comptesEpargne = null;
	}

	public ArrayList<Compte> getComptes() {
		return comptes;
	}

	public ArrayList<CompteEpargne> getComptesEpargne() {
		return comptesEpargne;
	}

	public void setComptes(ArrayList<Compte> comptes) {
		this.comptes = comptes;
	}

	public void setComptesEpargne(ArrayList<CompteEpargne> comptesEpargne) {
		this.comptesEpargne = comptesEpargne;
	}

	public void createCompte() {
		if (this.comptes == null) {
			this.comptes = new ArrayList<Compte>();
			this.comptes.add(new Compte());
		}

		else
			this.comptes.add(new Compte());
	}

	public void createCompteEpargne() {
		if (this.comptesEpargne == null) {
			this.comptesEpargne = new ArrayList<CompteEpargne>();
			this.comptesEpargne.add(new CompteEpargne());
		}

		else
			this.comptesEpargne.add(new CompteEpargne());
	}

	public void crediterCompte(int index, double montant) throws IllegalArgumentException {
		if (index < this.comptes.size()) {
			this.comptes.get(index).crediterCompte(montant);
		} else {
			throw new IllegalArgumentException("Numéro de compte indisponible.");
		}
	}

	public void crediterCompteEpargne(int index, double montant) throws IllegalArgumentException {
		if (index < this.comptes.size())
			this.comptesEpargne.get(index).crediterCompte(montant);
		else
			throw new IllegalArgumentException("Numéro de compte indisponible.");
	}

	public void debiterCompte(int index, double montant) throws IllegalArgumentException {
		if (index < this.comptes.size())
			this.comptes.get(index).debiterCompte(montant);
		else
			throw new IllegalArgumentException("Numéro de compte indisponible.");
	}

	public void debiterCompteEpargne(int index, double montant) throws IllegalArgumentException {
		if (index < this.comptes.size())
			this.comptesEpargne.get(index).debiterCompte(montant);
		else
			throw new IllegalArgumentException("Numéro de compte indisponible.");
	}

	public void virement(Compte compte, CompteEpargne compteEpargne, double montant) {
		// TODO Auto-generated method stub
		
	}

}
