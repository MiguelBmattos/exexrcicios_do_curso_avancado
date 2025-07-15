package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.services.PaymentService;

public class Contract {

	private Integer number;
	private LocalDate date;
	private Double totalValue;
	private PaymentService paymentService;

	private List<Installment> list = new ArrayList<>();

	public Contract(Integer number, LocalDate date, Double totalValue, PaymentService paymentService) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
		this.paymentService = paymentService;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public List<Installment> getList() {
		return list;
	}

	public void processContract(int months) {
		Double installment = totalValue / months;

		for (int i = 1; i <= months; i++) {
			LocalDate dueDate = date.plusMonths(i);

			Double afterInterest = installment + paymentService.interest(installment, i);

			Double total = afterInterest + paymentService.paymentFee(afterInterest);

			list.add(new Installment(total, dueDate));
		}
	}
}
