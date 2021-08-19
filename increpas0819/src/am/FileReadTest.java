package am;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadTest {
	
	public static void main(String[] args){
		
		String path = "C:/Users/user/Desktop/테스트/Test.txt";
		
		File file = new File(path);
		FileInputStream f_in = null;
		
		if (file.isFile()) {
			try {
				
				f_in = new FileInputStream(file);	
				
				byte[] encoded = new byte[2048];
				int size = -1; // end of file
				
				while((size = f_in.read(encoded))  != -1) {
					System.out.println(size);
					System.out.write(encoded,0,size);
				}		
			} catch (Exception e1) {
				e1.printStackTrace();
			}finally {
				try {
					f_in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
