package am;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamTest {
	
	public static void main(String[] args) {
	
		System.out.print("입력 : ");
		InputStream input = System.in;
		 int res =0;
		try {
			 res= input.read();
			System.out.println(res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}
