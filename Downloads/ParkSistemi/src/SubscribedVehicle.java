
public class SubscribedVehicle implements Vehicle {
	private String plate;
	private final boolean special = false;
	private Subscription subscription;
	
	public SubscribedVehicle(String plate) {
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
		return subscription;
	}

	@Override
	public boolean isSpecial() {
		return special;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
}
