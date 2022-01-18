package banque;

public class CompteEpargne {
	private double credit;
	private double debit;

	public CompteEpargne() {
		this.credit = 0;
		this.debit = 0;
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

	public void crediterCompte(double i) {
		this.setCredit(this.credit + i);
	}

	public void debiterCompte(double i) throws IllegalArgumentException {
		if (i < this.credit) {
			this.setDebit(this.debit + i);
			this.setCredit(this.credit - i);
		} else
			throw new IllegalArgumentException("Pas assez de crédits disponible");

	}
}
