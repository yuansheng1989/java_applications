import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CarClient {
	public static void main(String[] args) {
		try {
			CarInterface car = (CarInterface) Naming.lookup("rmi://localhost:1099/CarService");
                        System.out.println("Model: " + car.getModel() + " Color: " + car.getColor() + " Mileage: " + car.getMileage());
			car.register();
			System.out.println("Model: " + car.getModel() + " Color: " + car.getColor() + " Mileage: " + car.getMileage() + " Plate: " + car.getPlate());
			//System.out.println(car);
		} catch (MalformedURLException murle) {
			System.out.println("MalformedURLException");
			System.out.println(murle);
		} catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
		} catch (NotBoundException nbe) {
			System.out.println("NotBoundException");
			System.out.println(nbe);
		}
	}
}
