package baekjoon1_for;

import java.util.Scanner;

public class Baek10871Re {
	public static void main(String[] args) {
		// 1. BaekJoon - 10871 X보다 작은 수
		// 2. 정수 N개로 이루어진 수열 A와 정수 X가 주어진다
		//    이때 A에서 X보다 작은 수를 모두 출력하는 프로그램
		// 3. 출력 : X 보다 작은 수를 입력받은 순서대로 공백으로 구분하여 출력
        //           X 보다 작은 수는 적어도 하나 존재한다.
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int X = scan.nextInt();
		
		for (int i = 0 ; i < N ; i ++) {
			int res = scan.nextInt();
			
			if (res < X) {
				System.out.println(res);
			}
		}
	}
}
