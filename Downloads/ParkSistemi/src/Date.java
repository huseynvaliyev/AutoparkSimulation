import java.util.Calendar;

public class Date {
	private int day;
	private int month;
	private int year;
	static Calendar calendar = Calendar.getInstance(); 
	
	public Date(int day,int month,int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public static Date getToday() {
		int day = calendar.get(Calendar.DATE);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		Date today = new Date(day,month,year);
		return today;
	}
	
	public boolean isAfterThan(Date other) {
		if(other.year > getToday().year) {
			return true;
		}
		else if(other.year < getToday().year) {
			return false;
		}
		else if(other.month > getToday().month) {
			return true;
		}
		else if(other.month < getToday().month) {
			return false;
		}
		else if(other.day > getToday().day) {
			return true;
		}
		return false;
	}
	
	public boolean isBeforeThan(Date other) {
		if(other.year > getToday().year) {
			return false;
		}
		else if(other.year < getToday().year) {
			return true;
		}
		else if(other.month > getToday().month) {
			return false;
		}
		else if(other.month < getToday().month) {
			return true;
		}
		else if(other.day > getToday().day) {
			return false;
		}
		return true;
	}
	
	public boolean isEqualWith(Date other) {
		if((other.year == getToday().year)&&(other.month == getToday().month)&&(other.day == getToday().day)) {
			return true;
		}
		return false;
	}
	
	
}
