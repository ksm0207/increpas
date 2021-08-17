package pm.file;

import java.io.File;

public class Ex7_File {
	
	public static void main(String[] args) {
		
		String path = "C:/Users/user/Documents/GitHub2/t125/파일생성23.txt";
		
		File f = new File(path);
		
		if(f.exists() && f.delete()) {
			System.out.println("파일 삭제 완료 ");
		}else{
			System.out.println("존재하지 않거나 이미 삭제한 파일입니다.");
		}
		
	}
}
