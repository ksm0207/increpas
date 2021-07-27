package personal_project2;

import java.util.Scanner;

public class Drink {
	
	public void getDrink() {
		VendingMachine vm = new VendingMachine();
		CheckMoney cm = new CheckMoney();
		
		System.out.println("Coffee 메뉴");
		String[][] drinkMenu = {
				{"⊙ 콜라" , "750"},
				{"⊙ 환타" , "750"},
				{"⊙ 사이다" ,"750"},
				{"⊙ 코코팜" ,"1100"}
			};
		
		for (int i=0 ; i<drinkMenu.length ; i ++) {
			System.out.println((i+1) +"." + drinkMenu[i][0] + " " + drinkMenu[i][1] + " 원 ");
		}
		
		System.out.println("무엇을 주문해볼까요? ");
		System.out.println("주문번호 :");
		int userChoies = vm.scan.nextInt() -1;
		
		if (vm.userMoney == 0) {
			System.out.println("선택한 메뉴 : " + drinkMenu[userChoies][0]);
			System.out.println("필요한 금액 : " + drinkMenu[userChoies][1]);
			System.out.println("y를 누르면 충전을 진행합니다.");
			
			if (vm.scan.next().equals("y")) {
				System.out.println("금액을 입력해주세요 : ");
				vm.userMoney += vm.scan.nextInt();
				System.out.println(vm.userMoney + "원 충전되었습니다");
				System.out.println(    "진행중   ");
				System.out.println(". . . . . . .");
				System.out.println(". . . . . . .");
				vm.userMoney = cm.checkItems(vm.userMoney, userChoies, drinkMenu); 
					
			}else {
				System.out.println("다른 메뉴를 선택해주세요.");
			}
		}
		else {
			if (vm.userMoney >= Integer.parseInt(drinkMenu[userChoies][1])) {
				vm.userMoney = cm.checkItems(vm.userMoney, userChoies, drinkMenu); 
				
			}else if (vm.userMoney <= Integer.parseInt(drinkMenu[userChoies][1])) {
				vm.userMoney = cm.checkItems(vm.userMoney, userChoies, drinkMenu); 
			}
		}
		System.out.println("남아있는 금액은 " + vm.userMoney + " 원 입니다 ");
	}

}
