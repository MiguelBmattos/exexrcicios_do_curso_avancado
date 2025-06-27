package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		File folder = new File("C:\\exercicio");
		folder.mkdir();

		File outFolder = new File("C:\\exercicio\\out");
		outFolder.mkdir();


		System.out.print("How many products you want to write down? ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + (i + 1) + " :");
			String str = sc.nextLine();
			String[] fields = str.split(", ");
			String name = fields[0].trim();
			double price = Double.parseDouble(fields[1].trim());
			int qnt = Integer.parseInt(fields[2].trim());

			list.add(new Product(name, price, qnt));
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\exercicio\\sourcefile.csv"))) {

			for (Product item : list) {
				bw.write(item.getName() + ", " + String.format("%.2f", item.getPrice()) + ", " + item.getQnt());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


		try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\exercicio\\out\\summary.csv"))) {

			for (Product item : list) {
				bw.write(item.getName() + ", " + String.format("%.2f", item.total()));
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		sc.close();
	}

}
