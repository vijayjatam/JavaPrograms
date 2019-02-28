package com.kali.schElectric;

public class MainClass {
	public static void main(String[] args) {
		Reservation reservation = new Reservation();

		Person person_1 = new Person(reservation);
		person_1.setName("kali");
		person_1.setAge(22);
		person_1.setHowmanySeats(5);
		Thread thread_1 = new Thread(person_1);

		Person person_2 = new Person(reservation);
		person_2.setName("Mahan");
		person_2.setAge(23);
		person_2.setHowmanySeats(4);
		Thread thread_2 = new Thread(person_2);

		Person person_3 = new Person(reservation);
		person_3.setName("Mahankali");
		person_3.setAge(24);
		person_3.setHowmanySeats(3);
		Thread thread_3 = new Thread(person_3);

		Person person_4 = new Person(reservation);
		person_4.setName("Venky");
		person_4.setAge(24);
		person_4.setHowmanySeats(3);
		Thread thread_4 = new Thread(person_4);

		Person person_5 = new Person(reservation);
		person_5.setName("Sowjanya");
		person_5.setAge(24);
		person_5.setHowmanySeats(3);
		Thread thread_5 = new Thread(person_5);

		Person person_6 = new Person(reservation);
		person_6.setName("Thottigadu");
		person_6.setAge(24);
		person_6.setHowmanySeats(4);
		Thread thread_6 = new Thread(person_6);

		Person person_7 = new Person(reservation);
		person_7.setName("person_7");
		person_7.setAge(24);
		person_7.setHowmanySeats(3);
		Thread thread_7 = new Thread(person_7);

		Person person_8 = new Person(reservation);
		person_8.setName("person_8");
		person_8.setAge(24);
		person_8.setHowmanySeats(4);
		Thread thread_8 = new Thread(person_8);

		thread_1.start();
		thread_2.start();
		thread_3.start();
		thread_4.start();
		thread_5.start();
		thread_6.start();
		thread_7.start();
		thread_8.start();
	}
}
