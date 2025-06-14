package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos numeros voce vai digitar? ");
		int n = sc.nextInt();
		int[] numero = new int[n];

		for (int i = 0; i < numero.length; i++) {
			System.out.print("Digite um numero: ");
			numero[i] = sc.nextInt();
		}

		System.out.println();
		int qnt = 0;
		System.out.println("NUMEROS PARES:");
		for (int i = 0; i < numero.length; i++) {
			if (numero[i] % 2 == 0) {
				System.out.printf("%d ", numero[i]);
				qnt += 1;
			}
		}

		System.out.println();
		System.out.printf("\nQUANTIDADE DE PARES = %d", qnt);

		sc.close();
	}

}
