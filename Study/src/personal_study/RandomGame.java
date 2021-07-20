package personal_study;

import java.util.Scanner;

public class RandomGame {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String res = "";
		// 1. 컴퓨터가 임의의 숫자를 가진다 1 ~ 100
		// 2. 3의 배수를 맞추기
		
		int rand = (int)(Math.random()*100)+1;
		int user = 0;
		
		System.out.println("[1] [2] [3] 숫자를 입력하세요 : ");
			try {
				user = scan.nextInt();
				switch (user) {
				case 1:
				case 2:
				case 3:
					res = ( (user %3) ==  (rand % 3) ) ? ("컴퓨터 값 : " + rand + " 정답입니다 ! ") :
						                                 ("컴퓨터 값 : " + rand + " 틀렸습니다 ! ");
					break;
				default:
					System.out.println("1~3 번호를 입력해주세요");
				}
				System.out.println(res);
			}catch (Exception error) {
				System.out.println("문자 혹은 기호가 포함 되었습니다.");
				
			}
	}
}
