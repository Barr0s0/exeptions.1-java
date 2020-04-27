package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number :");
		int n = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("check-out date (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: check-out date must be after check-In date");
		}
		else {
			Reservation reservation = new Reservation(n, checkIn, checkOut);
			System.out.println("Resevation" + reservation);
			
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.println("check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("check-out date(dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation : Reservation dates for update must be future dates");
			}else if (!checkOut.after(checkIn)) {
				System.out.println("Error in resevation: check-out date must be after chec-in date");
			}
			
		}
		
		sc.close();

	}

}
