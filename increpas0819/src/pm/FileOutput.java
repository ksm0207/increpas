package pm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {

	public static void main(String[] args) {
		
		String path = "C:/Users/user/Desktop/테스트/file.txt";
		
		File file = new File(path);
		
		FileOutputStream fos = null;
		
		try {
			 fos = new FileOutputStream(file);
			 
			 String text = "Data!!";
			 byte[] en = text.getBytes();
			 fos.write(en,0,en.length);
			 fos.flush();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
