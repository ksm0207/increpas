package am;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamTest {
	
	public static void main(String[] args) {
		
		String path = "C:/Users/user/Desktop/0820/io.txt";
		
		File f = new File(path);
		
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
			
			int size = -1;
			
			byte[] eof = new byte[2048];
			
			while((size = bis.read(eof)) != -1 ) {
				
				String res = new String(eof,0,size);
				
				System.out.println(res);
				
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
