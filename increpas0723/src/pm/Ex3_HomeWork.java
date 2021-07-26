package pm;

import java.util.Scanner;

public class Ex3_HomeWork {
	
	// 정수를 하나 받는다, 화면에 해당 구구단을 출력하는
	// 동작을 만드세요
	public void gugudan(int value) {
		
		for (int i = 1 ; i <= 9 ; i ++) {
			System.out.print( value + " * " + i + " = " + String.format("%2d", value * i));
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		// 키보드로 부터 숫자 하나를 입력받는다(구구단)
		
		Scanner scan = new Scanner(System.in);
		Ex3_HomeWork ex3 = new Ex3_HomeWork();
		
		int value = scan.nextInt();
		
		ex3.gugudan(value);
	}
}
