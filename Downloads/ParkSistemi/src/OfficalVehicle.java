
public class OfficalVehicle implements Vehicle {
	private String plate;
	private final boolean special = true;
	
	public OfficalVehicle(String plate) {
		this.plate = plate;
	}
	
	
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public Subscription getSubscription() {
		return null;
	}
	
	@Override
	public boolean isSpecial() {
		return special;
	}
	
	
	
}
