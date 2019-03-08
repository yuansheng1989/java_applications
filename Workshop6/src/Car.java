import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Car extends UnicastRemoteObject implements CarInterface {
	String model;
	String color;
	double mileage;
	int plate;
	
	public Car() throws RemoteException {
		this("Toyota", "black", 0.0);
	}
	
	public Car(String model, String color, double mileage) throws RemoteException {
		this.model = model;
		this.color = color;
		this.mileage = mileage;
	}
	
	public void register() throws RemoteException {
		this.plate = Math.abs(this.hashCode());
	}
	
        public String getModel() throws RemoteException {
                return this.model;
        }

        public String getColor() throws RemoteException {
                return this.color;
        }

        public double getMileage() throws RemoteException {
                return this.mileage;
        }

        public int getPlate() throws RemoteException {
                return this.plate;
        }

	@Override
	public String toString() {
		return "Model: " + this.model + " Color: " + this.color + " Mileage: " + this.mileage + "  Plate: " + this.plate;
	}

}
