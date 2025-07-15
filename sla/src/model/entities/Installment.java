package model.entities;

import java.time.LocalDate;

public class Installment {

	private Double amount;
	private LocalDate dueDate;

	public Installment(Double amount, LocalDate dueDate) {
		this.amount = amount;
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

}
