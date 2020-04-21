import java.util.Calendar;
import java.util.Scanner;
public class main {
	public static void  main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		Scanner inInteger = new Scanner(System.in);
		Scanner inString = new Scanner(System.in);
		Scanner inBool = new Scanner(System.in);
		System.out.print("Autopark hourlyFeesini giriniz:");
		int hourlyFee = inInteger.nextInt();
		System.out.print("Autopark capacitysini giriniz:");
		int capacity = inInteger.nextInt();
		AutoPark autopark = new AutoPark(hourlyFee,capacity);
		
		System.out.println("Autopark Menusü");
		System.out.println("1.AddVehichle");
		System.out.println("2.SearchVehicle");
		System.out.println("3.IsParked");
		System.out.println("4.VehicleEnter");
		System.out.println("5.VehicleExit");
		System.out.println("6.Exit");
		System.out.print("Seçiminizi giriniz:");
		int choise = inInteger.nextInt();
		while(choise!=6) {
			switch (choise) {
			  case 1:
				  System.out.print("Subscribe olan aracın platesini giriniz:");
				  String plateNum = inString.nextLine();
				  Date end = Date.getToday();
				  int a = end.getMonth();
				  end.setMonth(a+1);
				  Subscription sub = new Subscription(Date.getToday(),end,plateNum);
				  autopark.addVehicle(sub.getVehicle());
				  System.out.print("Seçiminizi giriniz:");
				  choise = inInteger.nextInt();
			    break;
			  case 2:
				  System.out.print("Aramak istediğiniz subscribe arabanın platesini giriniz:");
				  String subPlateNum = inString.nextLine();
				  if(autopark.searchVehicle(subPlateNum)==null) {
					  System.out.println("Böyle bir araç bulunmamaktadır");
				  }
				  System.out.print("Seçiminizi giriniz:");
				  choise = inInteger.nextInt();
			    break;
			  case 3:
				  System.out.print("Park halini görmek istediğiniz arabanın platesini giriniz:");
				  String parkPlateNum = inString.nextLine();
				  if(autopark.isParked(parkPlateNum) == true ) {
					  System.out.println("Araç park halindedir");
				  }
				  else {
					  System.out.println("Araç park halinde değil");
				  }
			    break;
			  case 4:
				  Time now = new Time(calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE));
				  System.out.print("Autoparka giren arabanın platesini giriniz:");
				  String enterPlateNum = inString.nextLine();
				  System.out.print("Autoparka giren araba officalmı:");
				  boolean offical = inBool.nextBoolean();
				  if(autopark.vehicleEnters(enterPlateNum,now,offical)==true) {
					  System.out.println("Araç giriş yaptı");
				  }
				  else {
					  System.out.println("Araç giriş yapamadı");
				  }
				  System.out.print("Seçiminizi giriniz:");
				  choise = inInteger.nextInt();
			    break;
			  case 5:
				  Time exitnow = new Time(calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE));
				  System.out.print("Autoparkdan çıkan arabanın platesini giriniz:");
				  String exitPlateNum = inString.nextLine();
				  if(autopark.vehicleExits(exitPlateNum, exitnow)==true) {
						System.out.println("Araç çıkış yaptı."); 
				  }
				  else {
					  System.out.println("Araç çıkış yapmadı");
				  }
				  System.out.print("Seçiminizi giriniz:");
				  choise = inInteger.nextInt();
			    break;
			}
		}
		inInteger.close();
		inString.close();
		inBool.close();
	}
	
}
