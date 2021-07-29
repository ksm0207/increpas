package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class B2752 {
	
	public static void main(String[] args) {
		
		// 1. 숫자 세개를 오름차순으로 정렬한다
		// 가장 작은수 그다음 수 가장 큰 수를 출력하자
		
		Scanner scan = new Scanner(System.in);
		
		int[] array = new int [3];
		
		for (int i=0; i<array.length; i++) {
			array[i] = scan.nextInt();
		}
		Arrays.sort(array);
		
		for (int res : array) {
			System.out.println(res);
		}
	}

}
