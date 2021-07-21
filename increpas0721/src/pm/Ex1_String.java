package pm;

import java.util.Scanner;

public class Ex1_String {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("입력 : ");
		String msg = scan.nextLine();
		String res = "";
		
		int len = msg.length();
		int count = 0;
		
		for (int i = 0 ; i < len ; i ++) {
			// msg 의 문자열 중에서 i 가 기억하는 숫자를
			// index로 사용하여 msg의 문자를 하나씩 가져온다
			
			char ch = msg.charAt(i);
			
			if (ch >= '0' && ch <= '9') {
				count ++;
			}
//			System.out.println(ch);
		}
		System.out.println(count);
		String str = "01-abc123-한글1234";
		String restr = str.replaceAll("[^0-9]","");
		;

		
	}
}
