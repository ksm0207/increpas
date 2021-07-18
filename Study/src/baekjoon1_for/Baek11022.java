package baekjoon1_for;

import java.util.Scanner;

public class Baek11022 {
	
	public static void main(String[] args) {
		// 1. BaekJoon - 11022 A+B - 8
		// 2. 두 정수 A와 B를 입력받은 다음 , A+B를 출력하는 프로그램
		// 3. 출력 :  "Case #x: A + B = C" 형식으로 출력한다. x는 테스트 케이스 번호
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for (int i = 0 ; i < T ; i ++) {
			int A = scan.nextInt();
			int B = scan.nextInt();
			
			System.out.println("Case #"+(i+1)+": " + (A) + " + " + (B) +  " = " + (A + B));
		}
	}
}
