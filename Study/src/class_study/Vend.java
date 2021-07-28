package class_study;

import java.util.Scanner;

class VariousItems {
	
	private String name;
	private int price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

public class Vend {
	
	VariousItems[] items = new VariousItems[8];
	
	public int getChangeMoney(int userMoney) {
		
		int [] money = {10000,5000,1000,500,100,50,10,1};
		
		if (userMoney != 0) {
			for (int i=0 ; i <money.length; i ++) {
				if (userMoney / money[i] > 0)
					System.out.println(money[i] + "원 " + userMoney/money[i] + "개 반환하였습니다.");
					userMoney %=money[i];
			}// end of for
			
		}
		userMoney = userMoney - userMoney;
		System.out.println("자판기 금액  : " + userMoney);
		
		return userMoney;			
	}// end of getChangeMoney

	public void getVariousItemsInit() {
		for (int i=0; i < items.length; i++) {
			items[i] = new VariousItems();
			switch (i) {
			case 0:
				items[i].setName("오징어칩");
				items[i].setPrice(2000);
				break;
			case 1:
				items[i].setName("꼬북칩 오리지날");
				items[i].setPrice(2200);
				break;
			case 2:
				items[i].setName("꼬북칩 초코맛");
				items[i].setPrice(2200);
				break;
			case 3:
				items[i].setName("포카칩");
				items[i].setPrice(2500);
				break;	
			case 4:
				items[i].setName("포카리스웨트");
				items[i].setPrice(1500);
				break;
			case 5:
				items[i].setName("코카콜라");
				items[i].setPrice(750);
				break;
			case 6:
				items[i].setName("스프라이트");
				items[i].setPrice(750);
				break;
			case 7:
				items[i].setName("핫식스");
				items[i].setPrice(1500);
				break;
			}// end of switch
		}// end of for loop(1)
	}// end of getVariousItemsInit
	
	public void getVariousItems(int money) {
		Scanner scan = new Scanner(System.in);
		
		for (int i=0; i<items.length; i++) {
			if (money > items[i].getPrice()) {
				System.out.printf("%8d.%s:%d원",
						i+1, items[i].getName(), items[i].getPrice());
//				System.out.println((i+1)+ "." + items[i].getName() + " " + items[i].getPrice());
				if (i == 3) {
					System.out.println();
				}
			}
		}// end of for loop(1)
		System.out.println();
	} // end of getVariousItems
	
	public int getReturnItme(int userChoies , int money) {
		
		Scanner scan = new Scanner(System.in);
	
		if (money >= items[userChoies].getPrice()) {
			System.out.println("주문하신 " +items[userChoies].getName() + " 나왔습니다 감사합니다.");
			money = money - items[userChoies].getPrice();
			System.out.println("남아있는 잔액은 " + money + " 원 입니다");
		}else {
			if (money < items[userChoies].getPrice()) {
				System.out.println("잔액이 부족합니다");
				System.out.println("금액을 더 충전해주세요.");
				money += scan.nextInt();
				System.out.println("주문하신 " +items[userChoies].getName() + " 나왔습니다 감사합니다.");
				money = money - items[userChoies].getPrice();
				System.out.println("남아있는 잔액은 " + money + " 원 입니다");
			}
		}
		return money;
	}// end of getReturnItme
	
	public static void main(String[] args) {
		Vend vend = new Vend();
		vend.getVariousItemsInit();
		Scanner scan = new Scanner(System.in);
		
		int getUserMoney =0;
		int userChoies = 0;
		
		
		System.out.print("돈을 입력하세요 :");
		getUserMoney += scan.nextInt();
		vend.getVariousItems(getUserMoney);
		
		System.out.println("가지고 있는 금액 : " + getUserMoney);
		System.out.print("선택 :");
	
		userChoies = scan.nextInt() -1;
		getUserMoney = vend.getReturnItme(userChoies, getUserMoney);
		
		while(true) {
			if (getUserMoney > 0) {
				System.out.println("추가 구매를 하시겠습니까? (y)(n)");
				if (scan.next().equals("y")) {
					System.out.print("선택 : ");
					userChoies = scan.nextInt() -1;
					getUserMoney = vend.getReturnItme(userChoies, getUserMoney);
				}else {
					System.out.println("남은 금액을 반환 하시겠습니까? (y)(n)");
					if(scan.next().equals("y")) {
						getUserMoney = vend.getChangeMoney(getUserMoney);
						break;
					}
				}
			}else {
				if (getUserMoney == 0) {
					System.out.println();
					System.out.println("현재 잔액이" + getUserMoney + " 원 입니다");
					System.out.println("금액을 더 충전할까요 ? (y) (n)");
					if (scan.next().equals("y")) {
						getUserMoney += scan.nextInt();
						vend.getVariousItems(getUserMoney);
						System.out.print("선택 : ");
						userChoies = scan.nextInt() -1;
						getUserMoney = vend.getReturnItme(userChoies, getUserMoney);
					}else {
						System.out.println("이용해주셔서 감사합니다.");
						break;
					}
				}
			}
		} // end of while
	}
}
