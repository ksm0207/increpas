package personal_project2;

import java.util.Scanner;

public class CheckMoney {
	
	public int checkItems(int userMoney , int userChoies , String[][] menu) {
		Scanner scan = new Scanner(System.in);
		
		if ((userMoney - Integer.parseInt(menu[userChoies][1])) >= 0) {
			userMoney = userMoney - Integer.parseInt(menu[userChoies][1]);
			System.out.println("주문하신 " + menu[userChoies][0] + " 나왔습니다 감사합니다 !");
		}else {
			System.out.println("잔액이 부족합니다");
			System.out.println("부족한 금액을 채워주세요 :");
			userMoney += scan.nextInt();
			userMoney = userMoney - Integer.parseInt(menu[userChoies][1]);
			System.out.println("주문하신" + menu[userChoies][0] + " 나왔습니다 감사합니다.");
		} 
		return userMoney;
	}
}
