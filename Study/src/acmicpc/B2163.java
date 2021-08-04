package acmicpc;

import java.util.Scanner;

public class B2163 {
	public static void main(String[] args) {
		// 1. N * M 크기의 초콜릿
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		System.out.println( (N * M) - (1*1) );
	}
}
