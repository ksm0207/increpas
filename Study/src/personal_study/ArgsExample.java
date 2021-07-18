package personal_study;

import java.util.Scanner;

public class ArgsExample {
	
	public void checkFirstCharacter(String [] check) {
		for (int j = 0 ; j < check.length ; j ++) {
			if (Character.isUpperCase(check[j].charAt(0))) {
				System.out.println("첫 문자가 대문자 입니다 : " +check[j]);
			}else if (Character.isDigit(check[j].charAt(0))) {
				System.out.println("첫 문자가 숫자 입니다 :  " + check[j]);
			}else if (Character.isLowerCase(check[j].charAt(0))) {
				System.out.println("첫 문자가 소문자 입니다 : " +check[j]);
			}
			else {
				System.out.println(check[j] + " 유효하지 못한 값");
			}
		}
}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArgsExample arg = new ArgsExample();
		args = new String[1];

		for (int i = 0 ; i < args.length; i ++) {
			args[i] = scan.next();
			arg.checkFirstCharacter(args);
		}
	}
}