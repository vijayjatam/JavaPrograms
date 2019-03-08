package com.kali.kali;
import com.kali.HanoiTime;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class DatesDifference {
	public static void main(String[] args) {
		dates();
	}
	
	public static void dates() {
		/*Calendar cal = Calendar.getInstance();
		System.out.println("Enter year, month, day, hour, min, sec");
		Scanner scan = new Scanner(System.in);
		cal.set(scan.nextInt(),scan.nextInt(),scan.nextInt()*//*,scan.nextInt(),scan.nextInt(),scan.nextInt()*//*);
//		cal.set(2, 8, 24, 3, 5, 2);
		System.out.println(cal.getTime());*/
		datesDiff();
	}
	public static void datesDiff() {
		String startDate = "1989-11-11 24:00:00";
		String endDate = "1990-11-04 00:00:00";
		DateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat Time_formate = new SimpleDateFormat("HH:mm:ss");
		try {
			java.util.Date dateStart = formate.parse(startDate);
			java.util.Date dateEnd = formate.parse(endDate);
//			java.util.Date dateEnd = formate.parse(formate.format(new java.util.Date()));
			long duration  = dateEnd.getTime() - dateStart.getTime();
//			System.out.println(duration+"    "+TimeUnit.MILLISECONDS.toSeconds(duration)+"  "+TimeUnit.MILLISECONDS.toMinutes(duration)+"   "+TimeUnit.MILLISECONDS.toHours(duration)+"  "+TimeUnit.MILLISECONDS.toDays(duration));
			BigInteger difference = BigInteger.valueOf(TimeUnit.MILLISECONDS.toSeconds(duration));
			System.out.println(difference +" "+dateStart+"  "+dateEnd);
			new HanoiTime().findDurationB_WDates(dateStart, dateEnd);
			
			/*long diff =Time_formate.parse(endDate.substring(endDate.lastIndexOf("-")+4)).getTime() - Time_formate.parse(startDate.substring(startDate.lastIndexOf("-")+4)).getTime() ;
			difference = BigInteger.valueOf(TimeUnit.MILLISECONDS.toSeconds(diff));
			new HanoiTime().findDurationB_WDates(dateStart, dateEnd);*/
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
