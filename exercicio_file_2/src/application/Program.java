package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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

		System.out.println("Enter the file path:");
		String pathFileSrc = sc.nextLine();

		File path = new File(pathFileSrc);
		String parentSrcPath = path.getParent();

		File outFolder = new File(parentSrcPath + "\\out");
		outFolder.mkdir();

		try (BufferedReader br = new BufferedReader(new FileReader(pathFileSrc))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0].trim();
				double price = Double.parseDouble(fields[1].trim());
				int qnt = Integer.parseInt(fields[2].trim());

				list.add(new Product(name, price, qnt));

				line = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFolder + "\\summary.csv"))) {

				for (Product item : list) {
					bw.write(item.getName() + ", " + item.total());
					bw.newLine();
				}
				System.out.println("...\\out\\summary.csv Created!");
			}

			catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}

		sc.close();
	}

}
