package example;

public class ReturnMoney {
	
	// 전액 반환 메소드
	public int returnChangeMoney(int u_money) {
			
			int [] money = {10000,5000,1000,500,100,50,10};
			int remainMoney;
			
			if (u_money == 0) {
				System.out.println("반환하실 금액이 없습니다.");
			}else {
				for (int i=0 ; i <money.length; i ++) {
					
					if (u_money / money[i] > 0) {
						System.out.println(money[i] + "원 " + u_money/money[i] + "개 반환하였습니다.");
						u_money %=money[i];
					}
				}// end of for
				remainMoney = u_money - u_money;
				System.out.println("자판기에 남은 돈 : " + remainMoney);
			}
			return u_money;
		}
}
