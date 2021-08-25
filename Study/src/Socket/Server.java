package Socket;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	final static int PORT = 3000;
	
	public static void main(String[] args) {
		try {
			
			/* ServerSocket 생성자는 현재 지정된 포트에 바인딩된 서버 소켓을 만든다*/
			ServerSocket s_sk = new ServerSocket(Server.PORT);
			
			while(true) {
			/* 해당 소켓에 대한 연결을 대기한다 , 반환 : 새로운 소켓 */	
				System.out.println("연결 대기중 ...");
				Socket socket = s_sk.accept();

				if(socket.isConnected()) {
					
					System.out.println("클라이언트 와 연결이 되었습니다");
					/* 클라이언트 IP 주소 - getInetAddress() */
					System.out.println("클라이언트 주소 : " + socket.getInetAddress());
					/* 클라이언트 Port 번호 - getPort() */
					System.out.println("클라이언트 포트 : " + socket.getPort());
					/* 현재 Server 포트번호 */
					System.out.println("서버 포트 : " + socket.getLocalPort());
					
					/* socket.getOutputStream() : 소켓의 출력 스트림을 반환 */
					PrintWriter print = new PrintWriter
							           (new BufferedOutputStream
							           (socket.getOutputStream()));
					
					print.println(" 안녕하세요 ? from Server...");
					
					print.close();
					socket.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
