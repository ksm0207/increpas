package pm.Socket;

import java.io.IOException;
import java.net.Socket;

public class Client {
	
	final static int PORT = 3000;
	
	public static void main(String[] args) {
		
		try {
			
			Socket socket = new Socket("192.168.0.17", Client.PORT);
		
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
