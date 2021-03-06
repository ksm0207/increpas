package personal_project3;

import java.util.Scanner;

public class RPS {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("게임을 진행하기 위한 코인을 넣어주세요 :");
		
		
		String computer = ""; //    컴퓨터 가위 바위 보 저장
		String user = "";     //    사용자 가위 바위 보 저장
		int userWin = 0;      //    사용자 승리
		int comWin = 0;       //    컴퓨터 승리
		int draw = 0;         //    무승부
		int invalid = 0;      //    에러입력 으로 인한 무효
		int fail = 0;         //    패배
		int count =0;         //    게임카운트
		int comRandom = 0;    //    컴퓨터 랜덤 값
		int userSelect = 0;   //    사용자 입력 값
		
		int coin = scan.nextInt();
		if (coin > 20) {
			System.out.println("1 ~ 20 코인을 입력 해 주세요!");
			return ;
		}else {
			System.out.println("컴퓨터가 랜덤값을 받았습니다.");
			System.out.println("사용자 입력 : "+"1. 가위 " + "2. 바위 " + "3. 보");
			for (int i=0; i<coin ; i++) {
				comRandom = (int)(Math.random()* 3+1);
				switch (comRandom) {
				case 1:
					computer = "가위";
					break;
				case 2:
					computer = "바위";
					break;
				case 3:
					computer = "보";
					break;
				}
				userSelect = scan.nextInt();
				
				switch (userSelect) {
				case 1:
					user = "가위";
					break;
				case 2:
					user = "바위";
					break;
				case 3:
					user = "보";
					break;
				}
				// 사용자 승리조건
				// 가위 : 보
				// 바위 : 가위
				// 보 : 바위
				if (userSelect >= 4) {
					System.out.println("유효하지 않은 값 입니다");
					invalid++;
					System.out.println("에러 입력 : " +invalid + "회 이번 라운드는 무효처리 됩니다 ");
				}else {
					if (userSelect == 1 && comRandom == 3 ||
							userSelect == 2 && comRandom == 1 ||
							userSelect == 3 && comRandom == 2) {
							System.out.println("Winner !");
							userWin ++;
						}else if (userSelect == comRandom) {
							System.out.println("Draw ...");
							draw ++;
						}else {
							fail ++;
							comWin++;
							System.out.println("Fail ...");
						}
					System.out.println("사용자 : " + user + " || " +"컴퓨터 : " + computer);
				}
				count ++;
				if (count == coin) {
					System.out.println("게임 종료 !");
					System.out.println("승률 계산중 ...");
					break;
				}
			}// end of for loop(1)
		}// end of if - else (1)
		float res = ((float)userWin/(float)(coin))*100;
		res = Math.round(res);
		
		System.out.println("게임 횟수 : " + coin + " 회 ");
		System.out.println("사용자 승리 횟수 : " + userWin + " 회 ");
		System.out.println("사용자 패배 횟수 : " + fail + " 회 ");
		System.out.println("컴퓨터 승리 횟수 : " + comWin + " 회 ");
		System.out.println("Draw 횟수 : " + draw + " 회 ");
		System.out.println("에러 횟수 : " + invalid + " 회 ");
		System.out.println("승률 : " +  res);
	}
}
