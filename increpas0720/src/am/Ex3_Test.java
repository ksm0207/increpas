package am;

import java.util.Random;
import java.util.Scanner;

public class Ex3_Test {
	public static void main(String[] args) {
		
		// 1. 정수를 입력받습니다
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int N = scan.nextInt();
		
		// 사용자가 입력한 값이 홀수인지 짝수인지 구별하자
		
		if (N %2 == 0) {
			System.out.println(N + " 짝수 입니다 ");
		}else {
			System.out.println(N + " 홀수 입니다");
		}
	}
}
