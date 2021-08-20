package pm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadLineExample {
	
	public static void main(String[] args) throws Exception {
	
		String path = "C:/Users/user/Desktop/0820/서울특별시.txt";
		FileInputStream fileIn = new FileInputStream(path);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(fileIn));
		
		String pos = "";
		

		while ((pos = br.readLine()) != null) {
			
			if (pos.length() > 0) {
				System.out.println(pos);
			}
		}
		fileIn.close();
		br.close();
		
	}
}
