package application;

import java.util.Scanner;

import entities.Rent;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt();
		Rent[] aps = new Rent[10];

		for (int i = 0; i < n; i++) {
			System.out.println("Rent #" + (i + 1) + ":");
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Room: ");
			int room = sc.nextInt();
			aps[room] = new Rent(name, email, room);
		}

		System.out.println();
		System.out.println("Busy rooms:");
		for (int i = 0; i < aps.length; i++) {
			if (aps[i] != null) {
				System.out.println(aps[i]);
			}
		}

		sc.close();
	}

}
