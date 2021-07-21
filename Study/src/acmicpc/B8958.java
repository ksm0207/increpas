package acmicpc;

import java.util.Scanner;



public class B8958 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		String [] arr = new String [count];
		
		for (int i = 0 ; i < arr.length; i ++) {
			arr[i] = scan.next();
		}

		int score = 0;
		for (int i = 0 ; i < arr.length; i ++) {
			System.out.println(arr[i]);
			
			if (arr[i].charAt(i) == 'O') {
				score ++;
				System.out.println(score);
			}
		}
		

	}
}
