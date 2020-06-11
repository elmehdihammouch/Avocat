package tools;



import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


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
	
public  static Date toToolsDate(Timestamp DBDate)  {
		if(DBDate!=null) {
		LocalDateTime localDate = DBDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		
		Date maDate = new Date();
	
		maDate.setDate(DBDate.toString());
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
		
		else {return null;}
	}

public static String toFDate(Date d) {
	String FrontDate;
	if(d!=null) {
		FrontDate = d.getYear()+"-"+d.getMonth()+"-"+d.getDay()+" à "+d.getHeurs()+":"+d.getMinutes();
	}
	else {
	    FrontDate = null;
	}
	return FrontDate;
}

}
