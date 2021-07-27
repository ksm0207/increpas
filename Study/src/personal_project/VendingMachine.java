package personal_project;

import java.util.Scanner;

public class VendingMachine {
	
	Scanner scan = new Scanner(System.in);
	static int userMoney;
	
	
	public static void main(String[] args) {
	
		VendingMachine vm = new VendingMachine();
		System.out.println("자판기 테스트");
		while(true) {
			vm.getMenu();
		}
	} // end of main
	
	// 자판기 메뉴 호출
	public void getMenu() {
	
		System.out.println("메뉴를 선택해주세요.");

		int selectNumber;

//		while(selectNumber < 1 || selectNumber > 4) {
			System.out.println("1.커피 " + " 2.음료수 " + " 3.과자 " + "4.반환하기" + " 5.종료하기");
			try {
				selectNumber = scan.nextInt();
				// if 문 수정예정
				switch (selectNumber) {
				case 1:
					getCoffee();
					break;
				case 2:
					getDrink();
					break;
				case 3:
					getSnack();
					break;
				case 4:
					returnChangeMoney();
					break;
				case 5:
					System.out.println("감사합니다 또 이용해주세요 !");
					System.exit(selectNumber);
					break;
				default:
//						System.out.println("Default : 다시 입력해주세요.");
				}// end of switch
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("에러 : 다시 입력해주세요.");
			}
//		}// end of while


	}
	
	// 커피 메뉴 호출
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
		
		// 주문번호 입력
		System.out.println("무엇을 주문 해 볼까요?");
		System.out.print("주문번호 : ");
		int userChoies = scan.nextInt() - 1; // ( Index - 입력값 )
	
		// 사용자 가 가지고 있는 금액이 0원 일때 체크
		if (userMoney == 0) {
			System.out.println("금액을 충전하고 이용하시겠습니까?");
			System.out.println("선택한 메뉴 :"  +coffeeMenu[userChoies][0] + "\n"
							 + "필요한 금액 :"  +coffeeMenu[userChoies][1]+"원");
			
			System.out.print("Y 를누르면 계속 진행합니다.");
			
			// y 를 누르면 금액을 충전할 수 있도록 입력값 받기
			if (scan.next().equals("y")) {
				System.out.println("감사합니다 금액을 입력해주세요.");
				userMoney += scan.nextInt();
				// moneyCheck() : 사용자 금액 체크 / 선택메뉴 + 금액 계산하는 메소드
				userMoney = moneyCheck(userMoney,userChoies,coffeeMenu);
			}else {
				// y 가 아닌 경우
				System.out.println("다른 메뉴로 이동합니다.");
			}		
		}else {
			if (userMoney >= Integer.parseInt(coffeeMenu[userChoies][1])) {
				userMoney = moneyCheck(userMoney,userChoies,coffeeMenu);
				
			}else if (userMoney <= Integer.parseInt(coffeeMenu[userChoies][1])) {
				userMoney = moneyCheck(userMoney,userChoies,coffeeMenu);
			}
			
		}
		System.out.println("현재 가지고 있는 금액은 " + userMoney +" 원 입니다");
		
		return userMoney;
		
	}
	
	// 음료수 메뉴 호출
	public int getDrink() {
		System.out.println("Drink 메뉴");
		String[][] drinkMenu = {
				{"⊙ 콜라" , "750"},
				{"⊙ 환타" , "750"},
				{"⊙ 사이다" ,"750"},
				{"⊙ 코코팜" ,"1100"}
			};
		
		for(int i=0 ; i <drinkMenu.length; i ++) {
			System.out.println((i+1)+"."+drinkMenu[i][0] + "  -----------" + drinkMenu[i][1] + "원");
		}
		
		System.out.println("무엇을 주문 해 볼까요?");
		System.out.print("주문번호 : ");
		int userChoies = scan.nextInt() - 1; // Index - 입력값
	
		// 사용자 가 가지고 있는 금액이 0원 일때 체크
		if (userMoney == 0) {
			System.out.println("금액을 충전하고 이용하시겠습니까?");
			System.out.println("선택한 메뉴 :"  +drinkMenu[userChoies][0] + "\n"
							 + "필요한 금액 :" +drinkMenu[userChoies][1]+"원");
			
			System.out.print("Y 를누르면 계속 진행합니다.");
			
			// y 를 누르면 금액을 충전할 수 있도록 입력값 받기
			if (scan.next().equals("y")) {
				System.out.println("감사합니다 금액을 입력해주세요.");
				userMoney += scan.nextInt();
				// moneyCheck() : 사용자 금액 체크 / 선택메뉴 + 금액 계산하는 메소드
				userMoney = moneyCheck(userMoney,userChoies,drinkMenu);
			}else {
				// y 가 아닌 경우
				System.out.println("감사합니다.");
			}		
		}else{
			 if (userMoney >= Integer.parseInt(drinkMenu[userChoies][1])) {
				userMoney = moneyCheck(userMoney,userChoies,drinkMenu);
			 }
			 else if (userMoney <= Integer.parseInt(drinkMenu[userChoies][1])) {
					userMoney = moneyCheck(userMoney,userChoies,drinkMenu);
			 }			
			
		}
		System.out.println("현재 가지고 있는 금액은 " + userMoney +" 원 입니다");
		
		return userMoney;
	
	} // end of getDrink()
	
	// 과자 메뉴 호출
	public int getSnack() {
		
		System.out.println("Snack 메뉴");
		String[][] snackMenu = {
				{"▦ 꼬북칩 오리지날" , "2000"},
				{"▦ 꼬북칩 초코" , "2500"},
				{"▦ 새우깡" , "2000"},
				{"▦ 오징어칩" ,"2000"}
			};
		
		for(int i=0 ; i <snackMenu.length; i ++) {
			System.out.println((i+1)+"."+snackMenu[i][0] + "  -----------" + snackMenu[i][1] + "원");
		}
		
		System.out.println("무엇을 주문 해 볼까요?");
		System.out.print("주문번호 : ");
		int userChoies = scan.nextInt() - 1; // Index - 입력값
	
		// 사용자 가 가지고 있는 금액이 0원 일때 체크
		if (userMoney == 0) {
			System.out.println("금액을 충전하고 이용하시겠습니까?");
			System.out.println("선택한 메뉴 :"  +snackMenu[userChoies][0] + "\n"
							 + "필요한 금액 :" +snackMenu[userChoies][1]+"원");
			
			System.out.print("Y 를누르면 계속 진행합니다.");
			
			// y 를 누르면 금액을 충전할 수 있도록 입력값 받기
			if (scan.next().equals("y")) {
				System.out.println("감사합니다 금액을 입력해주세요.");
				userMoney += scan.nextInt();
				// moneyCheck() : 사용자 금액 체크 / 선택메뉴 + 금액 계산하는 메소드
				userMoney = moneyCheck(userMoney,userChoies,snackMenu);
			}else {
				// y 가 아닌 경우
				System.out.println("감사합니다.");
			}		
		}else {
			 if (userMoney >= Integer.parseInt(snackMenu[userChoies][1])) {
				userMoney = moneyCheck(userMoney,userChoies,snackMenu);
			 }
			 else if (userMoney <= Integer.parseInt(snackMenu[userChoies][1])) {
					userMoney = moneyCheck(userMoney,userChoies,snackMenu);
			 }	
		}
		System.out.println("현재 가지고 있는 금액은 " + userMoney +" 원 입니다");
		
		return userMoney;
	}// end of getSnack()
	
	// 금액 체크
	public int moneyCheck(int userMoney,  int userChoies , String[][] menu) {
		
		if (userMoney - Integer.parseInt(menu[userChoies][1]) >= 0) {
			userMoney = userMoney - Integer.parseInt(menu[userChoies][1]);
//			System.out.println(userMoney + " " + menu[userChoies][0]);
			System.out.println("주문하신" + menu[userChoies][0] + " 나왔습니다 감사합니다.");
		}else {
			System.out.println("잔액이 부족합니다.");
			System.out.println("부족한 금액을 채워주세요 :");
			userMoney += scan.nextInt();
			userMoney = userMoney - Integer.parseInt(menu[userChoies][1]);
			System.out.println("주문하신" + menu[userChoies][0] + " 나왔습니다 감사합니다.");
		}
		return userMoney;
	}	
	
	// 금액 반환
	public int returnChangeMoney() {
		
		int [] money = {10000,5000,1000,500,100,50,10};
		int remainMoney;
		
		if (userMoney == 0) {
			System.out.println("반환하실 금액이 없습니다.");
		}else {
			for (int i=0 ; i <money.length; i ++) {
				
				if (userMoney / money[i] > 0) {
					System.out.println(money[i] + "원 " + userMoney/money[i] + "개");
					userMoney %=money[i];
				}
			}// end of for
			remainMoney = userMoney - userMoney;
			System.out.println("자판기에 남은 돈 : " + remainMoney);
		}
		return userMoney;
	}// end of returnChangeMoney
}
