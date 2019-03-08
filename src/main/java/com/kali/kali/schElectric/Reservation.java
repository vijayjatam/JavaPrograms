package com.kali.kali.schElectric;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Reservation {
	int totalSeatsInBoghi = 25;
	int noOfSeatsInRow = 5;
	boolean threadsFollowFlag = false;
	int totalVacantSeats = 25;
	int howManyOneLogin = noOfSeatsInRow;

	static Map<String, Map<Integer, List<Integer>>> PersonsRowsAndSeats = new ConcurrentHashMap<String, Map<Integer, List<Integer>>>();
	static Map<Integer, List<Integer>> rowsAndSeats = new HashMap<Integer, List<Integer>>();
	static Map<Integer, List<Integer>> rowsAndVacateSeats = new HashMap<Integer, List<Integer>>();

	public Reservation() {
		int seat = 1;
		for (int row = 1; row <= (totalSeatsInBoghi / noOfSeatsInRow); row++) {
			List<Integer> seats_In_A_Row = new ArrayList<>();
			for (; seat <= (noOfSeatsInRow*row); seat++) {
				seats_In_A_Row.add(seat);
			}
			rowsAndSeats.put(row, seats_In_A_Row);
		}
		updateRowsOnVacantSeat();
	}

	public static void main(String[] args) {
		
		  /*System.out.println(rowsAndSeats);
		  System.out.println(rowsAndVacateSeats);*/
		
		// System.out.println(rowsAndVacateSeats);
		/*rowAndSeats =reservation.bookTickets(3,"Mahan");
		PersonsRowsAndSeats.put("Mahan", rowAndSeats);
		System.out.println("Vacant Seats: "+reservation.totalVacantSeats);
		System.out.println(PersonsRowsAndSeats);
		
		rowAndSeats =reservation.bookTickets(4,"bottel");
		PersonsRowsAndSeats.put("bottel", rowAndSeats);
		System.out.println("Vacant Seats: "+reservation.totalVacantSeats);
		System.out.println(PersonsRowsAndSeats);
		 
		rowAndSeats =reservation.bookTickets(4,"cup");
		PersonsRowsAndSeats.put("cup", rowAndSeats);
		System.out.println("Vacant Seats: "+reservation.totalVacantSeats);
		System.out.println(PersonsRowsAndSeats);
		 
		rowAndSeats =reservation.bookTickets(3, "pen");
		PersonsRowsAndSeats.put("pen", rowAndSeats);
		System.out.println("Vacant Seats: "+reservation.totalVacantSeats);
		System.out.println(PersonsRowsAndSeats);
		
		rowAndSeats =reservation.bookTickets(3, "hello");
		PersonsRowsAndSeats.put("hello", rowAndSeats);
		System.out.println("Vacant Seats: "+reservation.totalVacantSeats);
		System.out.println(PersonsRowsAndSeats);
		 
		rowAndSeats =reservation.bookTickets(4, "Mahankali");
		PersonsRowsAndSeats.put("MahanKali", rowAndSeats);
		System.out.println("Vacant Seats: "+reservation.totalVacantSeats);
		System.out.println(PersonsRowsAndSeats);*/
		
		System.out.println(rowsAndSeats);
		System.out.println(rowsAndVacateSeats);
		System.out.println(PersonsRowsAndSeats);
	}

	private void updateRowsOnVacantSeat() {
		for (int vacantSeatCount = 1; vacantSeatCount <= noOfSeatsInRow; vacantSeatCount++) {
			List<Integer> tempList = new ArrayList<Integer>();
			for (Map.Entry<Integer, List<Integer>> entryMap : rowsAndSeats.entrySet()) {
				if (entryMap.getValue().size() == vacantSeatCount) {
					tempList.add(entryMap.getKey());
				}
			}
			rowsAndVacateSeats.put(vacantSeatCount, tempList);
		}
		
	}

	public synchronized void bookTickets(int neededSeats,String name) {
		if(totalVacantSeats>=neededSeats && howManyOneLogin>=neededSeats){
//			PersonsRowsAndSeats.put(name, updateTickets(neededSeats));
			System.out.println(name+" --> "+updateTickets(neededSeats));
		}
		else{
			System.out.println(name + ", need "+ neededSeats+" but Only "+totalVacantSeats+" ticket(s) available....!");
		}
		notify();
		try {
			wait(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private Map<Integer,List<Integer>> updateTickets(int neededSeats){
		Map<Integer,List<Integer>> rowAndSeats = new HashMap<>();
		List<Integer> seats = new ArrayList<>();
		ArrayList<Integer> listOfRowsWhoHasVacantSeats = (ArrayList<Integer>) rowsAndVacateSeats.get(neededSeats);
		int count = neededSeats;
		while ((listOfRowsWhoHasVacantSeats != null && listOfRowsWhoHasVacantSeats.size() <= 0)
				|| listOfRowsWhoHasVacantSeats == null) {
			if (count >= noOfSeatsInRow) {
				break;
			} else if ((count + 1) <= noOfSeatsInRow) {
				listOfRowsWhoHasVacantSeats = (ArrayList<Integer>) rowsAndVacateSeats.get((count + 1));
			}
			count++;
		}
		if (listOfRowsWhoHasVacantSeats != null && listOfRowsWhoHasVacantSeats.size() > 0) {
			List<Integer> seatsInThisRow = rowsAndSeats.get(listOfRowsWhoHasVacantSeats.get(0));
			totalVacantSeats =  (totalVacantSeats-neededSeats);
			count = neededSeats;
			Iterator<Integer> iterator = seatsInThisRow.iterator();
			while (iterator.hasNext()) {
				Integer intr = iterator.next();
				if (count != 0) {
					iterator.remove();
				} else {
					break;
				}
				seats.add(intr);
				count--;
			}
			rowsAndSeats.put(listOfRowsWhoHasVacantSeats.get(0), seatsInThisRow);
			updateRowsOnVacantSeat();
			rowAndSeats.put(listOfRowsWhoHasVacantSeats.get(0), seats);
		}
		else{
			rowAndSeats = adjustTheSeats(neededSeats);
		}
		return rowAndSeats;
	}
	private Map<Integer,List<Integer>> adjustTheSeats(int neededSeats){
		Map<Integer,List<Integer>> rowAndSeats = new HashMap<>();
		
		ArrayList<Integer> listOfRowsWhoHasVacantSeats =null;
		int count =0;
		totalVacantSeats =  (totalVacantSeats-neededSeats);
		while(neededSeats!=0){
			List<Integer> seats = new ArrayList<>();
			listOfRowsWhoHasVacantSeats = (ArrayList<Integer>) rowsAndVacateSeats.get(neededSeats);
			count = neededSeats;
			while ((listOfRowsWhoHasVacantSeats != null && listOfRowsWhoHasVacantSeats.size() <= 0)
					|| listOfRowsWhoHasVacantSeats == null) {
				if (count == 1) {
					break;
				} else if ((count - 1) >= 1) {
					listOfRowsWhoHasVacantSeats = (ArrayList<Integer>) rowsAndVacateSeats.get((count - 1));
				}
				count--;
			}
			List<Integer> seatsInThisRow = rowsAndSeats.get(listOfRowsWhoHasVacantSeats.get(0));
			neededSeats = (neededSeats-count);
			Iterator<Integer> iterator = seatsInThisRow.iterator();
			while (iterator.hasNext()) {
				Integer intr = iterator.next();
				if (count != 0) {
					iterator.remove();
				} else {
					break;
				}
				seats.add(intr);
				count--;
			}
			rowsAndSeats.put(listOfRowsWhoHasVacantSeats.get(0), seatsInThisRow);
			updateRowsOnVacantSeat();
			rowAndSeats.put(listOfRowsWhoHasVacantSeats.get(0), seats);
		}
		return rowAndSeats;
	}
	private Map<Integer,List<Integer>> updateTickets(int neededSeats, int incrOrDecr){

		Map<Integer,List<Integer>> rowAndSeats = new HashMap<>();
		ArrayList<Integer> listOfRowsWhoHasVacantSeats =null;
		int count =0;
		totalVacantSeats =  (totalVacantSeats-neededSeats);
		while(neededSeats!=0){
			List<Integer> seats = new ArrayList<>();
			listOfRowsWhoHasVacantSeats = (ArrayList<Integer>) rowsAndVacateSeats.get(neededSeats);
			count = neededSeats;
			while ((listOfRowsWhoHasVacantSeats != null && listOfRowsWhoHasVacantSeats.size() <= 0)
					|| listOfRowsWhoHasVacantSeats == null) {
				if (count == 1) {
					break;
				} else if ((count + incrOrDecr) >= 1) {
					listOfRowsWhoHasVacantSeats = (ArrayList<Integer>) rowsAndVacateSeats.get((count + incrOrDecr));
				}
				count = count + incrOrDecr;
			}
			List<Integer> seatsInThisRow = rowsAndSeats.get(listOfRowsWhoHasVacantSeats.get(0));
			neededSeats = (neededSeats-count);
			Iterator<Integer> iterator = seatsInThisRow.iterator();
			while (iterator.hasNext()) {
				Integer intr = iterator.next();
				if (count != 0) {
					iterator.remove();
				} else {
					break;
				}
				seats.add(intr);
				count--;
			}
			rowsAndSeats.put(listOfRowsWhoHasVacantSeats.get(0), seatsInThisRow);
			updateRowsOnVacantSeat();
			rowAndSeats.put(listOfRowsWhoHasVacantSeats.get(0), seats);
		}
		return rowAndSeats;
	
	}
}
