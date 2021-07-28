package example;

import java.util.Scanner;

public class VendingMachine{
	public static void main(String[] args) {
		
		// 자판기 객체
		VendingMachine vm = new VendingMachine();
		// 입력 객체
		Scanner scan = new Scanner(System.in);
		// 금액 확인 체크 후 아이템 반환 하는 메소드
		MoneyCheck money_check = new MoneyCheck();
		// 전액 반환 해주는 메소드
		ReturnMoney rt_money = new ReturnMoney();
		
		// 메뉴 호출
		Menu [] menu = vm.start();
		
		int userMoney = 0;
		System.out.println("무엇을 주문하시겠습니까 ?");
		System.out.print("주문 번호 : ");
		while(true){
			try {
				int userChoies = scan.nextInt() -1;
				if (userMoney == 0) {
					System.out.println("선택한 메뉴 : " + menu[userChoies].getMenu());
					System.out.println("필요한 금액 : " + menu[userChoies].getPrice());
					
					System.out.println("금액을 충전해주세요.");
					userMoney = scan.nextInt();
					userMoney = money_check.checkItems(userMoney, userChoies, menu);
				}
				System.out.println("현재 가지고 있는 금액은 " + userMoney + " 원 입니다");
				
				if(userMoney > 0)
					System.out.println("전액 반환 을 하시려면 5번을 눌러주세요");
					userChoies = scan.nextInt();		
					rt_money.returnChangeMoney(userMoney);
			}catch (Exception e) {
					System.out.println("다시 입력해주세요.");
					scan = new Scanner(System.in);
			}
		}
	}
	public Menu[] start() {
		
		Menu[] menu = new Menu[4];
		System.out.println("자판기 테스트 !! ");
		for (int i = 0 ; i < menu.length ; i ++) {
			menu[i] = new Menu();
			
			switch (i) {
			case 0:
				menu[i].setMenu("레쓰비");
				menu[i].setPrice(600);
				break;
			case 1:
				menu[i].setMenu("사이다");
				menu[i].setPrice(700);
				break;
			case 2:
				menu[i].setMenu("콜라");
				menu[i].setPrice(700);
				break;
			case 3:
				menu[i].setMenu("게토레이");
				menu[i].setPrice(900);
				break;
			}
			System.out.println( (i+1) +"." +menu[i].getMenu() + "  " +  menu[i].getPrice());
		} // end of for(1)
		return menu;
	}
}	

