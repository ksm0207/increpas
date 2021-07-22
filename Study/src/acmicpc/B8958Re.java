package acmicpc;

import java.util.Scanner;

public class B8958Re {
	public static void main(String[] args) {
		
		// testcase : 5
		
		// 1 2 0 0 1 0 0 1 2 3 = 10
		// O O X X O X X O O O

		// 1 2 0 0 1 2 0 0 1 2 = 9
		// O O X X O O X X O O

		// 1 0 1 0 1 0 1 0 1 0 1 0 1 0 = 7
		// O X O X O X O X O X O X O X
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		
		int score = 0 , sum = 0;
		
		String [] array = new String [count];
		
		// 입력
		for (int i = 0 ; i < array.length ; i ++) {
			array[i] = scan.next();
		}
		
		// 비교
		for (int i = 0 ; i < count ; i ++) {
			
			score =0;
		    sum = 0;
			
			for (int j = 0 ; j < array[i].length() ; j ++) {
				
				if (array[i].charAt(j) == 'O') {
					score ++;
				}else {
					score = 0;
				}
				sum = sum + score;
				
			} // end of for loop (2)
			System.out.println(sum);
		}// end of for loop(1)
	}
}
