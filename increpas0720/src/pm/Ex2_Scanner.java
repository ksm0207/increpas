package pm;

import java.util.Scanner;

public class Ex2_Scanner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("입력 : ");
		String n = scan.nextLine();
		
		// next() : 엔터키 바로 전까지를 받음
	
		
		System.out.print("입력2 : ");
		String n2 = scan.nextLine(); // 엔터키
//		String n3 = scan.nextLine(); // 반가워
		
		System.out.println(n + ", " + n2);
		
		 
	}
}
