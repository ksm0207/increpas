package pm;

import java.io.IOException;
import java.io.PrintStream;

public class OutputTest {
	
	public static void main(String[] args) {
		
		
		PrintStream ps = System.out;
		
		String str = "안녕하세요?";
		
		byte[] buf = str.getBytes();
		
		try {
			ps.write(buf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
