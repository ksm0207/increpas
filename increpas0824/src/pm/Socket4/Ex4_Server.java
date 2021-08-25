package pm.Socket4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex4_Server {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(3000);
		Scanner scan = new Scanner(System.in);
		String message = "";
		
		System.out.println("서버 시작!");
		
		
		
		
		while(true) {
			Socket s = ss.accept();// 접속자 받기
			
			BufferedReader reader = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
			// 1) 소켓으로부터 inputstream을 얻어낸다.
			// 2) 1)을 가지고 Reader로 변환해주는 InputStreamReader를 생성한다.
			// 3) 2)를 가지고 한줄단위로 처리가 가능한 BufferedReader를 만든다.
			
			//메세지를 보내기위해 Writer 준비
			PrintWriter writer = 
					new PrintWriter(s.getOutputStream(),true);
			
			//한줄 읽기
			String msg = reader.readLine();
			
			//접속자의 ip
			String ip = s.getInetAddress().getHostAddress();
			
			//접속자에게 다시 메세지 보내기
			
			writer.println(ip+":"+msg);
			
			System.out.println("Test 2 : "+ip+":"+message);
		}
	}

}
