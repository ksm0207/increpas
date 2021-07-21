package am;

import java.util.Scanner;

public class Ex2_String {
	public static void main(String[] args) {
		 // 1. 입력한 길이를 체크하기
		
		Scanner scan = new Scanner(System.in);
	
		String str = scan.next();
		int val = str.length();

		// 2. 숫자 포함 체크
		for (int i = 0 ; i < val ; i ++) {
			
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				System.out.println("문자에 숫자가 포함되었습니다");
				break;
			} 
		}
	}
}
