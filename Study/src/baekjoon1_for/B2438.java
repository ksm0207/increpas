package baekjoon1_for;

import java.util.Scanner;

public class B2438 {
	public static void main(String[] args) {
		// 1. BaekJoon - 2438 별찍기 1
		// 2. 첫째 줄 별 1개 둘째 줄 별 2개 N번째 줄에는 별 N개를 찍자
		// 3. 출력 : 첫째 줄에 테스트 케이스 개수 T 만큼 출력한다
		
		Scanner scan = new Scanner(System.in);
		
		int star = scan.nextInt();
		
		for (int i = 0 ; i < star ; i ++) {
			for (int j = 0 ; j <= i ; j ++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
