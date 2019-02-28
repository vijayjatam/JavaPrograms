package com.kali;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author mahan.k.palavelli
 *
 */
public class HanoiTime {
	
	public static void main(String[] args) {
		System.out.println("Enter disk size");
		Scanner scan = new Scanner(System.in);
		int DISK_SIZE = scan.nextInt();
		findHanoiTime(DISK_SIZE, new BigInteger("933262154439441526816992388562667004907159682643816214685929638952175999932299156089414639761565182862536979208272237582511852109168640"));
	}
		public static void findHanoiTime(int DISK_SIZE, BigInteger numberOfChanges) {
		byte[] input = {0};
		BigInteger BIG_MILLISEC = new BigInteger(input);
		BigInteger BIG_SECOND = new BigInteger(new byte[]{2});
		BigInteger BIG_MINUTE = new BigInteger(input);
		BigInteger BIG_HOUR = new BigInteger(input);
		BigInteger BIG_DAY = new BigInteger(input);
		BigInteger BIG_MONTH = new BigInteger(input);
		BigInteger BIG_YEAR = new BigInteger(input);
		
		if(DISK_SIZE != 0) {
			BIG_SECOND = BIG_SECOND.pow(DISK_SIZE);
			BIG_SECOND = BIG_SECOND.subtract(BigInteger.valueOf(1));
		}
		else {
			BIG_SECOND = numberOfChanges.divideAndRemainder(BigInteger.valueOf(1000))[0];
			BIG_MILLISEC = numberOfChanges.divideAndRemainder(BigInteger.valueOf(1000))[1];
		}
		System.out.println("No.of Disk chages: "+BIG_SECOND);
		
		StringBuilder stBuilder =new StringBuilder("Length of changes: "+BIG_SECOND.toString().length()+" and years size: ");
		
		if(BIG_SECOND.compareTo(BigInteger.valueOf(59)) == 1) {
			BigInteger[] divAndReminder = BIG_SECOND.divideAndRemainder(BigInteger.valueOf(60));
			BIG_MINUTE = divAndReminder[0];
			BIG_SECOND = divAndReminder[1];
			if(BIG_MINUTE.compareTo(BigInteger.valueOf(59)) == 1) {
				divAndReminder = BIG_MINUTE.divideAndRemainder(BigInteger.valueOf(60));
				BIG_HOUR = divAndReminder[0];
				BIG_MINUTE = divAndReminder[1];
				if(BIG_HOUR.compareTo(BigInteger.valueOf(23)) == 1) {
					divAndReminder = BIG_HOUR.divideAndRemainder(BigInteger.valueOf(24));
					BIG_DAY = divAndReminder[0];
					BIG_HOUR = divAndReminder[1];
					if(BIG_DAY.compareTo(BigInteger.valueOf(29)) == 1) { // For Average
						divAndReminder = BIG_DAY.divideAndRemainder(BigInteger.valueOf(30));
						BIG_MONTH = divAndReminder[0];
						BIG_DAY = divAndReminder[1];
						if(BIG_MONTH.compareTo(BigInteger.valueOf(11)) == 1) {
							divAndReminder = BIG_MONTH.divideAndRemainder(BigInteger.valueOf(12));
							BIG_YEAR = divAndReminder[0];
							BIG_MONTH = divAndReminder[1];
						}
					}
				}
			}
		}
		
		System.out.println("\n Time to complete "+DISK_SIZE+" Disks, \n\n"+BIG_YEAR+" YEARS, "+BIG_MONTH+" MONTHS, "+BIG_DAY+" DAYS, "+BIG_HOUR+" HOURS, "+BIG_MINUTE+" MINUTES, "+BIG_SECOND+" SECONDS, "+BIG_MILLISEC+" MILLI SECONDS");
		
		System.out.println(stBuilder.append(BIG_YEAR.toString().length()));
		
		
		/*long SECOND = 1, MINUTE = 0, HOUR = 0, DAY = 0, MONTH = 0, YEAR = 0;
		for(int i= 1; i<= DISK_SIZE; i++) {
			SECOND = SECOND*2;
			BIG_SECOND = BIG_SECOND.multiply(BigInteger.valueOf(2));
		}*/
		/*SECOND = SECOND -1;
		
  		System.out.println("Total Chages: "+SECOND);
  		if(SECOND>=60) {
			MINUTE = SECOND/60;
			SECOND = SECOND%60;
			if(MINUTE>=60) {
				HOUR = MINUTE/60;
				MINUTE = MINUTE%60;
				if(HOUR>=24) {
					DAY = HOUR/24;
					HOUR = HOUR%24;
					if(DAY>=30) { // For Average
						MONTH = DAY/30;
						DAY = DAY%30;
						if(MONTH>=12) {
							YEAR = MONTH/12;
							MONTH = MONTH%12;
						}
					}
				}
			}
		}
		
		System.out.println(YEAR+" year, "+MONTH+" month, "+DAY+" day, "+HOUR+" hour, "+MINUTE+" minute, "+SECOND+" second");*/
		
		
		/*long longVal = BIG_SECOND.longValue();
	    int hours = (int) longVal / 3600;
	    int remainder = (int) longVal - hours * 3600;
	    int mins = remainder / 60;
	    remainder = remainder - mins * 60;
	    int secs = remainder;

	    System.out.println(hours+","+mins+","+secs);*/
	}
	public void findDurationB_WDates(java.util.Date startDate, java.util.Date endDate) {
			/*Map<Integer, Integer> daysInMonth = new LinkedHashMap<Integer, Integer>();
			daysInMonth.put(1, 31);
			daysInMonth.put(2, 28);
			daysInMonth.put(3, 31);
			daysInMonth.put(4, 30);
			daysInMonth.put(5, 31);
			daysInMonth.put(6, 30);
			daysInMonth.put(7, 31);
			daysInMonth.put(8, 31);
			daysInMonth.put(9, 30);
			daysInMonth.put(10, 31);
			daysInMonth.put(11, 30);
			daysInMonth.put(12, 31);
			long startYear, endYear,startMonth,endMonth,startDay,endDay,differInYears,differInMonths = 0,differInDays = 0;
			startYear = startDate.getYear();
			endYear = endDate.getYear();
			startMonth = startDate.getMonth();
			endMonth = endDate.getMonth();
			startDay = startDate.getDay();
			endDay = endDate.getDay();
			differInYears = endYear - startYear;
			if(startMonth > endMonth) {
				differInYears--;
				endMonth = endMonth+12;
				differInMonths = endMonth - startMonth;
			} else
				differInMonths = endMonth - startMonth;
			if(endYear % 400 == 0 && endMonth>2) {
				daysInMonth.put(2, 29);
			}
			if(startDay > endDay) {
				differInMonths--;
				endDay = endDay+daysInMonth.get(endMonth);
				differInDays = endDay - startDay;
			} else {
				differInDays = endDay - startDay;
			}*/


		byte[] input = {0};
		BigInteger BIG_MILLISEC = new BigInteger(input);
		BigInteger BIG_SECOND = new BigInteger(new byte[]{2});
		BigInteger BIG_MINUTE = new BigInteger(input);
		BigInteger BIG_HOUR = new BigInteger(input);
		BigInteger BIG_DAY = new BigInteger(input);
		BigInteger BIG_MONTH = new BigInteger(input);
		BigInteger BIG_YEAR = new BigInteger(input);
		long duration = endDate.getTime() - startDate.getTime();

		BIG_SECOND = BigInteger.valueOf(TimeUnit.MILLISECONDS.toSeconds(duration));
		BIG_MILLISEC = BigInteger.valueOf(TimeUnit.MILLISECONDS.toMillis(duration)).divideAndRemainder(BigInteger.valueOf(1000))[1];
		System.out.println(TimeUnit.MILLISECONDS.toDays(duration));
		if(BIG_SECOND.compareTo(BigInteger.valueOf(59)) == 1) {
			BigInteger[] divAndReminder = BIG_SECOND.divideAndRemainder(BigInteger.valueOf(60));
			BIG_MINUTE = divAndReminder[0];
			BIG_SECOND = divAndReminder[1];
			if(BIG_MINUTE.compareTo(BigInteger.valueOf(59)) == 1) {
				divAndReminder = BIG_MINUTE.divideAndRemainder(BigInteger.valueOf(60));
				BIG_HOUR = divAndReminder[0];
				BIG_MINUTE = divAndReminder[1];
				if(BIG_HOUR.compareTo(BigInteger.valueOf(23)) == 1) {
					divAndReminder = BIG_HOUR.divideAndRemainder(BigInteger.valueOf(24));
					BIG_DAY = divAndReminder[0];
					BIG_HOUR = divAndReminder[1];
					if(BIG_DAY.compareTo(BigInteger.valueOf(29)) == 1) { // For Average
						divAndReminder = BIG_DAY.divideAndRemainder(BigInteger.valueOf(30));
						BIG_MONTH = divAndReminder[0];
						BIG_DAY = divAndReminder[1];
						if(BIG_MONTH.compareTo(BigInteger.valueOf(11)) == 1) {
							divAndReminder = BIG_MONTH.divideAndRemainder(BigInteger.valueOf(12));
							BIG_YEAR = divAndReminder[0];
							BIG_MONTH = divAndReminder[1];
						}
					}
				}
			}
		}
			/*if(BIG_DAY.compareTo(BigInteger.valueOf(4)) == 1)
				BIG_DAY = BIG_DAY.subtract(BIG_YEAR.multiply(BigInteger.valueOf(5)));
			else {
				BIG_YEAR = BIG_YEAR.subtract(BigInteger.valueOf(1));
			}*/
		System.out.println("\n Time between above dates , \n\n"+BIG_YEAR+" YEARS, "+BIG_MONTH+" MONTHS, "+BIG_DAY+" DAYS, "+BIG_HOUR+" HOURS, "+
				BIG_MINUTE+" MINUTES, "+BIG_SECOND+" SECONDS, "+BIG_MILLISEC+" MILLI SECONDS");

	}
}
