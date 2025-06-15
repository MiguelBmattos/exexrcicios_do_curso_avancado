package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Person;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantas pessoas serao digitadas? ");
		int n = sc.nextInt();
		sc.nextLine();
		Person[] person = new Person[n];

		for (int i = 0; i < person.length; i++) {
			int x = i + 1;
			System.out.printf("Altura da %da pessoa: ", x);
			double height = sc.nextDouble();
			System.out.printf("Genero da %da pessoa: ", x);
			char gender = sc.next().charAt(0);
			person[i] = new Person(height, gender);
		}

		double menor = person[0].getHeight();
		double maior = person[0].getHeight();

		for (int i = 0; i < person.length; i++) {
			if (person[i].getHeight() > maior) {
				maior = person[i].getHeight();
			} else if (person[i].getHeight() < menor) {
				menor = person[i].getHeight();
			}
		}

		System.out.printf("Menor altura = %.2f\n", menor);
		System.out.printf("Maior altura = %.2f\n", maior);

		int qntM = 0;
		int qntF = 0;
		double mediaF = 0;

		for (int i = 0; i < person.length; i++) {
			if (person[i].getGender() == 'f') {
				mediaF += person[i].getHeight();
				qntF += 1;
			} else if (person[i].getGender() == 'm') {
				qntM += 1;
			}
		}

		mediaF /= qntF;

		System.out.printf("Media das alturas das mulheres = %.2f\n", mediaF);
		System.out.printf("Numero de homens = %d", qntM);

		sc.close();
	}

}
