package entitites;

public class Bussines extends TaxPayer {

	private Integer workersQnt;

	public Bussines(String name, Double anualIncome, Integer workersQnt) {
		super(name, anualIncome);
		this.workersQnt = workersQnt;
	}

	public Integer getWorkersQnt() {
		return workersQnt;
	}

	@Override
	public Double tax() {
		double tax = 0.0;
		if (workersQnt > 10) {
			tax = 0.14;
		} else {
			tax = 0.16;
		}
		return anualIncome * tax;
	}
}
