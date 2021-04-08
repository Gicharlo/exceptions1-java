package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room Number");
		int number = sc.nextInt();

		System.out.println("Check-in date: ");
		Date checkIn = format.parse(sc.next());

		System.out.println("Check-out date: ");
		Date checkOut = format.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");

		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation:" + reservation);
			
			System.out.println();
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date: ");
			checkIn = format.parse(sc.next());

			System.out.println("Check-out date: ");
			checkOut = format.parse(sc.next());
			
			Date now = new Date();
			
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			
			reservation.upgrateDates(checkIn, checkOut);
			System.out.println("Reservation:" + reservation);
		}

		sc.close();
	}

}
