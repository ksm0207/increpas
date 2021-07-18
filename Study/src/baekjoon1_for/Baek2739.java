package baekjoon1_for;

import java.util.Scanner;

public class Baek2739 {
	public static void main(String[] args) {
		
		// 1. BaekJoon - 2739 구구단
		// 2. N을 입력받은 뒤 구구단 N단을 출력하는 프로그램
		// 3. 출력 : N * 1 부터 N * 9 까지 출력한다
		
		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();
		
		for (int i = 1 ; i <= 9 ; i ++) {
			System.out.println(val + " * " + i + " = " + val * i);
		}
	}
}
