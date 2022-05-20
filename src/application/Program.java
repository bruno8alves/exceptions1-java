package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner (System.in);

		try {

			System.out.print("Room number: ");
			int room = sc.nextInt();

			System.out.print("Check-in date (DD/MM/YYYY): ");
			Date checkin = sdf.parse(sc.next());

			System.out.print("Check-out date (DD/MM/YYYY): ");
			Date checkout = sdf.parse(sc.next());


			Reservation r = new Reservation(room, checkin, checkout);
			System.out.println("Reservation: "+r.toString());

			System.out.println();

			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());

			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkout = sdf.parse(sc.next());

			r.updateDates(checkin, checkout);
		} catch (ParseException e) {
			System.out.println("Invalid format date.");
		} catch (IllegalArgumentException e) {
			System.out.println("Error in reservation: "+ e.getMessage());
		}
		sc.close();
	}
}

