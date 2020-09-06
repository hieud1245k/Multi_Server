import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class ServerImpl2 extends AbstractServer implements Remote {
	private static final long serialVersionUID = -7580724319100360630L;

	protected ServerImpl2() throws RemoteException {

	}

	public ServerImpl2(String iPHost, int port,String serverName) throws RemoteException {
		super(iPHost, port,serverName);
	}
	
	public static void main(String[] args) throws RemoteException {
		ServerImpl2 serverImpl2 = new ServerImpl2("localhost", 8888,"server 2");
		try {
			Naming.rebind("rmi://" + serverImpl2.getIPHost() + ":" + serverImpl2.getPort() + "/server2", serverImpl2);
			System.out.println("waiting for connect...");
			serverImpl2.ServerInterface();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
