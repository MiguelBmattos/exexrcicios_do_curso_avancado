package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BussinesExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Eter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Initial balance: ");
		Double initialDeposit = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		Account account = new Account(number, name, withdrawLimit);
		account.deposit(initialDeposit);

		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		Double amount = sc.nextDouble();

		try {
			account.withdraw(amount);
			System.out.printf("Novo saldo: %.2f", account.getBalance());
		} catch (BussinesExceptions e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		sc.close();
	}

}
