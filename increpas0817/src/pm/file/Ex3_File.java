package pm.file;

import java.io.File;
import java.io.IOException;

public class Ex3_File {
	
	public static void main(String[] args) {
		
		/* 절대경로 */
		String path = "C:\\Users\\user\\Documents\\GitHub/my_str.txt";
		
		/* 파일 경로를 가지고 File객체를 만들자 */
		File file = new File(path);
		
		/* File 객체는 실제 파일이 존재여부와는 상관없이 메모리상에 생성이 된다*/
		
		if (file.exists()) {
			System.out.println("존재하는 파일");
		}else {
			try {
				
				/* 파일 생성 */
				file.createNewFile();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("새로운 파일 생성");
		}
		
		
					   
	}

}
