package pm;

import java.util.Scanner;

public class Ex3_dowhile_G {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("입력 : ");
		
		int i = 1;
		
		int dan = scan.nextInt();
		
		do {
			System.out.println(dan + " * "+ (i) + " = " + (dan * i));
			i ++;
		} while (i <= 9);
	}
}
