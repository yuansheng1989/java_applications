import java.rmi.Naming;

public class CarServer {
	public CarServer() {
		try {
			CarInterface car = new Car();
			Naming.rebind("rmi://localhost:1099/CarService", car);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	public static void main(String args[]) {
		new CarServer();
		System.out.println("CarServer is running");
	}
}