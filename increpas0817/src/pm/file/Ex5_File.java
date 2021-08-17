package pm.file;

import java.io.File;
import java.io.IOException;

public class Ex5_File {
	
	public static void main(String[] args) {
		
		/* 경로(폴더) 준비 */
		String path = "C:/Users/user/Documents/GitHub2/t125";
	
		/* 파일 */
		String file_name = "파일생성23.txt";
		
		/* 부모 : 폴더 */
		File parent = new File(path);
		
		/* 자식 : 파일 */
		File child = new File(parent, file_name);
		
		if(!parent.isDirectory()) {
			System.out.println("디렉토리 접근 확인 !");
			/* mkdir () : 경로에 있는 마지막 폴더만 생성 한다*/
			/* 경로상 존재하지 않는 폴더들이 존재한다면 모두 생성한다. */
			parent.mkdirs();	
			System.out.println("폴더 생성 완료!");
		}
		
		if(parent.isDirectory()){
			System.out.println("폴더 확인");
			try {
				if(child.isFile()) {
					System.out.println("존재하는 파일 입니다.");
					System.out.println(child.length());
					long size = child.length();
					
					System.out.println("파일 크기 : " + size + " byte");
					
					
				}else {
					System.out.println("새로운 파일을 만들었습니다.");
					child.createNewFile();
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("존재하지 않는 폴더 입니다.");			
		}
		
	}

}
