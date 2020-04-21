
public class RegularVehicle implements Vehicle {
	private String plate;
	private final boolean special = false;
	
	public RegularVehicle(String plate) {
		this.plate = plate;
	}
	
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	

	@Override
	public Subscription getSubscription() {
		return null;
	}

	@Override
	public boolean isSpecial() {
		return special;
	}
	
}
