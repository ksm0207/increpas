package am;

import java.util.Scanner;

public class Ex4_for {
	public static void main(String[] args) {
		
		// 1. 구구단 
		
		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();
		
		for (int i = 1 ; i <= 9 ; i ++ ) {
			System.out.println(val + " * " + i + " = " + (val * i));
		}

	}
}
