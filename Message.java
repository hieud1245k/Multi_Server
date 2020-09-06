import java.io.Serializable;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3163511511469631031L;
	private String message;
	private int logicalclock;
	private String fromServer;
	
	

	public Message(String message, int logicalclock, String fromServer) {
		super();
		this.message = message;
		this.logicalclock = logicalclock;
		this.fromServer = fromServer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getLogicalclock() {
		return logicalclock;
	}

	public void setLogicalclock(int logicalclock) {
		this.logicalclock = logicalclock;
	}

	public String getFromServer() {
		return fromServer;
	}

	public void setFromServer(String fromServer) {
		this.fromServer = fromServer;
	}
	@Override
	public String toString() {
		return "From: " + this.getFromServer() + "\n" + "Message: " + this.getMessage() + "\n";
	}
}
