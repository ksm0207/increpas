package pm.Socket3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import pm.Socket2.Server;

public class Client {
	
public static void main(String[] args) {
		
		
		System.out.print("Server로 전송 할 메세지 입력 : ");
		Scanner scan = new Scanner(System.in);
		String message = scan.nextLine();
		
		if(message != null && message.trim().length() > 0) {
			try {
				Socket socket = new Socket("192.168.0.17", 3000);
				
				
				
				PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
				
				writer.println(message);

				
				
				BufferedReader br = new BufferedReader
						(new InputStreamReader(socket.getInputStream()));
				
				String str = br.readLine();
				
				System.out.println(str);
				
				
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
