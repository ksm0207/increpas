package acmicpc;

import java.util.Scanner;

public class B9655 {
/*	
	문제
	돌 게임은 두 명이서 즐기는 재밌는 게임이다.

	탁자 위에 돌 N개가 있다. 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며,
	돌은 1개 또는 3개 가져갈 수 있다. 마지막 돌을 가져가는 사람이 게임을 이기게 된다.
	두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오.
	게임은 상근이가 먼저 시작한다.
	출력
	상근이가 게임을 이기면 SK를, 창영이가 게임을 이기면 CY을 출력한다.
*/
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		String res = "";
		int N = scan.nextInt();
	
		res = (N%2==1) ? ("SK") : ("CY");
		
		System.out.println(res);
	}
}
