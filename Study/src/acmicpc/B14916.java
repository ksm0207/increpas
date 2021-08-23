package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class B14916 {
	
	// 1. 백준 14916번 거스름돈
	
	/*
	   거스름돈이 15원이면 5원짜리 3개
	   거스름돈이 14원이면 5원짜리 2개와 2원짜리 2개로 총 4개를
	   거스름돈이 13원이면 5원짜리 1개와 2원짜리 4개로 총 5개를 주어야
	   동전의 개수가 최소가 된다.
	   
	*/
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력 : ");
		
		int input = Integer.parseInt(br.readLine());
		int save = 0 ;
		
		while(input > 0) {
			
			if(input %5 == 0) {
				input = input / 5;
				save = save + input;
				break;
			}else {
				input = input / 5;
				save ++;
				save = input + save;
			}
		}
		
		if (input < 0) {
			System.out.print(-1);
		}else {
			
			System.out.print(save);
		}
		
		
		
		
	}
}
