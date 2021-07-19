package personal_study;

import java.util.Scanner;

public class Args {
	
	public boolean check(String [] value) {
		boolean b = true;
		
		for (int i = 0 ; i < value.length ; i ++ ) {
	
			if (Character.isUpperCase(value[i].charAt(0))) {
				return b;
			}else if (Character.isDigit(value[i].charAt(0))) {
				return b;
			}else if (Character.isLowerCase(value[i].charAt(0))) {
				return b;
			}else {
				b = false;
			}
		}
		return b;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Args arg = new Args();
		args = new String [1];
		
		System.out.print("입력 : ");
		for (int i = 0 ; i < args.length; i ++) {
			args[i] = scan.next();
			arg.check(args);
		}
		
		for (int i = 0; i < args.length ; i ++) {
			System.out.println("'첫'대소문자 or 숫자 체크");
			System.out.println("입력 한 값 : " + args[i]);
			System.out.println("결과 : " + arg.check(args));
		}
	}
	
}