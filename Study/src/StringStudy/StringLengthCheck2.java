package StringStudy;

import java.util.Scanner;

public class StringLengthCheck2 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("입력 : ");
		String name = scan.nextLine();
				               
		if (name.trim().length() == 0)
			System.out.println("빈 문자열 입니다");
		else
			System.out.println("문자열 확인 : " + name);
	}

}
