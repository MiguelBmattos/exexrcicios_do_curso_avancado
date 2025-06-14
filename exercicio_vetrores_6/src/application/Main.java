package application;

import java.util.Scanner;

import entities.Person;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantas pessoas voce vai digitar? ");
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
			person[i] = new Person(name, age);
		}

		int maior = person[0].getAge();
		int p = 0;

		for (int i = 0; i < person.length; i++) {
			if (person[i].getAge() > maior) {
				maior = person[i].getAge();
				p = i;
			}
		}

		System.out.printf("PESSOA MAIS VELHA: %s", person[p].getName());

		sc.close();
	}

}
