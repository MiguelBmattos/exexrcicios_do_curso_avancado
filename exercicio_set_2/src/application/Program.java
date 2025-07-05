package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Set<Integer> set = new HashSet<>();

		System.out.print("How many students for course A? ");
		int qnt = sc.nextInt();
		for (int i = 1; i <= qnt; i++) {
			int id = sc.nextInt();
			set.add(id);
		}

		System.out.print("How many students for course B? ");
		qnt = sc.nextInt();
		for (int i = 1; i <= qnt; i++) {
			int id = sc.nextInt();
			set.add(id);
		}

		System.out.print("How many students for course A? ");
		qnt = sc.nextInt();
		for (int i = 1; i <= qnt; i++) {
			int id = sc.nextInt();
			set.add(id);
		}

		System.out.println("Total students: " + set.size());

		sc.close();
	}

}
