package pm.Socket4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ex4_Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.print("메세지 입력:");

		Scanner scan = new Scanner(System.in);
		String msg = scan.nextLine();
		
		//서버 접속
		Socket s = new Socket("192.168.0.17", 3000);
		
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(
						s.getInputStream()));
		
		//서버로 메세지를 보내기 위해 스트림 준비
		PrintWriter writer = new PrintWriter(s.getOutputStream(),true);
		
		writer.println(msg); //서버로 데이터 보내기(ip가 없는 문자열)
		
		String str = reader.readLine();// 서버로부터 전달되어오는 메세지 받기
		System.out.println(str);// ip가 있는 문자열
	}

}
