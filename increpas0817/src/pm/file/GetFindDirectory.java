package pm.file;

import java.io.File;
import java.util.Scanner;

public class GetFindDirectory {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
//		C:/Users/user/Documents/GitHub		
		System.out.print("경로 입력 : ");
		String path = scan.next();
		
		File file = new File(path);

		if(file.isDirectory()) {
			System.out.println("경로 확인");
			
			String [] get = file.list();
			
			for (int i=0; i<get.length; i++) {
				System.out.println(get[i]);
			}
		}else {
			System.out.println("찾으시는 경로가 없습니다.");
		}
		
		
		
	}

}
