
public class Subscription {
	private Date begin;
	private Date end;
	private SubscribedVehicle vehicle;
	
	public Subscription(Date begin,Date end,String plate) {
		this.begin = begin;
		this.end = end;
		setVehicle(new SubscribedVehicle(plate));
		vehicle.setSubscription(this);
	}
	
	
	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}


	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
	public SubscribedVehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(SubscribedVehicle vehicle) {
		this.vehicle = vehicle;
	}

	public boolean isValid() {
		if(end.isBeforeThan(Date.getToday()) == true){
			return true;
		}
		return false;
	}
	
	
}
