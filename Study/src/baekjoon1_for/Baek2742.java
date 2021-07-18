package baekjoon1_for;

import java.util.Scanner;

public class Baek2742 {
	
	public static void main(String[] args) {
		// 1. BaekJoon - 2742 N 찍기 (반대)
		// 2. N이 주어졌을때 1부터 N 까지 한줄에 하나씩 반대로 출력하기
		// 3. 1부터 N까지 반대로 출력
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		
		for (int i = N ; i >= 1 ; i --) {
			
			System.out.println(i);
		}
		
	}
}
