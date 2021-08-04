package acmicpc;

import java.util.Scanner;
import java.util.Stack;

public class B10773 {
	public static void main(String[] args) {
		
		Stack<Integer> stack = new  Stack<Integer>();
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		int count = scan.nextInt();
		int input;
	
		for(int i=0; i<count; i++) {
			
			input = scan.nextInt();
		
			if (input == 0) {
				stack.pop();
			}else {
				stack.push(input);
			}
			
		}// end of for loop(1)
		
		for (int res : stack) {
			sum += res;
			
		}
		System.out.println(sum);
	}
}
