package application;

import java.time.Instant;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import model.entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the file path: ");
		String path = sc.next();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Set<LogEntry> set = new HashSet<>();

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(" ");
				String name = fields[0];
				Instant moment = Instant.parse(fields[1]);

				set.add(new LogEntry(name, moment));

				line = br.readLine();
			}

			System.out.println("Total users: " + set.size());

		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		sc.close();
	}
}
