import java.util.ArrayList;
import java.util.Calendar;
public class AutoPark {
	private int capacity;
	private ArrayList<SubscribedVehicle> subscribedVehicle  = new ArrayList<SubscribedVehicle>();
	private ArrayList<ParkRecord> parkRecords = new ArrayList<ParkRecord>();
	private double hourlyFee;
	private double incomeDaily = 0;
	Calendar calendar = Calendar.getInstance();
	
	
	public AutoPark(double hourlyFee, int capacity) {
		this.hourlyFee = hourlyFee;
		this.capacity = capacity;
	}
	
	public SubscribedVehicle searchVehicle(String plate) {
		for(int i=0;i<subscribedVehicle.size();i++) {
			if(subscribedVehicle.get(i).getPlate().equals(plate)) {
				System.out.println(subscribedVehicle.get(i).getPlate()+" Begin date: "+subscribedVehicle.get(i).getSubscription().getBegin().getDay()+"/"+subscribedVehicle.get(i).getSubscription().getBegin().getMonth()+"/"+subscribedVehicle.get(i).getSubscription().getBegin().getYear()+" End Date:"
								   +subscribedVehicle.get(i).getSubscription().getEnd().getDay()+"/"+subscribedVehicle.get(i).getSubscription().getEnd().getMonth()+"/"+subscribedVehicle.get(i).getSubscription().getEnd().getYear());
				return subscribedVehicle.get(i);
			}
		}
		return null;
	}
	
	public boolean addVehicle(SubscribedVehicle vehicle) {
		if(searchVehicle(vehicle.getPlate())!= null) {
			return false;
		}
		if(subscribedVehicle.size()<capacity) {
			subscribedVehicle.add(vehicle);
			System.out.println("Araba Eklendi");
			return true;
		}
		return false;
	}
	
	public boolean isParked(String plate) {
		Time a = new Time(0,0);
		Time b = new Time(0,0);
		for(int i=0;i<parkRecords.size();i++) {
			if(parkRecords.get(i).getPlate().equals(plate)) {
				 b = parkRecords.get(i).getExitTime();
				 a = parkRecords.get(i).getEnterTime();
			}
		}
		if((b == null)) {
			if(a == null) {
				return false;
			}
		return true;
		}
		return false;
	}
	
	public boolean vehicleEnters(String plate,Time enter, boolean offical) {
		if(isParked(plate)==true) {
			System.out.println("Bu araç park halindedir.");
			return false;
		}
		if(searchVehicle(plate)!=null) {
			ParkRecord parkRecord = new ParkRecord(enter,null,plate,true,false);
			parkRecords.add(parkRecord);
			return true;
		}
		ParkRecord parkRecord = new ParkRecord(enter,null,plate,false,offical);
		parkRecords.add(parkRecord);
		return true;
	}
	
	public boolean vehicleExits(String plate,Time exit) {
		for(int i=0;i<parkRecords.size();i++) {
			if((parkRecords.get(i).getPlate().equals(plate))&&(parkRecords.get(i).getExitTime()==null)) {
				if(parkRecords.get(i).getSubscribed()==false) {
					if(parkRecords.get(i).isOffical() == false) {
						parkRecords.get(i).setExitTime(exit);
						int fee = exit.getDifference(parkRecords.get(i).getEnterTime())/60;
						double newFee = (fee * hourlyFee);
						incomeDaily = incomeDaily + newFee;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public ArrayList <ParkRecord> getParkRecords(){
		return parkRecords;
	}
	
	public ArrayList <SubscribedVehicle> getSubscribedVehicle(){
		return subscribedVehicle;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
}
