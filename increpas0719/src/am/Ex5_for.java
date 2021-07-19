package am;

import java.util.Scanner;

public class Ex5_for {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		for (int i = 65 ; i <= 69 ; i ++) {
			
			// (char)i는 i의 값을 char 형으로 형변환
			// 형변환을 하게되면 연산속도가 많아진다.
			System.out.println((char)i);
		}
		System.out.println("===========================");
		char ch = 'A';
		for (int i = 1 ; i < 6; i ++) {
			
			System.out.println(ch ++);
		}
	}
}
