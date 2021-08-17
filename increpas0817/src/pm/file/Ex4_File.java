package pm.file;

import java.io.File;

public class Ex4_File {
	
	public static void main(String[] args) {
		String path = "C:/Users/user/Documents/GitHub/t123/test.txt";
		
		File f = new File(path);
		
		
		if(!f.exists()) {
			try {
				/* NewFile -> 파일만 만들 수 있다 */
				/* 단 경로(폴더) 는 만들어 줄 수 없음.*/
				f.createNewFile();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		}
		
	}

}
