
public class ParkRecord {
	private Time enterTime;
	private Time exitTime;
	private String plate;
	private Vehicle vehicle;
	private boolean subscribed;
	private boolean offical;
	
	public ParkRecord(Time enterTime, Time exitTime,String plate,boolean subscribed,boolean offical) {
		this.enterTime = enterTime;
		this.exitTime = exitTime;
		this.subscribed = subscribed;
		this.offical = offical;
		this.plate = plate;
	}
	
	public Time getEnterTime() {
		return enterTime;
	}
	
	public void setEnterTime(Time enterTime) {
		this.enterTime = enterTime;
	}
	public Time getExitTime() {
		return exitTime;
	}
	public void setExitTime(Time exitTime) {
		this.exitTime = exitTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public boolean getSubscribed() {
		return subscribed;
	}
	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public boolean isOffical() {
		return offical;
	}

	public void setOffical(boolean offical) {
		this.offical = offical;
	}
	
}
