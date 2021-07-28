package example;

import java.util.Scanner;

public class MoneyCheck {
	
	// 금액 확인 후 아이템 반환 메소드
	public int checkItems(int money , int userChoies , Menu[] menu) {
		
		Scanner scan = new Scanner(System.in);
		
		if ((money - menu[userChoies].getPrice()) >= 0) {
			money = money - menu[userChoies].getPrice();
			System.out.println("주문하신 " + menu[userChoies].getMenu() + " 나왔습니다 감사합니다 !");
		}else {
			System.out.println("잔액이 부족합니다");
			System.out.println("부족한 금액을 채워주세요 :");
			money += scan.nextInt();
			money = money - menu[userChoies].getPrice();
			System.out.println("주문하신 " + menu[userChoies].getMenu() + " 나왔습니다 감사합니다.");
		} 
		return money;
	}
}
