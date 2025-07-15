package model.services;

public class CreditCardService implements PaymentService {

	@Override
	public Double paymentFee(Double amount) {
		return amount * 0.015;
	}

	@Override
	public Double interest(Double amount, int months) {
		return amount * (0.02 * months);
	}

}
