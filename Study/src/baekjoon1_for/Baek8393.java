package baekjoon1_for;

import java.util.Scanner;

public class Baek8393 {
	public static void main(String[] args) {
		
		// 1. BaekJoon - 8393 합
		// 2. N이 주어졌을때 1부터 N 까지의 합을 구하는 프로그램
		// 3. 1부터 N까지 합을 출력
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int sum = 0;
		
		for (int i = 0 ; i <= N ; i ++) {
			sum = sum + i;
		}
		System.out.println(sum);
	}
}
