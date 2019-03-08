import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CarInterface extends Remote {
	public void register() throws RemoteException;
	public String getModel() throws RemoteException;
	public String getColor() throws RemoteException;
	public double getMileage() throws RemoteException;
	public int getPlate() throws RemoteException;
}
