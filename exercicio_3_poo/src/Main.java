import java.util.Locale;
import java.util.Scanner;

import entities.Student;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Student student = new Student();

		student.name = sc.nextLine();
		student.nota1 = sc.nextDouble();
		student.nota2 = sc.nextDouble();
		student.nota3 = sc.nextDouble();

		double soma = student.soma();
		String condition = student.coondition();
		double missing = student.missing();

		System.out.println("FINAL GRADE = " + soma);
		System.out.println(condition);
		if (missing == 0) {
			System.out.println();
		} else {
			System.out.println("MISSING " + missing + " POINTS");
		}

		sc.close();
	}

}
