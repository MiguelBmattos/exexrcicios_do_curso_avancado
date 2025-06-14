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
		Person[] person = new Person[n];

		for (int i = 0; i < person.length; i++) {
			int x = i + 1;
			sc.nextLine();
			System.out.printf("Dados da %da pessoa:\n", x);
			System.out.print("Nome: ");
			String name = sc.nextLine();
			System.out.print("Idade: ");
			int age = sc.nextInt();
			System.out.print("Altura: ");
			double height = sc.nextDouble();
			person[i] = new Person(name, age, height);
		}

		double sum = 0;
		for (int i = 0; i < person.length; i++) {
			sum += person[i].getHeight();
		}

		double avg = sum / person.length;
		System.out.printf("Altura media: %.2f", avg);
		System.out.println();

		int qnt = 0;

		for (int i = 0; i < person.length; i++) {
			if (person[i].getAge() < 16) {
				qnt += 1;
			}
		}

		double percentage = (qnt * 100) / person.length;
		System.out.printf("Pessoas com menos de 16 anos: %.1f%%", percentage);
		System.out.println();

		for (int i = 0; i < person.length; i++) {
			if (person[i].getAge() < 16) {
				System.out.println(person[i].getName());
			}
		}

		sc.close();
	}

}
