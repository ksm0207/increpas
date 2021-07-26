package pm;

import java.util.Scanner;

public class Ex5_HomeWork {
	public static void main(String[] args) {
		
		Ex5_HomeWork ex5 = new Ex5_HomeWork();
		
		int [] rand = ex5.getRandomValue();
		boolean gameResult = true;

		System.out.println("숫자 야구 게임 입니다.");
		
		do {
			gameResult = ex5.getGameResult(rand);
	
			if(gameResult != true) {
				System.out.println("다시 입력 하세요\n");
			}
		} while (gameResult != true);
	}

	
	public int[] getRandomValue() {
		
		boolean flag;
		int [] randomComputer = new int [3];
		
		for (int i = 0 ; i < randomComputer.length ;) {
			flag = true;
			randomComputer[i] = (int)(Math.random()* 9)+1;
			for (int j = 0 ; j < i ; j ++) {
				if (randomComputer[i] == randomComputer[j]) {
					
//					System.out.println("중복값 발생 : " + randomComputer[i] + " " + randomComputer[j]);
					flag = false;
					break;
				} // end of for loop(2)
			}
			if (flag) {
				i ++;
			}
		}// end of for loop (1)
		return randomComputer;
	}
	
	public boolean getGameResult(int [] com) {
		
		int [] user = new int [3]; // 유저
		int strike = 0; // 스트라이크
		int ball = 0;   // 볼
		
		user = checkInputValue();
		
		for (int i = 0 ; i <= 2 ; i ++) {
			for (int j = 0 ; j <= 2 ; j++) {
				if (i == j) {
					
					if (user[i] == com[j]) {
						strike ++;
						}
				}else {
					if(user[i] == com[j])
						ball++;
				}
			}// end of for loop(2)
		}// end of for loop (1)
		
		System.out.print("사용자 입력 값 : ");
		for (int  i = 0 ; i < user.length ; i ++) {
			System.out.printf("%-3d",user[i]);
			
		}
//		System.out.print("컴퓨터 랜덤 값 : ");
//		for(int i = 0 ; i < com.length; i ++) {
//			System.out.printf("%-3d" ,  com[i]);
//		}
		System.out.println();
		System.out.print("게임결과 : " +strike + " 스트라이크 " + ball + " 볼 입니다. \n");
		
		return strike == 3;
	}

	public int[] checkInputValue() {
		
		Scanner scan = new Scanner(System.in);
		int[] userValue = new int[3];
		
		
		System.out.println("1 ~ 9 까지 의 숫자를 입력하세요 ");
		for (int i = 0 ; i < userValue.length ; i ++) {
			
			while(userValue[i] < 1 || userValue[i] > 9) {
				
				try {
					userValue[i] = scan.nextInt();
					if (userValue[i] < 1) {
						System.out.println("1 보다 작은 수는 입력할 수 없습니다.");
						System.out.println("다시 입력하세요");
					}else if (userValue[i] > 9) {
						System.out.println("9 보다 큰 수는 입력할 수 없습니다");
						System.out.println("다시 입력하세요.");
					}// end of if else	
				} catch (Exception e) {
					while(true) {
					    scan = new Scanner(System.in);
						System.out.println("문자 및 특수기호 가 포함되었습니다");
						System.out.println("다시 입력하세요.");
						break;
					}
				}
			} // end of while
			System.out.println( (i+1) + " 번째 입력 값 : " + userValue[i]);				
		}
		return userValue;
	}
}

