package am;

import java.util.Scanner;

public class Ex2_String2 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String s = scan.next();

		for (int i = 0 ; i < s.length() ; i ++) {
			if (s.matches(".*[0-9].*")) {
				System.out.println("입력한 길이 :" + s.length());
				System.out.println("숫자가 포함되었습니다");
				break;
			}else {
				System.out.println("입력한 길이 :" + s.length());
				System.out.println("숫자가 포함되지 않았습니다");
				break;
			}
		}
	}
}
