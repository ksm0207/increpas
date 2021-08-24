package pm.Socket2;

import java.io.BufferedInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	final static int PORT = 3000;
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(Server.PORT);
			System.out.println("서버 On");
			while(true) {
				
				Socket con = server.accept();
				
//				String message = "Hello";
				
				BufferedInputStream bis = new BufferedInputStream(con.getInputStream());

				byte[] encoding = new byte[2048];
				int size = -1;
				
				StringBuffer sb = new StringBuffer();
				
				while((size = bis.read(encoding)) != -1) {
					String message = new String(encoding);
					sb.append(message);
				}
				
				String ip = con.getInetAddress().getHostAddress();
				
				System.out.println(ip + " " + sb.toString());	
			}// end of while(true)
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
