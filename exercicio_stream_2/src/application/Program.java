package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Employees;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employees> list = new ArrayList<>();

		System.out.print("Enter the fiile path: ");
		String path = sc.next();

		System.out.print("Enter salary: ");
		double baseSalary = sc.nextDouble();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String lines = br.readLine();

			while (lines != null) {
				String[] field = lines.split(",");

				list.add(new Employees(field[0], field[1], Double.parseDouble(field[2])));

				lines = br.readLine();
			}

			List<String> moreThen = list.stream()
					.filter(e -> e.getSalary() > baseSalary)
					.map(Employees::getEmail)
					.sorted()
					.toList();

			System.out.println("Email  of people whose salary is more than " + String.format("%.2f", baseSalary));
			moreThen.forEach(System.out::println);

			double m = list.stream()
					.filter(e -> e.getName().charAt(0) == 'M')
					.mapToDouble(Employees::getSalary)
					.sum();

			System.out.println("Sum of people whose name starts with 'M': " + String.format("%.2f", m));

		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		sc.close();
	}

}
