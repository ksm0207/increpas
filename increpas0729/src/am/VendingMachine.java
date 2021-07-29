package am;

import java.util.Scanner;

public class VendingMachine {
	
	// 꽃을 5개만 판매하는 자판기
	Flower [] items = new Flower[5];

//	Flower [] items;
	
	// 배열 초기화
	public void initItems() {
		// 배열을 생성하고 각 요소에 초기화 하는 반복문
//			items = new Flower[5];
		for (int i=0; i<items.length; i++) {
			items[i] = new Flower();
			switch (i) {
			case 0:
				items[i].setName("해바라기");
				items[i].setPrice(1000);
				items[i].setCreate_date("2021-07-25");
				break;
			case 1:
				items[i].setName("장미");
				items[i].setPrice(1500);
				items[i].setCreate_date("2021-07-26");
				break;
			case 2:
				items[i].setName("노랑국화");
				items[i].setPrice(1800);
				items[i].setCreate_date("2021-07-27");
				break;
			case 3:
				items[i].setName("백합");
				items[i].setPrice(2000);
				items[i].setCreate_date("2021-07-28");
				break;
			case 4:
				items[i].setName("튤립");
				items[i].setPrice(2000);
				items[i].setCreate_date("2021-07-29");
				break;
			}
		}// end of for loop(1)
	}
	
	// 금액을 인자로 받고 금액의 범위안에 속하는 꽃들을 출력하기
	public boolean getPrint(int money) {
		boolean flag = false;
		
		for (int i=0; i<items.length; i++) {
			// 배열로부터 객체를 하나씩 가져오기 (변수를 빼서 가져오는방법)
			Flower flower = items[i];
			if (money >= flower.getPrice()) {
				System.out.printf("%d.%s:%d ",
						i+1,
						flower.getName(),
				        flower.getPrice());
				flag = true;
			}
		}// end of for loop(1)
		System.out.println();
		
		if (!flag)
			System.out.println("금액이 부족합니다.");
		
		return flag;
	}// end of getPrint()

	public int getItems(int u_money , int userChoise) {
		
		if (u_money - items[userChoise].getPrice() >= 0) {
			System.out.println("주문하신 " + items[userChoise].getName() + " 나왔습니다 !" + items[userChoise].getCreate_date());
			u_money = u_money - items[userChoise].getPrice();
			System.out.println("남은잔액 : " + u_money + " 원");
		}else {
			System.out.println("잘못된 입력입니다.");
		}
		
		return u_money;
	}
}
