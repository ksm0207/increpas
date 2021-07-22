package acmicpc;

import java.util.Scanner;

public class B8958 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int count = scan.nextInt();
		String [] arr = new String [count];
		
		
		int sum , score;
		
		
		for (int i = 0 ; i < arr.length; i ++) {
			arr[i] = scan.next();
		}	
		
		for (int i = 0 ; i < count; i ++) {

			score = 0;
			sum = 0;
			
			for (int j = 0 ; j < arr[i].length() ; j ++) {
				
//				System.out.println("length   : " +arr.length);
//				System.out.println("length() : " +arr[i].length());
//				
				if (arr[i].charAt(i) == 'O') {
					score ++;
				}else {
					score = 0;
				}
				sum = sum + score;
			}// end of for loop(2)
			
			System.out.println("Sum =====> "+sum);
			
		} // end of for loop (1)
	}
}
// 1 2 0 0 1 0 0 1 2 3 = 10
// O O X X O X X O O O

// 1 2 0 0 1 2 0 0 1 2 = 9
// O O X X O O X X O O

// 1 0 1 0 1 0 1 0 1 0 1 0 1 0 = 7
// O X O X O X O X O X O X O X



