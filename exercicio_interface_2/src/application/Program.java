package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Quota;
import model.services.ContractService;
import model.services.PayPalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter the contract data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (DD/MM/YYYY): ");
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();

		Contract contract = new Contract(number, date, totalValue);

		System.out.print("Enter Installments quantity: ");
		int months = sc.nextInt();

		ContractService service = new ContractService(new PayPalService());

		service.processContract(contract, months);

		System.out.println("Installments:");

		for (Quota quotas : contract.getQuotas()) {
			System.out.println(quotas);
		}
		sc.close();
	}

}
