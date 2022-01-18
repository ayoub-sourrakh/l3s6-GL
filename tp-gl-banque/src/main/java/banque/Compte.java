package banque;

import java.util.ArrayList;

public class Compte {
	private double credit;
	private double debit;
	private ArrayList<Double> releve = new ArrayList<>();

	public Compte() {
		this.credit = 0;
		this.debit = 0;
		for (int i = 0; i < 5; i++) {
			this.releve.add((double) 0);
		}
	}

	public Compte(double credit, double debit) {
		this.credit = credit;
		this.debit = debit;
	}

	public double getCredit() {
		return credit;
	}

	public double getDebit() {
		return debit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}

	public void crediterCompte(double i) throws IllegalArgumentException{
		if (i > 0 && i <= 100000) {
			this.setCredit(this.credit + i);
			this.ajoutOperationReleve(i);
		} else if (i < 0)
			throw new IllegalArgumentException("Vous ne pouvez pas créditer un montant négatif.");
		else if (i == 0)
			throw new IllegalArgumentException("Vous ne pouvez pas créditer un montant nul.");
		else if (i > 100000)
			throw new IllegalArgumentException("Les crédits de plus de 100.000 sont interdits, veuillez contacter votre conseiller.");
	}

	public void debiterCompte(double i) throws IllegalArgumentException {
		if (i > 0 && i <= 100000) {
			this.setCredit(this.credit - i);
			this.ajoutOperationReleve(-i);
		} else if (i < 0)
			throw new IllegalArgumentException("Vous ne pouvez pas débiter un montant négatif.");
		else if (i == 0)
			throw new IllegalArgumentException("Vous ne pouvez pas débiter un montant nul.");
		else if (i > 100000)
			throw new IllegalArgumentException("Les débits de plus de 100.000 sont interdits, veuillez contacter votre conseiller.");
	}

	public ArrayList<Double> getReleve() {
		return this.releve;
	}

	public double sommeOperationsReleve() {
		int i = 0;
		double somme = 0;
		for (i = 0; i < this.releve.size(); i++) {
			somme += this.releve.get(i);
		}
		return somme;
	}

	public void ajoutOperationReleve(double op) {
		for (int i = 0; i < 5; i++) {
			if (i != 4) {
				if (this.releve.get(i) == 0) {
					this.releve.set(i, op);
					break;
				}
			} else {
				if (this.releve.get(i) == 0) {
					this.releve.set(i, op);
					break;
				} else {
					this.releve.set(0, this.sommeOperationsReleve());
					for (i = 1; i < 5; i++) {
						this.releve.set(i, (double) 0);
					}
					this.releve.set(1, op);
					break;
				}
			}
		}

	}

}