package application;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		LocalDate birthDate = LocalDate.parse(sc.nextLine(), fmt);
		Client client = new Client(name, email, birthDate);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		LocalDateTime date = LocalDateTime.now();
		Order order = new Order(date, status, client);

		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String itemName = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			Product product = new Product(itemName, price);

			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			OrderItem orderItem = new OrderItem(quantity, price, product);
			order.addItem(orderItem);
		}

		System.out.println("ORDER SUMMARY:");
		System.out.println(order);

		sc.close();
	}

}
