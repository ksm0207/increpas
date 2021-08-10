package acmicpc;

import java.util.Scanner;

public class B10988 {
	
	public static void main(String[] args) {
		
		// 0. 백준 10988 - 팰린드롬인지 확인하기
		
	   /* 1. 알파벳 소문자로만 이루어진 단어가 주어진다.
		 주어진 단어가 팰린드롬인지 확인하는 프로그램을 만든다.
	     팰린드롬 이란 ? : 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 뜻한다.*/
	
		Scanner scan = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		/* 입력 */
		System.out.print("입력 : ");
		String input = scan.next(); // level
		
		sb.append(input).reverse(); 
		String res = sb.toString();
		
		
		// 팰린드롬 체크.
		if(input.equals(res)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}
