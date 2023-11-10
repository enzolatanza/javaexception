package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		/*
		 *--> COMANDOS GIT
		 *--> 1) Criado um repositorio no github 
		 *--> 2) $git init
		 *--> 3) $git remote add origin git@github.com:enzolatanza/javaexception.git
		 *--> 4) $git pull origin main
		 * */
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		//Testando se a data de checkout é posterior a data de checkin
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: "+reservation);
			
			System.out.println();
			System.out.println("Enter data to update reservation: ");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			//verificando se as datas são posteriores a data atual
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else{
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: "+reservation);
			}
		}
		
		sc.close();
	}

}
