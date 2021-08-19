package Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class SaveTxtFile {

	public static void main(String[] args) {
		
//		C:/Users/user/Desktop/테스트
		StringBuffer sb = new StringBuffer();
		Scanner scan = new Scanner(System.in);
		
		String path = "C:/Users/user/Desktop/테스트/";
		
		System.out.println("파일 이름을 입력해주세요.");
		String save = scan.nextLine();
		
		sb.append(save);
		sb.append(".txt");
		
		save = sb.toString();
		
		File file = new File(path , ".txt");
		
				/* txt 파일로 데이터 저장하기 예제 */
		try {
			
			
			/* text.getBytes() : 문자열을 바이트 시퀀스로 인코딩이 진행된다 */
			/* 결과는 byte[] 인 encoded 에 저장된다.*/
			if (file.exists()) {
				if(file.isFile())
					System.out.println("이미 존재하는 파일입니다.");
			}else {
				
				System.out.println("새로운 파일 생성 !");
				System.out.println("경로확인 : "+path + ""+ save);
				
				StringBuffer sb2 = new StringBuffer();
				sb2.append(path).append(save);
				String res = sb2.toString();
				
				OutputStream output = new FileOutputStream(res);
				System.out.print(save + " 파일에 입력 할 내용 : ");
				
				String text = scan.nextLine();
				byte[] encoded = text.getBytes();
				System.out.println(encoded);
				output.write(encoded);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
