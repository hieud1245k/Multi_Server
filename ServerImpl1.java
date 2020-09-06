import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;


public class ServerImpl1 extends AbstractServer implements Remote {
	private static final long serialVersionUID = -7580724319100360630L;

	protected ServerImpl1() throws RemoteException {
		
	}

	public ServerImpl1(String iPHost, int port,String serverName) throws RemoteException {
		super(iPHost, port,serverName);
	}

	public static void main(String[] args) throws RemoteException {
		ServerImpl1 serverImpl1 = new ServerImpl1("localhost", 9999,"server 1");
		try {
			Naming.rebind("rmi://" + serverImpl1.getIPHost() + ":" + serverImpl1.getPort() + "/server1", serverImpl1);
			System.out.println("waiting for connect...");
			serverImpl1.ServerInterface();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
