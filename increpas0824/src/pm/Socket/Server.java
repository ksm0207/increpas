package pm.Socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		
		try {
			
			ServerSocket ss = new ServerSocket(3000);
			
			System.out.println("서버 On");
			
			while(true) {
				
//				▼ N클라이언트가 3000으로 연결할때까지 대기중
//				  그러나 연결이 완료되면 Socket 객체를 반환
				Socket socket = ss.accept();
				
				InetAddress inet = socket.getInetAddress();

				if (socket.isConnected()) {
					String ip = inet.getHostAddress(); // 클라이언트 IP값
					System.out.println(ip + " 클라이언트 접속 ");
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
