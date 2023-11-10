package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		/*
		 *--> COMANDOS GIT
		 *--> 1) Criado um repositorio no github 
		 *--> 2) $git init
		 *--> 3) $git remote add origin git@github.com:enzolatanza/javaexception.git
		 *--> 4) $git pull origin main
		 * */

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {			
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: "+reservation);
			
			System.out.println();
			System.out.println("Enter data to update reservation: ");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			reservation.updateDates(checkIn, checkOut);
			
			System.out.println("Reservation: "+reservation);
		}
		//PArseException caso a entrada nao seja compativo com o formado tada
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		//bloco catch capturando a exceção
		catch(DomainException e) {
			//getMessage() -> é a mensagem lançada na throws
			System.out.println("Error in reservation: "+e.getMessage());
		}
		//qualquer outra exceção inesperada
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
