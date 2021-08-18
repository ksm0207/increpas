package am;

import java.io.InputStream;

public class InputTest3 {
	
	public static void main(String[] args) {
		
		InputStream key = System.in;
		
		try {
			System.out.print("입력 :");
			int i=0;
			while(i < 4) {
				int data = key.read();
				System.out.println((char)data);
				System.out.println(data);
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
