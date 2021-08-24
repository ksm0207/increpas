package pm.Socket3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception{
		
		ServerSocket socket = new ServerSocket(3000);
		System.out.println("서버 시작");
		
		while(true) {
			
			Socket con =socket.accept();
			
			if (con.isConnected()) {
				
				BufferedReader br = new BufferedReader
				(new InputStreamReader(con.getInputStream()));
				
				PrintWriter writer = new PrintWriter(con.getOutputStream(),true);

				String text2= br.readLine();				
				String ip = con.getInetAddress().getHostAddress();
				
				writer.println("Client : " + ip + " : " + text2);

			}
		}
	}
}
