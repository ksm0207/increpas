package example0715;

import java.util.Scanner;

public class AscTest2 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자 -> 문자");
		System.out.print("숫자 입력 : ");
		int value;
		
		while(true) {
		   try {
				value = scan.nextInt();
				char c = (char)value;
				System.out.println(c);
	
			} catch (Exception e) {
				System.out.println(e.getMessage());
				scan = new Scanner(System.in);
			}	
		}
	}
}
