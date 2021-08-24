package pm.Socket2;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		
		System.out.print("Server로 전송 할 메세지 입력 : ");
		Scanner scan = new Scanner(System.in);
		String message = scan.nextLine();
		
		if(message != null && message.trim().length() > 0) {
			try {
				Socket socket = new Socket("192.168.0.17", Server.PORT);
				BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
				
				bos.write(message.getBytes());
				bos.flush();
				
				bos.close();
				socket.close();
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
