package increpas_example0719;

import java.util.Scanner;

public class Gugudan {
	
	// 멤버변수 'x'
	int x;
	
	public void isGuguDan(int x) {
		
		// 지정된 객체 지정
		this.x = x;
		
		// 구구단 출력
		for (int i = 1 ; i <= 9 ; i ++) {
			System.out.println
			(
				this.x + " * " + i + " = " + (this.x * i)
			);
		}
	}
	public static void main(String[] args) {
		// 1. 구구단 객체 생성
		Gugudan gugudan = new Gugudan();
		// 2. 스캐너 객체 생성
		Scanner scan = new Scanner(System.in);
		// 3. 입력 문구
		System.out.print("인수 입력 : ");
		// 4. 입력
		int val = scan.nextInt();
		// 5. 변수 val --> isGugudan 메서드에 값 전달
		gugudan.isGuguDan(val);
		
		
	}
}
