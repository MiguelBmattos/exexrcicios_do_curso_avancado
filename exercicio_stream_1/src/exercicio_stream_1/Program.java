package exercicio_stream_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Products;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Products> list = new ArrayList<>();

		System.out.print("Enter the full file path: ");
		String path = sc.next();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String lines = br.readLine();
			while (lines != null) {
				String[] fields = lines.split(",");
				String name = fields[0].trim();
				Double price = Double.parseDouble(fields[1].trim());

				list.add(new Products(name, price));

				lines = br.readLine();
			}

			double avg = list.stream().mapToDouble(Products::getPrice).sum() / list.size();

			System.out.printf("Average price: %.2f\n", avg);

			List<String> lessThenAvg = list.stream().filter(p -> p.getPrice() < avg)
					.sorted(Comparator.comparing((Products p) -> p.getName().toLowerCase()).reversed())
					.map(Products::getName).toList();

			lessThenAvg.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		sc.close();
	}

}
