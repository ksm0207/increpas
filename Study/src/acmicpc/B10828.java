package acmicpc;

import java.util.Scanner;
import java.util.Stack;

public class B10828 {
	public static void main(String[] args) {
		// 1. 백준 10828번 -  스택
		
		// Stack 명령어
		// 1. push X : 정수 X를 스택에 넣는 연산
		// 2. pop : 스택에서 가장 위에 있는 정수를 빼고 수를 출력 만약 없을 경우 -1을 반환
		// 3. size : 스택에 들어있는 정수의 개수 출력
		// 4. empty : 스택이 비어있으면 1 아니면 0을 출력
		// 5. top : 스택의 가장 위에 있는 정수를 출력 만약 없으면 -1을 출력
		
		Stack<Integer> stack = new Stack<Integer>();
		Scanner scan = new Scanner(System.in);
		
		int start = scan.nextInt();
		int res = 0;
		int push;
		String str = "";
		
		
		for(int i=0; i<start; i++) {
			str = scan.next();
			if (str.equals("pop")) {
				res = (str.equals("pop")) ? (-1) : (stack.pop());
				System.out.println(res);
			}else if (str.equals("top")) {
				res = (str.equals("top")) ? (-1) : (stack.pop());
				System.out.println(res);
			}else if (str.equals("push")) {
				push = scan.nextInt();
				res = (str.equals("push")) ? (stack.push(push)) : (-1);
				System.out.println(res);
			}else {
				System.out.println(res);
			}
		}
	}
}
