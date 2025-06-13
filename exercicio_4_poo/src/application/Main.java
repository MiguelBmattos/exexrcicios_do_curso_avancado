package application;

import java.util.Locale;
import java.util.Scanner;

import util.CurrencyConverter;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("What is the dollar price? ");
		double precoDolar = sc.nextDouble();
		System.out.print("How many dollars will be bought? ");
		double dolarQnt = sc.nextDouble();

		double pay = CurrencyConverter.pay(precoDolar, dolarQnt);

		System.out.printf("Amount to be paid in reais = %.2f", pay);

		sc.close();
	}

}
