package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			sc.nextLine();
			LocalDate checkin = LocalDate.parse(sc.nextLine(), fmt);
			System.out.print("Check-out date (DD/MM/YYYY): ");
			LocalDate checkout = LocalDate.parse(sc.nextLine(), fmt);
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);

			System.out.println(reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkin = LocalDate.parse(sc.nextLine(), fmt);
			System.out.print("Check-out date (DD//MM/YYYY): ");
			checkout = LocalDate.parse(sc.nextLine(), fmt);

			reservation.updateDates(checkin, checkout);
			System.out.println(reservation);
		}

		catch (DateTimeParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}

		sc.close();
	}

}
