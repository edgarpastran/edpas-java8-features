package com.edpas.java8.i.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeApp {

	private void compareDatesWithJDK7() {
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		date1.set(2000, 00, 01);
		System.out.println("date1 after date2 = "+date1.after(date2));
	}

	private void compareDatesWithJDK8() {
		LocalDate date1 = LocalDate.of(1776, 07, 04);
		LocalDate date2 = LocalDate.now();
		System.out.println("date1 after date2 = "+date1.isAfter(date2));
		System.out.println("date1 before date2 = "+date1.isBefore(date2));
		
		LocalTime time1 = LocalTime.of(22, 30, 50);
		LocalTime time2 = LocalTime.now();
		System.out.println("time1 after time2 = "+time1.isAfter(time2));
		System.out.println("time1 before time2 = "+time1.isBefore(time2));
		
		LocalDateTime dateTime1 = LocalDateTime.of(2000, 01, 01, 22, 30, 50);
		LocalDateTime dateTime2 = LocalDateTime.now();
		System.out.println("dateTime1 after dateTime2 = "+dateTime1.isAfter(dateTime2));
		System.out.println("dateTime1 before dateTime2 = "+dateTime1.isBefore(dateTime2));
	}
	
	private void compareDates(int version) {
		System.out.println("Method compareDates:");
		if (version <= 7) {
			System.out.println("JDK <= 7");
			this.compareDatesWithJDK7();
		}
		else {
			System.out.println("JDK = 8");
			this.compareDatesWithJDK8();
		}
		System.out.println();
	}
	
	private void takeTimeWithJDK7() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(1000);
		long end = System.currentTimeMillis();
		System.out.println("end - start = "+(end-start));
	}

	private void takeTimeWithJDK8() throws InterruptedException {
		Instant start = Instant.now();
		Thread.sleep(1000);
		Instant end = Instant.now();
		System.out.println("end - start = "+Duration.between(start, end).toMillis());
	}
	
	private void takeTime(int version) throws InterruptedException {
		System.out.println("Method takeTime:");
		if (version <= 7) {
			System.out.println("JDK <= 7");
			this.takeTimeWithJDK7();
		}
		else {
			System.out.println("JDK = 8");
			this.takeTimeWithJDK8();
		}
		System.out.println();
	}
	
	private void periodBetwwenDatesWithJDK7() {
		Calendar past = Calendar.getInstance();
		past.set(2000, 0, 1);
		Calendar present = Calendar.getInstance();
		
		int years = 0;
		while (past.before(present)) {
			past.add(Calendar.YEAR, 1);
			if (past.before(present)) {
				years++;
			}
		}
		System.out.println("present - past = "+years+" years");
	}
	
	private void periodBetwwenDatesWithJDK8() {
		LocalDate past = LocalDate.of(2000, 1, 1);
		LocalDate present = LocalDate.now();
		
		Period period = Period.between(past, present);
		System.out.println("present - past = "+period.getYears()+" years "+period.getMonths()+" months "+period.getDays()+" days");
	}
	
	private void periodBetwwenDates(int version) {
		System.out.println("Method periodBetwwenDates:");
		if (version <= 7) {
			System.out.println("JDK <= 7");
			this.periodBetwwenDatesWithJDK7();
		}
		else {
			System.out.println("JDK = 8");
			this.periodBetwwenDatesWithJDK8();
		}
		System.out.println();
	}
	
	private void convertDateWithJDK7() throws ParseException {
		String past = "01/01/2000";
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateConverted = formatter.parse(past);
		System.out.println(dateConverted);
		
		Date present = Calendar.getInstance().getTime();
		formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
		String dateString = formatter.format(present);
		System.out.println(dateString);
	}
	
	private void convertDateWithJDK8() throws ParseException {
		String past = "01/01/2000";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(past, formatter);
		System.out.println(date);
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(formatter.format(date));
	}
	
	private void convertDate(int version) throws ParseException {
		System.out.println("Method convertDate:");
		if (version <= 7) {
			System.out.println("JDK <= 7");
			this.convertDateWithJDK7();
		}
		else {
			System.out.println("JDK = 8");
			this.convertDateWithJDK8();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		DateTimeApp app = new DateTimeApp();
		try {
			app.compareDates(7);
			app.compareDates(8);
			app.takeTime(7);
			app.takeTime(8);
			app.periodBetwwenDates(7);
			app.periodBetwwenDates(8);
			app.convertDate(7);
			app.convertDate(8);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
