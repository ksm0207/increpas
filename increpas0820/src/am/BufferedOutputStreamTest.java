package am;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class BufferedOutputStreamTest {
	
	public static void main(String[] args) throws Exception{
		
		String path = "C:/Users/user/Desktop/0820/io.txt";
		
		String text = "연습용 텍스트.";
		
		File f = new File(path);
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
		
		byte[] eof = text.getBytes();
		
		bos.write(eof);
		bos.flush(); 
	}

}
