package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Room number: ");
		int room = sc.nextInt();

		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkin = sdf.parse(sc.next());
		
		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date checkout = sdf.parse(sc.next());

		
		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out must be after check-in date.");
		} else {
			Reservation r = new Reservation(room, checkin, checkout);
			System.out.println("Reservation: "+r.toString());
			
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());
			
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
					
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be furture dates.");
			} else if (!checkout.after(checkin)) {
				System.out.println("Error in reservation: Check-out must be after check-in date.");
			} else {
				r.updateDates(checkin, checkout);
				System.out.println("Reservation: "+r.toString());
			}
		}
		
		
		sc.close();
	}

}
