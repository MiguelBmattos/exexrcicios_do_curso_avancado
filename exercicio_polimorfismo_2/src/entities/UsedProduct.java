package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDate manufacturedDate;

	public UsedProduct(String name, Double price, LocalDate manufacturedDate) {
		super(name, price);
		this.manufacturedDate = manufacturedDate;
	}

	public LocalDate getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(LocalDate manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " (used) $ ");
		sb.append(String.format("%.2f", price) + " ");
		sb.append("(Manufacture date: " + fmt.format(manufacturedDate) + ")");
		return sb.toString();
	}
}
