package pm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadLine2 {
	
	public static void main(String[] args) throws Exception {
	
		String path = "C:/Users/user/Desktop/0820/io.txt";
		
		FileInputStream fis = new FileInputStream(path);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
		String text = "";
		
		while( (text = br.readLine() ) != null) {
			System.out.println(text);
		}
		
		fis.close();
		br.close();
		
	}
}
