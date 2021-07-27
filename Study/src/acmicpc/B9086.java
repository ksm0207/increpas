package acmicpc;

import java.util.Scanner;

public class B9086 {
	
	public static void main(String[] args) {
		
		// 1. 문자열을 입력받는다
		// 2. 첫 글자와 마지막 글자를 출력한다
		Scanner scan = new Scanner(System.in);
		String input = "";
		int count = scan.nextInt();
		
		for(int i=0; i<count; i++) {
			input = scan.next();
			char ch = input.charAt(0);
			char ch2 = input.charAt(input.length()-1);
			System.out.println(ch + "" + ch2);
		}
		
	}

}
