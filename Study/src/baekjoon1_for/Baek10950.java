package baekjoon1_for;

import java.util.Scanner;

public class Baek10950 {
	public static void main(String[] args) {
		
		// 1. BaekJoon - 10950 A+B - 3
		// 2. 두 정수 A와 B를 입력받은 다음 , A+B를 출력하는 프로그램
		// 3. 출력 : 첫째 줄에 테스트 케이스 개수 T 만큼 출력한다
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		int A;
		int [] sum = new int [T];
		
		for (int i = 0 ; i < T ; i ++) {
			A = scan.nextInt();
			sum[i] = scan.nextInt();
			sum[i] =  sum[i] + A;
		}
		
		for (int res : sum) {
			System.out.println(res);
		}
	}
}
