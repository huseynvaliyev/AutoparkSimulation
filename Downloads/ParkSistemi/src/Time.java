import java.util.Calendar;

public class Time {
	private int hour;
	private int minute;
	Calendar now = Calendar.getInstance(); 
	
	public Time(int hour,int minute) {
		this.hour = hour;
		this.minute = minute;
	}
	
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public int getDifference(Time other) {
		int difference = ((now.get(Calendar.HOUR_OF_DAY)*60)+now.get(Calendar.MINUTE))-((other.hour*60)+other.minute);
		return difference;
	}
}
