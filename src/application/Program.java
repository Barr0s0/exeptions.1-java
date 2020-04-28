package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Room number :");
			int n = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyy)");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("check-out date (dd/MM/yyyy)");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(n, checkIn, checkOut);
			System.out.println("Resevation" + reservation);
	
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.println("check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("check-out date(dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}	
		catch (ParseException e) {
			System.out.println("Invalid date formate");
		} 
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
			}
		
		sc.close();

	}

}
