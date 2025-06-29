package entities;

public class Employee {

	private String name;
	protected Integer hours;
	protected Double valuePerHour;

	public Employee() {
	}

	public Employee(String name, Integer hours, Double valuePerHour) {
		this.name = name;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHours() {
		return hours;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Double payment() {
		return valuePerHour * hours;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " - $ ");
		sb.append(String.format("%.2f", payment()));
		return sb.toString();
	}
}
