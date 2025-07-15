package model.services;

import java.time.LocalDate;
import model.entities.Contract;
import model.entities.Quota;

public class ContractService {

	private OnlinePaymentService paymentService;

	public ContractService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void processContract(Contract contract, Integer months) {

		double quota = contract.getTotalValue() / months;

		for (int i = 1; i <= months; i++) {
			
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double quotaAfterInterest = quota + (paymentService.interest(quota, i));
			
			double finalQuotaValue = quotaAfterInterest + (paymentService.paymentFee(quotaAfterInterest));
			
			contract.getQuotas().add(new Quota(dueDate, finalQuotaValue)); 
		}
	}
}
