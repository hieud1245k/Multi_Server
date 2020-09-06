import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class AbstractServer extends UnicastRemoteObject implements Server, ActionListener {
	private static final long serialVersionUID = 1L;
	private int port;
	private String IPHost;
	private String serverName;

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField tf_InputMessage;
	private JTextArea textArea_1, textArea;
	private JButton btnNewButton_1, btnNewButton;
	private JCheckBox cb_server[] = new JCheckBox[4];
	private JScrollPane cpShowMessage;

	protected AbstractServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbstractServer(String iPHost, int port, String serverName) throws RemoteException {
		super();
		this.port = port;
		IPHost = iPHost;
		this.serverName = serverName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
	}

	public String getIPHost() {
		return IPHost;
	}

	public void setIPHost(String iPHost) {
		IPHost = iPHost;
	}

	@Override
	public Message send(Message message) throws RemoteException {
		textArea_1.setText(textArea_1.getText() + message.toString());
		return message;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	@Override
	public Message receive(Message message) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void ServerInterface() {
		frame = new JFrame();
		frame.setTitle(this.getServerName() + " is listening at port " + this.getPort());
		frame.setBounds(100, 100, 843, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Lookup servers in the system", TitledBorder.LEADING, TitledBorder.TOP,
				null, Color.BLUE));
		panel.setBounds(12, 0, 801, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(
				new TitledBorder(null, "Server infor", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBounds(12, 515, 801, 88);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("IP Address:");
		lblNewLabel.setBounds(12, 36, 79, 28);
		panel_1.add(lblNewLabel);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(91, 36, 124, 28);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Host Name:");
		lblNewLabel_1.setBounds(243, 36, 67, 28);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Port:");
		lblNewLabel_2.setBounds(464, 36, 44, 28);
		panel_1.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(516, 36, 67, 28);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("State Server:");
		lblNewLabel_3.setBounds(614, 36, 79, 28);
		panel_1.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(322, 36, 108, 28);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(704, 36, 85, 28);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Servers in the system", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.BLUE));
		panel_2.setBounds(12, 78, 196, 437);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		textArea = new JTextArea();
		textArea.setEditable(false);
		cpShowMessage = new JScrollPane(textArea);
		cpShowMessage.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_2.add(cpShowMessage, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(207, 85, 606, 319);
		frame.getContentPane().add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(
				new TitledBorder(null, "Deliver message", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_4.setBounds(207, 403, 606, 112);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Message:");
		lblNewLabel_4.setBounds(12, 28, 62, 27);
		panel_4.add(lblNewLabel_4);

		tf_InputMessage = new JTextField();
		tf_InputMessage.setBounds(86, 28, 496, 27);
		panel_4.add(tf_InputMessage);
		tf_InputMessage.setColumns(10);

		btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(505, 68, 77, 31);
		panel_4.add(btnNewButton);

		btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(416, 68, 77, 31);
		panel_4.add(btnNewButton_1);

		cb_server[1] = new JCheckBox("Server 1");
		cb_server[1].setBounds(12, 68, 78, 25);
		panel_4.add(cb_server[1]);

		cb_server[2] = new JCheckBox("Server 2");
		cb_server[2].setBounds(90, 68, 78, 25);
		panel_4.add(cb_server[2]);

		cb_server[3] = new JCheckBox("Server 3");
		cb_server[3].setBounds(168, 68, 78, 25);
		panel_4.add(cb_server[3]);

		cb_server[0] = new JCheckBox("All servers", true);
		cb_server[0].setBounds(244, 68, 89, 25);
		panel_4.add(cb_server[0]);
		panel_3.setLayout(new BorderLayout(0, 0));
		JTabbedPane jTabbedPane = new JTabbedPane();

		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		cpShowMessage = new JScrollPane(textArea_1);
		cpShowMessage.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jTabbedPane.addTab("Messages", cpShowMessage);
		JLabel label = new JLabel("Logical Clock", JLabel.CENTER);
		jTabbedPane.addTab("Logical Lock", label);
		panel_3.add(jTabbedPane, BorderLayout.CENTER);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(btnNewButton)) { // send
			String mess = tf_InputMessage.getText();
			Message message = new Message(mess, 1, this.getServerName());
			Server server;
			try {
				if (this.getServerName() == "server 1") {
					server = (Server) Naming.lookup("rmi://" + this.getIPHost() + ":" + this.getPort() + "/server2");
				} else {
					server = (Server) Naming.lookup("rmi://" + this.getIPHost() + ":" + this.getPort() + "/server1");
				}
				server.send(message);
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (arg0.getSource().equals(btnNewButton_1)) { // reset
			tf_InputMessage.setText("");
		}
	}

}
