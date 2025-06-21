package entitites;

public class Person extends TaxPayer {

	private Double healthExpenses;

	public Person(String name, Double anualIncome, Double healthExpenses) {
		super(name, anualIncome);
		this.healthExpenses = healthExpenses;
	}

	public Double getHealthExpenses() {
		return healthExpenses;
	}

	@Override
	public Double tax() {
		double tax = 0.0;
		if (anualIncome < 20000.00) {
			tax = 0.15;
		} else {
			tax = 0.25;
		}
		return (anualIncome * tax) - (healthExpenses * 0.5);
	}
}
