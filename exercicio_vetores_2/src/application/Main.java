package application;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos numeros voce vai digitar? ");
		int n = sc.nextInt();
		double[] vet = new double[n];
		double soma =0;
		
		for(int i=0; i<vet.length; i++) {
			System.out.print("Digite um numero: ");
			vet[i] = sc.nextInt();
			soma += vet[i];
		}
		
		System.out.println();
		System.out.print("VALORES = ");
		
		for(int i=0; i<vet.length; i++) {
			System.out.printf("%.1f ",vet[i]);
		}
		
		System.out.println();
		double avg = soma/vet.length;
		System.out.printf("SOMA = %.2f\n", soma);
		System.out.printf("MEDIA = %.2f", avg);
		
		sc.close();
	}

}
