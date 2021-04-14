package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.println("Room Number");
		int number = sc.nextInt();

		System.out.println("Check-in date: ");
		Date checkIn = format.parse(sc.next());

		System.out.println("Check-out date: ");
		Date checkOut = format.parse(sc.next());

		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reservation:" + reservation);

	
		System.out.println();
		System.out.println("Enter data to update the reservation:");
		System.out.println("Check-in date: ");
		checkIn = format.parse(sc.next());

		System.out.println("Check-out date: ");
		checkOut = format.parse(sc.next());

		reservation.upgrateDates(checkIn, checkOut);
		
		System.out.println("Reservation:" + reservation);
		}
		
		catch(ParseException e){
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();
	}

}
