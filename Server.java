import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
	public Message send(Message message) throws RemoteException;
	public Message receive(Message message) throws RemoteException;
}
