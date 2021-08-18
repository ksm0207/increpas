package am;

import java.io.File;

public class FileExample {

	public static void main(String[] args) {
//		C:/Users/user/Desktop/테스트/
		String path = "c:/";
		
		File file = new File(path);
		
		if(file.isDirectory()) {
//			String[] res = file.list();
			File[] res = file.listFiles();
			for(int i=0; i<res.length; i++) {
				File r = res[i];
				if(!r.isHidden()) {
					System.out.println(r.getName());
				}	
			}	
		}else {
			System.out.println("Nul");
		}
	}
}
