package pm.file;

import java.io.File;
import java.util.Scanner;

public class Ex8_File {

	public static void main(String[] args) {
		// 키보드로 부터 경로를 입력받는다.
		Scanner scan = new Scanner(System.in);

		System.out.println("폴더 경로:");
		String path = scan.nextLine();// 사용자로 하여금 경로를 하나 받는다.
		
		File f = new File(path);
		
		if(f.isDirectory()) {
			// 디렉토리일 경우는 그 안에 파일 또는 다른 디렉토리들이 존재할 수 있다.
			// 그 목록을 가져와서 출력해보자!
			String[] sub = f.list();
			for(int i=0; i<sub.length; i++) {
				System.out.println(sub[i]);
			}//for의 끝
		}else {
			System.out.println("찾으시는 경로가 없습니다.");
		}
		
		
	}

}
