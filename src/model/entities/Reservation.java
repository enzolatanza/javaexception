package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if(!checkOut.after(checkIn)) {
			throw new DomainException( "Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	//diferença entre duas datas retorna um valor tipo long
	public long duration() {
		//diferença em millisegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		//convertendo o valor em millisegundos em dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	//throws DomainException propaga a exceção sendo assim o metodo main deve possuir os try e catch
	public void updateDates(Date checkIn, Date checkOut) throws DomainException{
		//verificando se as datas são posteriores a data atual
		//Caso ocorra algum erro será lançado uma exceção
		Date now = new Date();
		//DomainException é uma exceção personalizada 
		if(checkIn.before(now) || checkOut.before(now)) {
			//throw lança uma exceção
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException( "Check-out date must be after check-in date");
		}
	}
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
}
