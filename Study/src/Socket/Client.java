package Socket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame {
	
	final static int PORT = 3000;
	
	private Socket socket;
	private JTextField message;
	private JTextArea area;
	
	public Client() {
		
		message = new JTextField(30);
		area = new JTextArea(10,50);
		
		area.setBackground(Color.BLACK);
		JScrollPane scroll =new JScrollPane(area);	
		
		this.setLayout(new BorderLayout(10,10));
		this.add("North",message);
		this.add("Center",scroll);
		
		area.setEnabled(false);
		this.setSize(650,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
			
				System.exit(0);
			}
		});
	
		connectionServer();
		
	}
	private void connectionServer() {
		
		String getServerIP = "192.168.0.17";
		
		try {
			
			socket = new Socket(getServerIP, Server.PORT);
			
			if(socket.isConnected()) {
				area.append("서버 접속 성공 ! ");
				area.append("\n");
				area.append("[Server 포트] : " + socket.getPort());
				area.append("\n");
				area.append("[클라이언트 포트] : " + socket.getLocalPort());
				area.append("\n");
			}
			
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			area.append(br.readLine());
			
			br.close();
			socket.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void main(String[] args) {
			
		new Client();
	
	}
	
	

}
