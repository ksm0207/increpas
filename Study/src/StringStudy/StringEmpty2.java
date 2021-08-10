package StringStudy;

import java.util.Scanner;

public class StringEmpty2 {
	
	public static void main(String[] args) {
		
		/* trim() + isEmpty */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("입력 : ");
		String name = scan.nextLine();

		if (isCheck(name))
			System.out.println("Null 혹은 공백이 포함되었습니다.");
		else
			System.out.println("문자열 확인 : " + name);
		
	}
	
	public static boolean isCheck(String str) {
		
		return str == null || str.trim().isEmpty();
	}

}
