package tools;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Date {
	public String date;
	public int day;
	public int year;
	public int month;
	public int heurs;
	public int minutes;
	public int seconds;
	
	
	
	
	public Date() {
		super();
	}
	
	




	






	
	public String getDate() {
		return date;
	}














	public void setDate(String date) {
		this.date = date;
	}














	public int getDay() {
		return day;
	}














	public void setDay(int day) {
		this.day = day;
	}














	public int getYear() {
		return year;
	}














	public void setYear(int year) {
		this.year = year;
	}














	public int getMonth() {
		return month;
	}














	public void setMonth(int month) {
		this.month = month;
	}














	public int getHeurs() {
		return heurs;
	}














	public void setHeurs(int heurs) {
		this.heurs = heurs;
	}














	public int getMinutes() {
		return minutes;
	}














	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}














	public int getSeconds() {
		return seconds;
	}














	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}














	@Override
	public String toString() {
		return "Date [day=" + day + ", year=" + year + ", month=" + month + ", heurs=" + heurs + ", minutes=" + minutes
				+ ", seconds=" + seconds + "]";
	}




	









	@SuppressWarnings("deprecation")
	public  static Date toDbDate(String requestDate)  {
		
		LocalDateTime localDate = LocalDateTime.parse(requestDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
		
		Date maDate = new Date();
	
		maDate.setDate(requestDate);
		/*  utilDate = sdf.parse(localDate);
		  cal.setTime(utilDate);*/
		  maDate.setDay(localDate.getDayOfMonth());
		  maDate.setMonth(localDate.getMonth().getValue());
		  maDate.setYear(localDate.getYear());
		  maDate.setHeurs(localDate.getHour());
		  maDate.setMinutes(localDate.getMinute());
		  maDate.setSeconds(localDate.getSecond());
		
		return maDate;
	}

}
