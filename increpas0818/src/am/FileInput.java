package am;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileInput {
	public static void main(String[] args) {
		
		String path = "C:/Users/user/Desktop/테스트/Test.txt";
		
		File f = new File(path);
		
		if (f.isFile()) {
			FileInputStream fileStream = null;
		
			try {
				fileStream = new  FileInputStream(f);
				
				int data = -1;
				
				System.out.println("Result");
				
				while((data = fileStream.read()) != -1 )
					System.out.write(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					fileStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	}
}
