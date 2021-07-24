package acmicpc;

import java.util.Scanner;

public class B1120 {
	public static void main(String[] args) {
		
		// 백준 1120번 문자열
		
		// 문자열 A 와 B 가 주어진다
		// A의 길이는 B의 길이보다 작거나 같다
		// 이제 A의 길이가 B의 길이가 같아질 때 까지
		// 다음과 같은 연산을 할 수 있다
		
		// (1) A 앞에 아무 알파벳을 추가한다
		// (2) A 뒤에 아무 알파벳을 추가한다
		// 이때 A와B 의 길이가 같으면서 최소로 하는 프로그램을 만들것
		
		// 출력 : A 와 B의 길이가 같으면서 차이를 최소가 되도록 할때
		//        그 차이를 출력하시오.
		
		// 입력 : abaabc aababbc

		
		Scanner scan = new Scanner(System.in);
		
		String A = scan.next();
		String B = scan.next();
		
		System.out.println(A.length() + " " + B.length());
	
	}
}
