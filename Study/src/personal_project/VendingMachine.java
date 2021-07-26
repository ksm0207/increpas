package personal_project;

import java.util.Scanner;

public class VendingMachine {
	
	Scanner scan = new Scanner(System.in);
	static int userMoney;
	
	
	public static void main(String[] args) {
		
		VendingMachine vm = new VendingMachine();
		
		while(true) {
			vm.getMenuCheck();
		}

	} // end of main
	
	
	public void getMenuCheck() {
		System.out.println("자판기 테스트");
		System.out.println("메뉴를 선택해주세요.");
		String[] menu = new String[3];
		
		int selectNumber = 0;
		
		for (int i=0; i<menu.length; i ++) {
			
			while(selectNumber < 1 || selectNumber > 4) {
				System.out.println("1.커피 " + " 2.음료수 " + " 3.과자 " + "4.종료하기");
				try {
					selectNumber = scan.nextInt();
					// if 문 수정예정
					switch (selectNumber) {
					case 1:
						getCoffee();
						break;
					case 2:
						System.out.println("2번 메소드 호출");
						break;
					case 3:
						System.out.println("3번 메소드 호출");
						break;
//					default:
//						
//						System.out.println("Default : 다시 입력해주세요.");
					
					}// end of switch
				} catch (Exception e) {
					scan = new Scanner(System.in);
					System.out.println("Catch : 다시 입력해주세요.");
				}
			}// end of while
		}

	}
	
	public int getCoffee() {
		
		System.out.println("Coffee 메뉴");
		String[][] coffeeMenu = {
				{"♨ 디카페인 오리지날" , "2000"},
				{"♨ 아메리카노" , "2500"},
				{"♨ 카페 라떼" , "3000"},
				{"♨ 바닐라 라떼" , "3500"}
			};
		
		for(int i=0 ; i <coffeeMenu.length; i ++) {
			System.out.println((i+1)+"."+coffeeMenu[i][0] + "  -----------" + coffeeMenu[i][1] + "원");
		}
		
		System.out.println("무엇을 주문 해 볼까요?");
		System.out.print("주문번호 : ");
		int userChoies = scan.nextInt() - 1;
	
		if (userMoney == 0) {
			System.out.println("금액을 충전하고 이용하시겠습니까?");
			System.out.println("선택한 메뉴 :"  +coffeeMenu[userChoies][0] + "\n"
							 + "필요한 금액 :" +coffeeMenu[userChoies][1]+"원");
			
			System.out.print("Y 를누르면 계속 진행합니다.");
			
			if (scan.next().equals("y")) {
				System.out.println("감사합니다 금액을 입력해주세요.");
				userMoney += scan.nextInt();
				userMoney = check(userMoney,userChoies,coffeeMenu);
			}else {
				System.out.println("감사합니다.");
			}		
		}else {
			userMoney = check(userMoney,userChoies,coffeeMenu);
		}
		System.out.println("현재 가지고 있는 금액은 " + userMoney +" 원 입니다");
		
		return userMoney;
		
	}
	public int check(int userMoney,  int userChoies , String[][] menu) {
		
		if (userMoney - Integer.parseInt(menu[userChoies][1]) >= 0) {
			
			userMoney = userMoney - Integer.parseInt(menu[userChoies][1]);
//			System.out.println(userMoney + " " + menu[userChoies][0]);
			System.out.println("주문하신 메뉴가 나왔습니다 감사합니다.");
		}else {
			System.out.println("잔액이 부족합니다.");
			
		}
		return userMoney;
	}	
	
}
