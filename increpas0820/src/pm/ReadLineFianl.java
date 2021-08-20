package pm;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ReadLineFianl {
	
	public static void main(String[] args) throws Exception{
		
		StringBuffer sb = new StringBuffer();
		
		String path = "C:/Users/user/Desktop/0820/서울특별시.txt";
		
		
		FileInputStream fis = new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
		String text = "";
		
		
		

	
		
	}

}
