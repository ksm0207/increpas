package am;

import java.util.Scanner;

public class Ex1_Exception {
	public static void main(String[] args){
		// ArithmeticException : 0 으로 나누려고 할 때 예외발생
		
		Scanner scan = new Scanner(System.in);
		System.out.println("입력 a : ");
		int a = scan.nextInt();
		System.out.println("입력 b : ");
		int b = scan.nextInt();
		
		try {
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			//  ( / by zero )
			System.out.println(e.getMessage());
		}
	}
}
