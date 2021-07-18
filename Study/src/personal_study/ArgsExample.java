package personal_study;

import java.util.Scanner;

public class ArgsExample {
	
	public String checkFirstCharacter(String [] check) {
		
		for (int j = 0 ; j < check.length ; j ++) {
			if (Character.isUpperCase(check[j].charAt(0))) {
				check[j] = "첫 문자가 대문자 입니다";
			}else if (Character.isDigit(check[j].charAt(0))) {
				check[j] = "첫 문자가 숫자 입니다";
			}else if (Character.isLowerCase(check[j].charAt(0))) {
				check[j] = "첫 문자가 소문자 입니다";
			}
			else {
				check[j] = "유효하지 못한 값";
			}
			return check[j];
		}
		return null;
		
}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArgsExample arg = new ArgsExample();
		args = new String[1];

		for (int i = 0 ; i < args.length; i ++) {
			args[i] = scan.next();
			arg.checkFirstCharacter(args);
		}
		
		for (int j = 0; j < args.length ; j ++) {
			System.out.println(args[j]);
		}
	}
}