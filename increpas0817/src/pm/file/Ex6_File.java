package pm.file;

import java.io.File;

public class Ex6_File {
	public static void main(String[] args) {
		String path = "C:/Users/user/Documents/GitHub2/t125";
		
		/* 삭제 안되는 코드 */
		
		File f =  new File(path);
		
		if(f.exists()) {
			if(f.delete()) {
				System.out.println("삭제 성공 ");				
			}else {
				System.out.println("이미 존재하는 파일입니다 . 삭제 실패");
			}
			
		}
		
	}
}
