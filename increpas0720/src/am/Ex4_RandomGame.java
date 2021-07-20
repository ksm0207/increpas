package am;


import java.util.Scanner;

public class Ex4_RandomGame {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 컴퓨터가 1 ~ 10까지의 수들중 하나만 가진다
		// 시작값을 더해줘야 0이 안나오고 표현하고자 하는 범위가 나온다
	
		// Math.random() 범위 + 시작수)
		int n = (int)(Math.random()*100)+1;
		// 2로 나눴을때 나머지 값을 res에 저장
		int res = (n % 2);
		System.out.println("홀수 1 || 짝수 0");
		// 사용자 입력
		int cmd = scan.nextInt();
		
		switch (cmd) {
		case 1:
		case 0:	
			if (cmd == res) {
				System.out.println("정답입니다 !");
			}else {
				System.out.println("틀렸습니다 !");
			}
			break;

		default:
			System.out.println("잘못 입력 했습니다");
		
		}
		
	}
}
