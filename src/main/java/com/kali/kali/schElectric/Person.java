package com.kali.kali.schElectric;

import com.kali.schElectric.Reservation;

public class Person implements Runnable{
	private String name;
	private int age;
	private int howmanySeats;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHowmanySeats() {
		return howmanySeats;
	}
	public void setHowmanySeats(int howmanySeats) {
		this.howmanySeats = howmanySeats;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	Reservation reservation;
	public Person(Reservation reservation){
		this.reservation = reservation;
	}
	@Override
	public void run() {
		if(howmanySeats<=this.reservation.noOfSeatsInRow){
			reservation.bookTickets(howmanySeats, name);
		}
//		showTickets();
	}
	/*public void showTickets(){
		System.out.println(Reservation.PersonsRowsAndSeats);
	}*/
	
}
