package application;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos numeros voce vai digitar? ");
		int n = sc.nextInt();
		double[] num = new double[n];

		for (int i = 0; i < num.length; i++) {
			System.out.print("Digite um numero: ");
			num[i] = sc.nextDouble();
		}

		double maior = num[0];
		int posicao = 0;

		for (int i = 0; i < num.length; i++) {
			if (num[i] > maior) {
				maior = num[i];
				posicao = i;
			}
		}

		System.out.println();
		System.out.printf("MAIOR VALOR = %.1f\n", maior);
		System.out.print("POSICAO DO MAIOR VALOR = " + posicao);

		sc.close();
	}

}
