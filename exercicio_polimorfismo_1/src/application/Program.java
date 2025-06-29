package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutSourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> employee = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("OutSourced (y/n)? ");
			char option = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			if (option == 'y') {
				System.out.print("Additional Charge: ");
				double additionalCharge = sc.nextDouble();
				employee.add(new OutSourcedEmployee(name, hours, valuePerHour, additionalCharge));
			} else {
				employee.add(new Employee(name, hours, valuePerHour));
			}
		}

		System.out.println();
		System.out.println("PAYMENTS:");
		for (Employee e : employee) {
			System.out.println(e);
		}

		sc.close();
	}

}
