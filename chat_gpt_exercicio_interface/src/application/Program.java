package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.CreditCardService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter contract data:");

		System.out.print("Number: ");
		int number = sc.nextInt();

		System.out.print("Date (DD/MM/YYYY): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);

		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();

		System.out.print("Enter number of installment: ");
		int months = sc.nextInt();
		sc.nextLine();

		System.out.print("Payment service (paypal/credit card): ");
		String option = sc.nextLine();
		
		System.out.println("Installment:");

		if (option.equals("paypal")) {
			Contract contract1 = new Contract(number, date, totalValue, new PaypalService());
			contract1.processContract(months);
			
			for (Installment i : contract1.getList()) {
				System.out.println(i.getDueDate() + " - " + i.getAmount());
			}

		} else if (option.equals("credit card")) {
			Contract contract2 = new Contract(number, date, totalValue, new CreditCardService());
			contract2.processContract(months);

			for (Installment i : contract2.getList()) {
				System.out.println(i.getDueDate() + " - " + i.getAmount());
			}
		}

		sc.close();
	}

}
