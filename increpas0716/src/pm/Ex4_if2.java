package pm;

import java.util.Scanner;

public class Ex4_if2 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		// a = 10;
		int a;
		int point = 0;
		
		System.out.print("입력 : ");
		while (true) {
			try {
				 a = scan.nextInt();
				if (a >= 10) {
					System.out.println("매우높음");
				}else if (a >= 8) {
					System.out.print("높음");
				}else if (a >= 4) {
					System.out.println("중간");
				}
				else {
					System.out.println("낮음");
				}
				point ++;
				if (point == 4) {
					System.out.println("Exit");
					break;
				}
			} catch (Exception e) {
				System.out.println("문자 혹은 특수문자가 포함되었습니다");
				scan = new Scanner(System.in);
			}
		}
	}
}
