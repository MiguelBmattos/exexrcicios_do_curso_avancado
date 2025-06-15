package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Student;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos alunos digitados? ");
		int n = sc.nextInt();
		Student[] aluno = new Student[n];

		for (int i = 0; i < aluno.length; i++) {
			int x = i + 1;
			System.out.printf("Digite nome, primeira e segunda nota do %do aluno\n", x);
			sc.nextLine();
			String name = sc.nextLine();
			double grade1 = sc.nextDouble();
			double grade2 = sc.nextDouble();
			aluno[i] = new Student(name, grade1, grade2);
		}

		System.out.println("Alunos aprovados:");
		for (int i = 0; i < aluno.length; i++) {
			double media = (aluno[i].getGrade1() + aluno[i].getGrade2()) / 2;
			if (media >= 6.0) {
				System.out.printf("%s\n", aluno[i].getName());
			}
		}

		sc.close();
	}

}
