package personal_project2;

import java.util.Scanner;

public class Coffee {
	
	public void getCoffee() {
		
		VendingMachine vm = new VendingMachine();
		CheckMoney cm = new CheckMoney();
		
		System.out.println("Coffee 메뉴");
		String [][] coffeeMenu = {
				{"♨ 디카페인 오리지날" , "2000"},
				{"♨ 아메리카노" , "2500"},
				{"♨ 카페 라떼" , "3000"},
				{"♨ 바닐라 라떼" , "3500"}
			};
		
		for (int i=0 ; i<coffeeMenu.length ; i ++) {
			System.out.println((i+1) +"." + coffeeMenu[i][0] + " " + coffeeMenu[i][1] + " 원 ");
		}
		
		System.out.println("무엇을 주문해볼까요? ");
		System.out.println("주문번호 :");
		int userChoies = vm.scan.nextInt() -1;
		
		if (vm.userMoney == 0) {
			System.out.println("선택한 메뉴 : " + coffeeMenu[userChoies][0]);
			System.out.println("필요한 금액 : " + coffeeMenu[userChoies][1]);
			System.out.println("y를 누르면 충전을 진행합니다.");
			
			if (vm.scan.next().equals("y")) {
				System.out.println("금액을 입력해주세요 : ");
				vm.userMoney += vm.scan.nextInt();
				System.out.println(vm.userMoney + "원 충전되었습니다");
				System.out.println(    "진행중   ");
				System.out.println(". . . . . . .");
				System.out.println(". . . . . . .");
				vm.userMoney = cm.checkItems(vm.userMoney, userChoies, coffeeMenu); 
					
			}else {
				System.out.println("다른 메뉴를 선택해주세요.");
			}
		}
		else {
			if (vm.userMoney >= Integer.parseInt(coffeeMenu[userChoies][1])) {
				vm.userMoney = cm.checkItems(vm.userMoney, userChoies, coffeeMenu); 
				
			}else if (vm.userMoney <= Integer.parseInt(coffeeMenu[userChoies][1])) {
				vm.userMoney = cm.checkItems(vm.userMoney, userChoies, coffeeMenu); 
			}
		}
		System.out.println("남아있는 금액은 " + vm.userMoney + " 원 입니다 ");
	}
	
}
