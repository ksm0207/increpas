package example0715;

import java.util.Scanner;

public class AscTest {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("문자 -> 숫자 바꾸기");
		System.out.println("Input : ");
		
		char value = scan.next().charAt(0);
		int change = value;
		
		System.out.println(change);
	}
}
